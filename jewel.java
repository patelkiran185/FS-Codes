
import java.util.*;
import java.util.stream.*;

public class jewel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String jewels=sc.next();
        String stones=sc.next();
        System.out.println(getCount(jewels,stones));
        sc.close();
    
    }
    public static int getCount(String jewels,String stones){
        Set<Character> sett=jewels.chars().mapToObj(c->(char)c).collect(Collectors.toSet());
        int count=(int) stones.chars().filter(c->sett.contains((char)c)).count();
        return count;
        // jewels.chars().mapToObj(c->(char)c).collect(Collectors.toSet())
    }
}
