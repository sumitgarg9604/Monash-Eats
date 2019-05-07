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
    Restaurant res[] ;
    RestaurantOwner resOwner[];
    //Items item[];
    
    public MonashEats()
    {
        res = new Restaurant[3];
        res[0] = new Restaurant("3145","Derby Thai","Thai Restaurant","Caulfield East","4244839","Sumit");
        res[1] = new Restaurant("3145","Quality bakers"," bakery","Glen Huntly","323232323","Rohan");
        res[2] = new Restaurant("3183","Lava"," Bala clava"," St. Kilda"," 3232323","Shrey");

        resOwner = new RestaurantOwner[3];
        resOwner[0] = new RestaurantOwner("Sumit","32232","fav pet","parrot","Sumit","sgar0010@gmail.com");
        resOwner[1] = new RestaurantOwner("Shrey","32323","fav pet","parrot","Shrey","scha0010@gmail.com");
        resOwner[2] = new RestaurantOwner("Rohan","32323","fav pet","parrot","Shrey","rsin0010@gmail.com");
        
        //item = new Items[10];
        //item[0] = new Item("noodles","singapore noodles",4,
        //resOwner[3] = new RestaurantOwner();
    }

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
        String ques = inp.accessInput("Enter Security Question");
        String ans = inp.accessInput("Enter Security Answer");
        String password = inp.accessInput("Enter Password:");
        String confirmPassword = inp.accessInput("Confirm Password:");

        //RestaurantOwner owner  = new RestaurantOwner(name,phoneNumber,ques,ans,password,email);
        FileIo file = new FileIo();
        try{
            file.usingBufferedWritter(name+","+phoneNumber+","+ques+","+ans+","+password+","+email+"\n", "owner.txt");
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
        //res.viewRestaurant(searchSuburbCode);
    }

    /*public void addRestaurant()
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
     */
    public void placeOrder()
    {
        Input inp = new Input();
        int resNumber = 1;
        int[] storeIndex = new int[3];
        int a = 0;
        String searchSuburbCode = inp.accessInput("Enter your suburb code");
        for(int i=0;i<3;i++)
        {

            if(searchSuburbCode.equals(res[i].getSuburbCode()))
            {
                System.out.println(resNumber+". Restaurant Name:"+res[i].getRestaurantName());

                storeIndex[a] = i;
                a++;
                resNumber++;
            }

        }

        int resChoice = Integer.parseInt(inp.accessInput("Press Restaurant Number to select:"));
        // this is index of your restaurant in res[] -->storeIndex[resChoice-1]
        int selResNum = storeIndex[resChoice-1];
        //String name = 
        //Restaurant res1 = new Restaurant(res[selResNum].getRestaurantName(),"asdasd","adasd","asdad","asdasd","asdasd");

        Restaurant res1 = new Restaurant(res[selResNum].getSuburbCode(),res[selResNum].getRestaurantName(),
                          res[selResNum].getRestaurantDesc(),res[selResNum].getRestaurantAddress(),
                          res[selResNum].getRestaurantPhone(),res[selResNum].getRestaurantOwner());
        //System.out.println(selResNum);
        // we can use now res[selResNum] for selected restaurant//
        System.out.println("Welcome to Restaurant "+res1.getRestaurantName());
        System.out.println("1. View Restaurant Menu");
        System.out.println("2. View Restaurant Information"); 
        int choice = Integer.parseInt(inp.accessInput("Press Option Number to choose:"));
        switch(choice)
        {
            case 1:
            {
                System.out.println("abc");
                res[selResNum].getMenu().displayMenu();
                
                int choice1 = Integer.parseInt(inp.accessInput("Press Option Number to choose Menu:"));
                String selCat = res[selResNum].getMenu().getCategory(choice1-1);
                System.out.println("You selected "+selCat);
                
                break;
            }

            case 2:
            res1.displayRestaurantInfo();
            break;

        }

    }

    public void viewItems(String menuCat)
    { 
            
    }
}