package jevgeny.ragina.proofit.service;

import jevgeny.ragina.proofit.model.PolicyModel;

public interface PremiumCalculatorService {
    public Double calculate(PolicyModel policy);
}
