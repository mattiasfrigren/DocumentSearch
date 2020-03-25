package documentProject;

/**
 * @author 91matfri
 */
public class TxtDocument {

    private String title;
    private String textContent;
    private boolean isEdit;
    private boolean isSorted;

    public TxtDocument(String title, String textContent) {
    this.title = title;
    this.textContent = textContent;
    this.isEdit = false;
    this.isSorted = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public boolean isSorted() {
        return isSorted;
    }

    public void setSorted(boolean sorted) {
        isSorted = sorted;
    }
}
