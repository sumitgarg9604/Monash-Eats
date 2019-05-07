import java.util.Scanner;

public class Input
{
    /**
     * responsible for taking input from user and returns the same in String format.
     * @return String
     * @param message : message to be displayed for  
     */      
public String accessInput(String message)
    { 
        Scanner console = new Scanner(System.in);
        System.out.print(message);
        String inp = console.nextLine();
        return inp;
    }   
}

    