
import java.util.*;
public class Solution {
    public static int[][] mergedArray(int[][] nums1,int[][] nums2){
        TreeMap<Integer,Integer> mpp=new TreeMap<>();
        for(int[] num:nums1){
            mpp.put(num[0],mpp.getOrDefault(num[0], 0)+num[1]);
        }
        for(int[] num:nums2){
            mpp.put(num[0],mpp.getOrDefault(num[0], 0)+num[1]);
        }

        int[][] res=new int[mpp.size()][2];
        int c=0;
        for(var p:mpp.entrySet()){
            res[c++]=new int[]{p.getKey(),p.getValue()};
        }
        return res;
    }

//     Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
// Output: [[1,6],[2,3],[3,2],[4,6]
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] nums1=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums1[i][j]=sc.nextInt();
            }
        }
        int k=sc.nextInt();
        int l=sc.nextInt();
        int[][] nums2=new int[k][l];
        for(int i=0;i<k;i++){
            for(int j=0;j<l;j++){
                nums2[i][j]=sc.nextInt();
            }
        }
        System.out.println();
        int[][] res=mergedArray(nums1,nums2);
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i].length;j++){
                System.out.print(res[i][j]+",");
            }
           
        }
        sc.close();
    }
}
