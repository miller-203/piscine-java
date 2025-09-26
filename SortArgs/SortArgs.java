public class SortArgs {
    public static void sort(String[] args) {
        java.util.Arrays.sort(args);
        System.out.println(String.join(" ", args));
    }
}