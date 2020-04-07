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
    private static InputReader reader = new InputReader();
    private static DocumentLibrary library;
    private static List<TxtDocument> documentList = new ArrayList<>();
    private static String title ="";
    private static String textContent = "";


    public static DocumentLibrary getLibrary(){
        if (library ==null){
            library = new DocumentLibrary(); }
        return library;
    }

    public void createTxtDocument(){
        System.out.println("Please name your document: ");
        while (title.equals("")) {
            title = reader.getString();
        }
        System.out.println("write what you want to the document");
        while (textContent.equals("")) {
            textContent = reader.getString();
        }
    }
//test
    public void saveToTxtFile() throws IOException {
        File txtFile = new File(DifferentLocalStoragePaths.docPath+"\\DocumentProject\\src\\documentPackage\\"+title+".txt");
        if (txtFile.createNewFile()){
            FileWriter writer = new FileWriter(txtFile);
            writer.write(textContent);
            writer.close();
            System.out.println("\""+title+"\" was created.");}
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

    public void printAllTitles(){
        String viewTitle="";
        if (documentList.size()>0){
            for (TxtDocument title : documentList) {
            System.out.println(title.getTitle());
            viewTitle = title.getTitle()+ "\n" +viewTitle;
            }
        }
        else {System.out.println("The library is empty.");
        }
    }
    public void printTextContent(String title){
        boolean titleFound = false;
        if (documentList.size()>0){
            for (TxtDocument txtContent : documentList) {
                if (txtContent.getTitle().equals(title)){
                System.out.println(txtContent.getTextContent());
                titleFound = true;
                }
            }
            if (!titleFound) {
                System.out.println("There is no \""+title+"\" in the library.");
            }
        }
        else {System.out.println("The library is empty.");
        }
    }
    //TODO Must add method to remove document from localstorage
    public void deleteTxtFileFromLocalAndList() throws IOException {
        String deleteTitle = "";
        boolean deleteSuccess = false;
        System.out.println("Please enter the title you want to remove:");
        while (deleteTitle.equals("")) {
            deleteTitle = reader.getString();
            for (TxtDocument elements : documentList) {
                if (elements.getTitle().equals(deleteTitle)) {
                    deleteTxtDocument(elements);
                    deleteTxtFile(deleteTitle);
                    System.out.println("\"" + deleteTitle + "\" was deleted.");
                    deleteSuccess = true;
                    break;
                }
            }
        }
        if (!deleteSuccess) {
            System.out.println("There is no title \"" + deleteTitle + "\" and no file was deleted.");
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
        String title = "";
        System.out.println("Please enter the title you want to print:");
        while (title.equals("")) {
            title=reader.getString();
        }
        printTextContent(title);
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
