package jevgeny.ragina.proofit.model;

import java.util.List;

import jevgeny.ragina.proofit.model.PolicySubObjectModel;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class PolicyObjectModel {
    @NonNull 
    @Getter @Setter public List<PolicySubObjectModel> subObjects;
    @NonNull 
    @Getter @Setter public String name;

}
