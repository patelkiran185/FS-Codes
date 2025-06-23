import java.util.*;
import java.util.stream.*;

public class SortFreStream {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(getFre(str));
        sc.close();
    }
    public static String getFre(String str){
        String res=str.chars()
                        .mapToObj(s->(char) s)
                        .collect(Collectors.groupingBy(c->c,Collectors.counting()))
                        .entrySet().stream()
                        .sorted(Comparator
                        .comparing(Map.Entry<Character,Long>::getValue,Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey)
                        )
                        .map(e->String.valueOf(e.getKey()).repeat(e.getValue().intValue()))
                        .collect(Collectors.joining())
                        ;

        return res;
    }
}
