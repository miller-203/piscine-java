import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File baseDir = new File("documents");
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            return "documents folder not found.";
        }

        String result = searchRecursive(baseDir, fileName);
        return result != null ? result : null;
    }

    private static String searchRecursive(File dir, String fileName) {
        File[] files = dir.listFiles();
        if (files == null) return null;

        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return file.getPath().replace("\\", "/");
            } else if (file.isDirectory()) {
                String found = searchRecursive(file, fileName);
                if (found != null) return found;
            }
        }
        return null;
    }
}
