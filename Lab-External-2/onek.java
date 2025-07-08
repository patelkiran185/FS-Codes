
public class onek {
    public static void main(String[] args) {
        int[][] matrix={{9,9,6},{6,2,1},{1,2,1}};
        System.out.println(longestIncreasingPath(matrix));;
    }
    public static final int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};

    public static int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        if(matrix.length==0) return 0;

        int maxi=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int len=dfs(m,n,i,j,dp,matrix);
                maxi=Math.max(maxi,len);
            }
        }
        return maxi;
    }
    public static int dfs(int m,int n,int i,int j,int[][] dp,int [][] matrix){
        if(dp[i][j]!=0)return dp[i][j];
        int maxi=1;
        for(int[] dir : dirs){
            int x=i+dir[0];
            int y=j+dir[1];
            if(x<0 || x >=m || y<0 || y >=n || matrix[x][y]<=matrix[i][j]) continue;
            int len=1+dfs(m,n,x,y,dp,matrix);
            maxi=Math.max(len,maxi);
        }
        dp[i][j]=maxi;
        return maxi;
    }
}
