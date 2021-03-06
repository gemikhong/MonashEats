import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * The Validation class will allow the system to validate all user inputs accepted via the keyboard from
the user.               .
 *
 * @author Nhat Khong
 * @version on May 25, 2019
 */

public class Validation {

    /**
     * stringIsBlank checks if the input string is blank or not
     *
     * @param String input
     * @return boolean blank is True or False
     */
    public static boolean stringIsBlank(String input)
    {
        boolean blank = false;
        if (input.trim().length() == 0)
        {
            return blank = true;
        }
        return blank;
    }
    
     /**  
     * stringIsDouble checks if the input string is a Double value
     *
     * @param String aString
     * @return boolean True or False
     */
    public static boolean stringIsDouble(String aString)
    {
        try {
                Double.parseDouble(aString);
                return true;
            }
        catch (NumberFormatException e)
            {
                return false;
            }
    }
    
     /**  
     * stringIsInteger checks if the input string is an Integer value
     *
     * @param String aString
     * @return boolean True or False
     */
    public static boolean stringIsInt(String aString)
    {
        try {
                Integer.parseInt(aString);
                return true;
            } 
        catch (NumberFormatException e)
            {
                return false;
            }
    }    
    
    /**
     * stringLengthOutRange checks if the input string is out of the range
     *
     * @param String input, int min number of characters, int max number of characters
     * @return boolean outRange is True or False
     */    
    public static boolean stringLengthOutRange(String input, 
                                            int min, 
                                            int max)
    {
        boolean outRange = false;
        if ((input.length() > max) || 
                (input.length() < min))
        {
            return outRange = true;
        }
        return outRange;
    }
    
    /**  
     * stringNumeric checks if the input string contains numeric characters or not
     *
     * @param String aString
     * @return boolean True or False
     */ 
    public static boolean stringNumeric(String aString)
    {
        if (aString.length() == 0)
        return false;
        int position = 0;
        while (position < aString.length())
        {
            char thisCharacter = aString.charAt(position);
            if (thisCharacter < '0' || 
                    thisCharacter > '9')
            return false;
            position++;
        }
        return true;
    }
    
    /**  
     * stringNumberInRange checks if the input string is an integer number within a range
     *
     * @param String aString
     * @return boolean True or False
     */ 
    public static boolean stringNumberInRange(String input, int min, int max)
    {
        if (stringNumeric(input)){
            int input_number = Integer.valueOf(input);
            if (input_number >= min && input_number <= max){
                return true;
            }            
        }
        return false;
    }
    
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_PATTERN = "(?:\\+?61)?(?:\\(0\\)[23478]|\\(?0?[23478]\\)?)\\d{8}";
        /**  
     * validEmail checks if the input string follows email pattern
     *
     * @param String aString
     * @return boolean True or False
     */ 
    public static boolean validEmail(String input){
        Pattern p = Pattern.compile(EMAIL_PATTERN);
        Matcher m = p.matcher(input);
        return m.matches();
    }
    
    /**  
     * validPhoneNo checks if the input string follows phone number pattern
     *
     * @param String aString
     * @return boolean True or False
     */ 
    public static boolean validPhoneNo(String input){
        Pattern p = Pattern.compile(PHONE_PATTERN);
        Matcher m = p.matcher(input);
        return m.matches();
    }
    
    /**  
     * validPassword checks if the input string is a valid password
     *
     * @param String aString
     * @return boolean True or False
     */ 
    public static boolean validPassword(String input){
            if(input.length() == 0){
                System.out.println("Password cannot be empty");
                return false;
            }
            
            if(input.length()<6){
                System.out.println("Password must have at least 6 characters. Please enter again!");
                return false;
            }
            
            if(stringNumeric(input)){
                System.out.println("Password can't be numbers only. Please enter again!");
                return false;
            }
        return true;
    }
    
    /**  
     * validAddress checks if the input string is a valid address
     *
     * @param String aString
     * @return boolean True or False
     */ 
    public static boolean validAddress(String input){
        if(stringIsBlank(input)){
            return false;
        }
        return true;
    }
}
