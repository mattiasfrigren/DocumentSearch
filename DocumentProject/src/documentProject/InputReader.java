package documentProject;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class handles exceptions and userinput. After checking input the methods returns valid inputs.
 *
 * @author Henrik
 */
public class InputReader {
    private static InputReader inputReader;
    private static Scanner sc = new Scanner(System.in);
    private InputReader(){}
    /**
     * Variables created for testpurpose.
     */
    private static Boolean getIntThrowed;
    private static Boolean getStringThrowed;
    private static Object inputtedNumber;
    private static String inputtedName = "";
    /**
     * Handling integers
     * @return valid integer or -1
     */
    public static int getInt() {
        try {
            inputtedNumber = sc.nextInt();
            if (!inputtedNumber.getClass().getSimpleName().equals("Integer")) {
                getIntThrowed = true;
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException | ArithmeticException exception){
                System.out.println("You have to input a legal number.");
                sc = new Scanner(System.in);
            return -1;
        }
        return (int) inputtedNumber;
    }
    /**
     * Handling strings
     * @return valid string or "".
     */
    public static String getString() {
        sc = new Scanner(System.in);
        inputtedName =sc.nextLine();
        try {
            if (inputtedName.equals("")) {
                getStringThrowed = true;
                throw new IllegalArgumentException("You have to write something, please try again.");
            }
        }
        catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
            sc = new Scanner(System.in);
        }
        return inputtedName;
    }
    /**
     * A getter for scannerobject used for creating an array in documentlibrary class.
     * @return scanner
     */
    public static Scanner getSc() {
        return sc;
    }
    /**
     * A setter for scannerobject used for creating an array in documentlibrary class.
     * @param sc scanner
     */
    public static void setSc(Scanner sc) {
        InputReader.sc = sc;
    }
    /**
     * A getter to give access to the only instance of the class
     * @return the instance
     */
    public static InputReader getInputReader() { return inputReader; }
    /**
     * Getters and setters used from the testclasses.
     * @param inputtedNumber
     */
    public static void setInputtedNumber(Object inputtedNumber) { InputReader.inputtedNumber = inputtedNumber; }
    public static void setInputtedName(String inputtedName) { InputReader.inputtedName = inputtedName; }
    public static Boolean getGetIntThrowed() { return getIntThrowed; }
    public static void setGetIntThrowed(Boolean getIntThrowed) { InputReader.getIntThrowed = getIntThrowed; }
    public static Boolean getGetStringThrowed() { return getStringThrowed; }
}
