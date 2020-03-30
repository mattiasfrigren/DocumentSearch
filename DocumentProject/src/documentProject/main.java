package documentProject;

import java.io.IOException;

public class main {

    public static void main(String[]args) {
        DocumentLibrary.getLibrary().readInFilesToList();
        Hub.displayHub();
    }
}
