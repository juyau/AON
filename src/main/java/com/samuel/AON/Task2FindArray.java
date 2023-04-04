package com.samuel.AON;

import org.junit.Assert;
import org.junit.Test;

public class Task2FindArray {
    public static void main(String[] args) {

        int[] arr1 = {4,9,3,7,8};
        int[] arr2 = {3,7,8};
        int result = findSubArrayIndex(arr1, arr2);
        System.out.println(result);

    }

    @Test
    public void testArraysShouldEqualTo2() {
        int[] arr1 = {4,9,3,7,8};
        int[] arr2 = {3,7};
        Assert.assertEquals(2, findSubArrayIndex(arr1, arr2));
    }

    public static int findSubArrayIndex(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) return -1;
        if(arr1.length < arr2.length ) return -1;

        for (int m = 0; m < arr1.length; m++) {
            if(arr1[m] == arr2[0]){
                int index = m;
                if(arr2.length > arr1.length - index) return -1;

                for (int j : arr2) {
                    if (arr1[m++] != j) return -1;
                }
                return index;
            }
        }
        return -1;
    }
}
