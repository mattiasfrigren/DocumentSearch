package documentProject;

/**
 * Anara
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

//for sorting
public class WordsReader {
    public String[] readFile(String filename) throws FileNotFoundException {
        FileInputStream stream = new FileInputStream(filename);
        return readFile(stream);
    }

    private String[] readFile(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNext())
            words.add(scanner.next());
        return words.toArray(new String[0]);
    }

    public String[] readAllFiles(File directory) throws FileNotFoundException {
        ArrayList<String> allWords = new ArrayList<>();
        for (File file : directory.listFiles()){
            for (String word : readFile(new FileInputStream(file)))
                allWords.add(word);
        }
        return allWords.toArray(new String[0]);
    }
}
