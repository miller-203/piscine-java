import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StreamCollect {
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        return s.collect(Collectors.groupingBy(str -> Character.toUpperCase(str.charAt(0))));
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer>
    s) {
        return s.collect(Collectors.groupingBy(n -> n % 4, Collectors.maxBy(Integer::compareTo)));
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        return s.sorted().collect(Collectors.joining(" # ", "{", "}"));
    }
}