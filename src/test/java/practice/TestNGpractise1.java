package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNGpractise1 {

	@Test
	public void statement()
	{
		System.out.println("hi");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	
	
	
}
