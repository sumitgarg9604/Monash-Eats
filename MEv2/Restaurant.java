import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Write a description of class Restaurant here.
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
    //Items item[];
    /**
     * Constructor for objects of class Restaurant
     */
    public Restaurant()
    {
        
        // initialise instance variables
        //item = new Items[3];//
        menu = new Menu();
               
        //menu[0] = new Menu();
        //menu[1] = new Menu();
        //menu[2] = new Menu();
        //menu[1] = new Menu("Breakfast","Lunch","Dinner");
        //menu[2] = new Menu("Breakfast","Lunch","Dinner");
    }
    
    public Menu getMenu()
    {
         menu = new Menu();
        return menu;
    }
    
    public Restaurant(String suburbCode1,String name1, String description1, String address1, String phoneNumber1,String resOwner1 )
    {
        suburbCode = suburbCode1;
        name = name1;
        description = description1;
        address = address1;
        phoneNumber = phoneNumber1;
        resOwner = resOwner1;
    }

    public void addRestaurant()
    {

    }

    /*public void viewRestaurant(String searchSuburbCode)
    {

    try
    {
    BufferedReader reader = new BufferedReader(new FileReader("Restaurants.txt")); 
    while (true) {
    String line = reader.readLine();
    Scanner scan = new Scanner(line);
    scan.useDelimiter("\n");
    String resDetails = scan.next();
    //System.out.println("This is resDetails"+resDetails);
    Scanner scan1 = new Scanner(resDetails);
    scan1.useDelimiter(",");
    String suburbCode = scan1.next();
    //System.out.println("THis is suburbCode"+suburbCode);
    if(suburbCode.equals(searchSuburbCode))
    {
    System.out.println("Restaurant Name:"+scan1.next());
    System.out.println("Restaurant Description:"+scan1.next());
    System.out.println("Restaurant Location:"+scan1.next());
    System.out.println("Restaurant Phone number:"+scan1.next());
    System.out.println();
    }

    if (line == null) {
    break;
    }
    //System.out.println(line);
    }
    }
    catch(Exception ex){
    //System.out.println(ex);
    }
    }
     */

    public void displayRestaurantInfo()
    {
        System.out.println("Restaurant Name:"+name);
        System.out.println("Restaurant Description:"+description);
        System.out.println("Restaurant Location:"+address);
        System.out.println("Restaurant Phone number:"+phoneNumber);
    }

    public void searchRestaurant(String suburbCode)
    {

    }

    public String getRestaurantName()
    {
        return name;
    }

    public String getRestaurantDesc()
    {
        return description;
    }

    public String getRestaurantAddress()
    {
        return address;
    }

    public String getRestaurantPhone()
    {
        return phoneNumber;
    }

    public String getSuburbCode()
    {
        return suburbCode;
    }

    public String getRestaurantOwner()
    {
        return resOwner;
    }

    public void setRestaurantName( String name1)
    {
        name = name1;
    }

    public void setRestaurantDesc( String description1)
    {
        description = description1;
    }

    public void setRestaurantAddress( String address1)
    {
        address = address1;
    }

    public void setRestaurantPhone( String phoneNumber1)
    {
        phoneNumber = phoneNumber1;
    }

    public void setSuburbCode( String suburbCode1)
    {
        suburbCode = suburbCode1;
    }

    public void setRestaurantOwner( String resOwner1)
    {
        resOwner= resOwner1;
    }
}

