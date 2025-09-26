public class StringReplace {
    public static String replace(String s, Object target, Object replacement) {
        if (s == null || target == null || replacement == null) {
            return s;
        }
        if (target instanceof Character && replacement instanceof Character) {
            return s.replace((Character) target, (Character) replacement);
        } else if (target instanceof String && replacement instanceof String) {
            return s.replace((String) target, (String) replacement);
        } else {
            return s;
        }
    }
}