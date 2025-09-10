import java.util.*;
import java.util.HashMap;
import java.io.*;
public class q1subArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: subarray starting from index 0

        for (int num : nums) {
            sum += num; // current prefix sum

            // check if there is a prefix sum that we can subtract to get k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);  
                //instead of normal counting it will tell how many are present having sum equals to the target value
                //count++;
            }
            // store/update the current prefix sum count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
   public int[] subarraySumIndices(int[] nums, int target) {
        int n = nums.length;
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // prefixSum -> last index
        map.put(0, -1); // base case: subarray starting from index 0

        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];

            if (map.containsKey(prefixSum - target)) {
                int start = map.get(prefixSum - target) + 1;
                int end = i;
                return new int[]{start, end}; // return indices of subarray
            }

            map.put(prefixSum, i);
        }

        return new int[]{}; // return empty array if no subarray found
    }
}
