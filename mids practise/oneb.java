import java.util.*;

class oneb {
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int minLength = n + 1; // Initialize with an impossible value

        // Iterate over all possible starting points of subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;

            // Iterate over all possible ending points of subarrays starting at i
            for (int j = i; j < n; j++) {
                sum += A[j]; // Add the current element to the sum

                // Check if the sum is greater than or equal to K
                if (sum >= K) {
                    minLength = Math.min(minLength, j - i + 1); // Update the minimum length
                    break; // No need to check longer subarrays starting at i
                }
            }
        }

        // If no valid subarray is found, return -1
        return minLength == n + 1 ? -1 : minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new oneb().shortestSubarray(arr, k));
    }
}