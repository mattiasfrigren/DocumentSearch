package documentProject;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    static Scanner sc = new Scanner(System.in);
    public static Boolean getIntThrowed = false;
    public static Boolean getStringThrowed = false;
    public static Object inputtedNumber;
    public static String inputtedName;


    public static int getInt() {
        try {
            Scanner sc = new Scanner(System.in);
            /* outcomment scannerinput to test the function
            inputtedNumber = sc.nextInt();*/
            if (!inputtedNumber.getClass().getSimpleName().equals("Integer")) {
                getIntThrowed = true;
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException exception){
                System.out.println("You have to input a legal number");
            return -1;
        }
        return (int) inputtedNumber;
    }

    public static String getString() {
      /* outcomment scannerinput to test the function
        inputtedName =sc.next(); */
        try {
            if (inputtedName.equals("")) {
                getStringThrowed = true;
                throw new IllegalArgumentException("You have to write something, please try again.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //getString();
        }
        return inputtedName;
}}
