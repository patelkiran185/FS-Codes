import java.util.*;

class Matchstick {
    public static boolean makesquare(int[] matchsticks) {
        
        int sum=0;
        for(int i=0;i<matchsticks.length;i++){
            sum+=matchsticks[i];
        }
        if(sum%4 != 0 ) return false;
        int a=sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides=new int[4];
        return backtrack(matchsticks,sides,0,a);
    }
   private static boolean backtrack(int[] matchsticks, int[] sides, int index, int targetLength) {  
        if (index == matchsticks.length) {  
            return sides[0] == targetLength && sides[1] == targetLength &&  
                   sides[2] == targetLength && sides[3] == targetLength;  
        }  
        for (int i = 0; i < 4; i++) {  
            if (sides[i] + matchsticks[index] <= targetLength) {  
                sides[i] += matchsticks[index];  
                
                if (backtrack(matchsticks, sides, index + 1, targetLength)) {  
                    return true;  
                }   
                sides[i] -= matchsticks[index];  
            }  
            if (sides[i] == 0) break;   
        }  
        return false;  
    }  
    private static void reverse(int[] matchsticks) {  
        for (int i = 0; i < matchsticks.length / 2; i++) {  
            int temp = matchsticks[i];  
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];  
            matchsticks[matchsticks.length - 1 - i] = temp;  
        }  
    } 
    public static void main(String[] args) {
        int[] arr={1,1,2,2,2};
        System.out.println(makesquare(arr));
    }
}