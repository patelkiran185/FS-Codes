// Balbir Singh is working with Binary Trees.
// The elements of the tree are given in level-order format.

// Balbir is observing the tree from the right side, meaning he 
// can only see the rightmost nodes (one node per level).

// You are given the root of a binary tree. Your task is to determine 
// the nodes visible from the right side and return them in top-to-bottom order.

// Input Format:
// -------------
// Space separated integers, elements of the tree.

// Output Format:
// --------------
// A list of integers representing the node values visible from the right side


// Sample Input-1:
// ---------------
// 1 2 3 5 -1 -1 5

// Sample Output-1:
// ----------------
// [1, 3, 5]



// Sample Input-2:
// ---------------
// 3 2 4 3 2

// Sample Output-2:
// ----------------
// [3, 4, 2]


import java.util.*;
class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
    }
}

class Solution{
    private static Node buildTree(int[] levelorder,int idx){
        if(levelorder.length==0) return null;
        Queue<Node> q=new LinkedList<>();
        
        Node root=new Node(levelorder[idx]);
        q.offer(root);
        int i=1;
        while(!q.isEmpty() && i< levelorder.length){
            Node curr=q.poll();
            if(levelorder[i]!=-1){
                curr.left=new Node(levelorder[i]);
                q.offer(curr.left);
                
            }
            i++;
            if(i<levelorder.length && levelorder[i]!=-1){
                curr.right=new Node(levelorder[i]);
                q.offer(curr.right);
            }
            i++;
        }
       
        return root;
    }
    public static  List<Integer> getRightView(int[] levelorder){
        if(levelorder==null || levelorder.length==0) return new ArrayList<>();
        Node root=buildTree(levelorder,0);
        List<Integer> res=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node curr=q.poll();
                if(i==size-1){
                    res.add(curr.val);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            
        }
        return res;
        
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int[] levelorder=new int[input.length];
        for(int i=0;i<input.length;i++){
            levelorder[i]=Integer.parseInt(input[i]);
        }
        List<Integer> ans=getRightView(levelorder);
        System.out.println(ans);
        sc.close();
    }
}