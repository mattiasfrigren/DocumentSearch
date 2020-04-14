package documentProject;

/**
 * A class with only one method used for the searching.
 * @author Mattias
 */
public class CompileText {
    /**
     * Method that finds patterns in the searchword to do the searching more efficient and find words in words.
     * @param searchWord The word to compile
     * @return the intarray with the the pattern used in Knuth Morris Pratt algorithm.
     */
    public int[] compileStringArray (String searchWord){
        int inputToArray =0;
        int[] compiledArray = new int[searchWord.length()];
        compiledArray[0] = inputToArray;
        for (int i = 1; i <searchWord.length() ; i++) {
            if (searchWord.charAt(i)==searchWord.charAt(inputToArray)){
                inputToArray++;
                compiledArray[i]=inputToArray; }
            else {
                if (inputToArray!=0){
                    inputToArray = compiledArray[inputToArray-1]; }
                else{
                    compiledArray[i]=inputToArray;
                }
            }
        }
        return compiledArray;
    }
}
