package com.guoxz.person.algorithmlearning.dynamic.programming;

/**
 * <p>Title:BackpackProblem</p>
 * <p>Description: 背包问题的动态规划解决方法 </p>
 * Copyright: Copyright (c) 2019
 * Company: SI-TECH
 *
 * @author guoxz
 * @version 1.0
 * @since 2019年04月03日 8:56
 */
public class BackpackProblem {
    /**
    * @Title: knapsack
    * @Description: 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
    *@param weight : 所有物品的重量集合
    *@param n :物品的数量
    *@param w :背包的总重量
    * @return : int 背包最大的总重量
    * @author guoxz
    * @version 1.0
    * @since  2019/4/3 9:05
    */
    public int knapsack(int[] weight, int n, int w){
        boolean[][] itemsStatus = new boolean[n][w+1];
        //先把第一个物品预处理
        itemsStatus[0][0] = true;
        itemsStatus[0][weight[0]] = true;
        //第二个物品在第一个的物品的结果集上处理
        for (int i = 1; i < n; i++) {
            int itemsWeight = weight[i];
            for (int j = 0; j < w; j++) {
                //不放入背包
                if (itemsStatus[i-1][j]){
                    itemsStatus[i][j] = true;
                }
                //放入背包
                if (itemsStatus[i-1][j] && j+weight[i] <= w){
                    itemsStatus[i][j+weight[i]] = true;
                }
            }
            //优化放入背包
            /*for (int j = 0; j < w - weight[i]; j++) {
                if(itemsStatus[i-1][j]){
                    itemsStatus[i][j+weight[i]] = true;
                }
            }*/
        }
        //控制台打印多阶段的矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < w + 1; j++) {
                System.out.print(itemsStatus[i][j]+" ");
            }
            System.out.println(" ");
        }
        //输出结果
        for (int i = w; i > 0; i--) {
            if(itemsStatus[n-1][i]){
                return i;
            }
        }
        return 0;
    }
    /**
    * @Title: optimizeKnapsack
    * @Description: 对knapsack的优化处理，将二维数组变成一维数组
     *@param weight : 物品的重量集合
     *@param n : 物品的个数
     *@param w : 背包的可装载重量
    * @return : int
    * @author guoxz
    * @version 1.0
    * @since  2019/4/4 8:44
    */
    public int optimizeKnapsack(int[] weight, int n, int w){
        boolean[] knapsackStatus = new boolean[w + 1];
        knapsackStatus[0] = true;
        knapsackStatus[weight[0]] = true;
        for (int i = 0; i < n; i++) {
            for (int j = w-weight[i]; j > 0 ; j--) {
                if (knapsackStatus[j]) {
                    knapsackStatus[j + weight[i]] = true;
                }
            }
        }
        //打印结果集
        for (int i = w; i > 0; i--) {
            if(knapsackStatus[i]){
                return i;
            }
        }
        return 0;
    }
}
