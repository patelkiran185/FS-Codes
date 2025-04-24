import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class Trie {
    private final TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    
    public boolean hasAllPrefixes(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            node = node.children[index];
            if (node == null || !node.isEndOfWord) {
                return false;
            }
        }
        return true;
    }
}

public class LongestValidLevelCode {
    public static String findLongestValidCode(String[] codes) {
        Trie trie = new Trie();
        Arrays.sort(codes);
        
        for (String code : codes) {
            trie.insert(code);
        }
        
        String longestValid = "";
        
        for (String code : codes) {
            if (trie.hasAllPrefixes(code)) {
                if (code.length() > longestValid.length() || (code.length() == longestValid.length() && code.compareTo(longestValid) < 0)) {
                    longestValid = code;
                }
            }
        }
        
        return longestValid;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        
        String[] codes = input.split(" ");
        System.out.println(findLongestValidCode(codes));
    }
}
