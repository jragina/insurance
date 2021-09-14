package jevgeny.ragina.proofit.service.impl;

import jevgeny.ragina.proofit.model.*;
import jevgeny.ragina.proofit.service.PremiumCalculatorService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;

import jevgeny.ragina.proofit.enums.*;
/**
 * Service calculates insurance sum based on each sub-object type
 * Premium is calclualted on policy level 
 */
@Service
public class PremiumCalculatorServiceImpl implements PremiumCalculatorService {
    
    
    public Double calculate(PolicyModel policy) {
        Double premiumSum = 0.0;

            Map<RiskType,Double> policySumInsuredMap = new HashMap();

            for (PolicyObjectModel policyObject : policy.getPolicies()) {

                for (PolicySubObjectModel policySubObject : policyObject.getSubObjects()) {
                
                    for(RiskType riskType: RiskType.values()){
                        if (Objects.equals(riskType, policySubObject.getRiskType())){

                            //sum is calclualted on policy level
                            Double policySumTypeVal = policySumInsuredMap.get(riskType);
                            if (policySumTypeVal!= null){
                                policySumTypeVal += policySubObject.getSumInsured();

                            }else{
                                policySumTypeVal = policySubObject.getSumInsured();
                            } 
                            policySumInsuredMap.put(riskType, policySumTypeVal);
                            
                        }
                    } 
                }
                
            }
            Double premiumFire = 0.0;
            Double premiumTheft = 0.0;
            for (RiskType riskType : policySumInsuredMap.keySet()) {
                if(Objects.equals(riskType, RiskType.FIRE)){
                    Double sumInsuredFire = policySumInsuredMap.get(riskType);
                    Double coefficentFire = 0.014;

                     if(sumInsuredFire > 100)
                     {
                        coefficentFire = 0.024;
                     }
                     premiumFire += (sumInsuredFire * coefficentFire);
                 }
                 if(Objects.equals(riskType, RiskType.THEFT)){
                     Double sumInsuredTheft = policySumInsuredMap.get(riskType);
                     Double coefficentTheft = 0.11;
                      if(sumInsuredTheft >= 15)
                      {
                        coefficentTheft = 0.05;
                      }
                      premiumTheft += (sumInsuredTheft * coefficentTheft);
                      
                  }
            }
            premiumSum = premiumTheft + premiumFire;
        
        return round(premiumSum, 2);
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
