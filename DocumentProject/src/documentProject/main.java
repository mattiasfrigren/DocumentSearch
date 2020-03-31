package documentProject;

import java.io.IOException;

public class main {

    public static void main(String[]args) {
        try {
            DocumentLibrary.getLibrary().readInFilesToList();
            Hub.displayHub();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
