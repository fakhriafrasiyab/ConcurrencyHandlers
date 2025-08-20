package org.example.medium;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static boolean containsDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        // nums = [1,2,3,1], k = 3
        //[1,2,3,1,2,3]
        int[] nums = {1, 2, 3, 1, 2, 3};

        System.out.println(containsDuplicate(nums, 2));

    }
}

