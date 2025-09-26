import java.io.*;
import java.nio.file.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];
        byte[] bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(inputFile));
        String res = Capitalize.cap(new String(bytes).toLowerCase());
        Files.write(Paths.get(outputFile), res.trim().getBytes());
    }
    public static String cap(String s) {
        String[] words = s.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                continue;
            }
            if (word.length() > 0) {
                result += Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
            }
            if (i < words.length - 1) {
                result += " ";
            }
        }
        return result.trim();
    }
}