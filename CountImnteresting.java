
import java.util.*;

public class CountImnteresting {
    public static long func(int[] nums, int modulo, int k) {
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int cnt = 0;
        long ans = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                cnt++;
            }
            int modval = cnt % modulo;
            int target = (modval - k + modulo) % modulo;
            ans += mpp.getOrDefault(target, 0);
            mpp.put(modval, mpp.getOrDefault(modval, 0)+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4 };
        System.out.println(func(arr, 2, 1));
    }
}
