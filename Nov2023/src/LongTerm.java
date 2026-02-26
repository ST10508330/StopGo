
import java.time.LocalDateTime;


/**
 *
 * @author rykhi
 */
public class LongTerm extends Daily 
{
    
    private String parkingBay;
    
    public LongTerm(String inRN, LocalDateTime inEY, LocalDateTime inET, String inPB)
    {
        super(inRN, inEY, inET);
        parkingBay = inPB;
    }
    
}
