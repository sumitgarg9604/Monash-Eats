
/**
 * Abstract class User - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class User
{
    String name;
    String phoneNumber;
    String securityQuestion;
    String securitAnswer;
    String password;
    //String confirmPassword;
    String email;

    public String getName()
    {
        return name;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getPassword()
    {
        return password ;
    }

    public void setName(String name1 )
    {
        name = name1;
    }

    public void setPhoneNumber(String phoneNumber1 )
    {
        phoneNumber = phoneNumber1;
    }

    public void setPassword(String password1)
    {
        password  = password1;
    }

}
