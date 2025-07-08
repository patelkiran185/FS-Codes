// Write a JAVA Program to implement onee with its operations
// Given an integer array nums, return the number of reverse pairs in the array. A reverse pair is a
// pair (i, j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j].
// Example 1:
// Input: nums = [1,3,2,3,1]
// Output: 2
// Example 2:
// Input: nums = [2,4,3,5,1]
// Output: 3
// Constraints:
// 1 <= nums.length <= 5 * 104
// -2^31 <= nums[i] <= 2^31 – 1


import java.util.*;

class onee {
    public int reversePairs(int[] nums) {
        int count = 0;

        // Iterate through all pairs (i, j) where i < j
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > 2L * nums[j]) { // Use 2L to avoid integer overflow
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        onee solution = new onee();

        int[] nums1 = {1, 3, 2, 3, 1};
        int[] nums2 = {2, 4, 3, 5, 1};

        System.out.println("Output for nums1: " + solution.reversePairs(nums1)); // Output: 2
        System.out.println("Output for nums2: " + solution.reversePairs(nums2)); // Output: 3
    }
}