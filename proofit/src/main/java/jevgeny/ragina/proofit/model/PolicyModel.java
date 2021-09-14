package jevgeny.ragina.proofit.model;

import java.util.List;

import jevgeny.ragina.proofit.enums.PolicyStatus;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PolicyModel {
    @NonNull
    @Getter @Setter public List<PolicyObjectModel> policies;
    @NonNull
    @Getter @Setter public String number;
    @NonNull
    @Getter @Setter PolicyStatus status;
}
