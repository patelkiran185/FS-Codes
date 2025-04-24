import java.util.*;
public class solu {
    public static int[] missreparr(int[][] grid){
        int n=grid.length;
        int size=n*n;
        int[] freq=new int[size+1];
        int a=-1,b=-1;
        for(int[] row:grid){
            for(int l:row){
                freq[l]++;
            }
        }
        for(int i:freq){
            System.out.print(i+ " ");
        }
        for(int i=1;i<=size;i++){
            if(freq[i]==0) b=i;
            if(freq[i]==2) a=i;
        }
        return new int[]{a,b};
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] grid=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        int[] res=new int[2];
        res=missreparr(grid);
        System.out.println(res[0]+" "+res[1]);
        sc.close();

    }
}
