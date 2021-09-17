package com.yuanxindong.algorithm.demo.day01;

/**
 * @author yuanxindong
 * @date 9/17/21  11:13 PM
 */
public class BinarySearch {

    /**
     * 有序数组，进行匹配值
     *
     * @param args
     */


    public static void main(String[] args) {
        //在数据中匹配value，在有序的数组中进行查询
        int[] lists = new int[]{
            1, 2, 3, 48, 59, 100, 111, 123, 125, 126, 128, 2344, 88888,
        };
        int value = 125;
        int i = bSearch(lists, value);
        System.out.println(i);

        int i1 = bSearchPlus(lists, 0, lists.length, value);
        System.out.println(i1);

        //查找第一个值等于给定的值
        int[] listV2 = new int[]{
            1, 2, 3, 48, 59, 100, 111, 123, 123, 123, 125, 126, 128, 2344, 88888,
        };
        int value2 = 123;

        int i2 = bSearchFirst(listV2, value2);
        System.out.println(i2);


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


    private static int bSearchFirst(int[] a, int value) {

        int low = 0;
        int high = a.length;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (a[mid] < value) {
                low = mid + 1;
            } else if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] == value) {
                //如果前一个数字不等与a[mid]
                if (a[mid - 1] != value || (mid == 0)) {
                    return mid;
                } else {
                    high = mid - 1;

                }
            }

        }

        return -1;
    }


}
