import java.util.*;

public class GoodSubarraysOptimized {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        long res = 0;
        long pairCount = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int val = nums[right];
            // Count how many pairs this val adds
            pairCount += freq.getOrDefault(val, 0);
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            // Shrink the window from left until pairCount < k
            while (pairCount >= k) {
                res += (n - right); // All subarrays starting from left and ending at or after right
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                pairCount -= freq.get(leftVal); // Removing leftVal removes this many pairs
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        GoodSubarraysOptimized sol = new GoodSubarraysOptimized();
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        int k = 2;
        long result = sol.countGood(nums, k);
        System.out.println("Number of good subarrays: " + result);  // Should print 4
    }
}
