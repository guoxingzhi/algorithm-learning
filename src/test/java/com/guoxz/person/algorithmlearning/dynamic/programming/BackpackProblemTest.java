package com.guoxz.person.algorithmlearning.dynamic.programming;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * <p>Title:BackpackProblemTest</p>
 * <p>Description: 背包问题的动态规划解决方案 </p>
 * Copyright: Copyright (c) 2019
 * Company: SI-TECH
 *
 * @author guoxz
 * @version 1.0
 * @since 2019年04月03日 9:41
 */
public class BackpackProblemTest {

    @Test
    public void knapsack() {
    }


    private BackpackProblem backpackProblem = new BackpackProblem();

    @Test
    public void testKnapsack(){
        int[] weights = {3,5,7,9,11,13,17,19};
        int w = backpackProblem.knapsack(weights, weights.length, 31);
        System.out.println("背包最重为：" + w);
    }



    @Test
    public void optimizeKnapsack(){
        int[] weights = {3,5,7,9,11,13,17,19};
        int w = backpackProblem.optimizeKnapsack(weights, weights.length, 31);
        System.out.println("背包最重为：" + w);
    }
}