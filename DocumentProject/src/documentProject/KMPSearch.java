package documentProject;

import java.util.ArrayList;
import java.util.List;

public class KMPSearch {
    private InputReader reader = InputReader.getInputReader();
    private DocumentLibrary library = DocumentLibrary.getLibrary();
    public String titleSearch;
    private String maxAppearing = "";
    private static int firstIndex;
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
        library.readInTitle();
        String textContent = library.getTextContent(library.getTitle());
        if (textContent!=null && textContent.length()>0) {
            String searchWord = enterSearchWord();
            int[] result = searchKMP(textContent, searchWord);
            if (result.length != 0) {
                System.out.print("The length of the document \""+library.getTitle()+ "\" is "+textContent.length()+
                        " chars.\nThe word \"" + searchWord + "\" appear in index(es):");
                for (int index : result) {
                    System.out.print(" " + index + ",");
                }
                System.out.println("");
            } else {
                System.out.println("The word does not appear in the document \""+library.getTitle()+"\".");
            }
        }
        else {
            System.out.println("The title does not exists in the library.");
        }
    }
    //The method only uses other methods.
    public void countWords(){
        library.readInTitle();
        String textContent = library.getTextContent(library.getTitle());
        if (textContent!=null && textContent.length()>0) {
            String searchWord = enterSearchWord();
            System.out.println("The word \"" + searchWord + "\" appears " + getTimes(textContent, searchWord) + " times in the document.");
        }
        else {
            System.out.println("The title does not exists in the library.");
        }
    }
    public int getTimes(String content,String word){
        int[] result = searchKMP(content.toLowerCase(),word.toLowerCase());
        if (result.length!=0){firstIndex = result[0];}
        return result.length;
    }

    public String enterSearchWord() {
        String searchWord = "";
        System.out.println("Please enter searchword. ");
        while (searchWord.equals("")) {
            searchWord=reader.getString(); }

        return searchWord.toLowerCase();
    }
    //Hard to test beacuse you have to create documents.

    public void compareDocuments() {
        maxAppearing = "";
        String wordToSearch = enterSearchWord();
        int max = getMax(wordToSearch);
        if (max>0) {
            System.out.println("The word \"" + wordToSearch + "\" appear most ("+max+") times in the document(s): \"" + maxAppearing + ".");
        }
        else {
        System.out.println("The word \"" + wordToSearch + "\" does not appear in any document.");
        }
    }
    public int getMax(String wordToSearch) {
        int max = 0;
        int current;
        if (library.getDocumentList().size()!=0) {
            for (int i = 0; i < library.getDocumentList().size(); i++) {
                current = getTimes(library.getDocumentList().get(i).getTextContent(), wordToSearch);
                if (current > max) {
                    maxAppearing = library.getDocumentList().get(i).getTitle() + ".txt\""+ " (The first index is at "+firstIndex+")";
                    max = current;
                } else if (current == max) {
                    maxAppearing += ", " + library.getDocumentList().get(i).getTitle() + ".txt\""+ " (The first index is at "+firstIndex+")";
                }
            }
        }
        return max;
    }

    public int[] convertListToArray(List<Integer> result){
        int[] sendBackResult = new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            sendBackResult[i] = result.get(i); }
        return sendBackResult;
    }

    public void searchForTitle(){
        maxAppearing ="";
        // titleSearch = "test";  <---- for testing
        String titleSearch = enterSearchWord();
        for (TxtDocument doc:library.getDocumentList()) {
           int[] titleArray = searchKMP(doc.getTitle().toLowerCase(),titleSearch);
            if (titleArray.length!=0){
                maxAppearing +=doc.getTitle()+".txt | ";
            }
        }
        if(!maxAppearing.equals("")) {
            System.out.println(titleSearch + " appears in the documents: " + maxAppearing);
        }
        else {
            System.out.println("There is no titles with that word.");
        }
    }

    public String getMaxAppearing() {
        return maxAppearing;
    }

}
