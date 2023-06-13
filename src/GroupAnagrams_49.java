import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            var indexes = new HashMap<String, List<Integer>>();
            for (int i = 0; i < strs.length; i++) {
                var key = sort(strs[i]);
                var indices = indexes.get(key);
                if (indices == null) {
                    indices = new ArrayList<>();
                }
                indices.add(i);
                indexes.put(key, indices);
            }
            return indexes.values().stream()
                    .map(indices -> {
                            return indices.stream()
                                .map(i -> strs[i])
                                .collect(Collectors.toList());
                    })
                    .collect(Collectors.toList());
        }

        private String sort(String str) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
