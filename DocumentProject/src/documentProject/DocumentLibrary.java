package documentProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 91matfri
 */
public class DocumentLibrary {
    private static DocumentLibrary library;
    private List<TxtDocument> documentList = new ArrayList<>();
    private static String title;
    private static String textContent;


    public static DocumentLibrary getLibrary(){
        if (library ==null){
            library = new DocumentLibrary(); }
        return library;
    }

    public void createTxtDocument(){
        System.out.println("Please name your document: ");
        title ="hej";
        System.out.println("write what you want to the document");
        textContent = "bärs";
    }
    public void saveToTxtFile() throws IOException {
        File txtFile = new File("C:\\Users\\91matfri\\IdeaProjects\\documentgroup\\DocumentProject\\src\\documentPackage\\"+title+".txt");
        if (txtFile.createNewFile()){
            FileWriter writer = new FileWriter(txtFile);
            writer.write(textContent);
            writer.close();
        }
        else System.out.println("file already exists");
    }

    public void readInFilesToList() throws IOException {
        File getAllFiles =new File("C:\\Users\\91matfri\\IdeaProjects\\documentgroup\\DocumentProject\\src\\documentPackage");
        File[] fileArray =getAllFiles.listFiles();
        for (File txtfile: fileArray) {
            if (txtfile.isFile()){
                addToList(new TxtDocument(txtfile.getName(),Files.readString(Paths.get(txtfile.getPath()), StandardCharsets.UTF_8)));
            }
        }
    }

    public void deleteTxtDocument(TxtDocument txtDocument){
        documentList.remove(txtDocument);
    }

    public void deleteTxtFile(File txtFile){
        txtFile.delete();
    }

    public void addToList(TxtDocument document){
        documentList.add(document);
    }

    public List<TxtDocument> getDocumentList() {
        return documentList;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        DocumentLibrary.title = title;
    }

    public static String getTextContent() {
        return textContent;
    }

    public static void setTextContent(String textContent) {
        DocumentLibrary.textContent = textContent;
    }
}
