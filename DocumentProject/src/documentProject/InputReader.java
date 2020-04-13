package documentProject;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static Scanner sc = new Scanner(System.in);
    public static Boolean getIntThrowed = false;
    public static Boolean getStringThrowed = false;
    public static Object inputtedNumber;
    public static String inputtedName;


    public static int getInt() {
        try {
            /* outcomment scannerinput to test the function*/
            inputtedNumber = sc.nextInt();
            if (!inputtedNumber.getClass().getSimpleName().equals("Integer")) {
                getIntThrowed = true;
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException exception){
                System.out.println("You have to input a legal number");
                sc = new Scanner(System.in);
            return -1;
        }
        catch   (ArithmeticException ae) {
            System.out.println("Number to large, cant read");
            sc = new Scanner(System.in);
            return -1;
        }
        return (int) inputtedNumber;
    }

    public static String getString() {
        sc = new Scanner(System.in);
      /* outcomment scannerinput to test the function*/
        inputtedName =sc.nextLine();
        try {
            if (inputtedName.equals("")) {
                getStringThrowed = true;
                throw new IllegalArgumentException("You have to write something, please try again.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            sc = new Scanner(System.in);
        }
        catch (InputMismatchException ime) {
            System.out.println(ime.getMessage());
            sc = new Scanner(System.in);
        }
        return inputtedName;
}

    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        InputReader.sc = sc;
    }

}
