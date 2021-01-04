import java.util.*;
import java.lang.Double;
import java.io.*;

/**
 * This is the main controller class of Monash Eats application
 * all the controls from boundary class are operated in this class
 *  @author (Sumit Garg)
 * @version MEv2
 */
public class MonashEats
{
    Restaurant res[];
    Restaurant res1;
    Cart cart = new Cart();
    Customer cust;
    RestaurantOwner owner;
    Input inp; 
    FileIo fileio;
    Administrator admin;
    
    /**
     * default constructor for Monash Eats class
     */
    public MonashEats()
    {
        res1 = new Restaurant();
        cust = new Customer();
        res = new Restaurant[7];
        owner = new RestaurantOwner();
        fileio = new FileIo();
        inp = new Input();
        admin = new Administrator();
        getRestaurants();
    }

    /**
     * This method is used to print rating level for restaurant
     */
    public void showRestaurant()
    {
        System.out.println("Available Restaurants: Search based on SuburbCode");
        System.out.println();
        for (int i = 0; i < res.length; i++)
        {
            if (res[i].getRating() == 0.0)
            {
                String rating = "No Ratings Yet";
                System.out.println("Suburbcode: " + res[i].getSuburbCode() + " Name: " + res[i].getRestaurantName() +"\n Restaurant Desc: " 
                    + res[i].getRestaurantDesc() + "\n Rating: " + rating +"\n");
            }
            else
            {
                double rating = res[i].getRating();
                //System.out.println(res[i]);
                System.out.println("Suburbcode: " + res[i].getSuburbCode() + " Name: " + res[i].getRestaurantName() +"\n Restaurant Desc: " 
                    + res[i].getRestaurantDesc() + "\n Rating: " + rating +"\n");}
        }
    }

