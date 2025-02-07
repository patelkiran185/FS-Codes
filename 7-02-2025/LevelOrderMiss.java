// Write a program to construct a binary tree from level-order input, while treating -1 
// as a placeholder for missing nodes. The program reads input, constructs the tree, 
// and provides an in-order traversal to verify correctness.

// Input Format:
// ---------------
// Space separated integers, level order data (where -1 indiactes null node).

// Output Format:
// -----------------
// Print the in-order data of the tree.


// Sample Input:
// ----------------
// 1 2 3 -1 -1 4 5

// Sample Output:
// ----------------
// 2 1 4 3 5

// Explanation:
// --------------
//     1
//    / \
//   2   3
//      / \
//     4   5


// Sample Input:
// ----------------
// 1 2 3 4 5 6 7

// Sample Output:
// ----------------
// 4 2 5 1 6 3 7

// Explanation:
// --------------
//         1
//        / \
//       2   3
//      / \  / \
//     4  5 6  7


import java.util.*;
class TreeNode 
{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class LevelOrderMiss{
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        int[] levelOrder = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            levelOrder[i] = Integer.parseInt(arr[i]);
        }
        TreeNode root = buildTree(levelOrder);
        inorderTraversal(root);
        sc.close();
    }
public static TreeNode buildTree(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();
            if (i < levelOrder.length && levelOrder[i] != -1) {
                current.left = new TreeNode(levelOrder[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < levelOrder.length && levelOrder[i] != -1) {
                current.right = new TreeNode(levelOrder[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
    public static void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }
    }