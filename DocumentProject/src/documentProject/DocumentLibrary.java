package documentProject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 91matfri
 */
public class DocumentLibrary {
    private static DocumentLibrary library;
    private List<TxtDocument> documentList = new ArrayList<>();

    public static DocumentLibrary getLibrary(){
        if (library ==null){
            library = new DocumentLibrary(); }
        return library;
    }

    public void createTxtDocument(){
        String title = "hej";
        String text = "tjäna";
        addToList(new TxtDocument(title,text));
    }
    public void addToList(TxtDocument document){
        documentList.add(document);
    }

    public List<TxtDocument> getDocumentList() {
        return documentList;
    }

}
