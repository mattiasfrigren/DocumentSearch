package documentProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 91matfri
 */
public class DocumentLibrary {
    private static DocumentLibrary library;
    private static List<TxtDocument> documentList = new ArrayList<>();
    private static String title ="bla";
    private static String textContent = "blabla";
    Scanner sc = new Scanner(System.in);

    public static DocumentLibrary getLibrary(){
        if (library ==null){
            library = new DocumentLibrary(); }
        return library;
    }

    public void createTxtDocument(){
        System.out.println("Please name your document: ");
        title ="tjäna";
        System.out.println("write what you want to the document");
        textContent = "fredagsbärs";
    }

    public void saveToTxtFile() throws IOException {
        File txtFile = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage\\"+title+".txt");
        if (txtFile.createNewFile()){
            FileWriter writer = new FileWriter(txtFile);
            writer.write(textContent);
            writer.close();
        }
        else System.out.println("file already exists");
    }

    public void readInFilesToList() {
        File getAllFiles = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage");
        File[] fileArray = getAllFiles.listFiles();
        for (File txtfile: fileArray) {
            if (txtfile.isFile()){
                String textContent = null;
                try {
                    textContent = Files.readString(Paths.get(txtfile.getPath()), StandardCharsets.UTF_8);
                } catch (IOException e) {
                    System.out.println("Warning: The file '" + txtfile.getPath() + "' could not be read.");
                }
                addToList(new TxtDocument(txtfile.getName(), textContent));
            }
        }
    }

    public void createNewTxtFile() throws IOException {
        createTxtDocument();
        saveToTxtFile();
        addToList(new TxtDocument(title,textContent));
    }

    public void printAllTitles(){
        if (documentList.size()>0){
        for (TxtDocument title : documentList) {
            System.out.println(title.getTitle());
        }}
    }
    public void printTextContent(String title){
        for (TxtDocument txtContent : documentList) {
            if (txtContent.getTitle().equals(title)){
                System.out.println(txtContent.getTextContent());
            }
        }
    }
    //TODO Must add method to remove document from localstorage
    public void deleteTxtFileFromLocalAndList() throws IOException {
        System.out.println("Please enter the title you want to remove:");
        String deleteTitle = sc.next();
        for (TxtDocument elements: documentList) {
            if (elements.getTitle().equals(deleteTitle)) {
                deleteTxtDocument(elements);
                deleteTxtFile(deleteTitle);
            }
        }
    }

    public void deleteTxtDocument(TxtDocument txtDocument){
        documentList.remove(txtDocument);
    }
    //TODO redo method
    public void deleteTxtFile(String txtFile){
        File deleteFile = new File(DifferentLocalStoragePaths.docPath+
                "\\DocumentProject\\src\\documentPackage\\"+txtFile+".txt");
        if (deleteFile.isFile()){
        deleteFile.delete();}
    }

    public void addToList(TxtDocument document){
        if (!documentList.contains(document.getTitle())){
        documentList.add(document);}
    }

    public void chooseTitleToPrint() {
        System.out.println("Please enter the title you want to print:");
        printTextContent(sc.next());
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
