package week2_20_24Apr;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 23/04/2020
============
1) Go to https://www.pepperfry.com/
2) Mouseover on Furniture and click Office Chairs under Chairs
3) click Executive Chairs
4) Change the minimum Height as 50 in under Dimensions
5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
6) Mouseover on Homeware and Click Pressure Cookers under Cookware
7) Select Prestige as Brand
8) Select Capacity as 1-3 Ltr
9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
10) Verify the number of items in Wishlist
11) Navigate to Wishlist
12) Move Pressure Cooker only to Cart from Wishlist
13) Check for the availability for Pincode 600128
14) Click Proceed to Pay Securely
15 Click Proceed to Pay
16) Capture the screenshot of the item under Order Item
17) Close the browser
 */
public class TC008_PepperFry_04232020 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//1) Go to https://www.pepperfry.com/
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pepperfry.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Actions builder=new Actions(driver);
		
		//2) Mouseover on Furniture and click Office Chairs under Chairs
		WebElement eleFurniture = driver.findElementByXPath("//a[text()='Furniture']");
		WebElement eleOfcChair = driver.findElementByXPath("//a[text()='Office Chairs']");
		builder.moveToElement(eleFurniture).pause(500).click(eleOfcChair).pause(600).perform();
		
		//3) click Executive Chairs
		driver.findElementByXPath("//img[@alt='Executive Chairs']/parent::div").click();
		Thread.sleep(2000);
		
		//4) Change the minimum Height as 50 in under Dimensions
		WebElement eleMin = driver.findElementByXPath("(//div[@class='clip__filter-dimension-input-holder'])[2]/input");
		eleMin.clear();
		eleMin.sendKeys("50",Keys.TAB);
		Thread.sleep(8000);
		driver.findElementByXPath("//div[@id='regPopUp']/a").click();
		
		//5) Add "Poise Executive Chair in Black Colour" chair to Wishlist
		List<WebElement> eleChairList = driver.findElementsByXPath("//div[@unbxdattr='product']");
		for (int i = 0; i < eleChairList.size(); i++) {
			int increament=i+1;
			
			String sChairName = driver.findElement(By.xpath("(//a[@class='clip-prd-dtl'])["+increament+"]")).getText();
			//System.out.println(sChairName);
			if(sChairName.equals("Poise Executive Chair In Black Colour")) {
				builder.moveToElement(driver.findElement(By.xpath("(//a[@class='clip-prd-dtl'])["+increament+"]"))).pause(200).perform();
				driver.findElement(By.xpath("(//a[@class='clip-add-to-cart-btn'])["+increament+"]")).click();
				System.out.println("'Poise Executive Chair in Black Colour chair' Added to WishList Sucessfully");
				Thread.sleep(2000);
				driver.findElementByXPath("//a[@class='gb-close pf-icon pf-icon-close']").click();
			}
			
				
		}
		//6) Mouseover on Homeware and Click Pressure Cookers under Cookware
		
		builder.moveToElement(driver.findElementByXPath("//a[text()='Homeware']")).pause(200).perform();
		driver.findElementByXPath("//a[text()='Pressure Cookers']").click();
		Thread.sleep(2000);
		
		//7) Select Prestige as Brand
		driver.findElementByXPath("//label[text()='Prestige']").click();
		Thread.sleep(2000);
		
		//8) Select Capacity as 1-3 Ltr
		driver.findElementByXPath("//label[text()='1 Ltr - 3 Ltr']").click();
		Thread.sleep(2000);
		
		//9) Add "Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr" to Wishlist
		List<WebElement> eleCooker = driver.findElementsByXPath("//div[@unbxdattr='product']");
		for (int i = 0; i < eleCooker.size(); i++) {
			int increament=i+1;
			
			String sCookerName = driver.findElement(By.xpath("(//a[@class='clip-prd-dtl'])["+increament+"]")).getText();
			//System.out.println(sCookerName);
			if(sCookerName.equals("Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr")) {
				builder.moveToElement(driver.findElement(By.xpath("(//a[@class='clip-prd-dtl'])["+increament+"]"))).pause(200).perform();
				driver.findElement(By.xpath("(//a[@class='clip-add-to-cart-btn'])["+increament+"]")).click();
				System.out.println("'Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr' Added to WishList Sucessfully");
				Thread.sleep(2000);
				driver.findElementByXPath("//a[@class='gb-close pf-icon pf-icon-close']").click();
			}
			
				
		}
		//10) Verify the number of items in Wishlist
		String sNumber = driver.findElementByXPath("//a[@class='pf-icon pf-icon-cart2 header_tab cart']/following::span[1]").getText();
		if(sNumber.equals("2"))
			System.out.println("Verified the Number of items in Wishlist-2");
		
		//11) Navigate to Wishlist
		driver.findElementByXPath("//a[@class='pf-icon pf-icon-cart2 header_tab cart']").click();
		Thread.sleep(2000);
		
		//12) Move Pressure Cooker only to Cart from Wishlist
		driver.findElementByXPath("//a[text()='Nakshatra Cute Metallic Red Aluminium Cooker 2 Ltr']/following::div[@class='item_cta']/div/a[1]").click();
		Thread.sleep(2000);
		
		//13) Check for the availability for Pincode 600128
		driver.findElementByXPath("//input[@class='srvc_pin_text']").sendKeys("600128");
		driver.findElementByXPath("//a[text()='Check']").click();
		Thread.sleep(2000);
		
		//14) Click Proceed to Pay Securely
		driver.findElementByXPath("//a[text()='Proceed to pay securely ']").click();
		Thread.sleep(4000);
		
		//15 Click Proceed to Pay
		//16) Capture the screenshot of the item under Order Item
		File src = driver.findElementByXPath("//a[@class='ck-pro-img-link']/img").getScreenshotAs(OutputType.FILE);
		File dsc = new File("./OrderItem.png");
		FileUtils.copyFile(src, dsc);
		
		//17) Close the browser
		driver.close();
	}

}
