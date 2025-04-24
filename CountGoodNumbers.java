// leetcode 1922
import java.util.*;
public class CountGoodNumbers {
    private static long MOD=1000000007;
    public static long pow(long x,long n){
        if(n==0) return 1;
        long temp=pow(x,n/2) % MOD;
        System.out.println("Trmps  "+ temp+" ");
        if(n%2==0){
            return (temp*temp) % MOD;
            
        }else{
            return (x*temp%MOD*temp) % MOD;
        }
    }
    public static int countGoodNumbers(long n){
        long even=(n+1)/2;
        System.out.println("Even"+even);
        long odd=n/2;
        System.out.println("Odd"+ odd);
        long first=pow(5,even) % MOD;
        long sec=pow(4,odd) % MOD;
        return (int)((first*sec)%MOD);
    }
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(50));
    }
}
