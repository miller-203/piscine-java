import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
        
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> result = new HashSet<>();
        Set<Integer> copy = new HashSet<>(set1);
        for (Integer element : copy) {
            if (set2.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}