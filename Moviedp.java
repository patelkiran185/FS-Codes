import java.util.*;
public class Moviedp {
    private static int movieratingssum(int[] arr){
        int n=arr.length;
        int[] dp=new int[n];
        if(n==0) return 0;
        if(n==1) return arr[0];
        dp[0]=arr[0];
        dp[1]=arr[1]+Math.max(0,arr[0]);
        // System.out.println(dp[0]);
        // System.err.println(dp[1]);
        for(int i=2;i<n;i++){
            dp[i]=arr[i]+Math.max(dp[i-1],dp[i-2]);
            // System.out.print(dp[i]+" ");
        }
        for(int i:dp){
            System.out.println(i);
        }
        return Math.max(dp[n-1],dp[n-2]);
    }
    public static void main(String[] args) {
        int[] arr={-3, 2, 4, -1, -2, -5};
        int ans=movieratingssum(arr);
        System.out.println(ans);
    }
}
