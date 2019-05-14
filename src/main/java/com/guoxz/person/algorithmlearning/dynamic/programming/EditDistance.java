package com.guoxz.person.algorithmlearning.dynamic.programming;

/**
 * <p>Title:EditDistance</p>
 * <p>Description: 求两个字符串的编辑距离 </p>
 * 编辑距离：指的就是，将一个字符串转化成另一个字符串，需要的最少编辑操作次数（比如增加一个字符、删除一个字符、替换一个字符）。编辑距离越大，说明两个字符串的相似程度越小；相反，编辑距离就越小，说明两个字符串的相似程度越大。对于两个完全相同的字符串来说，编辑距离就是 0。
 * Copyright: Copyright (c) 2019
 *
 * @Author guoxz
 * @Version 1.0
 * @Since 2019年04月29日 11:27
 */
public class EditDistance {
    /**
    * @Title: getLevenshteinDistance
    * @Description: 莱文斯坦距离算法求字符strA和strB的编辑距离
    * @param strA : 字符串a
    * @param strB : 字符串b
    * @return : int 编辑距离
    * @author guoxz
    * @version 1.0
    * @since  2019/4/29 11:49
    */
    public int getLevenshteinDistance(String strA, String strB, int i, int j) {
        char[] charA = strA.toCharArray();
        char[] charB = strB.toCharArray();
        int lengthA = charA.length;
        int lengthB = charB.length;

        return 0;
    }

    private void computeDistance(char[] charA,int lengthA,char[] charB,int lengthB,int editDistance){
        for (int i = 0; i < lengthA; i++) {
            if (charA[i] == charB[i]) {
            } else {
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("合并分支pull request测试");
    }

}
