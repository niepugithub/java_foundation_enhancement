package com.leetCode;

/**
 * @description:
 * @author:niepu
 * @version:1.0
 * @date:2019/4/1 22:53
 **/
public class Solution1015 {

    public static void main(String[] args) {
        System.out.println(minK(97));
        System.out.println(smallestRepunitDivByK(97));
        System.out.println(1111111111111111L / 17);
    }

    public static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int s = 0;
        for (int i = 1; i <= k; i++) {
            s = (s * 10 + 1) % k;
            if (s == 0) {
                return i;
            }
        }
        return -1;
    }

    public static long minK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        long s = 0;
        int n = 0;
        while (true) {
            s = (10 * s + 1) % k;
            n++;
            if (s == 0) {
                return n;
            }
        }
    }
}