    /**
     * This method is used to read file from txt file and fill into arraylist
     */
    public void getRestaurants()
    {
        FileIo file = new FileIo();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Restaurants.txt"));
            int i = 0;
            while (i<7) {

                String line = reader.readLine();
                Scanner scan = new Scanner(line);
                scan.useDelimiter("\n");
                String restaurantDetails = scan.next();
                Scanner scan1 = new Scanner(restaurantDetails);
                scan1.useDelimiter(",");
                String suburbCode = scan1.next(); 
                String name = scan1.next();
                String description = scan1.next();
                String address = scan1.next();
                String phoneNumber = scan1.next();
                String resOwner = scan1.next();
                String rating = scan1.next();
                double rating1 = Double.parseDouble(rating);
                res[i] = new Restaurant(suburbCode,name,description,address, phoneNumber,resOwner,rating1);

                i++;
            }
            reader.close();
        }
        catch(Exception e)
        { System.out.println(e);
        }
    }

    /**
     * This method is used to transfer Restaurant arraylist
     */
    public Restaurant[] getRestaurant()
    {
        return res;
    }

    /**
     * This method is used to transfer Restaurant owner
     */
    public RestaurantOwner getRestaurantOwner()
    {
        return owner;
    }

    /**
     * This method is used to transfer Customer instance
     */
    public Customer getCustomer()
    {
        return cust;
    }

    /**
     * This method is used to define customer's default attributes
     */
    public void setCustomer(String email1,String password1,String name1,String phoneNumber1,String address1,int suburbCode1,String secQues,String secAns)
    {
        cust = new Customer(email1,password1,name1,phoneNumber1,address1,suburbCode1,secQues,secAns);
    }

    /**
     * this method is uesed to define restaurant owner's default attributes
     */
    public void setOwner(String email1,String password1,String name1,String phoneNumber1,String ques,String ans)
    {
        owner = new RestaurantOwner(email1,password1,name1,phoneNumber1,ques,ans);
    }

    /**
     * this method is used to read from file to set user email address into arraylist
     */
    public boolean checkUserEmail(String email,String fileName)
    {

        FileIo file = new FileIo();
        boolean isFound = false;

        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
            while (!isFound) {
                String line = reader.readLine();

                if (line == null)     {
                    isFound = false;
                    break;
                }
                Scanner scan = new Scanner(line);
                scan.useDelimiter("\n");

                String userDetails = scan.next();

                Scanner scan1 = new Scanner(userDetails);
                scan1.useDelimiter(",");

                String emailRegistered = scan1.next();
                if( emailRegistered.equals(email))
                {
                    isFound = true;
                    System.out.println();
                    System.out.println("This email is already registered. Please use another email");
                    System.out.println();
                    break;
                }

            }
        }
        catch(Exception e)
        { 
            System.out.println("Error");
        }

        return (!isFound);
    }

    /**
     * this method is used to write to txt file about customer information
     */
    public void registerCustomer(String email,String password,String name,String phoneNumber,String address,int suburbCode,String ques, String ans)
    {

        FileIo file = new FileIo();

        try{

            file.usingBufferedWritter(email+","+password+","+name+","+phoneNumber+","+address+","+suburbCode+","+ques+","+ans+"\n", "customer.txt");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("Congratulations, you are now registered to order for Monash Eats");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

        }
        catch(Exception e)
        { System.out.println("Error");
        }

    }

    /**
     * This method is used to write to txt file about restaurant owner information
     */
    public boolean registerOwner(String email,String password,String name,String phoneNumber, String secQues, String secAns)
    {

        FileIo file = new FileIo();

        try{

            file.usingBufferedWritter(email+","+password+","+name+","+phoneNumber+","+secQues+","+secAns+"\n", "owner.txt");
            System.out.println();
            System.out.println("Congratulations, you are now registered to order for Monash Eats");
            System.out.println();
        }
        catch(Exception e)
        { System.out.println(e);
        }
        return true;
    }   

    /**
     * This method is used to read from txt file and check with user input to determine login status
     */
    public boolean login(String userName, String enteredPassword)
    {
        boolean isFound = false;
        if(!(cust.getName()).equals(""))
        {
            System.out.println();
            System.out.println("You are already logged in");
            System.out.println();
            isFound = false;
        }
        else
        {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("customer.txt")); 

                while (!isFound) {
                    String line = reader.readLine();

                    if (line == null)     {
                        isFound = false;

                        break;
                    }
                    Scanner scan = new Scanner(line);
                    scan.useDelimiter("\n");

                    String userDetails = scan.next();

                    Scanner scan1 = new Scanner(userDetails);
                    scan1.useDelimiter(",");
                    String email = scan1.next();
                    String password = scan1.next();

                    if(enteredPassword.equals(password) && userName.equals(email))
                    {
                        String name = scan1.next();
                        String phoneNumber = scan1.next();
                        String address = scan1.next();
                        int suburbCode = Integer.parseInt(scan1.next());
                        String secQues = scan1.next();
                        String secAns = scan1.next();
                        System.out.println();
                        System.out.println("Successfully Logged In");
                        System.out.println();
                        System.out.println("Welcome "+name+" to Monash Eats"); 
                        setCustomer(email,password,name,phoneNumber,address,suburbCode,secQues,secAns);
                        System.out.println();
                        isFound = true; 

                        break;
                    }

                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        if(isFound==false)
            return false;
        else 
            return true;
    }

    /**
     * This method is used to read from file and check with the user input to determine restaurant owner login
     */
    public boolean loginRestaurantOwner(String userName, String enteredPassword)
    {
        boolean isFound = false;
        if(!(owner.getName()).equals(""))
        {
            System.out.println();
            System.out.println("You are already logged in");
            System.out.println();
            isFound = false;
        }
        else
        {
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader("owner.txt")); 

                while (!isFound) {
                    String line = reader.readLine();

                    if (line == null)     {
                        isFound = false;

                        break;
                    }
                    Scanner scan = new Scanner(line);
                    scan.useDelimiter("\n");
                    String userDetails = scan.next();
                    Scanner scan1 = new Scanner(userDetails);
                    scan1.useDelimiter(",");
                    String email = scan1.next();
                    String password = scan1.next();

                    if(enteredPassword.equals(password) && userName.equals(email))
                    {
                        String name = scan1.next();
                        String phoneNumber = scan1.next();
                        String ques = scan1.next();
                        String ans = scan1.next();

                        System.out.println();
                        System.out.println("Successfully Logged In");
                        System.out.println();
                        System.out.println("Welcome "+name+" to Monash Eats"); 
                        setOwner(email,password,name,phoneNumber,ques,ans);
                        System.out.println();
                        isFound = true; 

                        break;
                    }

                }
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        if(isFound)
            return true;
        else 
            return false;
    }
    
    /**
     * This method is used to let user place order in system
     */
    public int placeOrder(String searchSuburbCode )
    {
        cart.emptyCart();
        boolean isFoundRestaurant = false;
        Input inp = new Input();
        int resNumber = 1;
        int[] storeIndex = new int[7];
        int a = 0;

        boolean errorCheckSuburbCode = false;
        //boolean checkLogin = false;
        int checkLogin = 1;
        System.out.println();
        System.out.println("Restaurants that deliver to "+searchSuburbCode );
        System.out.println();
        for(int i=0;i<res.length;i++)
        {

            if(searchSuburbCode.equals(res[i].getSuburbCode()))
            {
                System.out.println(resNumber+". Restaurant Name:"+res[i].getRestaurantName());
                storeIndex[a] = i;
                a++;
                resNumber++;
                isFoundRestaurant = true;
            }
        } 
        if(!isFoundRestaurant)
        {
            System.out.println("We currently do not deliver to this suburbCode. please choose another one!!");
            checkLogin = 0;
            return checkLogin;
        }

        boolean valid1 = false;
        int resChoice = 0;
        do{
            do{
                valid1 = false;
                try
                {
                    resChoice = Integer.parseInt(inp.accessInput("Press Restaurant Number to select:"));
                    valid1 = true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    valid1 = false;
                }
            }while(!valid1);
            if (!(resChoice <= (a) && resChoice > 0))
                System.out.println("Invalid Input. Please enter number from list");
        }while(!(resChoice <= (a) && resChoice > 0));

        // this is index of your restaurant in res[] -->storeIndex[resChoice-1]
        int selResNum = storeIndex[resChoice-1];
        res1 = new Restaurant(res[selResNum].getSuburbCode(),res[selResNum].getRestaurantName(),
            res[selResNum].getRestaurantDesc(),res[selResNum].getRestaurantAddress(),
            res[selResNum].getRestaurantPhone(),res[selResNum].getRestaurantOwner(),res[selResNum].getRating());
        // we can use now res[selResNum] for selected restaurant//
        System.out.println("Welcome to Restaurant "+res1.getRestaurantName());
        int choice =0;
        do{
            boolean errorCheck = false;
            choice = 0;
            do{
                try{
                    System.out.println("1. View Restaurant Menu");
                    System.out.println("2. View Restaurant Information");
                    System.out.println("3. Go to Homepage");
                    choice = Integer.parseInt(inp.accessInput("Press Option Number to choose:"));
                    errorCheck = false;
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("-----------------------------------------");
                    System.out.println("You have entered invalid input, Please enter 1 or 2");
                    System.out.println("-----------------------------------------");
                    errorCheck = true;
                }
            }while(errorCheck);

            switch(choice)
            {
                case 1:
                {

                    res[selResNum].getMenu().displayMenu(); 
                    break;
                }

                case 2:
                {
                    res1.displayRestaurantInfo();
                    inp.press1();
                    choice = 4;
                    break;
                }

                case 3:
                System.out.println();
                choice=5;
                break;

                default:
                {
                    System.out.println("-----------------------------------------");
                    System.out.println("Invalid choice, Please enter from 1,2,3");   
                    System.out.println("-----------------------------------------");
                    choice = 4;
                }

            }
        }while(choice == 4);
        if(choice==5)
        {
            return 3;
        }
        boolean valid2 = false;
        int choice1 = 0;
        do{
            do{
                valid2 = false;
                try{
                    choice1 = Integer.parseInt(inp.accessInput("Press Option Number to choose Menu:"));     // asks for menu category
                    valid2 = true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");  
                    valid2 = false;
                }
            }while(!valid2);
            if(!(choice1 <= 3 && choice1>0))
                System.out.println("Invalid Input. Please enter number from list");
        }while(!(choice1 <= 3 && choice1>0));

        String selCat = res[selResNum].getMenu().getCategory(choice1-1);                            // saves menucatgory selected
        System.out.println("You selected "+selCat); 
        // view items based on selection                                           
        int choice2 = 0; // to choose if add more items or view cart

        do{
            choice2 = 0;
            int selectedItem = viewItems(selCat,res[selResNum].getRestaurantName(),selResNum);
            int selectedItemQty = Integer.parseInt(inp.accessInput("Please enter qty of item"));
            cart.addToCart(res[selResNum].getRestaurantName(),res[selResNum].getMenu().getItems()[selectedItem].getItemName()
            ,selectedItemQty,res[selResNum].getMenu().getItems()[selectedItem].getItemPrice(),cust);
            cart.viewCart(cust,res[selResNum].getRestaurantName());

            System.out.println("Press 1 to add more items");
            System.out.println("Press 2 to edit cart");
            System.out.println("Press 3 to View Cart");

            boolean valid5 = false;

            do{
                do{
                    valid5 = false;
                    try
                    {
                        choice2 = Integer.parseInt(inp.accessInput("Press option Number:"));
                        valid5 = true;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Input. Please enter in numeric format");   
                        valid5 = false;
                    }
                }while(!valid5);
                if (!(choice2 <=3 && choice2 > 0))
                    System.out.println("Invalid Input. Please enter number from list");
            }while(!(choice2 <=3 && choice2 > 0));

            switch(choice2)
            {
                case 1:
                break;

                case 2:
                cart.editCart(cust,res[selResNum].getRestaurantName());

                case 3:
                {
                    cart.viewCart(cust,res[selResNum].getRestaurantName());
                    inp.press1();
                    System.out.println("Press 1 to add more items");
                    System.out.println("Press 2 to checkout");

                    boolean valid4 = false;
                    int choiceHere = 0;
                    do{
                        do{
                            valid4 = false;
                            try
                            {
                                choiceHere = Integer.parseInt(inp.accessInput("Press option Number:"));
                                valid4 = true;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Invalid Input. Please enter in numeric format");   
                                valid4 = false;
                            }
                        }while(!valid4);
                        if (!(choiceHere <=2 && choiceHere > 0))
                            System.out.println("Invalid Input. Please enter number from list");
                    }while(!(choiceHere <=2 && choiceHere > 0));

                    if( choiceHere == 1)
                        choice = 1;
                    else 
                        choice = 3;
                    break;
                }

                default:
                {
                    System.out.println("-----------------------------------------");
                    System.out.println("Invalid choice, Please enter from 1 or 2");   
                    System.out.println("-----------------------------------------");
                    choice = 1;
                    break;
                }

            }

        }while(choice == 1);
        if ((cust.getName()).equals(""))
        {
            System.out.println();
            System.out.println("You are not logged in. Please login:");
            System.out.println();
            checkLogin = 2;
        }

        return checkLogin ;

    }

    /**
     * This method is used to let user view past order read from txt file
     */
    public void viewPastOrdersCustomer()
    {
        String fileName = cust.getName()+"_Cart.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception e)
        {
            System.out.println("You have not yet placed any order");
        }
        System.out.println();
        inp.press1();

    }

    /**
     * This method is used to read file for restaurant owner to find out the
     * past order related to specific restaurant
     */
    public void viewPastOrdersRestaurant(int selResNum)
    {
        String fileName = res[selResNum].getRestaurantName()+"_history.txt";
        System.out.println("fileName is "+fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception e)
        {
            System.out.println("No orders has been placed yet at this restaurant");
        }
        System.out.println();
        inp.press1();

    }

    /**
     * This method is used to let user go to finalize order
     */
    public boolean checkOut()
    {
        System.out.println("Press 1 to finalize order");
        boolean checkoutStatus =true;

        System.out.println("Press 2 to cancel and go to homepage");
        int choice4 = Integer.parseInt(inp.accessInput("Please choose option:"));
        switch(choice4)
        {
            case 1:
            System.out.println("Congratulations !! Your order has been placed and sent to restaurant owner for approval");
            cart.checkout(res1.getRestaurantName(),cust);
            System.out.println("Thanks for choosing your payment method");
            System.out.println();
            System.out.println("Would you like to rate the Restaurant?");
            System.out.println("Press 1 to rate the restaurant");
            System.out.println("Press 2 to go to main menu");
            int choice5 = Integer.parseInt(inp.accessInput("Please choose option:"));
            switch(choice5)
            {
                case 1: 
                checkoutStatus = false;
                break;

                case 2:
                checkoutStatus = true;
                break;
            }
            break;

            case 2:
            System.out.println("You cancelled the order");
            checkoutStatus = true;
            break;
        }

        return checkoutStatus;
    }

    /**
     * This method is used for user to provide rating information
     */
    public boolean rating()
    {
        System.out.println(" Please rate your experience for "+res1.getRestaurantName());
        System.out.println("How was the restaurant?");
        System.out.println("5* 4* 3* 2* 1*");

        int rate1 = 0;
        boolean validation1= false;
        do{
            do{
                validation1= false;
                try
                {
                    rate1 = Integer.parseInt(inp.accessInput("Please rate from 1 to 5 "));
                    validation1= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation1= false;
                }
            }while(!validation1);
            if(!(rate1 >0 && rate1 <=5))
                System.out.println("Please rate from 1 to 5 only");
        }while(!(rate1 >0 && rate1 <=5));
        System.out.println("How was the delivery from restaurant?");
        System.out.println("5* 4* 3* 2* 1*");

        int rate2 = 0;
        boolean validation2= false;
        do{
            do{
                validation2= false;
                try
                {
                    rate2 = Integer.parseInt(inp.accessInput("Please rate from 1 to 5 "));
                    validation2= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation2= false;
                }
            }while(!validation2);
            if(!(rate2 >0 && rate2 <=5))
                System.out.println("Please rate from 1 to 5 only");
        }while(!(rate2 >0 && rate2 <=5));

        System.out.println("How was the food");
        System.out.println("1.OK");
        System.out.println("2.Good");
        System.out.println("3.Yummy");

        int rate3 = 0;
        boolean validation3= false;
        do{
            do{
                validation3= false;
                try
                {
                    rate3 = Integer.parseInt(inp.accessInput("Please rate from 1 to 3 "));
                    validation3= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation3= false;
                }
            }while(!validation3);
            if(!(rate3 >0 && rate3 <=3))
                System.out.println("Please rate from 1 to 3 only");
        }while(!(rate3 >0 && rate3 <=3));

        System.out.println("Was the food damaged");
        System.out.println("0.Yes");
        System.out.println("1.No");
        int rate4 = 0;
        boolean validation4= false;
        do{
            do{
                validation4= false;
                try
                {
                    rate4 = Integer.parseInt(inp.accessInput("Please rate 0 or 1 "));
                    validation4= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation4= false;
                }
            }while(!validation4);
            if(!(rate4 >= 0 && rate4 <= 1))
                System.out.println("Please rate from 0 and 1 only");
        }while(!(rate4 >= 0 && rate4 <= 1));

        System.out.println("Thank you for your valuable feedback");

        double rating = (rate1+rate2+rate3+rate4)/4;
        String suburbCode = res1.getSuburbCode();
        String name = res1.getRestaurantName();
        String description = res1.getRestaurantDesc();
        String address = res1.getRestaurantAddress();
        String phoneNumber = res1.getRestaurantPhone();
        String resOwner = res1.getRestaurantOwner();
        double rating1 = res1.getRating();

        double newRating = (rating+rating1)/2;
        String oldInfo =  suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating1;
        fileio.removeFromFile("Restaurants.txt",oldInfo);
        String newInfo = suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+newRating;
        fileio.writeToFile("Restaurants.txt",newInfo);
        getRestaurants();
        return true;
    }

    /**
     * This method is used for let user view the item
     */
    public int viewItems(String menuCat,String resName,int selResNum)
    { 
        Input inp = new Input();
        ArrayList<Integer> itemInRes = new ArrayList<Integer>();
        int itemNumber = 1;
        for ( int i = 0;i<(res[selResNum].getMenu().getItems().length);i++)
        {
            if (((res[selResNum].getMenu().getItems()[i].getResName()).equals(resName)) && 
            ((res[selResNum].getMenu().getItems()[i].getItemCat()).equals(menuCat)))
            {
                {
                    System.out.println(itemNumber+" "+res[selResNum].getMenu().getItems()[i].getItemName()+" "+res[selResNum].getMenu().getItems()[i].getItemDesc()+" "+res[selResNum].getMenu().getItems()[i].getItemPrice());
                    itemNumber++;
                    itemInRes.add(i);
                }
            }}
        int addItemNumber = 0;
        boolean valid3 = false;

        do{
            do{
                valid3 = false;
                try
                {
                    addItemNumber = Integer.parseInt(inp.accessInput("Please select item number to add to cart:"));
                    valid3 = true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    valid3 = false;
                }

            }while(!valid3);
            if (!(addItemNumber < itemNumber && addItemNumber > 0))
                System.out.println("Invalid Input. Please enter number from list");
        }while(!(addItemNumber < itemNumber && addItemNumber > 0));
        int index = addItemNumber - 1;
        return (itemInRes.get(index));
    }

    /**
     * This method is to let user logout from system
     */
    public void logout(String user)
    {
        System.out.println("Thankyou !! Please visit again");
        System.out.println();
        if ( user.equals("customer"))
        {
            cust = new Customer();
            cart.emptyCart();
        }
        else if (user.equals("owner"))
            owner = new RestaurantOwner();

    }

    /**
     * This method is to let user can update restaurant information
     */
    public boolean updateRestaurntInfo(int restaurantIndex)
    {
        boolean back = true;
        Input inp = new Input();
        File file = new File("Restaurants.txt");
        res[restaurantIndex].displayRestaurantInfo();
        String selectedRestName = res[restaurantIndex].getRestaurantName();
        System.out.println("Press 1 to update suburbCode");
        System.out.println("Press 2 to update name");
        System.out.println("Press 3 to update description");
        System.out.println("Press 4 to update address");
        System.out.println("Press 5 to update phoneNo");
        System.out.println("Press 6 to back to update restaurant home page");
        int option = Integer.parseInt(inp.accessInput("Please select number to update information:")); 
        switch(option)
        {   
            //update  suburbcode
            case 1:
            {
                System.out.println("SuburbCode:");
                System.out.println("Current SuburbCode: "+ res[restaurantIndex].getSuburbCode());

                String suburbCode = res[restaurantIndex].getSuburbCode();
                String name = res[restaurantIndex].getRestaurantName();
                String description = res[restaurantIndex].getRestaurantDesc();
                String address = res[restaurantIndex].getRestaurantAddress();
                String phoneNumber = res[restaurantIndex].getRestaurantPhone();
                String resOwner = res[restaurantIndex].getRestaurantOwner();
                double rating = res[restaurantIndex].getRating();

                String newSuburbCode = inp.accessInput("Enter New Suburb Code:");
                String confirm = inp.accessInput("Please confirm with y or Y -- Suburb Code: " + newSuburbCode);
                if (confirm.equals("Y") || confirm.equals("y"))
                {
                    String oldInfo =  suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.removeFromFile("Restaurants.txt",oldInfo);
                    String newInfo = newSuburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.writeToFile("Restaurants.txt",newInfo);
                    System.out.println(" Information updated Successfully");
                    getRestaurants();
                }

                break;

            }

            //update Restaurant Name
            case 2:
            {
                System.out.println("Restaurant Name:");
                System.out.println("Current Restaurant Name: "+ res[restaurantIndex].getRestaurantName());
                String suburbCode = res[restaurantIndex].getSuburbCode();
                String name = res[restaurantIndex].getRestaurantName();
                String description = res[restaurantIndex].getRestaurantDesc();
                String address = res[restaurantIndex].getRestaurantAddress();
                String phoneNumber = res[restaurantIndex].getRestaurantPhone();
                String resOwner = res[restaurantIndex].getRestaurantOwner();
                double rating = res[restaurantIndex].getRating();

                String newRestaurantName = inp.accessInput("Enter New Restaurant Name:");
                String confirm = inp.accessInput("Please confirm with y or Y -- : Restaurant Name " + newRestaurantName);
                if (confirm.equals("Y") || confirm.equals("y"))
                {
                    String oldInfo =  suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.removeFromFile("Restaurants.txt",oldInfo);
                    String newInfo = suburbCode+","+newRestaurantName+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.writeToFile("Restaurants.txt",newInfo);
                    System.out.println(" Information updated Successfully");
                    getRestaurants();
                }
                break;
            }   

            //update Description
            case 3:
            {
                System.out.println("Restaurant Description:");
                System.out.println("Current Restaurant Description: "+ res[restaurantIndex].getRestaurantDesc());

                String suburbCode = res[restaurantIndex].getSuburbCode();
                String name = res[restaurantIndex].getRestaurantName();
                String description = res[restaurantIndex].getRestaurantDesc();
                String address = res[restaurantIndex].getRestaurantAddress();
                String phoneNumber = res[restaurantIndex].getRestaurantPhone();
                String resOwner = res[restaurantIndex].getRestaurantOwner();
                double rating = res[restaurantIndex].getRating();

                String newRestaurantDesc = inp.accessInput("Enter New Restaurant Description:");
                String confirm = inp.accessInput("Please confirm with y or Y -- : Restaurant Description " + newRestaurantDesc);
                if (confirm.equals("Y") || confirm.equals("y"))
                {
                    String oldInfo =  suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.removeFromFile("Restaurants.txt",oldInfo);
                    String newInfo = suburbCode+","+name+","+newRestaurantDesc+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.writeToFile("Restaurants.txt",newInfo);
                    System.out.println(" Information updated Successfully");
                    getRestaurants();
                }
                break;
            }   

            //update Restaurant Address
            case 4:
            {
                System.out.println("Restaurant Address:");
                System.out.println("Current Restaurant Address: "+ res[restaurantIndex].getRestaurantAddress());

                String suburbCode = res[restaurantIndex].getSuburbCode();
                String name = res[restaurantIndex].getRestaurantName();
                String description = res[restaurantIndex].getRestaurantDesc();
                String address = res[restaurantIndex].getRestaurantAddress();
                String phoneNumber = res[restaurantIndex].getRestaurantPhone();
                String resOwner = res[restaurantIndex].getRestaurantOwner();
                double rating = res[restaurantIndex].getRating();

                String newRestaurantAddress = inp.accessInput("Enter New Restaurant Address:");
                String confirm = inp.accessInput("Please confirm with y or Y -- : Restaurant Address " + newRestaurantAddress);
                if (confirm.equals("Y") || confirm.equals("y"))
                {
                    String oldInfo =  suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.removeFromFile("Restaurants.txt",oldInfo);
                    String newInfo = suburbCode+","+name+","+description+","+newRestaurantAddress+","+phoneNumber+","+resOwner+","+rating;
                    fileio.writeToFile("Restaurants.txt",newInfo);
                    System.out.println(" Information updated Successfully");
                    getRestaurants();
                }
                break;
            }   

            //update Phone Number
            case 5:
            {
                System.out.println("Restaurant Phone Number:");
                System.out.println("Current Restaurant Phone Number: "+ res[restaurantIndex].getRestaurantPhone());

                String suburbCode = res[restaurantIndex].getSuburbCode();
                String name = res[restaurantIndex].getRestaurantName();
                String description = res[restaurantIndex].getRestaurantDesc();
                String address = res[restaurantIndex].getRestaurantAddress();
                String phoneNumber = res[restaurantIndex].getRestaurantPhone();
                String resOwner = res[restaurantIndex].getRestaurantOwner();
                double rating = res[restaurantIndex].getRating();

                String newRestaurantPhone = inp.accessInput("Enter New Restaurant Phone Number:");
                String confirm = inp.accessInput("Please confirm with y or Y -- : Restaurant Phone Number " + newRestaurantPhone);
                if (confirm.equals("Y") || confirm.equals("y"))
                {
                    String oldInfo =  suburbCode+","+name+","+description+","+address+","+phoneNumber+","+resOwner+","+rating;
                    fileio.removeFromFile("Restaurants.txt",oldInfo);
                    String newInfo = suburbCode+","+name+","+description+","+address+","+newRestaurantPhone+","+resOwner+","+rating;
                    fileio.writeToFile("Restaurants.txt",newInfo);
                    System.out.println(" Information updated Successfully");
                    getRestaurants();
                }
                break;
            }   

            case 6:
            break;

            default:
            System.out.println("Invalid input,Please select from 1,2,3,4,5");

        }
        return back;
    }
}