package com.samuel.AON;

import org.junit.Assert;
import org.junit.Test;

public class TaskTwoFindArrayIndex {

    @Test
    public void testArraysShouldEqualTo2() {
        int[] mainArr = {4,9,3,7,8};
        int[] subArr = {3,7};
        Assert.assertEquals(2, findSubArrayIndex(mainArr, subArr));
    }

    public static int findSubArrayIndex(int[] mainArray, int[] subArray) {
        if(mainArray == null || subArray == null || mainArray.length == 0 || subArray.length == 0) return -1;
        if(mainArray.length < subArray.length ) return -1;

        int index = -1;
        int comparingIndex;
        for (int i = 0; i < mainArray.length; i++) {
            if(mainArray[i] == subArray[0]){
                index = i;
                comparingIndex = i;
                if(mainArray.length - index < subArray.length) return -1;

                for (int j : subArray) {
                    if (mainArray[comparingIndex++] != j) {
                        index = -1;
                        break;
                    };
                }
            }
        }
        return index;
    }
}
