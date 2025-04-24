import java.util.*;
public class MINIMUMOPER {
    public static  int getminium(int[][] grid,int x){
        Set<Integer> array=new HashSet<>();
        int rem=grid[0][0]%x;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]%x != rem){
                    return -1;
                }
                array.add(grid[i][j]);
            }
        }
        int minOp=Integer.MAX_VALUE;
       
        for(int target:array){
            int oper=0;
            for(int[] row:grid){
                for(int value:row){
                    oper+=Math.abs(value-target)/x;
                    System.out.println(oper);
                }
            }
            minOp=Math.min(minOp,oper);
        }
        System.out.println(array);
        return minOp;
    }
    public static void main(String[] args) {
        int[][] grid={{2,4},{6,8}};
        int x=2;
        int res=getminium(grid,x);
        System.out.println(res);
    }
}
