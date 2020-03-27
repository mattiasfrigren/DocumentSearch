package documentProject;

import java.io.IOException;

public class main {

    public static void main(String[]args){
        DocumentLibrary.getLibrary().createTxtDocument();
        try {
            DocumentLibrary.getLibrary().saveToTxtFile();
            DocumentLibrary.getLibrary().readInFilesToList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
