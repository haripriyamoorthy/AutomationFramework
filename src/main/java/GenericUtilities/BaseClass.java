package GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectrepository.InventoryPage;
import objectrepository.LoginPage;

public class BaseClass {
     
	
	public Fileutility fUtil = new Fileutility();
	public   Javautility jutil = new Javautility();
	public seleniumUtility sutil = new seleniumUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void bsconfig() {
		System.out.println("----Database connection successfull-----");
	}
	
	//@Parameters("Browser")
	//@BeforeTest
    @BeforeClass(alwaysRun = true)
	public void bcconfig (/*String Pvalue*/) throws IOException {
		String URL=fUtil.readDataFromPropertyFile("url");
		//For cross Browser Execution-Run Time Polymorphism
//		if (Pvalue.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
//
//		
//		else if (Pvalue.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}
//		
//		else  {
//			driver=new EdgeDriver();
//		}
		
		
		
		driver=new ChromeDriver();
		sutil.maximizeWindow(driver);
		sutil.implicitlywait(driver);
		driver.get(URL);
		System.out.println("----Browser launch successfull----");
		
		sdriver=driver;
		
	}
    
	@BeforeMethod(alwaysRun = true)
	public void bmconfig() throws IOException {
		
		String USERNAME= fUtil.readDataFromPropertyFile("username");
		String PASSWORD= fUtil.readDataFromPropertyFile("password");
		
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("----- Login to App successfull -----");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("----- Logout of App successfull -----");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("----- Browser closure successfull -----");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("----- Database Closure successfull -----");
	}
		
	
	
	
}
