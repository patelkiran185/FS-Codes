import java.util.*;


public class cipheryext {
    private static int shortstlength(String str){
        String[] words=str.split(" ");
        
        String res=words[0]+"$";
        for(int i=1;i<words.length;i++){
            if(words[i].length()>res.length()){
                res+=words[i]+"$";
            }else{
                if(res.contains(words[i]+"$")){
                    continue;
                }
                res+=words[i]+"$";
            }
        }

        return res.length();
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        String str=sc.nextLine();
        System.out.println(shortstlength(str));
        sc.close();
    }
}