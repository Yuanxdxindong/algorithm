package com.yuanxindong.algorithm.demo.day01;

import com.sun.tools.javac.util.List;
import java.util.ArrayList;

/**
 * @author yuanxindong
 * @date 9/17/21  11:13 PM
 */
public class BinarySearch {

    /**
     * 有序数组，进行匹配值
     * @param args
     */


    public static void main(String[] args) {
        //在数据中匹配value
        int[]  lists = new  int [] {
            1,2,3,48,59,100,111,123,125,126,128,2344,88888,
        };
        int  value = 125;
        int i = bSearch(lists, value);
        System.out.println(i);

        int i1 = bSearchPlus(lists, 0, lists.length, value);
        System.out.println(i1);

    }

    /**
     * 最简单的版本
     *
     * @param a     数组
     * @param value 值
     * @return
     */
    private static int bSearch(int[] a, int value) {

        int low = 0;
        int high = a.length;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return -1;
    }

    /**
     * 使用递归 + 优化计算
     *
     * @param a     数组a
     * @param low   起点
     * @param high  最高点
     * @param value 匹配的值
     * @return -1 or 匹配到的下标指针
     */
    private static int bSearchPlus(int[] a, int low, int high, int value) {
        if (low > high) {
            return -1;
        }
        //对于大
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bSearchPlus(a, mid + 1, high, value);
        } else {
            return bSearchPlus(a, low, mid + 1, value);
        }
    }


}
