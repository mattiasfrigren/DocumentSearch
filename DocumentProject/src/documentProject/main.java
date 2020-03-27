package documentProject;

import java.io.IOException;

public class main {

    public static void main(String[]args){
        DocumentLibrary.getLibrary().createTxtDocument();
        try {
            DocumentLibrary.getLibrary().saveToTxtFile();
            DocumentLibrary.getLibrary().readInFilesToList();
            System.out.println(DocumentLibrary.getLibrary().getDocumentList().get(DocumentLibrary.getLibrary().getDocumentList().size()-1).getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
