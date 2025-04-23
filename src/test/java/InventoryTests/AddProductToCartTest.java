package InventoryTests;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import GenericUtilities.ListnersImplementation;
import objectrepository.CartPage;
import objectrepository.InventoryItempage;
import objectrepository.InventoryPage;
@Listeners(GenericUtilities.ListnersImplementation.class)
public class AddProductToCartTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException {
		
	
	
	String PRODUCTNAME=fUtil.readDatafromExcel("Product", 1, 2);
	InventoryPage ip = new InventoryPage(driver);
	String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);



	// Step 5: Add the Product To Cart
		InventoryItempage iip = new InventoryItempage(driver);
		iip.clickOnAddToCartBtn();

		
		
		
	// Step 6: Navigate to Cart
		ip.clickOnCartContainer();
		  CartPage cp = new CartPage(driver);
		    String pInCart = cp.getProductName();
	if (pInCart.equals(pAddedToCart)) {
		System.out.println("PASS");
		System.out.println(pInCart);
	} else {
		System.out.println("FAIL");
	}

	
	}
}
