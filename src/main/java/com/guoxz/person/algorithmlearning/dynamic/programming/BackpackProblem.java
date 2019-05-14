package com.guoxz.person.algorithmlearning.dynamic.programming;

/**
 * <p>Title:BackpackProblem</p>
 * <p>Description: 背包问题的动态规划解决方法 </p>
 * Copyright: Copyright (c) 2019
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
    * @Description: 对knapsack方法的优化处理，将二维数组变成一维数组
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
    /**
    * @Title: bigCostKnapsack 
    * @Description: 0-1 背包问题升级版:我们刚刚讲的背包问题，只涉及背包重量和物品重量。我们现在引入物品价值这一变量。对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
    * @param weight : 物品的重量集合
    * @param itmesCost : 物品的价值集合
    * @param n : 决策的第几个商品
    * @param w : 背包的总重量
    * @return : int
    * @author guoxz
    * @version 1.0
    * @since  2019/4/12 10:07
    */
    public int bigCostKnapsack(int[] weight,int[] itmesCost, int n, int w){
        int[][] itemsCostStates = new int[n][w+1];
        for (int i = 0; i < itemsCostStates.length; i++) {
            for (int j = 0; j < itemsCostStates[i].length; j++) {
                itemsCostStates[i][j] = -1;
            }
        }
        //先把第一个物品预处理
        itemsCostStates[0][0] = 0;
        itemsCostStates[0][weight[0]] = itmesCost[0];
        //第二个物品在第一个的物品的结果集上处理
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < w; j++) {
                //不放入背包
                if (itemsCostStates[i-1][j] != -1){
                    itemsCostStates[i][j] = itemsCostStates[i-1][j];
                }
                //放入背包
                if (itemsCostStates[i-1][j] != -1 && j+weight[i] <= w){
                    if(itemsCostStates[i-1][j] + itmesCost[i] > itemsCostStates[i][j+weight[i]]){
                        itemsCostStates[i][j+weight[i]] = itemsCostStates[i-1][j] + itmesCost[i];
                    }
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
                System.out.print(itemsCostStates[i][j]+" ");
            }
            System.out.println(" ");
        }
        //输出结果
        int item = 0;
        for (int i = w; i > 0; i--) {
            if(itemsCostStates[n-1][i] != -1){
                item = i;
                break;
            }
        }
        //输出装入的物品顺序
        int itemsCo = item;
        for (int i = n-1; i > 0; i--) {
            //放了这个物品
            if(itemsCo-weight[i] >= 0 && itemsCostStates[i-1][itemsCo-weight[i]]!=-1){
                System.out.println("装了第" + i + "个物品，重量为："+weight[i]+"价值为："+itmesCost[i]);
                itemsCo = itemsCo-weight[i];
            }else{
            }
        }
        if(itemsCo != 0){
            System.out.println("装了第" + 0 + "个物品，重量为："+weight[0]+"价值为："+itmesCost[0]);
        }
        return item;
    }
}
