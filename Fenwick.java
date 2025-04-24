import java.util.*;
class BinaryIndexedTree{
   final static int MAX=1000;
    static int BITTree[]=new int[MAX];
    int getSum(int index){
        int sum=0;
        index=index+1;
        while(index>0){
            sum+=BITTree[index];
            index-=index & (-index);
        }
        return sum;
    }
    public static void update(int n,int index,int val){
        index=index+1;
        while(index<=n){
            BITTree[index]+=val;
            index+=index & (-index);
        }
    }
    void construct(int[] arr,int n){
        for(int i=1;i<=n;i++){
            BITTree[i]=0;
        }
        for(int i=0;i<n;i++){
            update(n,i,arr[i]);
        }
    }
}
class Fenwick{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        BinaryIndexedTree bit=new BinaryIndexedTree();
        bit.construct(arr,n);
        System.out.println(bit.getSum(5));
        bit.update(n,3,6);
        System.out.print(bit.getSum(5));
        sc.close();
    }
}