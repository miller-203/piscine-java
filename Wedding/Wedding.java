import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Wedding {
    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        Map<String, String> couples = new HashMap<>();
        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);
        
        int size = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < size; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }
        return couples;
        
    }
}