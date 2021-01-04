import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Stores all the restaurants in the system.
 *
 * @author (Sumit Garg)
 * @version MEv2
 */
public class Restaurant
{
    String name; 
    String description;
    String address;
    String phoneNumber;
    String suburbCode;
    String resOwner;
    Menu menu;
    double rating;

    /**
     * Constructor for objects of class Restaurant
     */
    public Restaurant()
    {
        menu = new Menu();
    }

    /**
     * getMenu() return the menu object of Menu clas     * 
     * @return Menu
     */
    public Menu getMenu()
    {
        menu = new Menu();
        return menu;
    }

    /**
     * Parametrized Constructor of Class Restaurant
     * Initialises the variables for object of Restaurant from Paramters 
     * @param suburbCode1 - suburb Code of Restaurant
     * @param name1 - name of Restaurant
     * @param phoneNumber1 - Contact number of Restaurant
     * @param address1 -  address of Restaurant
     * @param resOwner1 -  Name of Restaurant owner
     * @param rating1 -  rating1 of Restaurant by different users
     * 
     */
    public Restaurant(String suburbCode1 ,String name1, String description1, String address1, String phoneNumber1,
    String resOwner1,double rating1 )
    {
        suburbCode = suburbCode1;
        name = name1;
        description = description1;
        address = address1;
        phoneNumber = phoneNumber1;
        resOwner = resOwner1;
        rating = rating1;
    }
    
    /**
     * displayRestaurantInfo() is used to display restaurant information in boundary class
     */
    public void displayRestaurantInfo()
    {
        System.out.println("Restaurant Name:"+name);
        System.out.println("Restaurant Description:"+description);
        System.out.println("Restaurant Location:"+address);
        System.out.println("Restaurant Phone number:"+phoneNumber);

        if(rating == 0 || rating == 0.0)
            System.out.println("Restaurant Rating: No ratings yet ");
        else
            System.out.println("Restaurant Rating: "+rating);
    }
    
    /**
     * getRestaurantName() is used to transfer restaurant name attributes
     * @return String
     */
    public String getRestaurantName()
    {
        return name;
    }

    /**
     * getRestaurantDesc() is used to transfer restaurant desciprtion attributes
     * @return String
     */
    public String getRestaurantDesc()
    {
        return description;
    }

    /**
     * getRestaurantAddress() is used to transfer restaurant address attributes
     * @return String
     */
    public String getRestaurantAddress()
    {
        return address;
    }

    /**
     * getRestaurantPhone() is used to transfer restaurant phone number attributes
     * @return String
     */
    public String getRestaurantPhone()
    {
        return phoneNumber;
    }

    /**
     * getSuburbCode() is used to transfer restaurant suburb code attributes
     * @return String
     */
    public String getSuburbCode()
    {
        return suburbCode;
    }

    /**
     * getRating() is used to transfer restaurant suburb code attributes
     * @return double
     */
    public double getRating()
    {
        return rating;
    }

    /**
     * getRestaurantOwner() is used to transfer restaurant owner name attributes
     * @return String
     */
    public String getRestaurantOwner()
    {
        return resOwner;
    }

    /**
     * setRestaurantName( String name1) is used to set restaurant name attributes
     * @parameter - String - being validated
     */
    public void setRestaurantName( String name1)
    {
        name = name1;
    }

    /**
     * setRestaurantDesc( String description1) is used to set restaurant descritption attributes
     * @parameter - String - being validated
     */
    public void setRestaurantDesc( String description1)
    {
        description = description1;
    }

    
    /**
     * setRestaurantAddress( String address1) is used to set restaurant address attributes
     * @parameter - String - being validated
     */
    public void setRestaurantAddress( String address1)
    {
        address = address1;
    }

    /**
     * setRestaurantPhone( String phoneNumber1) is used to set restaurant phone number attributes
     * @parameter - String - being validated
     */
    public void setRestaurantPhone( String phoneNumber1)
    {
        phoneNumber = phoneNumber1;
    }

    /**
     * setSuburbCode( String suburbCode1) is used to set restaurant suburb code attributes
     * @parameter - String - being validated
     */
    public void setSuburbCode( String suburbCode1)
    {
        suburbCode = suburbCode1;
    }

    /**
     * setRestaurantOwner( String resOwner1) is used to set restaurant owner attributes
     * @parameter - String - being validated
     */
    public void setRestaurantOwner( String resOwner1)
    {
        resOwner= resOwner1;
    }
}

