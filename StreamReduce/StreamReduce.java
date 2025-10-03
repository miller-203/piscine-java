import java.util.stream.*;


public class StreamReduce {
    public static Integer sumAll(Stream<Integer> s) {
        return s.reduce(0, Integer::sum);
    }

    public static Integer divideAndAddElements(Stream<Integer> s, int divider) {
        return s.map(x -> x / divider).reduce(0, Integer::sum);
    }
}