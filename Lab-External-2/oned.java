// In Hyderabad after a long pandemic gap, the Telangana Youth festival is 
// Organized at HITEX. In HITEX, there are a lot of programs planned. During 
// the festival in order to maintain the rules of Pandemic, they put a 
// constraint that one person can only attend any one of the programs in 
// one day according to planned days.

// Now it’s your aim to implement the "Solution" class in such a way that 
// you need to return the maximum number of programs you can attend according 
// to given constraints.

// Explanation:
// You have a list of programs 'p' and days 'd', where you can attend only 
// one program on one day. Programs [p] = [first day, last day], 
// p is the program's first day and the last day.


// Input Format:
// -------------
// Line-1: An integer N, number of programs.
// Line-2: N comma separated pairs, each pair(f_day, l_day) is separated by space.

// Output Format:
// --------------
// An integer, the maximum number of programs you can attend.


// Sample Input-1:
// ---------------
// 4
// 1 2,2 4,2 3,2 2

// Sample Output-1:
// ----------------
// 4

// Sample Input-2:
// ---------------
// 6
// 1 5,2 3,2 4,2 2,3 4,3 5

// Sample Output-2:
// ----------------
// 5
import java.util.*;
class oned{
    public static void buildSegmentTree(int[] arr,int start,int end,int node){
        if(start==end){
            segmentTree[node]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        buildSegmentTree(arr, start, mid, 2*node+1);
        buildSegmentTree(arr, mid+1, end, 2*node+2);
        segmentTree[node]=Math.max(segmentTree[2*node+1],segmentTree[2*node+2]);
    }
    public static int querySegmentTree(int start, int end, int l, int r, int node) {
        // If the range [l, r] is completely outside [start, end]
        if (r < start || l > end) {
            return Integer.MIN_VALUE; // Return a very small value
        }
        // If the range [l, r] is completely inside [start, end]
        if (l <= start && r >= end) {
            return segmentTree[node];
        }
        // If the range [l, r] partially overlaps with [start, end]
        int mid = (start + end) / 2;
        int leftMax = querySegmentTree(start, mid, l, r, 2 * node + 1);
        int rightMax = querySegmentTree(mid + 1, end, l, r, 2 * node + 2);

        return Math.max(leftMax, rightMax);
    }

    // define segment tree size
    static int[] segmentTree;
    public static int findmaxiPrograms(int[] arr,int n){
        //initialising segment tree with space 4*n where n is number of nodes or number of elements
        segmentTree=new int[4*n];
        // build segment tree
        buildSegmentTree(arr,0,n-1,0);

        // query the max 
        int res=querySegmentTree(0,n-1,0,n-1,0);
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine(); //consume the newline character in the input buffer, if u want to read the next line of input we use this
        String input=sc.nextLine();

        int[] arr=new int[n*2];
        
        String parts[]=input.split(",");

        for(int i=0;i<n;i++){
            String[] nums=parts[i].split(" ");
            arr[i*2]=Integer.parseInt(nums[0]);
            arr[i*2+1]=Integer.parseInt(nums[1]);
        }
        int ans=findmaxiPrograms(arr,arr.length);
        System.out.println(ans);
        sc.close();
    }
}