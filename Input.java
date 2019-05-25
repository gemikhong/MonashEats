import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HUANG JIAN on May 15, 2019
 * Edited by NHAT KHONG (Gemi) on May 25, 2019: move the validations to a separate class
 */
public class Input {
    private static Scanner console = new Scanner(System.in);

    public static void welcomMsg(){
        System.out.print('\u000C');
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("            Welcome to Monash Eats");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
    }

    public static void showPage(String pageName){
        System.out.print('\u000C');
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("            "+pageName+" Page      ");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
    }

    public static void displayMainOptions()
    {
        System.out.println();
        System.out.println("Please Select from the following options:");
        System.out.println("Press 1 to Register an Account");
        System.out.println("Press 2 to Login");
        System.out.println("Press 3 to View Restaurant List");
        System.out.println("Press 4 to Exit");
        System.out.println();
    }

    public static void displayRegisterOptions(){
        System.out.println();
        System.out.println("Please Select from the following options:");
        System.out.println("Press 1 to create a customer account");
        System.out.println("Press 2 to create a restaurant account");
        System.out.println("Press 3 to Back");
        System.out.println();
    }
    
    public static String getInput(String msg)
    {
        System.out.println(msg);
        return console.nextLine().trim();
    }

    public static boolean checkExit(String input){
        return input.equals("-1")? true : false;
    }

    public static Integer strToInt(String input){
        try{
            return Integer.valueOf(input);
        }catch (Exception e){
            return  -1;
        }
    }

    public static void showPayment(){
        System.out.println("Please Select from the following options:");
        System.out.println("1. Cash");
        System.out.println("2. Coupon");
    }
}
