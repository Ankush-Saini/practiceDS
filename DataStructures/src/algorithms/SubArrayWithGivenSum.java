package com.general;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        ArrayList<Integer> arrlist = new ArrayList<>();
        if (arr == null || n == 0)
            return arrlist;
        int i = 0, j = 1, sum = arr[0];
        for (j = 1; j <= n; j++) {
            while (sum > s && i < j - 1) {
                sum -= arr[i];
                i++;
            }
            if (sum == s) {
                arrlist.add(i + 1);
                arrlist.add(j);
                return arrlist;
            }
            if (j < n) {
                sum += arr[j];
            }
        }
        arrlist.add(-1);
        return arrlist;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 7, 8};
        int sum = 15;
        System.out.println(subarraySum(arr, arr.length, sum));
    }
}
