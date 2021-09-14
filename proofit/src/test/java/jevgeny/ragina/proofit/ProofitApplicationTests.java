package jevgeny.ragina.proofit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import jevgeny.ragina.proofit.controllers.PolicyController;
import jevgeny.ragina.proofit.enums.PolicyStatus;
import jevgeny.ragina.proofit.enums.RiskType;
import jevgeny.ragina.proofit.model.PolicyModel;
import jevgeny.ragina.proofit.model.PolicyObjectModel;
import jevgeny.ragina.proofit.model.PolicySubObjectModel;
import jevgeny.ragina.proofit.service.impl.PremiumCalculatorServiceImpl;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProofitApplicationTests {
	@Autowired
	PremiumCalculatorServiceImpl premiumCalculatorServiceImpl;
	@Autowired
	PolicyController policyController;
	@Autowired
	private MockMvc mockMvc;
	@Test
	void contextLoads() {
	}
	@Test
	void accepteanceCriteria1(){
		PolicySubObjectModel so = new PolicySubObjectModel("TV FIRE", RiskType.FIRE, 100.00);
		PolicySubObjectModel so1 = new PolicySubObjectModel("TV theft", RiskType.THEFT, 8.00);
		List<PolicySubObjectModel> subObjects = new ArrayList<>();
		subObjects.add(so);
		subObjects.add(so1);
		PolicyObjectModel po = new PolicyObjectModel(subObjects, "= 2.28 ");
		List<PolicyObjectModel> policies = new ArrayList<>();
		policies.add(po);
		PolicyModel policy = new PolicyModel(policies, "FIRSTPOLICY = 2.28", PolicyStatus.APPROVED);
		assertEquals(2.28, premiumCalculatorServiceImpl.calculate(policy));
	}
	@Test
	void accepteanceCriteria2(){
		PolicySubObjectModel so = new PolicySubObjectModel("TV FIRE", RiskType.FIRE, 500.00);
		PolicySubObjectModel so1 = new PolicySubObjectModel("TV FIRE", RiskType.THEFT, 102.51);
		List<PolicySubObjectModel> subObjects = new ArrayList<>();
		subObjects.add(so);
		subObjects.add(so1);
		PolicyObjectModel po = new PolicyObjectModel(subObjects, "= 17.13 ");
		List<PolicyObjectModel> policies = new ArrayList<>();
		policies.add(po);
		PolicyModel policy = new PolicyModel(policies, "FIRSTPOLICY = 17.13", PolicyStatus.APPROVED);
		assertEquals(17.13, premiumCalculatorServiceImpl.calculate(policy));
	}

}
