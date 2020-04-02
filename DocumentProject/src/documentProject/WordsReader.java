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
        return readFile(stream); //stream - API flow
    }

    private String[] readFile(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        ArrayList<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (isWord(next))
            words.add(next);
        }
        return words.toArray(new String[0]); //the placeholder to the Array to tell what the type of the Array it is
        //the Object Array we return as a String Array
    }

    // boolean for excluding the numbers from the sorted data, so only words will be printed out in the console
    private boolean isWord(String next) {
        for (int n = 0; n < 10; n++) {
            if (next.contains(n + "")) {
                return false;
            }
        }
        return true;
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
