import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Write a description of class FileIo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileIo
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class FileIo
     */
    public FileIo()
    {
        // initialise instance variables
        x = 0;
    }

    public static void usingBufferedWritter(String fileContent,String fileName) throws IOException
    {
        //    String fileContent = "Hello Learner !! Welcome to howtodoinjava.com.";
        File file = new File(fileName);
        FileWriter fr = new FileWriter(file,true);
        BufferedWriter writer = new BufferedWriter(fr);
        writer.write(fileContent);
        writer.close();
    }

    public String readFile(String fileName)
    {
        File file = new File(fileName);
        String var="";
        try{
            Scanner sc = new Scanner(file);
            //sc.useDelimiter(",");
            var = sc.next();
        }
        catch(Exception ex)
        {
            System.out.println("Error");
        }
        return var;
    }
}
