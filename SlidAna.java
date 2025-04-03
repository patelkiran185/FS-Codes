import java.util.*;
class SlidAna{
    public static List<Integer> funcc(String str1,String str2){
        List<Integer> res=new ArrayList<>();
        if(str1.length()<=str2.length()) {
            return res;
        }
        Map<Character,Integer> str2freq=new HashMap<>();
        Map<Character,Integer> str1freq=new HashMap<>();
        for(char c:str2.toCharArray()){
            str2freq.put(c,str2freq.getOrDefault(c,0)+1);
        }
        int n=str2.length();
        for(int i=0;i<n;i++){
            char c=str1.charAt(i);
            str1freq.put(c,str1freq.getOrDefault(c,0)+1);
        }
        if(str1freq.equals(str2freq)){
            res.add(0);
            }
        for(int i=n;i<str1.length();i++){
            char nc=str1.charAt(i);
            char oc=str1.charAt(i-n);
            str1freq.put(nc,str1freq.getOrDefault(nc,0)+1);
  
                    str1freq.put(oc,str1freq.get(oc)-1);
    
             if(str1freq.get(oc)==0){
                str1freq.remove(oc);
            }
            if(str1freq.equals(str2freq)){
                res.add(i-n+1);
                }
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String note=sc.next();
        String code=sc.next();
        List<Integer> ans= funcc(note,code);
        System.out.print(ans);
        
    }
}