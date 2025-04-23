package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.Fileutility;
import GenericUtilities.Javautility;
import GenericUtilities.seleniumUtility;
import objectrepository.LoginPage;

public class AddProductToCartUsingDDTAndGU {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
               Fileutility futil = new Fileutility();
               Javautility jutil = new Javautility();
               seleniumUtility sutil = new seleniumUtility();
               
             //Read Common Data from Property file
       	String URL =	futil.readDataFromPropertyFile("url");
       	String USERNAME=futil.readDataFromPropertyFile("username");
       	String PASSWORD= futil.readDataFromPropertyFile("password");
       		//Read Test Data From Excel File
       		String PRODUCTNAME= futil.readDatafromExcel("Product", 1, 2);
       		
       		// Step 1: Launch the browser
       		WebDriver driver = new ChromeDriver();
       		sutil.maximizeWindow(driver);
       		sutil.implicitlywait(driver);
       		// Step 2: Load the Application
       		driver.get(URL);

       		// Step 3: login To Application
//       		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//       		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//       		driver.findElement(By.id("login-button")).click();
       		LoginPage lp=new LoginPage(driver);
       		lp.loginToApp(USERNAME, PASSWORD);
       		
//       		lp.getUsernameEdt().sendKeys(USERNAME);
//       		lp.getPasswordEdt().sendKeys(PASSWORD);
//       		lp.getLoginBtn().click();

       		// Step 4: Click on a Product 
       		WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
       		String pAddedToCart = productEle.getText();
       		productEle.click();

       		// Step 5: Add the Product To Cart
       		driver.findElement(By.id("add-to-cart")).click();

       		// Step 6: Navigate to Cart
       		driver.findElement(By.id("shopping_cart_container")).click();
       		
       		//capture screenshot for reference
       		String Screenshotname = "TC_001"+jutil.getSystemDateInFormat();
       		String path=sutil.takescreenshot(driver, Screenshotname);
       		System.out.println(path);

       		// Step 7: Validate the product in Cart
       		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
       		if (pInCart.equals(pAddedToCart)) {
       			System.out.println("PASS");
       			System.out.println(pInCart);
       		} else {
       			System.out.println("FAIL");
       		}

       		// Step 8: Logout of App
       		driver.findElement(By.id("react-burger-menu-btn")).click();
       		driver.findElement(By.linkText("Logout")).click();
       	}
     
	}


