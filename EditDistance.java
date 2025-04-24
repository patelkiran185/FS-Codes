import java.util.*;

public class EditDistance {

    public static int updateWord(List<String> words, String startWord, String endWord) {
        // your code goes here
        if(startWord.equals(endWord)) return 0;
        if ((!words.contains(startWord)) || (!words.contains(endWord))) {
            return -1;
        }
        int i=-1;
        int j=-1;
        for(int k=0;k<words.size();k++){
            if(words.get(k).equals(startWord)){
                i=k;
            }if(words.get(k).equals(endWord)){
                j=k;
            }
        }
      return Math.abs(j-i);
    }
    
    public static void main(String[] args) {
        // debug your code below
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println(EditDistance.updateWord(wordList, beginWord, endWord));
    }
}