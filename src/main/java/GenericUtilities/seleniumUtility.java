package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class seleniumUtility {
/**
 * this utility class will maximize the window
 * @param driver
 */
	
	
	public void maximizeWindow(WebDriver driver)
	{
	driver.manage().window().maximize();	
	}
	/**
	 * This utility class will minimize thw window
	 * @param driver
	 */
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will give the implicitly wait for the driver
	 * @param driver
	 */
	
	
	
	public void implicitlywait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will add explicitly wait to the code and wait for element to be visible
	 * @param driver
	 */
	
	public void forelementtobevisible(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	       wait.until(ExpectedConditions.elementToBeClickable(element));
	       
	}
	/**
	 * This method will add explicitly wait to the code and wait for element to be clickable
	 * @param driver
	 */
	
	public void ForElementtobeCLickable(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	       wait.until(ExpectedConditions.elementToBeClickable(element));
	       
	}
	/**
	 * Handling dropdowns by index
	 * @param element
	 * @param Index
	 */

	
	public void selectclassbyIndex(WebElement element,int Index) {
		 Select sel=new Select(element);
		 sel.selectByIndex(1);
	}
	/**
	 * Handling dropdowns by value
	 * @param element
	 * @param Index
	 */
	
	public void selectclassByValue(WebElement element,String Value) {
		 Select sel=new Select(element);
		 sel.selectByValue(Value);
	}
	
	/**
	 * Handling dropdowns by visibletext
	 * @param element
	 * @param Index
	 */
	public void selectclassByvisibletext(WebElement element,String Visisbletext) {
		 Select sel=new Select(element);
		 sel.selectByVisibleText(Visisbletext);
	}
	/**
	 * this belongs to action class by click the reference element and perform
	 * @param driver
	 * @param element
	 */
	public void actionclasselementtobeclick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.click(element).perform();
	}
/**
 * This belongs to actions such as click and hold	
 * @param driver
 * @param element
 */
	
	public void actionclasselementtobeclickandhold(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This belongs to action class right click on the context click
	 * @param driver
	 * @param element
	 */
	public void actionclasselementtobecontextclick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This belongs to action class on double click
	 * @param driver
	 * @param element
	 */
	public void actionclasselementtobedoubleclick(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This belongs to action class on drag and drop
	 * @param driver
	 * @param drag
	 * @param drop
	 */
	
	public void actionclasselementtobedraganddrop(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions act= new Actions(driver);
		act.dragAndDrop(drag,drop).perform();
	}
	/**
	 * This belongs to action class on mousehover
	 * @param driver
	 * @param element
	 */
	
	public void actionclasselementtobemousehover(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This belongs to action class on scroll
	 * @param driver
	 * @param element
	 */
	 public void actionclassscroll(WebDriver driver,WebElement element) {
		 Actions act=new Actions(driver);
		 act.scrollToElement(element).perform();
	 }
	 /**
	  * This belongs to move to frames by index
	  * @param driver
	  * @param index
	  */
	 public void framesbyindex(WebDriver driver,int index)
	 {
		 driver.switchTo().frame(index);
	 }
	 /**
	  * This belongs to move to frames by string
	  * @param driver
	  * @param value
	  */
	 public void framesbystring(WebDriver driver,String value) {
		 driver.switchTo().frame(value);
	 }
	 /**
	  * This belongs to move to frames by element
	  * @param driver
	  * @param element
	  */
	 public void framesbyElement(WebDriver driver,WebElement element) {
		  driver.switchTo().frame(element);
	 }
	 /**
	  * This belongs to move to frames to parent frame
	  * @param driver
	  */
	 public void framesswitchtoparentframe(WebDriver driver) {
		 driver.switchTo().parentFrame();
	 }
	 /**
	  * This method will switch control to the main page by avoid all the parent frames
	  * @param driver
	  */
	 public void defaultcontext(WebDriver driver) {
		 driver.switchTo().defaultContent();
	 }
	 /**
	  * This method will switch to window
	  * @param driver
	  * @param WinIds
	  */
	 
	 public void window(WebDriver driver,String WinIds) {
		 driver.switchTo().window(WinIds);
	 }
	 /**
	  * This method with switch to alert to handle that by accept
	  * @param driver
	  */
	 public void switchtoalert(WebDriver driver) {
	driver.switchTo().alert().accept();
		
	 }
	 /**
	  * This method with switch to alert to handle by dismiss
	  * @param driver
	  */
	 public void switchtoconfirmation(WebDriver driver) {
		 driver.switchTo().alert().dismiss();
	
	 }
	 /**
	  * This method with switch to alert to handle by sendkeys
	  * @param driver
	  * @param keys
	  */
	 
	 public void switchtoprompt(WebDriver driver,String keys) {
		driver.switchTo().alert().sendKeys(keys);
		
	 }
	 /**
	  * This method will return the text of an alert function
	  * @param driver
	  * @return
	  */
	 public String switchtogetalerttext(WebDriver driver) {
			return driver.switchTo().alert().getText();
			
		 }
	 
	 /**
	  * this moves the element to the scroll down by 500
	  * @param driver
	  */
	 
	 public void scrolldown(WebDriver driver)
	 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,500)");
	 }
	 /**
	  * This method will scroll up by -500
	  * @param driver
	  */
public void scrollup(WebDriver driver)
	 
	 {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,-500)");
	 }
/**
 * This method will scroll right by 500
 * @param driver
 */
public void scrollright(WebDriver driver)

{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(500,0)");
}
/**
 * This method will scroll left by 500
 * @param driver
 */
public void scrollleft(WebDriver driver)

{
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(-500,0)");
}
 /**
  * This method will capture the screenshot and return the path to caller
  * @param driver
  * @return
  * @throws IOException
  */
	 
	
	public String takescreenshot(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts= (TakesScreenshot) driver;
	       File temp= ts.getScreenshotAs(OutputType.FILE);
	       File perm= new File("./errorscreenshot/"+screenshotname+".png");
	       FileHandler.copy(temp,perm);
	       return perm.getAbsolutePath();// for extend reports
	}
	 
	 
}





