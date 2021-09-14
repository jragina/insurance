package jevgeny.ragina.proofit.model;
import jevgeny.ragina.proofit.enums.RiskType;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PolicySubObjectModel{
    @NonNull 
    @Getter @Setter public String subObjectName;
    @NonNull 
    @Getter @Setter public RiskType riskType;
    @NonNull 
    @Getter @Setter public Double sumInsured;

}
