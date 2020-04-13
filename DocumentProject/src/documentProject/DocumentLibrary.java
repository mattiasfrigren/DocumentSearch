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
    private static String docPath = DifferentLocalStoragePaths.getDocPath();
    private static int updateIndex;
    public static DocumentLibrary getLibrary(){
        if (library ==null){
            library = new DocumentLibrary(); }
        return library;
    }

//test
    public void saveToTxtFile() throws IOException {
        File txtFile = new File(docPath+"\\DocumentProject\\src\\documentPackage\\"+title+".txt");
        if (txtFile.createNewFile()){
            FileWriter writer = new FileWriter(txtFile);
            writer.write(textContent);
            writer.close();
            System.out.println("\""+title+"\" was created.");}
        else System.out.println("file already exists");
    }

    public void updateFile(String title,String textContent) throws IOException {
        File txtFile = new File(docPath+"\\DocumentProject\\src\\documentPackage\\"+title+".txt");
        FileWriter writer = new FileWriter(txtFile);
        writer.append(textContent);
        writer.close();
    }
    public void updateTextContent(String title, String textContent){
        if (documentExists(title))
        documentList.get(updateIndex).setTextContent(textContent);
    }

    public void readInFilesToList() throws IOException {
        File getAllFiles = new File(docPath+"\\DocumentProject\\src\\documentPackage");
        File[] fileArray = getAllFiles.listFiles();
        for (File txtfile: fileArray) {
            if (txtfile.isFile()&&txtfile.canExecute()&&txtfile.getName().endsWith(".txt")){
                addToList(new TxtDocument(cutString(txtfile.getName()),Files.readString(Paths.get(txtfile.getPath()), StandardCharsets.ISO_8859_1)));
            }
        }
    }

    public void createNewTxtFile() throws IOException {
        readInTitle();
        readInTextcontent();
        saveToTxtFile();
        addToList(new TxtDocument(title,textContent));
    }
    //reason for this method to return string is if we are going to use a View.
    public String printAllTitles(){
        String viewTitle="";
        if (documentList.size()!=0){
            for (TxtDocument title : documentList) {
            System.out.println(title.getTitle());
            viewTitle = title.getTitle()+ "\n" +viewTitle; }
        }
        else {System.out.println("The library is empty."); }
        return viewTitle;
    }

    public void printTextContent(){
        boolean titleFound = false;
        if (documentList.size()>0){
            for (TxtDocument txtContent : documentList) {
                if (txtContent.getTitle().equals(title)){
                System.out.println(txtContent.getTextContent());
                titleFound =true;
                break; }
            }
            if (!titleFound) {
                System.out.println("There is no \""+title+"\" in the library."); }
        }
        else {System.out.println("The library is empty."); }
    }

    public void deleteTxtFileFromLocalAndList() throws IOException {
            title = "";
            readInTitle();
            if (!documentExists(title)) {
                deleteTxtDocument();
                deleteTxtFile();
                System.out.println("\"" + title + "\" was deleted."); }
        else{
            System.out.println("There is no title \"" + title + "\" and no file was deleted."); }
    }

    public String cutString(String pathName){
        return (String) pathName.subSequence(0,pathName.length()-4);
    }

    public void deleteTxtDocument(){
        documentList.remove(documentList.get(updateIndex));
    }

    public void deleteTxtFile(){
        File deleteFile = new File(docPath+
                "\\DocumentProject\\src\\documentPackage\\"+title+".txt");
        if (deleteFile.isFile()){
        deleteFile.delete();
        }
    }

    public void addToList(TxtDocument document){
        if (documentExists(document.getTitle())){
        documentList.add(document);}
    }
    public boolean documentExists(String docName){
        for (int i = 0; i <documentList.size() ; i++) {
            if (documentList.get(i).getTitle().equals(docName)) {
                updateIndex =i;
                return false; }
        }
            return true;
    }

    public void chooseTitleToPrint() {
        readInTitle();
        printTextContent();
    }

    public List<TxtDocument> getDocumentList() {
        return documentList;
    }

    public static String getTitle() {
        return title;
    }
    public void readInTextcontent(){
        textContent = "";
        System.out.println("Write into the document: ");
        while (textContent.equals("")) {
            textContent=reader.getString(); }
    }

    public void readInTitle(){
        title = "";
        System.out.println("Please enter the title you want to print:");
        while (title.equals("")) {
            title=reader.getString(); }
    }

    public static void setTitle(String title) {
        DocumentLibrary.title = title;
    }

    public static String getTextContent() {
        return textContent;
    }
    public String[] getTextContent(String title) {
        for (TxtDocument text:documentList) {
            if (text.getTitle().equals(title)) {
            return createStringArray(text.getTextContent()); }
        }
        return null;
    }

    private String[] createStringArray(String textContent){
        InputReader reader = new InputReader();
        reader.setSc(new Scanner(textContent));
        ArrayList<String> tempList = new ArrayList();
        while (reader.getSc().hasNext()){
            tempList.add(reader.getSc().next());
        }
        reader.setSc(new Scanner(System.in));
        return tempList.toArray(new String[0]);
    }

    public static void setTextContent(String textContent) {
        DocumentLibrary.textContent = textContent;
    }
}
