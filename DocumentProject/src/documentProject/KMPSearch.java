package documentProject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handling the search
 * @author Mattias Henrik
 */
public class KMPSearch {
    private InputReader reader = InputReader.getInputReader();
    private DocumentLibrary library = DocumentLibrary.getLibrary();
    public String titleSearch;
    private String maxAppearing = "";

    private static int firstIndex;

    /**
     * This is the main searching method. It is Knuth Morris Pratt algorithm. It calls the compiletextmethod
     * to get the pattern of the word and then it add the searchinghits into a list. When done it convert the list
     * into an array.
     * @param textContent The text that will be determined.
     * @param searchWord The word to search for.
     * @return an intarray with the indexes where the searchword appear.
     */
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

    /**
     * This method handling when the user wants all the indexes of a word in a specific document. It calls
     * the "readintitle" method in the "documentlibrary", calls the entersearchword in this class and calls
     * the main searchmethod "KMPSearch".To easier understand the indexes the method also prints the total
     * indexes of the document before printing the indexes.
     */
    public void getIndexes(){
        library.readInTitle();
        String textContent = library.getTextContent(library.getTitle());
        if (textContent!=null && textContent.length()>0) {
            String searchWord = enterSearchWord();
            int[] result = searchKMP(textContent.toLowerCase(), searchWord.toLowerCase());
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
    /**
     * This method is used when counting the words for a search in a single document.
     * It calling the "readintitle" method in the "documentlibrary", calling the "entersearchword" in this class and
     * calling the "getTimes" and printing the result.
     */
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
    /**
     * This method simply calling the main search method and returning the int. It is used in both searching
     * for single documents and all the documents. It also changing the variable "firstindex" to where the first hit were.
     * @param content Documenttext
     * @param word Searchword
     * @return How many times appearing.
     */
    public int getTimes(String content,String word){
        int[] result = searchKMP(content.toLowerCase(),word.toLowerCase());
        if (result.length!=0){
            firstIndex = result[0];}
        return result.length;
    }
    /**
     * This method handling the userinput when user enter the searchword.
     * @return valid word
     */
    private String enterSearchWord() {
        String searchWord = "";
        System.out.println("Please enter searchword. ");
        while (searchWord.equals("")) {
            searchWord=reader.getString(); }

        return searchWord.toLowerCase();
    }

    /**
     * This method calls the "entersearchword" method, getting the number from "getmax" and prints the result
     * which document that contains most searchhits. It can be more than one document.
     */
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
    /**
     *This method calling the "gettimes" method with the documents an searchword one by one and bulding the
     * "maxappearing" string with the right titles and where the first hit were and therefore most releveant if
     * two titles have the same hits.
     * @param wordToSearch The searchword.
     * @return The number of hits.
     */
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
    /**
     * Method to convert a list into an array. Its easier to add to a list into the main search function but easier and more
     * efficient to handling the data later with an array.
     * @param result List with the ints from the search.
     * @return The intarray back to the searchfunction.
     */
    public int[] convertListToArray(List<Integer> result){
        int[] sendBackResult = new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            sendBackResult[i] = result.get(i); }
        return sendBackResult;
    }
    /**
     * Method to search for a title. It calls the "entersearchword" and the loop through the documentlist and
     * instead of calling the searchmethod with the documentcontent the method passes the titles here. Then
     * it prints the results.
     */
    public void searchForTitle(){
        maxAppearing ="";
       //  titleSearch = "testFile"; // <---- for testing
        String titleSearch = enterSearchWord();
        for (TxtDocument doc:library.getDocumentList()) {
           int[] titleArray = searchKMP(doc.getTitle().toLowerCase(),titleSearch.toLowerCase());
            if (titleArray.length!=0){
                maxAppearing +="\""+doc.getTitle()+".txt\" | ";
            }
        }
        if(!maxAppearing.equals("")) {
            System.out.println("\""+titleSearch+"\" appears in the following documents: " + maxAppearing);
        }
        else {
            System.out.println("There is no titles with that word.");
        }
    }
    /**
     * A getter used to testing.
     * @return The string with the titles/contents.
     */
    public String getMaxAppearing() {
        return maxAppearing;
    }

    public static int getFirstIndex() {
        return firstIndex;
    }


}