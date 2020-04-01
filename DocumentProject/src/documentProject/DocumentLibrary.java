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
        title ="nästatitle";
        System.out.println("write what you want to the document");
        textContent = "next content";
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

    public void readInFilesToList() throws IOException {
        File getAllFiles = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage");
        File[] fileArray = getAllFiles.listFiles();
        for (File txtfile: fileArray) {
            if (txtfile.isFile()){
                addToList(new TxtDocument(cutString(txtfile.getName()),Files.readString(Paths.get(txtfile.getPath()), StandardCharsets.UTF_8)));
            }
        }
    }

    public void createNewTxtFile() throws IOException {
        createTxtDocument();
        saveToTxtFile();
        addToList(new TxtDocument(title,textContent));
    }

    public String printAllTitles(){
        String viewTitle="";
        if (documentList.size()>0){
        for (TxtDocument title : documentList) {
            System.out.println(title.getTitle());
            viewTitle = title.getTitle()+ "\n" +viewTitle;
        }}
        return viewTitle;
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
        String deleteTitle = title;
        for (TxtDocument elements: documentList) {
            if (elements.getTitle().equals(deleteTitle)) {
                deleteTxtDocument(elements);
                deleteTxtFile(deleteTitle);
                break;
            }
        }
    }

    public String cutString(String pathName){
        return (String) pathName.subSequence(0,pathName.length()-4);
    }

    public void deleteTxtDocument(TxtDocument txtDocument){
        documentList.remove(txtDocument);
    }
    //TODO redo method
    public void deleteTxtFile(String txtFile){
        File deleteFile = new File(DifferentLocalStoragePaths.docPath+
                "\\DocumentProject\\src\\documentPackage\\"+txtFile+".txt");
        if (deleteFile.isFile()){
        deleteFile.delete();
        }
    }

    public void addToList(TxtDocument document){
        if (!documentList.contains(document.getTitle()) && documentExists(document.getTitle())){
        documentList.add(document);}
    }
    public boolean documentExists(String docName){
        for (TxtDocument document: documentList) {
            if (document.getTitle().equals(docName)){
                return false; }
        }
        return true;
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
