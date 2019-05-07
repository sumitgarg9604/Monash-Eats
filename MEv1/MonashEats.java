import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MonashEats
{

    public  void main()
    {
        System.out.println("Welcome to Monash Eats: Best Food Delivering app");

        Input inp = new Input();    
        int choice = 0;
        do{
            System.out.println("Press 1 to register as Customer");
            System.out.println("Press 2 to register as Restaurant Owner");
            //System.out.println("Press 3 to add a restaurant");
            System.out.println("Press 3 to login");
            System.out.println("Press 4 to search restaurant");
            System.out.println("Press 11 to exit");

            choice = Integer.parseInt(inp.accessInput("Enter Your Choice:"));
            switch(choice)
            {
                case 1:
                registerCustomer();
                break;

                case 2:
                registerRestaurantOwner();
                break;

                case 3:
                login();
                break;

                case 4:
                searchRestaurants();
                break;

                case 11:
                break;
            }}while(choice != 11);
    }

    public void registerCustomer()
    {
        Input inp = new Input();

        String name = inp.accessInput("Enter Name:");
        String phoneNumber = inp.accessInput("Enter Phone Number:");
        String email = inp.accessInput("Enter Email address");
        String password = inp.accessInput("Enter Password:");
        String confirmPassword = inp.accessInput("Enter Password:");

        Customer cust = new Customer(name,phoneNumber,email,password);
        FileIo file = new FileIo();
        try{
            file.usingBufferedWritter(cust.name+","+cust.phoneNumber+","+cust.email+","+cust.password+"\n", "customer.txt");
        }
        catch(Exception e)
        { System.out.println("error");
        }

    }

    public void registerRestaurantOwner()
    {
        Input inp = new Input();
        String name = inp.accessInput("Enter Name:");
        String phoneNumber = inp.accessInput("Enter Phone Number:");
        String email = inp.accessInput("Enter Email address");
        String password = inp.accessInput("Enter Password:");
        String confirmPassword = inp.accessInput("Enter Password:");

        RestaurantOwner owner  = new RestaurantOwner(name,phoneNumber,email,password,confirmPassword);
        FileIo file = new FileIo();
        try{
            file.usingBufferedWritter(owner.name+","+owner.phoneNumber+","+owner.email+","+owner.password+"\n", "owner.txt");
        }
        catch(Exception e)
        { System.out.println("error");  
        }
    }

    public void login()
    {
        Input inp = new Input();
        String userName = inp.accessInput("Enter email:");
        String enteredPassword = inp.accessInput("Enter your password:");
        boolean isFound = true;
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("customer.txt")); 
            while (isFound) {
                String line = reader.readLine();
                Scanner scan = new Scanner(line);
                scan.useDelimiter("\n");
                String userDetails = scan.next();

                Scanner scan1 = new Scanner(userDetails);
                scan1.useDelimiter(",");
                String name = scan1.next();
                String phoneNumber = scan1.next();
                String email = scan1.next();
                String password = scan1.next();

                if(enteredPassword.equals(password) && userName.equals(email))
                {
                    System.out.println("Welcome "+name+" to Monash Eats");
                    Customer cust = new Customer(name,phoneNumber,email,password);
                    System.out.println();
                    isFound = false;
                }

                if (line == null) {
                    break;
                }

            }
        }
        catch(Exception ex){
            //System.out.println(ex);
        }

    }

    public void searchRestaurants()
    {
        // search restaurants  

        Restaurant res = new Restaurant();

        Input inp = new Input();
        String searchSuburbCode = inp.accessInput("Enter your suburb code");
        res.viewRestaurant(searchSuburbCode);
    }

    public void addRestaurant()
    {
        Input inp = new Input();
        String name = inp.accessInput("Enter Name:");
        String phoneNumber = inp.accessInput("Enter Phone Number:");
        String address = inp.accessInput("Enter address");
        String suburbCode = inp.accessInput("Enter Suburb Code");
        String description = inp.accessInput("Enter description:");

        Restaurant res  = new Restaurant(suburbCode,name,description,address,phoneNumber);
        FileIo file = new FileIo();
        try{
            file.usingBufferedWritter(res.suburbCode+","+res.name+","+res.description+","+res.address+","+res.phoneNumber+"\n", "Restaurants.txt");
        }
        catch(Exception e)
        { System.out.println("error");  
        }
    }

    public void placeOrder()
    {
        
    }
}