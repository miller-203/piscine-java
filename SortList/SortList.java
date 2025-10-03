import java.util.List;
import java.util.Collections;
import java.util.ArrayList;


public class SortList {
    public static List<Integer> sort(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy);
        return copy;
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        if (list == null) {
            return null;
        }
        List<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy, Collections.reverseOrder());
        return copy;
    }
}