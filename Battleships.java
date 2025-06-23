import java.util.*;

public class Battleships {
    public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        char[][] arr=new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.next().charAt(0);
            }
        }
        System.out.println(getbattleships(arr,m,n));
        sc.close();
    }
    public static int getbattleships(char[][] arr,int m,int n){
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            
                if(arr[i][j]=='X'){
                    if((i==0 || arr[i-1][j]=='.') && (j==0 || arr[i][j-i]=='.')){
                        c++;
                    }
                }
            }
        }
        return c;
    }
}
