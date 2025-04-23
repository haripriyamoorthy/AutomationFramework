package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
		//Rule 2: Identify all web elements using annotations
		@FindBy(id = "user-name") 
		private WebElement usernameEdt; 
		//Auto-healing process-If first element couldn't find the first webelement,
	//	then it will automatically shift to another element
		@FindAll({@FindBy(name = "password"),@FindBy(id = "password")})//single weblement with multiple locators OR Operator
		private WebElement passwordEdt;
		//single webelement with multiple locators-AND Operator
	//	@FindBys({@FindBy(name = "password"),@FindBy(id = "password")})
	//	private WebElement passwordEdt;
		
		
		
		
		@FindBy(className = "submit-button")
		private WebElement loginBtn;
		
		//Rule 3: Create a constructor to initialize webelements
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//Rule 4: Provide getters to Access the web elements
		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//Business Library - Generic method - related to Application
		
		/**
		 * This method will perform login operation
		 * @param username
		 * @param password
		 */
		

		public void loginToApp(String uSERNAME, String pASSWORD) {
			// TODO Auto-generated method stub
			usernameEdt.sendKeys(uSERNAME);
			passwordEdt.sendKeys(pASSWORD);
		    loginBtn.click();
		}
		
		


}
