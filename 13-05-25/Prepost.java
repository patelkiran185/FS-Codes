// Given the preorder and postorder traversals of a binary tree, construct 
// the original binary tree and print its level order traversal.

// Input Format:
// ---------------
// Space separated integers, pre order data
// Space separated integers, post order data

// Output Format:
// -----------------
// Print the level-order data of the tree.


// Sample Input:
// ----------------
// 1 2 4 5 3 6 7
// 4 5 2 6 7 3 1

// Sample Output:
// ----------------
// [[1], [2, 3], [4, 5, 6, 7]]

// Explanation:
// --------------
//         1
//        / \
//       2   3
//      / \  / \
//     4   5 6  7


// Sample Input:
// ----------------
// 1 2 3
// 2 3 1

// Sample Output:
// ----------------
// [[1], [2, 3]]

// Explanation:
// --------------
//     1
//    / \
//   2  3



import java.util.*;
class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
   
}
class PrePost{
    
    public static int findIndex(int[] arr,int val,int start){
        for(int i=start;i<arr.length;i++){
            if(arr[i]==val){
                return i;
            }
        }return -1;
    }
    
    
    public static Node constructFromPrePost(int[] preorder,int[] postorder){
        return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }
    
    
    public static Node helper(int[] preorder,int[] postorder,int preStart,int preEnd,int postStart,int postEnd){
        if(preStart>preEnd) return null;
        
        Node root=new Node(preorder[preStart]);
        
        // root node from preorder which is the first element
        if(preStart==preEnd) return root;
        
        
        int leftInPost=findIndex(postorder,preorder[preStart+1],postStart);
        int leftTreeSize=leftInPost-postStart+1;
        
        root.left=helper(preorder,postorder,preStart+1,preStart+leftTreeSize,postStart,leftInPost);
        root.right=helper(preorder,postorder,preStart+leftTreeSize+1,preEnd,leftInPost+1,postEnd-1);
        
        
        
        return root;
    }
    
    public static void printLevelWise(Node root){
        if(root==null) return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> res=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node n=q.poll();
                level.add(n.val);
                if(n.left != null) q.add(n.left);
                if(n.right != null) q.add(n.right);
            }
            res.add(level);
        }
        System.out.println(res);
    }
    private static int[] convertToArray(String str){
        String[] strArr=str.split(" ");
        int[] arr=new int[strArr.length];
        for(int i=0;i<strArr.length;i++){
           arr[i]=Integer.parseInt(strArr[i]);
        }
        return arr;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        int[] preorder=convertToArray(sc.nextLine());
        int[] postorder=convertToArray(sc.nextLine());
        
        Node printt=constructFromPrePost(preorder,postorder);
        
        printLevelWise(printt);
        sc.close();
    }
}