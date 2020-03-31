package documentProject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {

    public static final int INPUT_FAILURE = -1;

    static int getInt() {
        Scanner sc = new Scanner(System.in);
        try{
            return sc.nextInt();
        }catch (InputMismatchException exception){
            System.out.println("That's not a number. Please try again.");
            return INPUT_FAILURE;
        }
    }

    static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
