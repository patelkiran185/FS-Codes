import java.util.*;

class oneb {


    public static int shortestSubarrayBruteForce(int[] nums, int k) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                    break; // Found shortest starting at i
                }
            }
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    /**
     * OPTIMAL SOLUTION: Using Deque and Prefix Sums
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * This is the method you asked about - it uses:
     * 1. Prefix sums for efficient range sum calculation
     * 2. Monotonic deque to maintain optimal candidates
     */
    public static int shortestSubarrayOptimal(int[] A, int K) {
        int N = A.length;
        
        // P[i] = prefix sum from 0 to i-1
        long[] P = new long[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (long) A[i];
        
        int ans = N + 1; // N+1 is impossible
        
        // Deque stores indices of prefix sums in increasing order
        Deque<Integer> monoq = new LinkedList<>(); 
        
        for (int y = 0; y < P.length; ++y) {
            // Remove indices with larger prefix sums (they won't be optimal)
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            
            // Check if we can form subarray with sum >= K
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());
            
            monoq.addLast(y);
        }
        
        return ans < N + 1 ? ans : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println("Brute Force: " + shortestSubarrayBruteForce(arr, k));
        System.out.println("Optimal (Deque): " + shortestSubarrayOptimal(arr, k));
        
        sc.close();
    }
}