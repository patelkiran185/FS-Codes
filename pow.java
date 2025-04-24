//leetcode 50
public class pow {
    public static double func(double x,long n){
        // return (double) Math.pow(x,n);
        if(n==0) return 1;
        if(n <0){
            x=1/x;
            n=-(long)n;
        }
        double half=func(x, n/2);
        if(n%2==0) {
             return half*half;
        }else{
            return x * half * half;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(func(2.0000,10));
    }
}
