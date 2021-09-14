package jevgeny.ragina.proofit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jevgeny.ragina.proofit.model.PolicyModel;
import jevgeny.ragina.proofit.model.ResponseModel;
import jevgeny.ragina.proofit.service.PremiumCalculatorService;
import jevgeny.ragina.proofit.wrappers.PolicyModelWrapper;

@Controller
public class PolicyController {
    @Autowired 
    PremiumCalculatorService premiumCalculatorService;
    @RequestMapping(value= "/calculate-premium", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> calculatePremium(@RequestBody PolicyModelWrapper policyModelWrapper) {
        String rez = premiumCalculatorService.calculate(policyModelWrapper.getPolicyModel()).toString();
        return new ResponseEntity(new ResponseModel(rez),HttpStatus.OK);
    }
}
