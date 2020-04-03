package documentProject;

import java.util.ArrayList;
import java.util.List;

public class KMPSearch {
    //TODO FIX SO ALL STRINGS ARE LOWERCASE

    private InputReader reader = new InputReader();
    private DocumentLibrary library = DocumentLibrary.getLibrary();

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

    public void runSearch(){
        String textContent = getTextContet();
        System.out.println("give me a search word please");
        String searchWord = reader.getString();
        int[] result = searchKMP(textContent,searchWord);
        for (int index :result) {
            System.out.println("o förekommer vid index: " + index);
        }
    }
    private String getTextContet(){
        System.out.println("please give me the title");
        String title= reader.getString().toLowerCase();
        for (TxtDocument doc:library.getDocumentList()) {
            if (doc.getTitle().equals(title)){
                return doc.getTextContent();
            }
        }
        return null;
    }



    private int[] convertListToArray(List<Integer> result){
        int[] sendBackResult = new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            sendBackResult[i] = result.get(i); }
        return sendBackResult;
    }
}
