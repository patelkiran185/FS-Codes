import java.util.*;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        // Step 1: Coordinate Compression
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int num : nums) {
            sortedSet.add(num); // Collect unique numbers in sorted order
        }
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        int index = 1;
        for (int value : sortedSet) {
            valueToIndex.put(value, index++); // Map each value to a compressed index
        }

        // Step 2: Fenwick Tree for Range Maximum Query
        int n = valueToIndex.size(); // Size of the compressed range
        FenwickTree fenwickTree = new FenwickTree(n);

        int maxLength = 0; // To store the maximum LIS length
        for (int num : nums) {
            int compressedIndex = valueToIndex.get(num); // Get compressed index for the current number
            int currentMax = fenwickTree.query(compressedIndex - 1); // Query max LIS for smaller numbers
            int newLength = currentMax + 1; // LIS length ending at this number
            fenwickTree.update(compressedIndex, newLength); // Update Fenwick Tree
            maxLength = Math.max(maxLength, newLength); // Update global max LIS length
        }

        return maxLength;
    }

    // Fenwick Tree implementation for Range Maximum Query
    class FenwickTree {
        private int[] tree;

        public FenwickTree(int size) {
            tree = new int[size + 1]; // Fenwick Tree array (1-based indexing)
        }

        // Update the Fenwick Tree at index with the new value
        public void update(int index, int value) {
            while (index < tree.length) {
                tree[index] = Math.max(tree[index], value); // Store the maximum value
                index += index & -index; // Move to the next index
            }
        }

        // Query the maximum value in the range [1, index]
        public int query(int index) {
            int max = 0;
            while (index > 0) {
                max = Math.max(max, tree[index]); // Get the maximum value in the range
                index -= index & -index; // Move to the parent index
            }
            return max;
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        System.out.println(lis.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // Output: 4
    }
}