package week4_04_08May;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/* 06/05/2020
===========
1) Go to https://www.ajio.com/shop/sale
2) Enter Bags in the Search field and Select Bags in Women Handbags
3) Click on five grid and Select SORT BY as "What's New"
4) Enter Price Range Min as 2000 and Max as 5000
5) Click on the product "Puma Ferrari LS Shoulder Bag"
6) Verify the Coupon code for the price above 2690 is applicable for your product, if applicable the get the Coupon Code and Calculate the discount price for the coupon
7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email
9) Click on ADD TO BAG and then GO TO BAG
10) Check the Order Total before apply coupon
11) Enter Coupon Code and Click Apply
12) Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated in Product details
13) Click on Delete and Delete the item from Bag
14) Close all the browsers
 */
public class TC0016_Ajio_05062020 {

	public static void main(String[] args) throws InterruptedException {
		
		double iDiscountProductPrice=0.0;
		//1) Go to https://www.ajio.com/shop/sale
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com/shop/sale");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//2) Enter Bags in the Search field and Select Bags in Women Handbags
		//driver.findElementByXPath("//button[text()='Allow Location']").click();
		driver.findElementByXPath("//input[@class='react-autosuggest__input react-autosuggest__input--open']").sendKeys("Bags");
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='Women Handbags']/preceding::span[text()='Bags in ']/parent::a/parent::li").click();
		Thread.sleep(5000);
		
		//3) Click on five grid and Select SORT BY as "What's New"
		driver.findElementByXPath("//div[@class='five-grid']/parent::div").click();
		Thread.sleep(2000);
		Select Sort=new Select(driver.findElementByXPath("//label[text()='Sort By']/following::select[1]"));
		Sort.selectByVisibleText("What's New");
		Thread.sleep(6000);
		
		//4) Enter Price Range Min as 2000 and Max as 5000
		driver.findElementByXPath("//span[text()='price']").click();
		driver.findElementById("minPrice").sendKeys("2000");
		driver.findElementById("maxPrice").sendKeys("5000");
		driver.findElementByXPath("//button[@class='rilrtl-button ic-toparw']").click();
		Thread.sleep(6000);
		
		//5) Click on the product "Puma Ferrari LS Shoulder Bag"
		WebElement eleProduct = driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']/preceding::div[text()='Puma']/parent::div");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", eleProduct);
		
		//driver.findElementByXPath("//div[text()='Ferrari LS Shoulder Bag']/preceding::div[text()='Puma']/preceding::div[1]").click();
		Thread.sleep(6000);
		
		//6) Verify the Coupon code for the price above 2690 is applicable for your product, if applicable the get the Coupon Code and Calculate the discount price for the coupon
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowlist=new ArrayList<>();
		allwindowlist.addAll(windowHandles);
		driver.switchTo().window(allwindowlist.get(1));
		String sProductPrice = driver.findElementByXPath("//div[@class='prod-sp']").getText().replaceAll("[^0-9]+","");
		double iProductPrice = Double.parseDouble(sProductPrice);
		String sCoupon = driver.findElementByXPath("//div[@class='promo-desc']").getText();
		if(sCoupon.contains("2690 and Above")) {
			String sDiscountPrice = driver.findElementByXPath("//div[@class='promo-desc']/preceding::span[1]").getText().replaceAll("[^0-9]+","");
			double iDiscountPrice = Double.parseDouble(sDiscountPrice);
			String sCouponCode = driver.findElementByXPath("//div[@class='promo-desc']/preceding::div[@class='promo-title']").getText();
			System.out.println("Coupon Code-"+sCouponCode);
			iDiscountProductPrice=iProductPrice-iDiscountPrice;
			System.out.println(iDiscountProductPrice);
		}
		else
			System.out.println("Coupon code for the price Below 2690");
		
			
			
		//7) Check the availability of the product for pincode 560043, print the expected delivery date if it is available
		driver.findElementByXPath("//span[text()='Enter pin-code to know estimated delivery date.']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@class='edd-pincode-modal-text']").sendKeys("600119");
		Thread.sleep(2000);
		driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
		Thread.sleep(2000);
		/*String sExpectedDelivery = driver.findElementByXPath("//li[text()='Expected Delivery: ']/span").getText();
		System.out.println("Expected Delivery Date-"+sExpectedDelivery);*/
		
		//8) Click on Other Informations under Product Details and Print the Customer Care address, phone and email
		driver.findElementByXPath("//div[text()='Other information']").click();
		String sCustomerCare = driver.findElementByXPath("//span[text()='Customer Care Address']/following::span[2]").getText();
		System.out.println("Customer Care Address-"+sCustomerCare);
		
		//9) Click on ADD TO BAG and then GO TO BAG
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(6000);
		WebElement eleBag = driver.findElementByXPath("//span[text()='GO TO BAG']");
		js.executeScript("arguments[0].click()", eleBag);
		Thread.sleep(6000);
		
		//10) Check the Order Total before apply coupon
		String[] sSplitOrderTotal = driver.findElementByXPath("//span[text()='Order Total']/following::span[1]").getText().split("Rs.");
		String sOrderTotal = sSplitOrderTotal[1].replaceAll("[^0-9. ]+","");
		double iOrderTotal = Math.round(Double.parseDouble(sOrderTotal));
		//System.out.println(iOrderTotal);
		System.out.println("Order Total-"+iOrderTotal);
		
		//11) Enter Coupon Code and Click Apply
		driver.findElementById("couponCodeInput").sendKeys("EPIC");
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='Apply']").click();
		
		//12) Verify the Coupon Savings amount(round off if it in decimal) under Order Summary and the matches the amount calculated in Product details
		String[] splitCoupon = driver.findElementByXPath("//p[@class='you-save-text']").getText().split("Rs.");
		String sCouponSaving = splitCoupon[1].replaceAll("[^0-9. ]+","");
		double iCouponSaving = Math.round(Double.parseDouble(sCouponSaving));
		
		String[] sSplitDiscountOrderTotal = driver.findElementByXPath("//span[text()='Order Total']/following::span[1]").getText().split("Rs.");
		String sDiscountOrderTotal = sSplitDiscountOrderTotal[1].replaceAll("[^0-9. ]+","");
		double iDiscountOrderTotal = Math.round(Double.parseDouble(sDiscountOrderTotal));
		System.out.println("Discount Order Total-"+iDiscountOrderTotal);
		double TotalOrderCouponSaving=iOrderTotal+iCouponSaving;
		if(iCouponSaving==iDiscountProductPrice)
			System.out.println("Verify the Coupon Savings amount(round off if it in decimal)-"+iCouponSaving+" under Order Summary and the matches-"+TotalOrderCouponSaving+" the amount calculated in Product details"+iDiscountProductPrice);
		else
			System.out.println("Verification Failed the Coupon Savings amount(round off if it in decimal)-"+iCouponSaving+" under Order Summary and the matches-"+TotalOrderCouponSaving+" the amount calculated in Product details"+iDiscountProductPrice);
		
		//13) Click on Delete and Delete the item from Bag
		driver.findElementByXPath("//div[text()='Delete']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='DELETE']").click();
		Thread.sleep(5000);
		
		//14) Close all the browsers
		driver.quit();
	}

}
