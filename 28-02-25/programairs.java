// Two brothers want to play a game, 
// The rules of the game are: one player gives two sorted lists of 
// numerical elements and a number (sum). 
// The opponent has to find the closest pair of elements 
// to the given sum.
// -> pair consists of elements from each list
// Please help those brothers to develop a program, that takes 
// two sorted lists as input and return a pair as output.
// Input Format:
// -------------
// size of list_1
// list_1 values
// size of list_2
// list_2 values
// closest number
// Output Format:
// --------------
// comma-separated pair
// Sample Input-1:
// ---------------
// 4
// 1 4 5 7
// 4
// 10 20 30 40
// 32
// Sample Output-1
// ---------------
// 1, 30
// Sample Input-2
// ---------------
// 3
// 2 4 6
// 4
// 5 7 11 13
// 15
// sample output-2
// ---------------
// 2, 13
import java.util.*;
class programairs{
    public static List<Integer> getpairs(int[] arr1,int[] arr2,int sum){
        List<Integer> res=new ArrayList<>();
        int left=0;
        int right=arr2.length-1;
        int close=Integer.MAX_VALUE;
        while(left < arr1.length && right >=0){
            int num1=arr1[left];
            int num2=arr2[right];
            int curr=num1+num2;
            int currd=Math.abs(sum-curr);
            if(currd < close){
                close=currd;
                res.clear();
                res.add(num1);
                res.add(num2);
            }
            if(curr < sum){
                left++;
            }else{
                right--;
            }
        }
        return res;
    }
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr1=new int[n];
    for(int i=0;i<n;i++){
        arr1[i]=sc.nextInt();
    }
    int m=sc.nextInt();
    int[] arr2=new int[m];
    for(int i=0;i<m;i++){
        arr2[i]=sc.nextInt();
    }
    int sum=sc.nextInt();
    List<Integer> res=new ArrayList<>();
    
    res=getpairs(arr1,arr2,sum);
    System.out.println(res);
    }
}