
/**
 * Write a description of class RestaurantOwner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RestaurantOwner extends User
{
     public RestaurantOwner()
    {
        name = "name1";
        phoneNumber = "phoneNumber1";
        email = "email1";
        password ="password1";
        //confirmPassword = "confirmPassword1";
    }

    public RestaurantOwner(String name1,String phoneNumber1,String email1,String password1,String confirmPassword1)
    {
        name = name1;
        phoneNumber = phoneNumber1;
        email = email1;
        password = password1;
        //confirmPassword = confirmPassword1;
    }

    public void displayRestaurantOwner()
    {
        System.out.println( name+phoneNumber+email+password);

    }       
    
    public void addRestaurant(String suburbCode)
    {
        
    }
}
