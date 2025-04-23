package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItempage {

	@FindBy(xpath = "//button[text()='Add to cart']") 
	private WebElement addtocart;
	
	
	@FindBy(className = "inventory_item_price")
	private WebElement Prizedetails;
	
	public WebElement getaddtocart() {
		return addtocart;
	}
	public WebElement getPrizedetails() {
		return Prizedetails;
	}
	public void clickonaddtocart() {
		addtocart.click();
	}
	
	
	public InventoryItempage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * This method will click on add to cart button
	 */
	public void clickOnAddToCartBtn()
	{
		addtocart.click();
	}
	/**
	 * this method will return the prize details
	 * @return
	 */
	public String getprize()
	{
		String prize=Prizedetails.getText();
		return prize;
	}
}
