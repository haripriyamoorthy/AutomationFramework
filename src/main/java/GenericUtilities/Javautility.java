package GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * This class consists of generic methods related to Java
 * @author Haripriya
 */
public class Javautility {
/**
 * This utility class will return the current time in specific format
 *
 * 
 * @return 
 */
public String getSystemDateInFormat()
{
	Date d=new Date();
	SimpleDateFormat sd= new SimpleDateFormat("dd-MM-yyyy_hh-mm--ss");
	String Date=sd.format(d);
	return Date;
}

	

}
