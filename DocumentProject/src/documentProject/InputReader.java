package documentProject;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

//TODO test needs to be created
public class InputReader {

    public static final int INPUT_FAILURE = -1;

    //public static int getInt () {
    //Scanner sc = new Scanner(System.in) {

    public static int getInt(InputStream in) {
        Scanner sc = new Scanner(in);
        try {
            return sc.nextInt();
        } catch (InputMismatchException exception){
            System.out.println("That's not a number. Please try again.");
            return INPUT_FAILURE;
        }
    }

    static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
