package com.guoxz.person.algorithmlearning.sort;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * <p>Title:MergeSort</p>
 * <p>Description: 归并排序 </p>
 * Copyright: Copyright (c) 2019
 * Company: SI-TECH
 * @Author guoxz
 * @Version 1.0
 * @Since 2019年11月28日 20:34
 */
public class MergeSort {

    private int[] outofArray = null ;
    private int count = 0;
    /***
    * @Title: mergeSort
    * @Description: 数组排序入口
    * @param array : 待排序数组
    * @return : int[] 排序好的数组
    * @author guoxz
    * @version 1.0
    * @since  2019/11/28 20:36
    */
    public int[] mergeSort(int[] array){
        outofArray = array;
        mergeSortSbsc(outofArray, 0, array.length-1);
        return outofArray;
    }
    /***
    * @Title: mergeSortSbsc
    * @Description: 归并排序的"归"过程，将数据一分为二
    * @param array :
    * @param start :
    * @param end :
    * @return : void
    * @author guoxz
    * @version 1.0
    * @since  2019/12/5 16:09
    */
    private void mergeSortSbsc(int[] array, int start, int end) {
        if(start >= end){
            return;
        }
        int med =  start + ((end -start)>>1);
        count++;
        mergeSortSbsc(array,start,med);
        mergeSortSbsc(array,med+1,end);
        merge(new int[end-start+1],array,start,med,end);
    }
    /***
    * @Title: merge
    * @Description: 将"归"过程的两个子集合进行合并为一个集合
    * @param ints :
    * @param array :
    * @param start :
    * @param med :
    * @param end :
    * @return : void
    * @author guoxz
    * @version 1.0
    * @since  2019/12/5 16:10
    */
    private void merge(int[] ints, int[] array, int start, int med, int end) {
        int i = start,j = med+1,k = 0 ;
        while (i<=med && j <= end){
            if(array[i] <= array[j]){
                ints[k] = array[i];
                i++;
            }else {
                ints[k] = array[j];
                j++;
            }
            k++;
        }
        if (i <= med){
            for ( ;i <= med; i++) {
                ints[k] = array[i];
                k++;
            }
        }

        if (j <= end){
            for ( ;j <= end; j++) {
                ints[k] = array[j];
                k++;
            }
        }
        i = start;
        for (int w = 0; w < ints.length; w++) {
            array[i] = ints[w];
            i++;
        }
        //log
        System.out.println("temp array:"+ JSON.toJSONString(ints));
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new MergeSort().mergeSort(new int[]{3,5,6,11,19,24,12,14,33,56,34,3,1,4})));
    }
}
