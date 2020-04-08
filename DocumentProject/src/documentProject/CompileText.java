package documentProject;

public class CompileText {

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
