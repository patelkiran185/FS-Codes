import java.util.*;
public class oneh{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        System.out.println(funcc(input));
        sc.close();
    }
    public static  boolean funcc(String input){
        HashMap<Character,Integer> mpp=new HashMap<>();
        for(int i=0;i<input.length();i++){
            mpp.put(input.charAt(i),mpp.getOrDefault(input.charAt(i), 0)+1);
        }
        
        int countofOne=0;
        List<Integer> l=new ArrayList<>();
        for(Map.Entry<Character,Integer> e:mpp.entrySet()) {
            l.add(e.getValue());
            
        }
        for(int i=0;i<l.size();i++){
            if(l.get(i)%2==1){
                countofOne++;
            }
        }
        return countofOne<=1;
    }
}
