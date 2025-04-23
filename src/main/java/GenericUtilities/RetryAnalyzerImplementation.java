package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*
 * 
 * This class implements the IRetryAnalyzer interface of testNG
 * @author=Haripriya
 */

public class RetryAnalyzerImplementation implements IRetryAnalyzer {
	
	
	int count =0;
	int retryCount=3;   // mannual analysis

	public boolean retry(ITestResult result) {
		
		while (count<retryCount) {   //retry 3 times
			count++;
			return true;
		}
		
		return false;
	}

}
