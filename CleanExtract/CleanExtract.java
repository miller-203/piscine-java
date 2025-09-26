public class CleanExtract {
    public static String extract(String s) {
        String[] words = s.split("\\|");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i].trim();
            int firstDot = word.indexOf('.');
            int lastDot = word.lastIndexOf('.');
            if (firstDot != -1 && lastDot != -1 && firstDot != lastDot) {
                result += word.substring(firstDot + 1, lastDot).trim();
            } else if (firstDot != -1) {
                result += word.substring(firstDot + 1).trim();
            } else {
                result += word;
            }
            if (result.length() > 0 && result.charAt(result.length() - 1) != ' ' && i < words.length - 1) {
                result += " ";
            }
        }
        return result;
    }
}