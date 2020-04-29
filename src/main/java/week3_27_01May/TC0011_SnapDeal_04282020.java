package week3_27_01May;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 28/04/2020
============
1) Go to https://www.snapdeal.com/
‎2) Mouse over on Toys, Kids' Fashion & more and click on Toys
3) Click Educational Toys in Toys & Games
‎4) Click the Customer Rating 4 star and Up 
5) Click the offer as 40-50
6) Check the availability for the pincode
7) Click the Quick View of the first product 
8) Click on View Details
9) Capture the Price of the Product and Delivery Charge
10) Validate the You Pay amount matches the sum of (price+deliver charge)
11) Search for Sanitizer
12) Click on Product "BioAyurveda Neem Power Hand Sanitizer"
13) Capture the Price and Delivery Charge
14) Click on Add to Cart
15) Click on Cart 
16) Validate the Proceed to Pay matches the total amount of both the products
17) Close all the windows
 */
public class TC0011_SnapDeal_04282020 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://www.snapdeal.com/
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Actions builder=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//‎2) Mouse over on Toys, Kids' Fashion & more and click on Toys
		builder.moveToElement(driver.findElementByXPath("//span[contains(text(),'Fashion & more')]")).pause(200).perform();
		
		//3) Click Educational Toys in Toys & Games
		driver.findElementByXPath("//span[text()='Educational Toys']").click();
		Thread.sleep(3000);
		
		//‎4) Click the Customer Rating 4 star and Up 
		driver.findElementByXPath("//label[@for='avgRating-4.0']").click();
		Thread.sleep(3000);
		
		//5) Click the offer as 40-50
		driver.findElementByXPath("//label[@for='discount-40%20-%2050']").click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='searcharea-overlay']")));
		Thread.sleep(1000);
		
		//6) Check the availability for the pincode
		driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/input").sendKeys("600119");
		driver.findElementByXPath("//div[@class='pincode-enter js-pincode-enter']/button").click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='searcharea-overlay']")));
		Thread.sleep(1000);
		
		//7) Click the Quick View of the first product 
		builder.moveToElement(driver.findElementByXPath("(//div[@class='product-tuple-image '])[1]")).pause(200).perform();
		driver.findElementByXPath("(//div[contains(text(),'Quick View')])[1]").click();
		
		
		//8) Click on View Details
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'view details')]")));
		
		driver.findElementByXPath("//a[contains(text(),'view details')]").click();
		Thread.sleep(5000);
		
		//9) Capture the Price of the Product and Delivery Charge
		String sPrice = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
		int iPrice = Integer.parseInt(sPrice);
		//System.out.println(iPrice);
		String sDeliveryCharge = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText().replaceAll("[^0-9]+","");
		int iDeliveryCharge = Integer.parseInt(sDeliveryCharge);
		//System.out.println(iDeliveryCharge);
		
		//10) Validate the You Pay amount matches the sum of (price+deliver charge)
		driver.findElementByXPath("//span[text()='add to cart']").click();
		Thread.sleep(5000);
		String sProduct1 = driver.findElementByXPath("//div[@class='you-pay']/span").getText().replaceAll("[^0-9]+","");
		int iProduct1 = Integer.parseInt(sProduct1);
		//System.out.println(iProduct1);
		int iTotalProduct1=iPrice+iDeliveryCharge;
		if(iProduct1==iTotalProduct1)
			System.out.println("Validate the You Pay amount-"+iProduct1+" matches the sum of (price+deliver charge)-"+iTotalProduct1);
		else
			System.out.println("Validation Failed the You Pay amount-"+iProduct1+" matches the sum of (price+deliver charge)-"+iTotalProduct1);
		
		//11) Search for Sanitizer
		driver.findElementById("inputValEnter").sendKeys("Sanitizer");
		driver.findElementByXPath("//span[text()='Search']").click();
		Thread.sleep(5000);
		
		//12) Click on Product "BioAyurveda Neem Power Hand Sanitizer"
		builder.moveToElement(driver.findElementByXPath("//img[@title='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']")).perform();
		driver.findElementByXPath("//img[@title='BioAyurveda Neem Power  Hand Sanitizer 500 mL Pack of 1']/following::div[2]").click();
		Thread.sleep(300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'view details')]")));
		
		driver.findElementByXPath("//a[contains(text(),'view details')]").click();
		Thread.sleep(5000);
		
		//13) Capture the Price and Delivery Charge
		String sPrice2 = driver.findElementByXPath("//span[@class='payBlkBig']").getText();
		int iPrice2 = Integer.parseInt(sPrice2);
		//System.out.println(iPrice2);
		String sDeliveryCharge2 = driver.findElementByXPath("(//span[@class='availCharges'])[2]").getText().replaceAll("[^0-9]+","");
		int iDeliveryCharge2 = Integer.parseInt(sDeliveryCharge2);
		//System.out.println(iDeliveryCharge2);
		int iTotalProduct2=iPrice2+iDeliveryCharge2;
		
		//14) Click on Add to Cart
		driver.findElementByXPath("//span[text()='ADD TO CART']").click();
		Thread.sleep(5000);
		
		//15) Click on Cart
		driver.findElementByXPath("//i[@class='sd-icon sd-icon-cart-icon-white-2']").click();
		Thread.sleep(3000);
		
		//16) Validate the Proceed to Pay matches the total amount of both the products
		String sProceedToPay = driver.findElementByXPath("//input[@class='btn btn-xl rippleWhite cart-button']").getAttribute("value").replaceAll("[^0-9]+","");
		int iProceedToPay = Integer.parseInt(sProceedToPay);
		int iTotalBothProduct=iTotalProduct1+iTotalProduct2;
		
		if(iProceedToPay==iTotalBothProduct)
			System.out.println("Validate the Proceed to Pay-"+iProceedToPay+" matches the total amount of both the products-"+iTotalBothProduct);
		else
			System.out.println("Validation Failed the Proceed to Pay-"+iProceedToPay+" matches the total amount of both the products-"+iTotalBothProduct);
		
		//17) Close all the windows
		driver.close();
	}

}
