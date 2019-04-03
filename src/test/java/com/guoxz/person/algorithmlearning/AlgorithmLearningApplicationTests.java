package com.guoxz.person.algorithmlearning;

import com.guoxz.person.algorithmlearning.dynamic.programming.BackpackProblem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlgorithmLearningApplicationTests {

	@Test
	public void contextLoads() {
	}


	private BackpackProblem backpackProblem = new BackpackProblem();

	@Test
	public void testKnapsack(){
		int[] weights = {3,5,7,9,11,13,17,19};
		backpackProblem.knapsack(weights, weights.length, 31);
	}

}
