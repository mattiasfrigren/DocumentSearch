package documentProject;

import java.io.IOException;

public class main {

    public static void main(String[]args) throws IOException {
        DocumentLibrary.getLibrary().readInFilesToList();
        Hub.displayHub();
    }
}
