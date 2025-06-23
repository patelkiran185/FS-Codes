// package vacation_practise;


// Pranav has a puzzle board filled with square boxes in the form of a grid.
// Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

// Pranav wants to find out the number of empty spaces which are completely 
// surrounded by the square boxes (left, right, top, bottom) in the board.

// You are given the board in the form of a grid M*N, filled wth 0's and 1's.
// Your task is to help Pranav to find the number of empty groups surrounded by
// the boxes in the puzzle board.

// Input Format:
// -------------
// Line-1: Two integers M and N, the number of rows and columns in the board.
// Next M lines: contains N space-separated either 0 or 1.

// Output Format:
// --------------
// Print an integer, the number of empty spaces in the puzzle board.


// Sample Input-1:
// ---------------
// 6 7
// 1 1 1 1 0 0 1
// 1 0 0 0 1 1 0
// 1 0 0 0 1 1 0
// 0 1 1 1 0 1 0
// 1 1 1 0 0 1 1
// 1 1 1 1 1 1 1

// Sample Output-1:
// ----------------
// 2

// Explanation:
// ------------
// The 2 empty groups are as follows:
// 1st group starts at cell(1,1), 2nd group starts at cell(3,4).
// The groups which are starts at cell(0,4), cell(1,6) and cell(3,0)
// are not valid empty groups, because they are not completely surrounded by boxes.


// Sample Input-2:
// ---------------
// 6 6
// 1 1 0 0 1 1
// 1 0 1 1 0 1
// 0 1 0 1 0 0
// 1 1 0 0 0 1
// 0 0 1 0 1 1
// 1 1 0 1 0 0

// Sample Output-2:
// ----------------
// 1

// Explanation:
// ------------
// The only empty group starts at cell(1,1) is surrounded by boxes.






import java.util.*;
public class CountGroups {
    public static int funcc(int[][] grid,int m,int n){
        int ans=0;
        boolean[][] visited=new boolean[m][n];
        // visited array to check if it traversed

        int[] dx={-1,1,0,0};
        int[] dy={0,0,-1,1};
        // to move in up down left right directions

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && !visited[i][j]){ // only done if it is 0 and is not visited
                    boolean isValid=true;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    visited[i][j]=true;

                    while(!q.isEmpty()){
                        int[] cell=q.poll();
                        int x=cell[0];
                        int y=cell[1];
                        System.out.println("Processing cell (" + x + ", " + y + ")");


                        if(x==0 || x==m-1 || y==0 || y==n-1){
                            isValid=false;

                        }
                        for(int k=0;k<4;k++){
                            int nx=x+dx[k];
                            int ny=y+dy[k];
                            if(nx>=0 && nx<m && ny>=0 && ny<n && !visited[nx][ny] && grid[nx][ny]==0){
                                q.add(new int[]{nx,ny});
                                visited[nx][ny]=true;
                                System.out.println("Adding neighbor (" + nx + ", " + ny + ") to the queue.");
                            }
                        }
                    }



                    if(isValid){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(funcc(arr,m,n));
        sc.close();
    }
}
