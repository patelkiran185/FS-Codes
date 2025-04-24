import java.util.*;
public class MinimumIndexSplit {
    public static int minimumIndex(List<Integer> nums){
        int n=nums.size();
        for(int i=0;i<n-1;i++){
            int left=findDominant(nums,0,i);
            int right=findDominant(nums,i+1,n-1);
            if(left != -1 && left == right){
                return i;
            }
        }
        return -1;
    }
    public static int findDominant(List<Integer> nums,int start,int end){
        int size=end-start+1;
        for(int i=start;i<=end;i++){
            int candidate=nums.get(i);
            int c=0;
            for(int j=start;j<=end;j++){
                if(nums.get(j)==candidate){
                    c++;
                }
            }
            if(c *2>size){
                return candidate;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        List<Integer> nums= new ArrayList<>(Arrays.asList(1, 2, 2,2));
        int ans=minimumIndex(nums);
        System.out.println(ans);
    }
}
