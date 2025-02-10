// You are given an integer array nums and two integers l and r. Your task is to 
// analyze the volatility of a sequence of values. The volatility of a sequence is 
// defined as the difference between the maximum and minimum values in that sequence.

// You need to determine the sequence with the highest volatility among all 
// sequences of length between l and r (inclusive).

// Return the highest volatility. If no such sequence exists, return -1.

// Input Format:
// -------------
// Line-1: 3 space separated integers, n, l, r
// Line-2: n space separated integers, nums[].

// Output Format:
// -------------
// An integer, the highest volatility.


// Sample Input-1:
// ---------------
// 5 2 3
// 8 3 1 6 2

// Sample Output-1:
// ----------------
// 7

// Explanation:
// ------------
// The possible sequences of length between l = 2 and r = 3 are:

// [8, 3] with a volatility of 8−3=5
// [3, 1] with a volatility of 3−1=2
// [1, 6] with a volatility of 6−1=5
// [8, 3, 1] with a volatility of 8−1=7
// The sequence [8, 3, 1] has the highest volatility of 7.

// Sample Input-2:
// ---------------
// 4 2 4
// 5 5 5 5

// Sample Output-2:
// ----------------
// 0

// Explanation:
// ------------
// All possible sequences have no volatility as the maximum and minimum values 
// are the same, resulting in a difference of 0.
 


import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int l=sc.nextInt();
        int r=sc.nextInt();
        
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int maxv=-1;
        for(int size=l;size<=r;size++){
            PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b)->b[0]-a[0]);
               PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)->a[0]-b[0]);
               for(int i=0;i<n;i++){
                   maxHeap.add(new int[]{nums[i],i});
                   minHeap.add(new int[]{nums[i],i});
                   if(i>=size){
                       while(!maxHeap.isEmpty() && maxHeap.peek()[1]<=i-size){
                           maxHeap.poll();
                       }
                        while(!minHeap.isEmpty() && minHeap.peek()[1]<=i-size){
                           minHeap.poll();
                       }
                   }
                   if(i>=size-1){
                       int maxi=maxHeap.peek()[0];
                       int mini=minHeap.peek()[0];
                       maxv=Math.max(maxv,maxi-mini);
                   }
               }
            
        }
        System.out.println(maxv);
    }
}