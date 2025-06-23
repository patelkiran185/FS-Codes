// Venkatadri is a maths teacher.
// He is teaching matrices to his students.
// He is given a matrix of size m*n, and it contains only positive numbers.
// He has given a task to his students to find the special matrix, 
// in the iven matrix A[m][n].
// A special matrix has following property:
// 	- The sum of elements in each row, each column and the two diagonals are equal.
// 	- Every 1*1 matrix is called as a special matrix.
// 	- The size of the special matrix should be a square, i.e., P*P.

// Your task is to help the students to find the speical matrix  with max size P.


// Input Format:
// -------------
// Line-1: Two space separated integers M and N, size of the matrix.
// Next M lines: N space separated integers m and n.

// Output Format:
// --------------
// Print an integer, maximum size P of the special matrix.


// Sample Input-1:
// ---------------
// 5 5
// 7 8 3 5 6
// 3 5 1 6 7
// 3 5 4 3 1
// 6 2 7 3 2
// 5 4 7 6 2

// Sample Output-1:
// ----------------
// 3

// Explanation:
// ------------
// The special square is:
// 5 1 6
// 5 4 3
// 2 7 3


// Sample Input-2:
// ---------------
// 4 4
// 7 8 3 5
// 3 2 1 6
// 3 2 3 3
// 6 2 3 3

// Sample Output-2:
// ----------------
// 2

// Explanation:
// ------------
// The special square is:
// 3 3
// 3 3



import java.util.*;
class SpecialMatrixFinder{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int[][] grid=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println(funcc(grid,m,n));
        sc.close();
    }
    public static int funcc(int[][] grid,int m,int n){
        int maxiSize=Math.min(m,n);
        for(int size=maxiSize;size>=1;size--){
            for(int i=0;i<=m-size;i++){
                for(int j=0;j<=n-size;j++){
                    if(matrixis(grid,i,j,size)){
                        return size;
                    }
                }
            }
        }
        return 1;
    }
    private static boolean matrixis(int[][] grid,int row,int col,int size){
        int tSum=0;
        for(int i=0;i<size;i++){
            tSum+=grid[row][col+i];
        }
       
        for(int i=0;i<size;i++){
            int roSum=0;
            for(int j=0;j<size;j++){
                roSum+=grid[row+i][col+j];
            }
            if(roSum!=tSum) return false;
        }
        
        for(int j=0;j<size;j++){
            int colSum=0;
            for(int i=0;i<size;i++){
                colSum+=grid[row+i][col+j];
            }
            if(colSum!=tSum) return false;
        }
        
        int d=0;
        for(int i=0;i<size;i++){
            d+=grid[row+i][col+i];
        }
        if(d!=tSum) return false;
        
        int d1=0;
        for(int i=0;i<size;i++){
            d1+=grid[row+i][col+size-1-i];
        }
        if(d1!=tSum) return false;
        return true;
    }
}