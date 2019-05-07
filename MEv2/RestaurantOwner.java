
/**
 * Write a description of class RestaurantOwner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RestaurantOwner extends User

{
    //Restaurant res[];
    
     public RestaurantOwner()
    {
        name = "name1";
        phoneNumber = "phoneNumber1";
        email = "email1";
        password ="password1";
        
        
        
        //confirmPassword = "confirmPassword1";
    }

    public RestaurantOwner(String name1,String phoneNumber1,String ques,String ans,String email1,String password1)
    {
        name = name1;
        phoneNumber = phoneNumber1;
        securityQuestion = ques;
        securityAnswer = ans;
        email = email1;
        password = password1;
        //confirmPassword = confirmPassword1;
    }

    /*public Restaurant[] getRestaurant()
    {
        return res;
    }*/
    public void displayRestaurantOwner()
    {
        System.out.println( name+phoneNumber+email+password);

    }       
    
    public void addRestaurant(String suburbCode)
    {
        
    }
}
