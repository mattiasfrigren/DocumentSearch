package documentProject;

import java.io.IOException;

//TODO create singelton and add Exception class

public class Hub {
    private static Hub hub;
    private static InputReader reader = new InputReader();
    private Submenus submenus = new Submenus();

    public void displayHub() throws IOException {
        int input = 0;
        while (input != 4) {
            printMenu();
            input = reader.getInt();
            switch (input) {
                case -1:
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
        private void printMenu () {
            System.out.println("Main menu\n[1] Document menu\n[2] Search menu\n[3] Sort menu\n[4] Exit system.");
        }

        public static Hub getHub () {
            if (hub == null) {
                hub = new Hub();
            }
            return hub;
        }

}
