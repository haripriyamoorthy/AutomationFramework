package inventorypage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.Fileutility;
import GenericUtilities.Javautility;
import GenericUtilities.seleniumUtility;
import objectrepository.CartPage;
import objectrepository.InventoryItempage;
import objectrepository.InventoryPage;
import objectrepository.LoginPage;

public class AddProductToCart {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
//		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
//		driver.findElement(By.id("password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("login-button")).click();
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();

		// Step 4: Click on a Product 
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);

;

		// Step 5: Add the Product To Cart
			InventoryItempage iip = new InventoryItempage(driver);
			iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
			ip.clickOnCartContainer();
		
	

		// Step 7: Validate the product in Cart
			  CartPage cp = new CartPage(driver);
			    String pInCart = cp.getProductName();
		if (pInCart.equals(pAddedToCart)) {
			System.out.println("PASS");
			System.out.println(pInCart);
		} else {
			System.out.println("FAIL");
		}

		// Step 8: Logout of App
		
		ip.logoutOfApp();
	}

	}


