// You are developing an application for a garden management system where each tree 
// in the garden is represented as a binary tree structure. The system needs to 
// allow users to plant new trees in a systematic way, ensuring that each tree is 
// filled level by level.

// A gardener wants to:
//  - Plant trees based on user input.
//  - Ensure trees grow in a balanced way by filling nodes level by level.
//  - Inspect the garden layout by performing an in-order traversal, which helps 
//    analyze the natural arrangement of trees.

// Your task is to implement a program that:
//     - Accepts a list of N tree species (as integers).
//     - Builds a binary tree using level-order insertion.
//     - Displays the in-order traversal of the tree.

// Input Format:
// -------------
// - An integer N representing the number of tree plants.
// - A space-separated list of N integers representing tree species.

// Output Format:
// --------------
// A list of integers, in-order traversal of tree.


// Sample Input:
// -------------
// 7
// 1 2 3 4 5 6 7

// Sample Output:
// --------------
// 4 2 5 1 6 3 7


// Explanation:
// ------------
// The tree looks like this:

//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7
// The in order is : 4 2 5 1 6 3 7


import java.util.*;

 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
   }

class LevelOrder{
    
    public static void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root=buildTree(arr);
        inorder(root);
        sc.close();
    }
    public static TreeNode buildTree(int[] arr){
        if(arr.length == 0 || arr == null){
            return null;
        }
        TreeNode root=new TreeNode(arr[0]);
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int i=1;
        while(!q.isEmpty() || i<arr.length){
            TreeNode curr=q.poll();
            if(i<arr.length && arr[i]!=-1){
                curr.left=new TreeNode(arr[i]);
                q.offer(curr.left);
            }i++;
            if(i<arr.length && arr[i]!=-1){
                curr.right=new TreeNode(arr[i]);
                q.offer(curr.right);
            }i++;
        }
        return root;
    }
}
