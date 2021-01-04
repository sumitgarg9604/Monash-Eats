
/**
 * Abstract class User - User is the parent class for
 * all the three actors in the system ( Customer, RestaurantOwner and Administrator)
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public abstract class User
{
    protected String name;
    protected String phoneNumber;
    protected String securityQuestion;
    protected String securityAnswer;
    protected String password;
    protected String email;

    /**
     * getName() returns the name of user
     * @return String
     */
    public String getName()
    {
        return name;
    }

    /**
     * getPhoneNumber() returns the phone Number of user
     * @return String
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    /**
     * getPassword() returns the password of user
     * @return String
     */
    public String getPassword()
    {
        return password ;
    }

    /**
     * setName() assignes the name of user
     * @param name1- new name being initialised
     */
    public void setName(String name1 )
    {
        name = name1;
    }

    /**
     * setPhoneNumber() assignes the name of user
     * @param phoneNumber1- new phone number being initialised
     */
    public void setPhoneNumber(String phoneNumber1 )
    {
        phoneNumber = phoneNumber1;
    }

    /**
     * setPassword() assignes the password to user
     * @param password1- new password being initialised
     */
    public void setPassword(String password1)
    {
        password  = password1;
    }

    /**
     * getEmail() returns the email of user
     * @return String
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * setemail() assignes the email of user
     * @param password1- new email being initialised
     */
    public void setEmail(String email1)
    {
        email  = email1;
    }

    /**
     * getSecAns() returns the security answer set by User to reset password of user
     * @return String
     */
    public String getSecAns()
    {
        return securityAnswer; 
    }

    /**
     * getSecQues() returns the security question set by User to reset password of user
     * @return String
     */
    public String getSecQues()
    {
        return securityQuestion; 
    }

     /**
     * setSecQues() assignes security question of user
     * @param secQues1- new security question being initialised
     */
    public void setSecQues(String secQues1)
    {
        securityQuestion = secQues1;
    }

    /**
     * setSecAns() assignes security answer of user
     * @param secAns1- new security answer being initialised
     */
    public void setSecAns(String secAns1)
    {
        securityAnswer = secAns1;
    }
}
