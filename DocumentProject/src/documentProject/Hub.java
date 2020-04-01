package documentProject;

public class Hub {
    public static void displayHub() {
        int input = 0;
        while (input !=4) {
            printMenu();
            input = InputReader.getInt(System.in);
            switch (input) {
                case InputReader.INPUT_FAILURE:
                    continue;
                case 1:
                    Submenus.showHandleDocumentMenu();
                    break;
                case 2:
                    Submenus.searchMenu();
                    break;
                case 3:
                    Submenus.sortMenu();
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Its not an alternative in the menu, please try again.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Main menu\n[1] Document menu\n[2] Search menu\n[3] Sort menu\n[4] Exit system.");
    }
}
