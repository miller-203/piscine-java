import java.io.*;
import java.nio.file.*;

public class CatInFile {
    public static void cat(String[] args) {
        for (String fileName : args) {
            try (InputStream in = System.in;
                 OutputStream out = Files.newOutputStream(Paths.get(fileName))) {

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                System.out.println("cat: " + fileName + ": No content");
            }
        }
    }
}
