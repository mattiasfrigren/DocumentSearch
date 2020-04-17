package documentProject;

/**
 * This class is used for create the textdocuments. Each document is an object of this class.
 * @author 91matfri
 */
public class TxtDocument {
    private String title;
    private String textContent;

    /**
     * The constructor.
     * @param title the title of the document.
     * @param textContent the content inside the document.
     */
    public TxtDocument(String title, String textContent) {
    this.title = title;
    this.textContent = textContent;
    }
    /**
     * Get the title
     * @return title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Get the content.
     * @return The content
     */
    public String getTextContent() {
        return textContent;
    }
    /**
     * Set the content while updating the library
     * @param textContent
     */
    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
