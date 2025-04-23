package InventoryTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import GenericUtilities.BaseClass;
import objectrepository.CartPage;
import objectrepository.InventoryItempage;
import objectrepository.InventoryPage;
@Listeners(GenericUtilities.ListnersImplementation.class)
public class AddLowestProductToCart extends BaseClass {
	
   @Test(groups = "RegressionSuite")
	public void AddProductToCartTest()  throws IOException {
		
		
		
	// Read Test Data From Excel File
			String SORTOPTION = fUtil.readDatafromExcel("Product", 4, 2);
			String PRODUCTNAME = fUtil.readDatafromExcel("Product", 4, 3);


		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnLowestPriceProduct(driver, PRODUCTNAME, SORTOPTION);
	;

		// Step 5: Add the Product To Cart
			InventoryItempage iip = new InventoryItempage(driver);
			iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
			ip.clickOnCartContainer();
			  CartPage cp = new CartPage(driver);
			    String pInCart = cp.getProductName();
			    Assert.assertEquals(pInCart, pAddedToCart);

				System.out.println(pInCart);
}
   @Test(retryAnalyzer = GenericUtilities.RetryAnalyzerImplementation.class)
   public void sample() {
	   //Assert.fail();
	   System.out.println("Hi");
   }
}