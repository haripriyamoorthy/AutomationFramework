package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



/*
 * This class implements the ITESTLISTNER interface Of testng 
 * @author Haripriya
 */

public class ListnersImplementation implements ITestListener {
     
	ExtentReports report;
	ExtentTest test;
	
	
	
	public void onTestStart(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"@Test execution started");
		//Intimate Extent report for Test
				test = report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"@Test is pass");
		
		//Log the Test result as PASS in Extent Report
				test.log(Status.PASS, methodname + " -> @Test is pass");
		
	}

	public void onTestFailure(ITestResult result) {
	
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"@Test is fail");
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodname + " -> @Test is Fail");


		
		//capture the exception
		System.out.println(result.getThrowable());
		
		test.log(Status.WARNING, result.getThrowable());
		
		
		//capture the screenshot
		seleniumUtility s= new seleniumUtility();
		Javautility j=new Javautility();
		String ScreenshotName=methodname+"-"+j.getSystemDateInFormat();
		try {
			String path = s.takescreenshot(BaseClass.sdriver, ScreenshotName);
			
			//Attach the screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
			}
		}

	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"@Test is skip");
		
		//Log the status as Skip in extent report
				test.log(Status.SKIP, methodname + " -> @Test is skip");
 
				
				//Log the exception in extent report
				test.log(Status.WARNING, result.getThrowable());

		
		//capture the exception
		System.out.println(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("suite execution started");
		//Configure the extent reports
        ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+new Javautility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter name", "Haripriya");
	}
	public void onFinish(ITestContext context) {
		System.out.println("suite execution finished");
	}

}
