/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer extends User
{
    String deliveryAddress;
    int suburbCode;
    public Customer()
    {
        name = "nameless";
        phoneNumber = "phoneNumber1";
        email = "email1";
        password ="password1";
        //confirmPassword = "confirmPassword1";
        deliveryAddress = "3135";
        suburbCode = 3145;
    }

    public Customer(String name1,String phoneNumber1,String email1,String password1)
    {
        name = name1;
        phoneNumber = phoneNumber1;
        email = email1;
        password = password1;
        //confirmPassword = confirmPassword1;
    }

    public void displayCustomer()
    {
        System.out.println( name+phoneNumber+email+password);

    }       

    public void setCustomer()
    {
        
    }
}
