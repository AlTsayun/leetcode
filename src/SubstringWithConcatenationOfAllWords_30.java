import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords_30 {
    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(new Solution().findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(new Solution().findSubstring("a", new String[]{"a"}));
    }

    private static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            var res = new ArrayList<Integer>();
            var wordLength = words[0].length();
            var wordToCount = new HashMap<String, Integer>();
            for (String word : words) {
                wordToCount.merge(word, 1, Integer::sum);
            }
            var clone = (HashMap<String, Integer>) wordToCount.clone();
            for (int i = 0; i < s.length() - wordLength + 1; i++) {
                int j = i;
                while (j < s.length() - wordLength + 1) {
                    var word = s.substring(j, j + wordLength);
                    if (clone.containsKey(word)) {
                        clone.compute(word, (key, value) -> value > 1 ? value - 1 : null);
                        j += wordLength;
                    } else {
                        break;
                    }
                }
                if (clone.isEmpty()) {
                    res.add(i);
                }
                clone.putAll(wordToCount);
            }
            return res;
        }
    }
}
