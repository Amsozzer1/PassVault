import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        File myObj = new File("help.csv"); // Specify the filename
        FileWriter write = new FileWriter(myObj);
        Scanner sc = new Scanner(myObj);
        myObj.setWritable(true);
        System.out.println(myObj.exists());
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String ints[] = line.split(",");
            write.append(line);
            for(int i=0; i< ints.length; i++)
            {
                System.out.println("Int: " + ints[i]+ "\n");
                

            }
            
        }

        
        
      sc.close();  
    }
}
