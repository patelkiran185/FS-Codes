

// A software development company is designing a smart home automation 
// system that uses sensor networks to monitor and control different devices 
// in a house. The sensors are organized in a hierarchical structure, where each 
// sensor node has a unique ID and can have up to two child nodes (left and right).

// The company wants to analyze the left-most sensors in the system to determine
// which ones are critical for detecting environmental changes. The hierarchy of 
// the sensors is provided as a level-order input, where missing sensors are 
// represented as -1.

// Your task is to build the sensor network as a binary tree and then determine 
// the left-most sensor IDs at each level.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// A list of integers representing the left-most sensor IDs at each level


// Sample Input-1:
// ---------------
// 1 2 3 4 -1 -1 5

// Sample Output-1:
// ----------------
// [1, 2, 4]



// Sample Input-2:
// ---------------
// 3 2 4 1 5

// Sample Output-2:
// ----------------
// [3, 2, 1]




import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Leftview {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        return leftview(root, res, 0);
    }

    public static List<Integer> leftview(TreeNode curr, List<Integer> res, int level) {
        if (curr == null) return res;
        if (level == res.size()) res.add(curr.val);
        leftview(curr.left, res, level + 1);
        leftview(curr.right, res, level + 1);
        return res;
    }
}