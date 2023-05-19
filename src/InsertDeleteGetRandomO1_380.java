import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandomO1_380 {
    public static void main(String[] args) {
        var randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }

    private static class RandomizedSet {
        private final Map<Integer, Integer> indices = new HashMap<>();
        private final List<Integer> numbers = new ArrayList<>();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            indices.put(val, numbers.size());
            numbers.add(val);
            return true;
        }

        public boolean remove(int val) {
            var index = indices.get(val);
            if (index == null) {
                return false;
            }
            var lastIndex = numbers.size() - 1;
            var lastElement = numbers.get(lastIndex);
            if (index != lastIndex) {
                numbers.set(index, lastElement);
                indices.put(lastElement, index);
            }
            indices.remove(val);
            numbers.remove(lastIndex);
            return true;
        }

        public int getRandom() {
            return numbers.get((int) (System.nanoTime() % numbers.size()));
        }
    }
}
