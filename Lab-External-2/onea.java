import java.util.*;
class onea {
    public int subarraysWithKDistinct(int[] A, int k) {
        // return atMostK(A, K) - atMostK(A, K - 1);
        int count=0;
        int n=A.length;
        for(int i=0;i<n;i++){
            Set<Integer> distinct=new HashSet<>();
            for(int j=i;j<n;j++){
                distinct.add(A[j]);
                if(distinct.size()==k){
                    count++;
                }else if(distinct.size()>k){
                    break;
                }
            }
        }

        return count;
    }

    // int atMostK(int[] A, int K) {
    //     int i = 0, res = 0;
    //     Map<Integer, Integer> count = new HashMap<>();
    //     for (int j = 0; j < A.length; ++j) {
    //         if (count.getOrDefault(A[j], 0) == 0)
    //             K--;
    //         count.put(A[j], count.getOrDefault(A[j], 0) + 1);
    //         while (K < 0) {
    //             count.put(A[i], count.get(A[i]) - 1);
    //             if (count.get(A[i]) == 0)
    //                 K++;
    //             i++;
    //         }
    //         res += j - i + 1;
    //     }
    //     return res;
    // }

     public static int bruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break; // No point continuing as we'll have > k distinct
                }
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        System.out.println(new onea().subarraysWithKDistinct(arr, k));
    }
}