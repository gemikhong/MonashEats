import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HUANG JIAN on 2019/5/15.
 */
public class Input {

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PHONE_PATTERN
            = "(?:\\+?61)?(?:\\(0\\)[23478]|\\(?0?[23478]\\)?)\\d{8}";

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

    public static boolean emailvalidate(String hex) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public static boolean phoneValidate(String hex){
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public static Integer strToInt(String input){
        try{
            return Integer.valueOf(input);
        }catch (Exception e){
            return  -1;
        }
    }

    public static void showPayment()
    {
        System.out.println("Please Select from the following options:");
        System.out.println("1. Cash");
        System.out.println("2. Coupon");
    }
}

