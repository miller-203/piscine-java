import java.io.*;

public class Cat {
    public static void cat(String[] args) throws IOException {
        for (String fileName : args) {
            try {
                byte[] bytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(fileName));
                System.out.write(bytes);
                // System.out.println(bytes);
            } catch (IOException e) {
                System.out.println("cat: " + fileName + ": No such file or directory");
            }
        }
    }
}
