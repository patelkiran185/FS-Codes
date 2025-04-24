/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=nums[1]+Math.max(0,nums[0]);
        for(int i=2;i<n;i++){
            dp[i]=nums[i]+Math.max(dp[i-1],dp[i-2]);
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
}
// @lc code=end

