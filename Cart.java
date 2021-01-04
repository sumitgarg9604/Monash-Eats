import java.util.*;
import java.lang.Double;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
/**
 * Cart stores items in the cart that user has purchased
 *
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class Cart
{
    int totalAmount;
    String itemName[];
    Input inp;

    ArrayList<Integer> qty = new ArrayList<Integer>();
    ArrayList<String> cart = new ArrayList<String>();
    ArrayList<Double> price = new ArrayList<Double>();
    int itemNumber = 0;
    
    /**
     * Constructor of class Cart
     * initialises object of class Input
     */
    public Cart()
    {
        inp  = new Input();
    }

    /**
     * addToCart() method adds the item to cart
     * @param resName - Restaurant name for which order is being ordered
     * @param itemName - item to be purchased
     * @param qty - quantity of the item
     * @param price - price per unit of the item
     * @param cust - cust object of customer class for which order is placed
     */
    public void addToCart(String resName,String itemName, int  qty1,double itemPrice, Customer cust)
    {

        int itemExisted  =  0; // 0 signifies we assume item is not already in cart)
        for( String searchName : cart)
        {
            if (searchName.equals(itemName))
            {
                int location = cart.indexOf(itemName);
                int plusQty = qty1 + qty.get(location);
                qty.set(location,plusQty);
                int i = qty.get(location);   
                double a = i;
                double updatedPrice = itemPrice*a;
                price.set(location,updatedPrice);
                itemExisted = 1;
            }

        }

        if( itemExisted == 0 )
        {
            cart.add(itemName);
            qty.add(qty1);

            price.add(itemPrice*qty1);
            System.out.println("Item " +itemName+" added to cart ");
            itemNumber++;
        }

    }
    
    /**
     * This method is to view the cart 
     */
    public void viewCart(Customer cust,String resName)
    {
        System.out.println("Welcome to cart");
        System.out.println("Restaurant Name: "+resName);
        if (cust.getName().equals(""))
            System.out.println(" Warning : You are not logged in");
        else
            System.out.println("Name:" +cust.getName());
        for( int i = 0;i<cart.size();i++)
        {
            System.out.println((i+1) + " " + cart.get(i)+ " "+qty.get(i)+ " " + price.get(i));
        }
        double sum = 0;
        for( double p : price)
        {
            sum +=p;    
        }
        System.out.println(" Total : "+ sum);
    }
    
    /**
     * It writes the purchased order to a file to access it for past orders
     * @param resName - restaurant name for which order is made
     * @param cust - Customer who ordered it
     * @param paymentMethod - what payment method the customer chooses
     */
    public void writeCartToFile(String resName,Customer cust,String paymentMethod)
    {   
        // gets current date time of order placed //
        FileIo fileio = new FileIo();
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
        String formattedDate = myDateObj.format(myFormatObj); 

        String restName = ("  Restaurant Name: "+resName+"\n");
        String custName = ("Name:" +cust.getName()+"\n");
        String fileName = cust.getName()+"_"+"Cart.txt";
        fileio.writeToFile(fileName,formattedDate);
        fileio.writeToFile(fileName,restName);
        for( int i = 0;i<cart.size();i++)
        {
            String line1 = ((i+1) + " " + cart.get(i)+ " "+qty.get(i)+ " " + price.get(i)+"\n");
            fileio.writeToFile(fileName,line1);
        }
        double sum = 0;
        for( double p : price)
        {
            sum +=p;    
        }
        String total = (" Total : "+ sum+"\n");
        fileio.writeToFile(fileName,total);
        String paymentMethod1 = "Payment Method :"+paymentMethod+"\n";
        fileio.writeToFile(fileName,paymentMethod1);
        fileio.writeToFile(fileName,"--------------------------------------------------------------------------");
    }

    /**
     * It writes the incoming order to a file to access it for past orders
     * @param resName - restaurant name for which order is made
     * @param cust - Customer who ordered it
     * @param paymentMethod - what payment method the customer chooses
     */
    public void writeHistoryForOwner(String resName,Customer cust,String paymentMethod)
    {   
        // gets current date time of order placed //
        FileIo fileio = new FileIo();
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
        String formattedDate = myDateObj.format(myFormatObj); 

        String restName = ("  Restaurant Name: "+resName+"\n");
        String custName = ("Customer Name:" +cust.getName()+"\n");
        String fileName = resName+"_history.txt";
        System.out.println("File name "+ fileName);
        String phoneNumber = ("Phone Number" +cust.getPhoneNumber()+"\n");
        fileio.writeToFile(fileName,formattedDate);
        fileio.writeToFile(fileName,restName);
        fileio.writeToFile(fileName,custName);
        fileio.writeToFile(fileName,phoneNumber);
        for( int i = 0;i<cart.size();i++)
        {
            String line1 = ((i+1) + " " + cart.get(i)+ " "+qty.get(i)+ " " + price.get(i)+"\n");
            fileio.writeToFile(fileName,line1);
        }
        double sum = 0;
        for( double p : price)
        {
            sum +=p;    
        }
        String total = (" Total : "+ sum+"\n");
        fileio.writeToFile(fileName,total);
        String paymentMethod1 = "Payment Method :"+paymentMethod+"\n";
        fileio.writeToFile(fileName,paymentMethod1);
        fileio.writeToFile(fileName,"--------------------------------------------------------------------------");
    }
    
    /**
     * This method clears the cart for nect user or if order is cancelled
     */
    public void emptyCart()
    {
        qty.clear();
        cart.clear();
        price.clear();
    }

    /**
     * checkout(String resName,Customer cust) is used to redirect user to finalize
     */
    public void checkout(String resName,Customer cust)
    {

        System.out.println("Choose Payment methods");
        System.out.println("1. Pay by cash");
        System.out.println("2. Pay by coupon");
        System.out.println("3. Pay by coupon and cash");
        String paymentMethod = "";
        int choice = Integer.parseInt(inp.accessInput("Please choose preferred payment method"));

        switch(choice)
        {
            case 1:
            System.out.println("Preferred mode of payment: Cash");
            paymentMethod = "Cash";
            break;

            case 2:
            System.out.println("Preferred mode of payment: Coupon");
            paymentMethod = "Coupon";
            break;

            case 3:
            System.out.println("Preferred mode of payment: Coupon and cash");
            paymentMethod = "Coupon and Cash";
            break;

        }
        writeCartToFile(resName,cust,paymentMethod);
        writeHistoryForOwner(resName,cust,paymentMethod);
    }
    
    /**
     * finalizeOrder() is used to finalize order or allow user to cancel order
     */
    public void finalizeOrder()
    {
        System.out.println("Press 1 to finalize order");
        System.out.println("Press 2 to cancel and go to homepage");
        int choice = Integer.parseInt("Please choose option");
        switch(choice)
        {
            case 1:

            System.out.println("Congratulations !! Your order has been placed and sent to restaurant owner for approval");
            break;

            case 2:
            System.out.println("You cancelled the order");
            emptyCart();
            break;

        }
    }
    
    /**
     * this method allows user to edit or update the items in the cart
     */
    public void editCart(Customer cust,String resName)
    {

        System.out.println();
        System.out.println("Press 1 to select item to update in cart");
        viewCart(cust,resName);
        boolean valid = false;
        int choice = 0;
        do{
            do{
                valid = false;
                try
                {
                    choice = Integer.parseInt(inp.accessInput("Please select item number to update"));
                    valid = true;
                }
                catch(Exception e)
                {
                    System.out.println("Invalid Input. Please enter in numeric format");   
                    valid = false;
                }
            }while(!valid);
            if (!(choice < (cart.size()+1) && choice>0 ))
                System.out.println("Invalid Input. Please enter number from list");
        }while((!(choice < (cart.size()+1) && choice>0 )));

        int itemSelected = choice - 1;
        int currentQty = qty.get(itemSelected);
        double currentPrice = price.get(itemSelected);
        double pricePerUnit = currentPrice/currentQty;
        System.out.println("Current Quantity : "+ qty.get(itemSelected));
        int newQty = 0;
        boolean valid2 = false;
        do{
            valid2= false;
            try
            {
                newQty = Integer.parseInt(inp.accessInput("Enter new Quantity:"));
                valid2= true;
            }
            catch(Exception e)
            {
                System.out.println("Invalid Input. Please enter in numeric format");   
                valid2= false;
            }
        }while(!valid2);

        double newPrice = newQty*(pricePerUnit);
        System.out.println("Total cost of this item is "+ newPrice);
        qty.set(itemSelected,newQty);
        price.set(itemSelected,newPrice);
        System.out.println("Item updated Successfully");

    }
}

