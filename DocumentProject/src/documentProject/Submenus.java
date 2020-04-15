package documentProject;
import java.io.IOException;

public class Submenus {
    private static InputReader reader = InputReader.getInputReader();
    private Sorting sorting = new Sorting();
    private KMPSearch search = new KMPSearch();
    private DocumentLibrary library = DocumentLibrary.getLibrary();

    public void showHandleDocumentMenu() throws IOException {
        int userInput = 0;
        while (userInput!=5) {
            System.out.println("What would you like to do?\n[1] Create new document\n[2] Delete document\n" +
                    "[3] Print all titles in the library\n[4] Print a document\n[5] Exit to main menu");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    library.createNewTxtFile();
                    break;
                case 2:
                    library.deleteTxtFileFromLocalAndList();
                    break;
                case 3:
                    library.printAllTitles();
                    break;
                case 4:
                    library.chooseTitleToPrint();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    public void searchMenu() {
        int userInput = 0;
        while (userInput!=5) {
            System.out.println("What would you like to do?\n[1] Search for a title.\n[2] Search for a word in a document " +
                    "and print indexes of word(s).\n[3] Search for a word in a document and get number of times appearing."+
                    "\n[4] Search for a word in all documents and show most times appearing.\n[5] Exit to main menu.");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    search.searchForTitle();
                    break;
                case 2:
                    search.getIndexes();
                    break;
                case 3:
                    search.countWords();
                    break;
                case 4:
                    search.compareDocuments();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    public void sortMenu() {
        int userInput = 0;
        while (userInput!=3) {
            System.out.println("What would you like to do?\n[1] Sort titles\n[2] Sort words in a document\n" +
                    "[3] Exit to main menu");
            userInput = reader.getInt();
            switch (userInput) {
                case 1:
                    sorting.sortTitles();
                    break;
                case 2:
                    sorting.sortText();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
}