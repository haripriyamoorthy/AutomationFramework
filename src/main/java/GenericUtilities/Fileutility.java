package GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method consists of generic methods related to File Operation
 * @author Haripriya
 */
public class Fileutility {
	/**
	 * This method will read data from property file for the key provided
	 * by the caller and value returned to the caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
  public String readDataFromPropertyFile(String key) throws IOException {
	  FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value= p.getProperty(key);
		return value;
  }
  
  public String readDatafromExcel(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
	  FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	  Workbook wb = WorkbookFactory.create(fise);
	  String value = wb.getSheet(sheetname).getRow(rowno).getCell(cellno).getStringCellValue();
	return value;
	  
  }
}
