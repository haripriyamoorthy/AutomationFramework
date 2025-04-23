package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	@FindBy(className = "inventory_item_name")
	private WebElement itemInfo;
	
	@FindBy(xpath = "//button[.='Remove']")
	private WebElement removeBtn;
	
	public WebElement getinventoryitemname() {
		return itemInfo;
	}
	public WebElement removeBtnmethod() {
		return removeBtn;
	}
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * This method will capture the Product Name
	 * @return
	 */
	public String getProductName()
	{
		return itemInfo.getText();
	}
	//Business library
		/**
		 * This method will click on add to cart button
		 */
		
}
