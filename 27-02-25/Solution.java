
// import java.util.*;
// class Solution{
//     public static boolean isSymmetricDesign(String input){
//         HashMap<Character,Integer> mpp=new HashMap<>();
//         for(int i=0;i<input.length();i++){
//             char ch=input.charAt(i);
//             mpp.put(ch,mpp.getOrDefault(ch,0)+1);
//         }
//         int odd=0;
//         for(Map.Entry<Character,Integer> s : mpp.entrySet()){
//             if(s.getValue() %2 != 0){
//                 odd++;
              
//             }
//         }
//         return odd<=1 ? true : false;
//     }
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         String input=sc.next();
//         System.out.println(isSymmetricDesign(input));
//         sc.close();
//     }
// }

import java.util.*;
public class Solution {
    static int[] parent=new int[26];
    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    static void union(int x,int y){
        int rootX=find(x);
        int rootY=find(y);
        if(rootX!=rootY){
            if(rootX<rootY){
                parent[rootY]=rootX;
            }else{
                parent[rootX]=rootY;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] input=sc.nextLine().split(" ");
        String key1=input[0];
        String key2=input[1];
        String ciphertext=input[2];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(int i=0;i<key1.length();i++){
            union(key1.charAt(i)-'a',key2.charAt(i)-'a');
        }
        StringBuilder ans=new StringBuilder();
        for(char ch:ciphertext.toCharArray()){
            ans.append((char)(find(ch - 'a')+'a'));
        }
        System.out.println(ans.toString());
       
        sc.close();
    }
     
}