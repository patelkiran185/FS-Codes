import java.util.*;

public class AArray {
    private static void func(int[] arr,int n,int minK,int maxK){
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=i;j<n;j++){
                temp.add(arr[j]);
                res.add(new ArrayList<>(temp));
            }
        
        }
        // for(List<Integer> i:res){
        //     System.out.println(i);
        // }
        int c=0;
        for(List<Integer> sub:res){
            int min=Collections.min(sub);
            int max=Collections.max(sub);
            if(min==minK && max==maxK){
                c++;
            }

        }
        System.out.println(c);
    }
    public static void main(String[] args) {
        int[] arr={1,3,5,2,7,5};
       func(arr,6,1,5);

    }
}
