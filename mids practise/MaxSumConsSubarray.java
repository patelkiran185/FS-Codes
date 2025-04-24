// find the maximum sum of ‘k’ consecutive elements inside the array.
import java.util.*;

public class MaxSumConsSubarray {
    private static int func(int[] arr,int k,int n){
        if(n<k) return -1;
        int maxSum=Integer.MIN_VALUE;
        for(int i=0;i<=n-k;i++){
            int curr=0;
            for(int j=i;j<k+i;j++){
                curr+=arr[j];
                System.out.print(curr + " ");
            }
            maxSum=Math.max(maxSum,curr);
            System.out.println(maxSum);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println("Maximum sum of 'k' consecutive elenets inside the array "+func(arr,k,n));
        sc.close();
    }
}
