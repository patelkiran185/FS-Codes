
// Mr Gnanesh is working with inteegrs,
// He is given a list of N tokens, the tokens are printed a number on it.
// You are given the list of numbers printed on Tokens as a list[] of size N.
// You need to help Mr Gnanesh, to find the top F frequent numbers printed 
// on tokens.

// Note: If the frequency of two tokens is same, pick the numbers in sorted order(Asc).

// Input Format:
// ----------------
// Line-1 -> Two Integers, N and F
// Line-2 -> N space separated integers, list[]

// Output Format:
// ------------------
// Print a list of integers of size F, top F frequent elements.


// Sample Input-1:
// ---------------
// 8 3
// 2 1 2 1 3 2 1 4

// Sample Output-1:
// ----------------
// [1, 2, 3]

// Explanation: 
// ------------
// 2 occurs 3 times, 1 occurs 3 times, 3 occurs 1 time, 4 occurs 1 time.
// So the top 3 tokens are 1,2,3.


// Sample Input-2:
// ---------------
// 10 3
// 1 4 2 4 2 2 3 4 1 3

// Sample Output-2:
// ----------------
// [2, 4, 1]








import java.util.*;
import java.util.stream.*;
public class TopFreqNumber{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int f=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        List<Integer> res=getTopFre(arr,n,f);
       System.out.println(res);
        sc.close();
    }
    public static List<Integer> getTopFre(int[] arr,int n,int f){
    //     List<Integer> res=new ArrayList<>();
    //     HashMap<Integer,Integer> mpp=new HashMap<>();
    //     for(int i=0;i<n;i++){
    //         mpp.put(arr[i],mpp.getOrDefault(arr[i],0)+1);
    //     }
    //   List<Map.Entry<Integer,Integer>> sorteden=new ArrayList<>(mpp.entrySet());
    //   sorteden.sort((a,b)->b.getValue()-a.getValue());

    //   for(int i=0;i<Math.min(f,sorteden.size());i++){
    //     res.add(sorteden.get(i).getKey());
    //   }
    List<Integer> res=IntStream.of(arr)
                .boxed()
                .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                .entrySet().stream()
                .sorted(Comparator
                .comparing(Map.Entry<Integer,Long>::getValue,Comparator.reverseOrder())
                .thenComparing(Map.Entry::getKey)
                )
                .limit(f)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
    ;

        return res;
    }
}
