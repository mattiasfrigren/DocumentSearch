package documentProject;

import java.util.ArrayList;
import java.util.List;

public class KMPSearch {
    private InputReader reader = new InputReader();
    private DocumentLibrary library = DocumentLibrary.getLibrary();
    private String maxAppearing = "";

    public int[] searchKMP(String textContent, String searchWord){
        CompileText compile = new CompileText();
        int[] compiledArr = compile.compileStringArray(searchWord);
        int pIndex =0;
        int tIndex =0;
        List<Integer> searchResult = new ArrayList<>();

        while (tIndex<textContent.length()){
            if (textContent.charAt(tIndex)==searchWord.charAt(pIndex)){
                pIndex++;
                tIndex++; }
            if (pIndex==searchWord.length()){
                searchResult.add(tIndex-pIndex);
                pIndex = compiledArr[pIndex-1]; }
            else if (tIndex<textContent.length()&&textContent.charAt(tIndex)!=searchWord.charAt(pIndex)){
                if (pIndex!=0){
                    pIndex = compiledArr[pIndex-1]; }
                else{tIndex = tIndex+1;}
            }
        }
        return convertListToArray(searchResult);
    }
    //The method only use other methods so no test is needed
    public void getIndexes(){
        String textContent = getTextContet(enterTitle());
        if (!textContent.equals("")) {
            String searchWord = enterSearchWord();
            int[] result = searchKMP(textContent, searchWord);
            if (result.length != 0) {
                System.out.print("The Size of the Text is: "+textContent.length()+" Chars.\nOrdet \"" + searchWord + "\" förekommer vid index:");
                for (int index : result) {
                    System.out.print(" " + index + ",");
                }
                System.out.println("");
            } else {
                System.out.println("Ordet förekommer inte i dokumentet.");
            }
        }
        else {
            System.out.println("Titeln finns inte i biblioteket.");
        }
    }
    //The method only uses other methods.
    public void countWords(){
        String textContent = getTextContet(enterTitle());
        if (!textContent.equals("")) {
            String searchWord = enterSearchWord();
            System.out.println("Ordet \"" + searchWord + "\" förekommer " + getTimes(textContent, searchWord) + " gånger i dokumentet.");
        }
        else {
            System.out.println("Titeln finns inte i biblioteket.");
        }
    }
    public int getTimes(String content,String word){
        int[] result = searchKMP(content.toLowerCase(),word.toLowerCase());
        return result.length;
    }
    //Only uses readermethod
    public String enterSearchWord() {
        System.out.println("give me a search word please");
        return reader.getString().toLowerCase();
    }
    //Hard to test beacuse you have to create documents.
    //TODO Enable multiwriter if two documents are equal.
    public void compareDocuments() {
        maxAppearing = "";
        String wordToSearch = enterSearchWord();
        int max = getMax(wordToSearch);
        if (max>0) {
            System.out.println("The word " + wordToSearch + " appear most in the document(s) \"" + maxAppearing + "\" (" + max + " times).");
        }
        else {
        System.out.println("The word " + wordToSearch + " does not appear in any document.");
        }
    }
    public int getMax(String wordToSearch) {
        int max = 0;
        int current;
        for (int i = 0; i<library.getDocumentList().size();i++) {
            current= getTimes(getTextContet(library.getDocumentList().get(i).getTitle()),wordToSearch);
            if (current>max) {
                maxAppearing = library.getDocumentList().get(i).getTitle()+".txt";
                max = current; }
            else if (current==max) {
                maxAppearing +=", " +library.getDocumentList().get(i).getTitle()+".txt"; }
            }
        return max;
    }

    public String enterTitle() {
        System.out.println("please give me the title");
        return reader.getString().toLowerCase();
    }
    //Cant test this because of some reason I cant understand
    public String getTextContet(String title){
        for (TxtDocument doc:library.getDocumentList()) {
            if (doc.getTitle().equals(title)){
                return doc.getTextContent();
            }
        }
        return "";
    }
    public int[] convertListToArray(List<Integer> result){
        int[] sendBackResult = new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            sendBackResult[i] = result.get(i); }
        return sendBackResult;
    }

}
