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
class ValidPath{
    public static Node buildTree(int[] arr){
        if(arr.length==0) return null;
        
        List<Node> nodes=new ArrayList<>();
        
        for(int val:arr){
            nodes.add(new Node(val));
        }

        for(int i=0;i<arr.length;i++){
            int leftI=2*i+1;
         
            int rightI=2*i+2;
            if(leftI<arr.length){
                nodes.get(i).left=nodes.get(leftI);
            }

            if(rightI<arr.length){
                nodes.get(i).right=nodes.get(rightI);
            }
        }
        return nodes.get(0);
    }
    public static boolean checkValidPath(Node root,int[] path){
        if(root == null )return false;
        return dfs(root,path,0);
    }
    public static boolean dfs(Node node,int[] path,int index){
        if(node == null || index >= path.length || node.val != path[index]){
        return false;
        }
        if (index == path.length - 1) { 
        return true;
    }

        return dfs(node.left,path,index+1) || dfs(node.right,path,index+1);

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        int[] arr=new int[input.length];
        
        String[] input1=sc.nextLine().split(" ");
        int[] path=new int[input1.length];
        for(int i=0;i<input.length;i++){
            arr[i]=Integer.parseInt(input[i]);
        }

        for(int i=0;i<input1.length;i++){
            path[i]=Integer.parseInt(input1[i]);
        }
        Node root=buildTree(arr);
        boolean ans=checkValidPath(root,path);
        System.out.println(ans);
        sc.close();
    }
}