/**
 * Customer clas stores the details of customers.
 *
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class Customer extends User
{
    
    private String address;      
    private int suburbCode;
    
    /**
     * Constructor of Class customer
     * Initialises the variables for object of customer to null 
     * It is inherited from User class
     */
    public Customer()
    {
        name = "";
        phoneNumber = "";
        email = "";
        password ="";
        address = "";
        suburbCode = 0000;
    }

     /**
     * Parametrized Constructor of Class customer
     * Initialises the variables for object of customer to Paramters 
     * @param email1 - email address of a customer
     * @param password1 - password to login 
     * @param name1 - name of Customer
     * @param phoneNumber1 - Contact number of Customer
     * @param address1 - delivery address of Customer
     * @param suburbCode1 - suburb Code of delivery address of customer
     * @param secQues - security question selected by customer to reset password
     * @param secAns - answer to security question to reset password
     */
    public Customer(String email1,String password1,String name1,String phoneNumber1,String address1,int suburbCode1,String secQues,String secAns)
    {
        email = email1;
        password = password1;
        name = name1;
        phoneNumber = phoneNumber1;
        address = address1;
        suburbCode = suburbCode1;

    }

    /**
     * getSuburbCode() returns the suburb code of user
     * @return int
     */
    public int getSuburbCode()
    {
        return suburbCode;
    }
    
    /**
     * getAddress() returns the address of user
     * @return String
     */
    public String getAddress()
    {
        return address;
    }
         
    /**
     * setSuburbCode() assignes the suburb Code of user
     * @param suburbCode1- new suburbCode being initialised
     */
    public void setSuburbCode(int suburbCode1)
    {
        suburbCode = suburbCode1;
    }
    
      /**
     * setAddress() assignes the address of user
     * @param address1- new address1 being initialised
     */
    public void setAddress(String address1)
    {
        address = address1;
    }

}
