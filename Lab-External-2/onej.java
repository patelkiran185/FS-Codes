
import java.util.*;
import java.util.LinkedList;


public class onej{
    static class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val=val;
        left=null;
        right=null;
    }
}

    public static void main(String[] args) {
        Integer[] arr={3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root=buildTree(arr);
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        int q=sc.nextInt();
        TreeNode px=new TreeNode(p);
        TreeNode py=new TreeNode(q);
        TreeNode res=getlowestancestor(root,px,py);
        System.out.println(res.val);
        sc.close();

    }
    public static TreeNode buildTree(Integer[] arr){
        if(arr.length==0 || arr[0]==null)return null;
        TreeNode root=new TreeNode(arr[0]);
        Queue<TreeNode> btq=new LinkedList<>();
        btq.offer(root);
        int i=1;
        while(i<arr.length){
            TreeNode curr=btq.poll();
            if(i<arr.length && arr[i]!=null){
                curr.left = new TreeNode(arr[i]);
                btq.offer(curr.left);
            }
            i++;
            if(i<arr.length && arr[i]!=null){
                curr.right=new TreeNode(arr[i]);
                btq.offer(curr.right);
            }
            i++;
        }
        return root;
    }
    public static TreeNode getlowestancestor(TreeNode root,TreeNode p,TreeNode q){
        List<TreeNode> path1=new ArrayList<>();
        List<TreeNode> path2=new ArrayList<>();
        getpath(root,p,path1);
        getpath(root,q,path2);

        int i=0;
        while(i<path1.size() && i<path2.size() && path1.get(i)==path2.get(i)){
            i++;
        }
        return path1.get(i-1);
    }
    public static boolean getpath(TreeNode root,TreeNode tar,List<TreeNode> path){
        if(root==null) return false;
        path.add(root);
        if(root.val==tar.val) return true;
        if(getpath(root.left, tar, path) || getpath(root.right, tar, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}

