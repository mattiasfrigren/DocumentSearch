package documentProject;

import java.io.IOException;

/**
 * Singleton class for displaying the mainmenu and call the methods.
 * @author Henrik
 */
public class Hub {
    private static Hub hub;
    private static InputReader reader = InputReader.getInputReader();
    private Submenus submenus = new Submenus();
    private int input = 0;
    private Hub(){}
    /**
     * Switching userinputs
     * @throws IOException if error while reading files
     */
    protected void displayHub() throws IOException {
        while (input != 4) {
            printMenu();
            input = reader.getInt();
            switch (input) {
                case 0:
                    System.out.println("You have to input a legal number.");
                    break;
                case 1:
                    submenus.showHandleDocumentMenu();
                    break;
                case 2:
                    submenus.searchMenu();
                    break;
                case 3:
                    submenus.sortMenu();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }
    /**
     * Printing the menu
     */
        private void printMenu () {
            System.out.println("Main menu\n[1] Document menu\n[2] Search menu\n[3] Sort menu\n[4] Exit system.");
        }
        /**
     * Set the input to 0 to reset the userinput after som exceptionhandling,
     * @param input userinput
     */
    public void setInput(int input) {
        this.input = input;
    }
    /**
     * Get the object
     * @return hub
     */
        protected static Hub getHub () {
            if (hub == null) {
                hub = new Hub();
            }
            return hub;
        }
}
