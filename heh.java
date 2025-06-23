import java.util.*;
class heh{
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
        System.out.println(getMaxEnemies(arr,m,n));
        sc.close();
    }
    public static int getMaxEnemies(char[][] arr,int m,int n){
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=0;
                if(arr[i][j]=='0'){
                    for(int k=i-1;k>=0;k--){
                        if(arr[k][j]=='W'){
                            break;
                        } if(arr[k][j]=='B'){
                            temp++;
                        }
                    }
                    for(int k=i+1;k<m;k++){
                        if(arr[k][j]=='W'){
                            break;
                        }if(arr[k][j]=='B'){
                            temp++;
                        }
                    }
                    for(int k=j-1;k>=0;k--){
                        if(arr[i][k]=='W'){
                            break;
                        }if(arr[i][k]=='B'){
                            temp++;
                        }
                    }
                    for(int k=j+1;k<n;k++){
                        if(arr[i][k]=='W'){
                            break;
                        } if(arr[i][k]=='B'){
                            temp++;
                        }
                    }
                }
                c=Math.max(c,temp);
            }
        }
        return c;
    }
}