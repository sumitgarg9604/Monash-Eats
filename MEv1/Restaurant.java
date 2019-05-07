import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Write a description of class Restaurant here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Restaurant
{
    String name; 
    String description;
    String address;
    String phoneNumber;
    String suburbCode;
    
    /**
     * Constructor for objects of class Restaurant
     */
    public Restaurant()
    {
        // initialise instance variables
        
    }

    public Restaurant(String suburbCode1,String name1, String description1, String address1, String phoneNumber1 )
    {
        suburbCode = suburbCode1;
        name = name1;
        description = description1;
        address = address1;
        phoneNumber = phoneNumber1;
    }
    
    public void addRestaurant()
    {

    }

    public void viewRestaurant(String searchSuburbCode)
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
}
