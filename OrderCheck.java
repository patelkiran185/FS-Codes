
// Problem Statement: In an IT company there are n number of Employees, they are
// asked to stand in ascending order according to their heights.But some employees are
// not currently standing in their correct position.
// Your task is to find how many employees are there who are not standing in their
// correct positions.
// Example height=[,,,,,,]
// The  employees at indices ,, and  are not in the right positions. The correct
// positions are (,,,,,).Return .
// Function Description Complete the function countEmployees in the editor below.
// count Employee has the following parameter(s):
// int height[n]:an array of heights in the order the employees are standing
// Returns:
// int: the number of employees not in their correct positions



import java.util.*;

public class OrderCheck {
    public static void main(String[] args) {
        int[] arr={1,2,1,3,3,4,3};
        System.out.println(getIndicesfrom(arr));
    }
    public static int getIndicesfrom(int[] arr){
        int ans=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                continue;
            }else{
                ans++;
            }
        }
        return ans;
    }
}
