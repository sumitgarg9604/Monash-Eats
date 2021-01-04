/**
 * Validation class validates the inputs entered by user
 *
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class Validation
{

    /**
     * Constructor for objects of class validation
     */
    public Validation()
    {

    }

    /**
     * isNumeric() validates if the input entered  is numerics or characters
     * @param str - str is being validated
     * @return boolean
     */
    public boolean isNumeric(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {           
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    /**
     * checkSuburbCodeLength() validates if the input entered confirms the length of 4 characters
     * @param str - str is being validated
     * @return boolean
     */
    public boolean checkSuburbCodeLength(String str)
    {
        if (str.length() != 4)
        {
            return false;
        }
        return true;
    }

    /**
     * checkCharacterIsNull() validates if the input entered is empty
     * @param str - str is being validated
     * @return boolean
     */
    public boolean checkCharacterIsNull(String str)
    {
        if (str.length() != 0)
        {
            return false;
        }
        return true;
    }

    /**
     * checkEmail() validates if the input confimrs the format of email
     * @param str - str is being validated
     * @return boolean
     */
    public boolean checkEmail(String str)
    {
        if (str.contains("@") && str.contains("."))
        {
            return true;
        }
        return false;
    }

    /**
     * checkSpace() validates if the input has any whitespaces
     * @param str - str is being validated
     * @return boolean
     */
    public boolean checkSpace(String str)
    {
        boolean check = str.contains("\\s+");
        if (check)
        {
            return true;
        }
        return false;
    }
}