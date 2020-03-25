package documentProject;

/**
 * @author 91matfri
 */
public class DocumentLibrary {
    private static DocumentLibrary library;

    public static DocumentLibrary getLibrary(){
        if (library ==null){
            library = new DocumentLibrary(); }
        return library;
    }

}
