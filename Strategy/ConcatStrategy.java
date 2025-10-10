public class ConcatStrategy implements OperationStrategy{
    public int execute(int a, int b) {
        return Integer.parseInt(String.valueOf(a) + String.valueOf(b));
    }
}
