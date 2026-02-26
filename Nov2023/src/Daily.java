
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;



/**
 *
 * @author rykhi
 */
public class Daily 
{
    
   private String registrationNumber;
   private LocalDateTime entryDateTime;
   private LocalDateTime exitDateTime;
   public static final double HOURLYRATE = 24.5;
   public static final double FINEAMOUNT = 850.0;

    public Daily(String inRN, LocalDateTime inEY, LocalDateTime inET) 
    {
        registrationNumber = inRN;
        entryDateTime = inEY;
        exitDateTime = inET;
    }

    public String getRegistrationNumber()
    {
        return registrationNumber;
    }

    public LocalDateTime getEntryDateTime() 
    {
        return entryDateTime;
    }

    public LocalDateTime getExitDateTime() 
    {
        return exitDateTime;
    }
    
    public double getParkingFee()
    {
        
        if (entryDateTime == exitDateTime)
        {
            Duration diff = Duration.between(entryDateTime.toLocalTime(),exitDateTime.toLocalTime());
            long secs = diff.toSeconds();
            
            LocalTime rDiff = LocalTime.ofSecondOfDay(secs);
            double fee = HOURLYRATE * rDiff.getHour();
            return fee;
        }
        else 
        {
            return FINEAMOUNT;

        }   
    }

    @Override
    public String toString()
    {
        return "Registration: " + "\t" + "Fee: " + getParkingFee() + "\n" + "Entry: " + entryDateTime + "\t" + "Exit: " + exitDateTime;
    }
   
   
   
    
    
}
