import java.util.*;

// Input: 
// 7				\\n
// 1 2 3 2 2 1 3	\\array garden
// 3				\\k

// Output: 
// [3, 2, 2, 2, 3]

// Explanation:

// For plots 0 to 2: [1,2,3] → 3 unique colors
// For plots 1 to 3: [2,3,2] → 2 unique colors
// For plots 2 to 4: [3,2,2] → 2 unique colors
// For plots 3 to 5: [2,2,1] → 2 unique colors
// For plots 4 to 6: [2,1,3] → 3 unique colors

class Solution{
    public static List<Integer> getuniqueflowers(int[] arr,int n,int k, List<Integer> res){
        Map<Integer,Integer> mpp=new HashMap<>();
        
        int c=0;
        for(int i=0;i<k;i++){
            mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
            if(mpp.get(arr[i])==1){
                c++;
            }
        }
         res.add(c);
        for(int i=k;i<n;i++){
            int out=arr[i-k];
            mpp.put(out,mpp.get(out)-1);
            if(mpp.get(out)==0) c--;
            int in=arr[i];
            mpp.put(in,mpp.getOrDefault(in,0)+1);
            if(mpp.get(in)==1){
                c++;
            }
             res.add(c);
        }
       
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        
         int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        
        int k=sc.nextInt();
        
      
        
        List<Integer> res=new ArrayList<>();
        getuniqueflowers(arr,n,k,res);
        System.out.println(res);
    }
}



























// A grid of light bulbs is given, represented as a matrix of size rows x cols, 
// where each cell contains either 0 (off) or 1 (on).

// Your task is to turn all the light bulbs off (0) by following the toggle rule:
//     - In each step, you can choose either an entire row or an entire column 
//     and toggle all its elements (change 0 to 1 and 1 to 0).
    
// At the end, if all light bulbs are turned off, print true, otherwise print false.


// Input Format
// -------------
// Line-1: Read two integers rows and cols(space separated).
// Line-2: Read the matrix of dimension rows X cols.

// Output Format
// --------------
// Print a boolean result.



// Sample input-1:
// ---------------
// 5 5
// 0 0 1 0 0
// 0 0 1 0 0
// 1 1 0 1 1
// 0 0 1 0 0
// 0 0 1 0 0

// Sample output-1:
// ----------------
// true

// Explanation:
// ------------
// 0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
// 0 0 1 0 0   row-3  0 0 1 0 0   cols-3  0 0 0 0 0
// 1 1 0 1 1   --->   0 0 1 0 0   --->    0 0 0 0 0
// 0 0 1 0 0          0 0 1 0 0           0 0 0 0 0
// 0 0 1 0 0          0 0 1 0 0           0 0 0 0 0 


// Sample input-2
// --------------
// 2 2
// 1 1
// 0 1

// Sample output-2
// ---------------
// false


// import java.util.*;
// public class solution{
//     static boolean flipPosible(int[][] grid,int m,int n){
//         int[] rowc=new int[m];
//         int[] colc=new int[n];
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==1){
//                     rowc[i]+=1;
//                     colc[j]+=1;
//                 }
//             }
//         }
//         for(int i=0;i<m;i++){
//            if(rowc[i]>n/2){
//                for(int j=0;j<n;j++){
//                    grid[i][j]=1-grid[i][j];
//                    colc[j]+=(grid[i][j]==1) ? 1 : -1;
//                }
//            }
//         }
//         for(int j=0;j<n;j++){
//             if(colc[j]>m/2){
//                 for(int i=0;i<m;i++){
//                     grid[i][j]=1-grid[i][j];
//                 }
//             }
//         }
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==1){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
//     public static void main(String []args){
//         Scanner sc = new Scanner(System.in);
//         int m= sc.nextInt();
//         int n = sc.nextInt();
//         int[][] arr = new int[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 arr[i][j]=sc.nextInt();
//             }
//         }
//         System.out.println(flipPosible(arr,m,n));
//     }
// }