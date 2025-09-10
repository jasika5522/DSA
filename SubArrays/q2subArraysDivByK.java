import java.util.HashMap;

public class q2subArraysDivByK {
     public int subarraysDivByK(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);  // base case: empty prefix sum
        for(int i = 0;i<nums.length;i++)
        {
            prefixSum += nums[i];
            /*
            mod = prefixSum % k  (-ve)
            mod += k (+ve)
            mod= mod % k (actual mod value)
            */ 
            int mod = ((prefixSum % k) + k) % k;  // handle negative numbers

            if(map.containsKey(mod))
            {
                count += map.get(mod);
            }
           // update the count of this mod in the map
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}
