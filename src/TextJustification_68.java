import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification_68 {
    public static void main(String[] args) {
//        println(new Solution().fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        println(new Solution().fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16));
        println(new Solution().fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20));
    }

    private static void println(List<String> lines) {
        lines.stream()
                .map(line -> "\"" + line + "\"")
                .forEach(System.out::println);
    }

    private static class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            var res = new ArrayList<String>();
            for (int i = 0; i < words.length; i++) {
                int fromWord = i;
                int filledWidth = 0;
                int widthToFill = words[i].length() + 1;
                while (widthToFill <= maxWidth + 1 && i < words.length) {
                    filledWidth = widthToFill;
                    i++;
                    if (i < words.length) {
                        widthToFill += words[i].length() + 1;
                    }
                }
                i--;
                filledWidth--;

                var line = new ArrayList<String>();
                for (int j = fromWord; j < i + 1; j++) {
                    line.add(words[j]);
                    line.add(" ");
                }
                line.remove(line.size() - 1);

                if (i == words.length - 1 || line.size() == 1) {
                    // Last line of text should be left-justified, and no extra space between words
                    // The same logic applies to lines with single word
                    while (filledWidth < maxWidth) {
                        line.add(" ");
                        filledWidth++;
                    }
                } else {
                    int k = 0;
                    while (filledWidth < maxWidth) {
                        while(line.get(k).equals(" ")) {
                            k++;
                        }
                        if (k == line.size() - 1) {
                            k = 0;
                            continue;
                        }
                        line.add(++k, " ");
                        filledWidth++;
                    }
                }
                res.add(String.join("", line));
            }
            return res;
        }
    }
}
