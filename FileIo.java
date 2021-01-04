import java.util.Scanner;
import java.io.*;
/**
 * This class is used to do operations with text files.
 *
 * @author (FIT5136_S19_Team31)
 * @version (v10.4)
 */
public class FileIo
{

    /**
     * Constructor for objects of class FileIo
     */
    public FileIo()
    {
        // initialise instance variables
    }

    public static void usingBufferedWritter(String fileContent,String fileName) throws IOException
    {

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

            var = sc.next();
        }
        catch(Exception ex)
        {
            System.out.println("Error");
        }
        return var;
    }

    public void removeFromFile(String fileName,String oldValue)
    {
        try{
            File inputFile = new File(fileName);
            File tempFile = new File("myTempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = oldValue;
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine.trim();
                if(trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close(); 
            reader.close(); 
            boolean b = inputFile.delete();
            boolean successful = tempFile.renameTo(inputFile);
        } 
        catch (Exception e)
        {
            System.out.println("Problem reading file.");
        }
    }

    public void writeToFile(String fileName,String newValue)
    {
        try{
            File inputFile = new File(fileName);
            FileWriter fr = new FileWriter(inputFile,true);
            BufferedWriter writer = new BufferedWriter(fr);
            writer.write(newValue);
            writer.close(); 
            fr.close();
        }
        catch (Exception e)
        {
            System.out.println("Problem reading file.");
        }
    }

}
