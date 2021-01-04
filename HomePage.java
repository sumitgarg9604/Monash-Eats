/**
 * Boundary class of Application Monash Eat
 * Takes user inputs from user and display pages
 *
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class HomePage
{
    private Input inp;
    private Validation valid;
    private MonashEats me;
    /**
     * Constructor for objects of class HomePage
     * Initialises the objects of Validation,MonashEats and Input class 
     */
    public HomePage()
    {
        valid = new Validation();
        me = new MonashEats();
        inp = new Input();
    }

    /**
     * Main Home Page of Application Monash Eats
     * It constitues to navigate as user of the application
     * This needs to be called to execute Monash Eats Application
     */
    public void homepageMain()
    {
        int choice = 0;
        do{
            boolean errorCheck = false;
            do{
                try{    
                    System.out.println("----------------------");
                    System.out.println("Welcome to Monash Eats");
                    System.out.println("----------------------");
                    System.out.println("Press 1 for Customer");
                    System.out.println("Press 2 for Restaurant Owner");
                    System.out.println("Press 3 for Administrator");
                    System.out.println("Press 0 to exit");

                    //Choice to act as which user
                    boolean validation1= false;
                    do{
                        validation1= false;
                        try
                        {
                            choice = Integer.parseInt(inp.accessInput("Please enter you choice:"));
                            validation1= true;
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid Input. Please enter in numeric format");   
                            validation1= false;
                        }
                    }while(!validation1);

                    System.out.println();
                    errorCheck = false;
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Invalid choice, Please enter valid input 1,2,3,0:");
                    System.out.println();
                    errorCheck = true;
                }
            }while(errorCheck);

            // switch case for the variable choice
            switch(choice)
            {
                case 1: 
                homepageCustomer();                             // home page of customer
                break;

                case 2:
                displayHomePageRestaurantOwner();               // home page od restaurant owner
                break;

                case 3:
                displayHomePageAdmin();                         // homepage of admin
                break;

                case 0:                                         // case to exit application
                choice = 4;
                System.out.println();
                System.out.println("Thanks for using Monash Eats. Keep Ordering !!");
                break;

                default:                                        // if wron input entered
                System.out.println("Invalid choice, Please enter valid input 1,2,0:"); 
                System.out.println();
                choice = 5;
            }
        }while( choice == 5 ); 
    }

    /**
     * This is the home page of administrator where he can 
     * login and contune with priveledges
     */
    public void displayHomePageAdmin()
    {
        System.out.println();
        System.out.println("Welcome to Administrator Home Page");
        System.out.println("Press 1 to Login");
        System.out.println("Press 2 to go to Monash Eats Home Page");
        System.out.println();
        //choice 1 is selection done by administratort to continue
        int choice1 = 0;

        boolean validation1= false;
        do{
            validation1= false;
            try
            {
                choice1 = Integer.parseInt(inp.accessInput("Enter Your Choice:"));
                validation1= true;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input. Please enter in numeric format");   
                validation1= false;
            }
        }while(!validation1);
        // case of choice1
        switch(choice1){
            case 1:
            displayHomePageAdmin();
            break;

            case 2:
            homepageMain();
        }
    }

    /**
     * This is the home page of customer where he can 
     * login and do fuctions such as login, place order and view Past oeders
     */
    public void homepageCustomer()
    {
        System.out.println("Welcome to Monash Eats: Best Food Delivering app");   
        int choice1 = 0;

        do{

            if(me.getCustomer().getName().equals(""))
            {
                System.out.println("Press 1 to Register as Customer");
                System.out.println("Press 2 to Login");
                System.out.println("Press 3 to Place order");
                System.out.println("Press 4 for Monash Eats Homepage");
                System.out.println("Press 0 to exit");

                boolean validation1= false;
                do{
                    validation1= false;
                    try
                    {
                        choice1 = Integer.parseInt(inp.accessInput("Enter Your Choice:"));
                        validation1= true;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Input. Please enter in numeric format");   
                        validation1= false;
                    }
                }while(!validation1);

                switch(choice1)
                {
                    case 1:
                    displayRegisterCustomer();              // to view register customer page
                    break;

                    case 2:                                 
                    displayLogin();                             // to view login page of customer
                    break;

                    case 3:
                    displayPlaceOrder();                       // to start order placing without logging in
                    choice1 = 0;
                    break;

                    case 4:
                    homepageMain();                             // Navigate to Main page of Monash Eats
                    break;

                    case 0:                                     // to exit
                    choice1 = 0;
                    System.out.println();
                    System.out.println("Thanks for using Monash Eats. Keep Ordering !!");
                    break;

                    default:                                        // validation to prevent unexpected behaviour
                    System.out.println("Invalid Choice,Plese enter from 1,2,3,4,0");
                }
            }
            else
            {         
                int choice=0;
                do
                {
                    System.out.println("Press 1 to place order");
                    System.out.println("Press 2 to view Past Orders");
                    System.out.println("Press 3 to go to Monash Eats Home Page");
                    System.out.println("Press 4 to Logout");
                    System.out.println("Press 0 to exit");

                    boolean validation1= false;
                    do{
                        validation1= false;
                        try
                        {
                            choice = Integer.parseInt(inp.accessInput("Enter Your Choice:"));
                            validation1= true;
                        }
                        catch(Exception e)
                        {
                            System.out.println("Invalid Input. Please enter in numeric format");   
                            validation1= false;
                        }
                    }while(!validation1);

                    switch(choice)
                    {
                        case 1:
                        displayPlaceOrder();                    // navigate to place order when logged in
                        break;

                        case 2:
                        me.viewPastOrdersCustomer();             // view past orders ordered by Customer at different restaurants
                        homepageCustomer();
                        break;

                        case 3:
                        homepageMain();                         // main homepage
                        break;

                        case 4:
                        me.logout("customer");                       // logout from system and go to main homepage
                        homepageMain();
                        break;

                        case 0:                                 // exit from menu
                        {

                            System.out.println();
                            choice = 0;
                            choice1 = 0;
                            break;
                        }

                        default:                                    // validation
                        {
                            System.out.println("Invalid Choice, Please enter from 1,2,3,4,0");
                            choice = 3;
                        }
                    }
                }while(choice==3);
            }

        }while(choice1 != 0);

    }

    /**
     * This method displays the page for Registering as a customer
     * to Monash Eats application
     */
    public void displayRegisterCustomer()
    {
        String name="";
        String phoneNumber = "";
        String email="";
        String password= "";
        String secQues = "";
        String secAns= "";
        String address= "";
        String suburbCode = "";
        boolean validation1= false;
        name = inp.accessInput("Enter Name:");                                  // Name of Customer
        boolean validation2 = false;
        do 
        {
            phoneNumber = inp.accessInput("Enter Phone Number:");               // Phone Number of Customer with character validation
            if(valid.isNumeric(phoneNumber))
            {
                validation2 = true;
            }
            else
            {
                System.out.println("Please enter the numberic character!");
            }
        }while(validation2 == false);
        validation2= false;
        boolean validation10 = false;
        do
        {
            email = inp.accessInput("Enter Email address:");                // email address of Customer with @ validation
            if (valid.checkEmail(email))
            {
                validation10 = true;
            }
            else
            {
                System.out.println("Please enter email address with correct format");
                System.out.println("For example: xxx@gmail.com");
            }

        }while(validation10 == false);
        validation10 = false;

        boolean a = me.checkUserEmail(email,"customer.txt");                    
        if( a )
        {
            int passCheck = 0;
            do{
                passCheck = 0;  
                password = inp.accessInput("Enter Password:");                      // Password 
                String confirmPassword = inp.accessInput("Confirm Password:");      // retype the same password to confirm

                if( !password.equals(confirmPassword))
                {
                    passCheck = 1;
                    System.out.println("Password does not match. Please enter passsword again");
                    System.out.println();
                }
            }while(passCheck == 1); 

            secQues = displaySecurityQues();                                        // method to display security ques 
            secAns = inp.accessInput("Please answer:");                             // user selects security question from 3 choices
            address = inp.accessInput("Enter Address");                              // answer to security question
            boolean codeIsNumeric = false;
            boolean length = false;
            do{

                boolean validation3= false;
                suburbCode = inp.accessInput("Enter your Suburb Post Code:");          // enter suburb code 

                codeIsNumeric = valid.isNumeric(suburbCode);
                if (codeIsNumeric)
                {
                    length = valid.checkSuburbCodeLength( suburbCode);
                    if(length)
                        break;
                    else
                        System.out.println("Suburb code is of 4 digits. For example: 3145");

                }
                else
                {
                    System.out.println("Suburb code is in numeric format. For example: 3145");
                }
            }while(!(codeIsNumeric && length ));
            int suburbCode1 = Integer.parseInt(suburbCode);
            me.registerCustomer(email,password,name,phoneNumber,address,suburbCode1,secQues,secAns);  // register customer method 

        }
        else
        {
            homepageCustomer();                                                             // return to homepage of customer
        }
    }

    /**
     * This method displays the register page for restaurant owner
     * 
     */
    public void displayRegisterOwner()
    {
        String name;
        String phoneNumber;
        String email;
        String password;

        name = inp.accessInput("Enter Name:");              // name of restaurant owner
        boolean validation1 = false;
        do 
        {
            phoneNumber = inp.accessInput("Enter Phone Number:");               //phone number of restaurant owner
            if(valid.isNumeric(phoneNumber))
            {
                validation1 = true;
            }
            else
            {
                System.out.println("Please enter the numberic character!");
            }
        }while(validation1 == false);
        validation1= false;

        boolean validation10 = false;
        do
        {
            email = inp.accessInput("Enter Email address:");                    // Email address of restaurant owner
            if (valid.checkEmail(email))
            {
                validation10 = true;
            }
            else
            {
                System.out.println("Please enter email address with correct format");
                System.out.println("For example: xxx@gmail.com");
            }

        }while(validation10 == false);
        validation10 = false;

        boolean a = me.checkUserEmail(email,"owner.txt");               // it checks if the email is already registered or not
        if( a )
        {
            int passCheck = 0;
            do{
                passCheck = 0;
                password = inp.accessInput("Enter Password:");           // password and confirm passsword to verify if both are same
                String confirmPassword = inp.accessInput("Confirm Password:");

                if( !password.equals(confirmPassword))  
                {
                    passCheck = 1;
                    System.out.println("Password does not match. Please enter passsword again");
                    System.out.println();
                }
            }while(passCheck == 1); 

            // security ques from Customer to help prevent reset password//

            String secQues = displaySecurityQues();                 //displays the security questions for restaurant owner to reset password
            String secAns = inp.accessInput("Please answer:");      // asnwer provided by restaurant owner
            boolean result = me.registerOwner(email,password,name,phoneNumber,secQues,secAns); // registers to system using 
            if(result)
                displayHomePageRestaurantOwner();                   // navigates to home page of restaurant owner if registered successfully
        }
        else
        {
            displayHomePageRestaurantOwner();               
        }
    }

    /**
     * This method provides the login page for customer
     */
    public void displayLogin()
    {
        String userName = inp.accessInput("Enter email:");                      // email of customer is entered
        String enteredPassword = inp.accessInput("Enter your password:");       // password is entered by Customer

        boolean success = me.login(userName,enteredPassword);                   // email and password passed as parameter to check login
        if(success == false)
        {
            System.out.println("Invalid email or password");                     
            int choice = 0;
            do{
                boolean errorCheck = false;
                do{
                    try{
                        System.out.println("Press 1 for relogin");               // 1 if wanted to login again
                        System.out.println("Press 2 for homepage");              // 2 to skip login and continue
                        choice = Integer.parseInt(inp.accessInput("please enter:"));
                        errorCheck = false;
                    }
                    catch(NumberFormatException ex)
                    {
                        System.out.println("Invalid choice, Please enter from 1 or 2");
                        errorCheck = true;
                    }
                }while(errorCheck);

                switch(choice)
                {
                    case 1: 
                    displayLogin();                                                // switch case to above options
                    break;

                    case 2:
                    homepageCustomer();
                    break;

                    default:
                    System.out.println("Invalid choice, Please enter from 1 or 2");                    
                    choice = 3;
                }
            }while( choice == 3 ); 
        }
    }

    /**
     * This method is for home page of restaurant owner 
     * where user can register  and continue with oper
     * operation after login
     * 
     * 
     */
    public void displayHomePageRestaurantOwner()
    {
        if ((me.getRestaurantOwner().getName()).equals(""))
        {
            System.out.println("-----Welcome to Monash Eats Restaurant Owner Home Page-----");
            System.out.println();
            System.out.println("Press 1 to Register as a Restaurant Owner");        
            System.out.println("Press 2 to login");
            System.out.println("Press 3 to go to Monash Eats HomePage");
            int choice = 0;

            boolean validation1= false;
            do{
                validation1= false;
                try
                {
                    choice = Integer.parseInt(inp.accessInput("Enter Your Choice:"));
                    validation1= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation1= false;
                }
            }while(!validation1);

            switch(choice)
            {
                case 1: 
                {
                    displayRegisterOwner();                 //Press 1 to Register as a Restaurant Owner
                    break;
                }

                case 2:
                displayLoginRestaurantOwner();              // to login as restaurant owner
                break;

                case 3:
                homepageMain();                                 // to go to home page of monash eats
                break;

                default:
                System.out.println("Please select from 1,2,3");
            }
        }
        else
        {       // The below page is after User successfully logged in as Restaurant owner
            System.out.println("-----Welcome "+(me.getRestaurantOwner().getName())+" to Monash Eats Restaurant Owner Home Page-----");
            System.out.println();

            System.out.println("Press 1 to select Restaurant");                     
            System.out.println("Press 2 to add a Restaurant");
            System.out.println("Press 3 to Remove a Restaurant");
            System.out.println("Press 4 to logout");
            System.out.println("Press 5 to go to Monash Eats HomePage");

            int choice = 0;

            boolean validation1= false;
            do{
                validation1= false;
                try
                {
                    choice = Integer.parseInt(inp.accessInput("Enter Your Choice:"));
                    validation1= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation1= false;
                }
            }while(!validation1);

            switch(choice)
            {
                case 1: 
                {
                    displayOwnedRestaurants();                  // it displays list of restaurants that owner owns
                    break;
                }

                case 2:
                System.out.println("Welcome to Add Restaurant Page");               // this is add restaurant page for owner to add new 
                displayHomePageRestaurantOwner();                           
                break;

                case 3:
                System.out.println("Welcome to Remove Restaurant Page");            // remove the restaurant from profile page
                displayHomePageRestaurantOwner();
                break;

                case 4:
                me.logout("owner");                                     // logout and continue with main menu
                homepageMain();
                break;

                case 5:
                homepageMain();
                break;
                default:
                System.out.println("Please select from 1,2,3,4,5");
            }
        }
    }

    /**
     * This method displays restaurants owned by Restaurant owners
     * and takes inputs which operation need to performed when a restaurants is selected
     */
    public void displayOwnedRestaurants()
    {   int resNumber = 1;
        int a = 0;
        int[] storeIndex = new int[7];
        System.out.println("-----List of Restaurants you own------");
        int ownRestaurants = 0;

        for(int i = 0;i<7;i++)
        {   
            if ((me.getRestaurant()[i].getRestaurantOwner()).equals(me.getRestaurantOwner().getEmail()))
            {
                System.out.println(resNumber+" "+me.getRestaurant()[i].getRestaurantName());
                storeIndex[a] = i;
                a++;
                resNumber++;
                ownRestaurants++;
            }

        }
        System.out.println("-------------------------------------");
        if(ownRestaurants != 0)
        {
            int resChoice = 0;
            boolean validation1= false;
            do{
                validation1= false;
                try
                {
                    resChoice = Integer.parseInt(inp.accessInput("Press Restaurant Number to select:"));
                    validation1= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation1= false;
                }
            }while(!validation1);

            // this is index of your restaurant in res[] -->storeIndex[resChoice-1]
            int selResNum = storeIndex[resChoice-1];

            //after validation the below code will only work when right option entered
            System.out.println(" Restaurant : "+me.getRestaurant()[selResNum].getRestaurantName());
            System.out.println("Press 1 to Edit Restaurant information");               // edit a restaurant information page
            System.out.println("Press 2 to View Past Orders");                          // to view past orders by that restaurant
            System.out.println("Press 3 to Go to homepage");                             // to go to homepage
            System.out.println("Press 4 to Logout");                                      // to logout

            int option = 0;
            boolean validation2= false;
            do{
                validation2= false;
                try
                {
                    option = Integer.parseInt(inp.accessInput("Enter your choice:"));
                    validation2= true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    validation2= false;
                }
            }while(!validation2);

            switch(option)
            {
                case 1:
                boolean back = me.updateRestaurntInfo(selResNum);
                if (back)
                {
                    displayHomePageRestaurantOwner();
                }
                break;

                case 2:
                me.viewPastOrdersRestaurant(selResNum);
                displayHomePageRestaurantOwner();
                break;

                case 3:
                displayHomePageRestaurantOwner();
                break;

                case 4: 
                me.logout("owner");
                homepageMain();
                break;

                default:
                System.out.println("Invalid choice, Please enter from 1,2,3,4");   

            }
        }
        else
        {
            System.out.println("You do not own any Restaurants");
            displayHomePageRestaurantOwner();
        }
    }

    /**
     * This method displays login page for Restaurant owner
     * and provides relogin option if credentails do not match
     */
    public void displayLoginRestaurantOwner()
    {
        String userName = inp.accessInput("Enter email:");                       // enter email address of owner
        String enteredPassword = inp.accessInput("Enter your password:");        // enter password that was provided by account was set

        boolean success = me.loginRestaurantOwner(userName,enteredPassword);     //email and password are passed to login and start session
        if(!success)
        {
            System.out.println("Invalid email or password");        
            int choice = 0;
            do{
                boolean errorCheck = false;
                do{
                    try{
                        System.out.println("Press 1 for relogin");              // provide relogin option of invalid credentials
                        System.out.println("Press 2 for homepage");

                        boolean validation2= false;
                        do{

                            validation2= false;
                            try
                            {
                                choice = Integer.parseInt(inp.accessInput("please enter:"));
                                validation2= true;
                            }
                            catch(Exception e)
                            {
                                System.out.println("Invalid Input. Please enter in numeric format");   
                                validation2= false;
                            }
                        }while(!validation2);

                        errorCheck = false;
                    }
                    catch(NumberFormatException ex)
                    {
                        System.out.println("Invalid choice, Please enter from 1 or 2");
                        errorCheck = true;
                    }
                }while(errorCheck);

                switch(choice)
                {
                    case 1: 
                    displayLoginRestaurantOwner();                                      
                    break;

                    case 2:
                    displayHomePageRestaurantOwner();
                    break;

                    default:
                    System.out.println("Invalid choice, Please enter from 1 or 2");                    
                    choice = 3;
                }
            }while( choice == 3 ); 
        }
        else
            displayHomePageRestaurantOwner();

    }

    /**
     * This method displays the security ques avaliable in the system
     * to set for Restaurant owner and Customer in order to reset password
     */
    public String displaySecurityQues()
    {
        String ques1 = "Q1: Which is your favourite pet?";                                              //ques1
        String ques2 = "Q2: Who is your favorite actor, musician, or artist?";                          // ques2
        String ques3 = "Q3: In what city were you born?";                                               //ques3
        String selection = "";
        System.out.println(ques1);
        System.out.println(ques2);
        System.out.println(ques3);
        System.out.println();

        int quesNumber = 0;
        boolean validation1= false;
        do{
            validation1= false;
            try
            {
                quesNumber = Integer.parseInt(inp.accessInput("Please select number of your security question:"));
                validation1= true;                                                                  // asks from user which question 
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input. Please enter in numeric format");   
                validation1= false;
            }
        }while(!validation1);

        if (quesNumber == 1)
        {
            selection = ques1;
            System.out.println(ques1);
        }
        else if(quesNumber == 2)
        {
            selection = ques1;
            System.out.println(ques2);
        }
        else if(quesNumber == 3)
        {
            selection = ques1;
            System.out.println(ques3);
        }

        return selection;                   // returns the question selected
    }

    /**
     * This method takes the system in place order page
     * and customer can continue with place order process with logged in or out
     */
    public void displayPlaceOrder()
    {
        String searchSuburbCode;
        boolean codeIsNumeric = false;
        boolean length = false;
        System.out.println();
        System.out.println("Welcome to Place order Page");
        System.out.println();
        me.showRestaurant();                                                                // prints all restaurants
        System.out.println();

        do{
            searchSuburbCode = inp.accessInput("Enter your Suburb Post Code:");                 // Asks for suburb code to search res 
            codeIsNumeric = valid.isNumeric(searchSuburbCode);
            if (codeIsNumeric)
            {
                length = valid.checkSuburbCodeLength( searchSuburbCode);                         // validated the suburbcode
                if(length)
                    break;
                else
                    System.out.println("Suburb code is of 4 digits. For example: 3145");

            }
            else
            {
                System.out.println("Suburb code is in numeric format. For example: 3145");
            }
        }while(!(codeIsNumeric && length ));

        int checkLogin = me.placeOrder(searchSuburbCode);                           // the suburb code is passed on to start

        if (checkLogin == 0)
            displayPlaceOrder();                                                    // if suburb code does not hae restaurant
        else if (checkLogin == 2)
        {
            displayLogin();                                                         // if logged out
            displayCheckout();                                                       // after logging in takes to checkout
        } 
        else if (checkLogin == 3)
            homepageCustomer();                                                     // to return to homepage and cancel the process
        else
            displayCheckout();

    }

    /**
     * THis method displats the checkout page
     * and navigates to display rating page
     */
    public void displayCheckout()
    {
        boolean goToHome = me.checkOut();               // calls out checkout page
        if(goToHome)
        {
            homepageCustomer();                          // if do not want to rate t
        }
        else if (!goToHome)
            displayRating();                                //if want to rate
    }

    /**
     * 
     * This method is take the customer to rating 
     * after order is placed and payment is done
     */
    public void displayRating()
    {
        System.out.println("Welcome to Rating menu");
        boolean a = me.rating();

        if(a)
        {
            homepageCustomer();
        }
    }
}
