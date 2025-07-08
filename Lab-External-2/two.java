
public class two{
    static int[] parent;
    public static void main(String[] args) {
        String s1="world";
        String s2="hello";
        String base="hallo";
        String res=getLexicographically(s1,s2,base);
        System.out.println(res);
    }
    public static String getLexicographically(String s1,String s2,String base){
        parent=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
        for(int i=0;i<s1.length();i++){
            union(s1.charAt(i)-'a',s2.charAt(i)-'a');
        }
        StringBuilder res=new StringBuilder();
        for(char c:base.toCharArray()){
            char sm=(char) (find(c-'a')+'a');
            res.append(sm);
        }
        return res.toString();
    }
    public static void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px==py) return;
        if(px<py) {
            parent[py]=px;
        }
        else if(px>py){
            parent[px]=py;
        }
    }
    public static int find(int x){
        if(parent[x]!=x){
            return find(parent[x]);
        }
        return x;
    }
}
