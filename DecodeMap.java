// In a forgotten realm, explorers often find ancient treasure maps written as 
// long strings of mysterious characters with no spaces. Luckily, they also carry 
// an ancient wordbook (pathBook) containing all the known names of places, 
// landmarks, and directions.

// Your task is to help the explorer decode the map by inserting spaces such that 
// each segment is a valid location or direction from the pathBook. Return all 
// possible ways to break the map string into a valid sequence of known locations.

// You can reuse entries from the pathBook as many times as needed.

// Example 1:
// ----------
// input:
// deserttemplegolds			//Trasure map
// desert temple gold golds	//pathBook

// output:
// [desert temple gold]

// Explanation: The map can be decoded directly into three known places.

// Example 2:
// ----------
// input:
// forestforesthill
// forest hill

// output:
// [forest forest hill]

// Explanation: The explorer can reuse 'forest' more than once.

// Example 3:
// ----------
// input:
// oceanmountaintemple
// mountain temple

// output:
// []

// Explanation: The map begins with 'ocean', which is missing from the pathBook, so no decoding is possible.


// Map Decoding Constraints:
// - 1 <= map.length <= 20
// - 1 <= pathBook.length <= 1000
// - 1 <= pathBook[i].length <= 10
// - All strings consist of lowercase English letters.
// - All entries in pathBook are unique.
// - Input is structured so the total number of valid decoded strings does not exceed 10^5.
    
// Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
// Output: ["cats and dog","cat sand dog"]
import java.util.*;

public class DecodeMap {
    private static void helper(String s,Set<String> words,int start,List<String> path,List<String> res){
        int n=s.length();
        if (start==n){
            res.add(String.join(" ",path));
            return ;
        }
        for(int end=start+1;end<=n;end++){
            String curr=s.substring(start, end);
            if(words.contains(curr)){
                path.add(curr);
                helper(s,words,end,path,res);
                path.remove(path.size()-1);
            }
        }
       
    }
    public static List<String> funn(String s,Set<String> words){
        List<String> res=new ArrayList<>();
        // if(s.length()==0) return res;
        helper(s,words,0,new ArrayList<>(),res);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String dict=sc.nextLine();
        Set<String> words=new HashSet<>(Arrays.asList(dict.split(" ")));
        // we are turning it into set for faster lookup
        // System.out.println(words);
        System.out.println(funn(s,words));
        sc.close();
    }
}
