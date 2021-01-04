import java.util.Scanner;
import java.io.IOException;

public class Input
{
    /**
     * responsible for taking input from user and returns the same in String format.
     * @return String
     * @param message : message to be displayed for user to know which input needs to be entered  
     */      
    public String accessInput(String message)
    {
        Scanner console = new Scanner(System.in);
        System.out.print(message);
        String inp = console.nextLine();
        int error = 0;
        do{
            if (inp.equals("") )
            {
                System.out.println("------------------------------------------- ");
                System.out.println("Error : No input entered, Please enter again");
                System.out.println("------------------------------------------- ");
                System.out.print(message);
                inp = console.nextLine();
                error = 1;
            }
            else
                error = 0;
        }while(error == 1);

        return inp;
    }

    /**
     * Press1() is used to allow time to read the previous 
     * output 
     */
    public void press1()
    {
        //System.out.println("Press enter to continue");      
        Scanner input = new Scanner(System.in);
        boolean b = false;
        do{
            b = false;
            String a = accessInput("Press 1 to continue");
            if(a.equals("1"))
                break;
            else 
                b = true;
        }while(b);

    }
}

