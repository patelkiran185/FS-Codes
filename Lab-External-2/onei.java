
import java.util.*;

public class onei {
    public static void main(String[] args) {
        
    }
     public static int[][] indexPairsBruteForce(String text, String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        List<int[]> result = new ArrayList<>();
        
        // Check all possible substrings
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                String substring = text.substring(i, j + 1);
                if (wordSet.contains(substring)) {
                    result.add(new int[]{i, j});
                }
            }
        }
        
        // Sort by first coordinate, then by second coordinate
        result.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        return result.toArray(new int[result.size()][]);
    }
}
