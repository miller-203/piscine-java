public class RegexReplace {
    public static String removeUnits(String s) {
        return s.replaceAll("[^0.9]", "");
    }
    
    // public static String obfuscateEmail(String s) {
    //     // your code here
    // }
}