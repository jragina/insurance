package jevgeny.ragina.proofit.wrappers;

import com.fasterxml.jackson.annotation.JsonProperty;

import jevgeny.ragina.proofit.model.PolicyModel;
import lombok.Getter;
import lombok.Setter;

public class PolicyModelWrapper {
    @JsonProperty("PolicyModel")
    @Getter @Setter public PolicyModel policyModel;
}
