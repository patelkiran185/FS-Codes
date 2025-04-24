import java.util.*;
class LetterCombination{
    static Map<Character,String> mpp=new HashMap<>();
    static {
        mpp.put('2',"abc");
        mpp.put('3',"def");
        mpp.put('4',"ghi");
        mpp.put('5',"jkl");
        mpp.put('6',"mno");
        mpp.put('7',"pqrs");
        mpp.put('8',"tuv");
        mpp.put('9',"wxyz");
    }
    static void backtrack(int i,String curStr,List<String> res,String digits){
        if(curStr.length() == digits.length()){
            res.add(curStr);
            return;
        }
        char digit=digits.charAt(i);
        String letters=mpp.get(digit);
        for(char letter:letters.toCharArray()){
            backtrack(i+1,curStr+letter,res,digits);
        }
    }
    static List<String> lettercombo(String digit){
        List<String> res=new ArrayList<>();
        if(digit.isEmpty()) return res;
        backtrack(0,"",res,digit);
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new  Scanner(System.in);
        String n=sc.nextLine();
        List<String> res=lettercombo(n);
        System.out.print(res);
        sc.close();
    }
}