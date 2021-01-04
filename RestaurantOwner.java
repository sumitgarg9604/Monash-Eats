/**
 * Restaurant owner user detail is stored in this clas.
 * It is inherited from User class
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class RestaurantOwner extends User
{

    /**
     * Constructor of RestaurantOwner user
     * Initialises the variables for object of RestaurantOwner to null 
     * 
     */
    public RestaurantOwner()
    {
        name = "";
        phoneNumber = "";
        email = "";
        password ="";

    }

    /**
     * Parametrized Constructor of Class Restaurant Owner
     * Initialises the variables for object of Restaurant Owner to Paramters 
     * @param email1 - email address of a Restaurant Owner
     * @param password1 - password to login 
     * @param name1 - name of Restaurant Owner
     * @param phoneNumber1 - Contact number of Restaurant Owner
     * @param address1 - delivery address of Restaurant Owner
     * @param suburbCode1 - suburb Code of delivery address of Restaurant Owner
     * @param secQues - security question selected by customer to reset password
     * @param secAns - answer to security question to reset password
     */
    public RestaurantOwner(String email1,String password1,String name1,String phoneNumber1,String ques,String ans)
    {
        email = email1;
        password = password1;
        name = name1;
        phoneNumber = phoneNumber1;
        securityQuestion = ques;
        securityAnswer = ans;
    }

    /**
     * displayRestaurantOwner() to display a restaurant owner in action
     */
    public void displayRestaurantOwner()
    {
        System.out.println( name+phoneNumber+email+password);
    }       

}
