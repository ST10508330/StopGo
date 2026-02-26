
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author rykhi
 */
public class ParkingManager 
{
    private Daily[] pArr = new Daily[50];
    private int size;
    
    public ParkingManager()
    {
        try {
            Scanner scFile = new Scanner(new File("parkings.txt"));
            while(scFile.hasNextLine())
                    {
                      String line = scFile.nextLine();
                      Scanner scLine = new Scanner(line).useDelimiter(";");
                      //GEY 268 FS;2023/09/01 10:51;2023/09/01 12:01  
                      String[] part = line.split(";");
                      int parts = part.length;
                      
                        if (parts == 3) 
                        {
                          String registration = scLine.next();
                          String entryDateTime = scLine.next();
                          String exitDateTime = scLine.next();
                          DateTimeFormatter format =DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                          
                          LocalDateTime entry = LocalDateTime.parse(entryDateTime, format);
                          LocalDateTime exit = LocalDateTime.parse(exitDateTime, format);
                          
                          
                          Daily a = new Daily(registration, entry, exit);
                          pArr[size++] = a;
                        }
                        else if ( parts == 4) 
                        {
                             String registration = scLine.next();
                          String entryDateTime = scLine.next();
                          String exitDateTime = scLine.next();
                          DateTimeFormatter format =DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
                          
                          LocalDateTime entry = LocalDateTime.parse(entryDateTime, format);
                          LocalDateTime exit = LocalDateTime.parse(exitDateTime, format);
                          
                          
                          LongTerm a = new LongTerm(registration, entry, exit, parkingB);
                          pArr[size++] = a;
                        }
  
                        
                    }
            
            
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("File not found");
        }
        
        
    }

    @Override
    public String toString() 
    {
        String results = "";
        
        for (int i = 0; i < size; i++) 
        {
            results += pArr[i].toString() + '\n\n';
            
        }
        
        return results;
    }
}
