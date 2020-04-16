package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*1) Go to https://www.nykaa.com/
2) Mouseover on Brands and Mouseover on Popular
3) Click L'Oreal Paris
4) Go to the newly opened window and check the title contains L'Oreal Paris
5) Click sort By and select customer top rated
6) Click Category and click Shampoo
7) check whether the Filter is applied with Shampoo
8) Click on L'Oreal Paris Colour Protect Shampoo
9) GO to the new window and select size as 175ml
10) Print the MRP of the product
11) Click on ADD to BAG
12) Go to Shopping Bag 
13) Print the Grand Total amount
14) Click Proceed
15) Click on Continue as Guest
16) Print the warning message (delay in shipment)
17) Close all windows
*/

public class TC002_Nykaa_04152020 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://www.nykaa.com/
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//2) Mouseover on Brands and Mouseover on Popular
		Actions builder=new Actions(driver);
		WebElement eleBrands = driver.findElementByXPath("//a[text()='brands']");
		WebElement elePopular = driver.findElementByXPath("//a[text()='Popular']");
		
		
		builder.moveToElement(eleBrands).pause(200).moveToElement(elePopular).pause(200).perform();
		
		//3) Click L'Oreal Paris
		driver.findElementByXPath("//a[@href='/brands/loreal-paris/c/595?eq=desktop']").click();
		Thread.sleep(6000);
		
		//4) Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowList=new ArrayList<>();
		allwindowList.addAll(windowHandles);
		driver.switchTo().window(allwindowList.get(1));
		if(driver.getTitle().contains("L'Oreal Paris"))
			System.out.println("The Title Contains L'Oreal Paris");
		else
			System.err.println("The Title Doesn't Contains L'Oreal Paris");
		
		//5) Click sort By and select customer top rated
		driver.findElementByXPath("//span[text()='popularity']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(3000);
		
		//6) Click Category and click Shampoo
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("//span[starts-with(text(),'Shampoo')]").click();
		Thread.sleep(3000);
		
		//7) check whether the Filter is applied with Shampoo
		String sFilter = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']").getText();
		if(sFilter.contains("Shampoo"))
			System.out.println("The Filter is applied with "+sFilter);
		else
			System.err.println("The Filter is not applied with Shampoo and filter contains "+sFilter);
		
		//8) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("//img[contains(@src,'color_protect_shampoo')]").click();
		Thread.sleep(3000);
		
		//9) GO to the new window and select size as 175ml
		Set<String> ShampoowindowHandles = driver.getWindowHandles();
		List<String> allShampooWindowHandles=new ArrayList<>();
		allShampooWindowHandles.addAll(ShampoowindowHandles);
		driver.switchTo().window(allShampooWindowHandles.get(2));
		driver.findElementByXPath("(//span[@class='size-pallets'])[2]").click();
		Thread.sleep(2000);
		
		//10) Print the MRP of the product
		String sMRP = driver.findElementByXPath("//span[@class='post-card__content-price-offer']").getText();
		String sMRPProduct = sMRP.replaceAll("[^0-9]+","");
		System.out.println("MRP of the Product-"+sMRPProduct);
		
		//11) Click on ADD to BAG
		driver.findElementByXPath("//button[contains(@class,'toggle-sbag')]").click();
		Thread.sleep(2000);
		
		//12) Go to Shopping Bag 
		driver.findElementByClassName("AddBagIcon").click();
		Thread.sleep(5000);
		
		//13) Print the Grand Total amount
		String sGrand = driver.findElementByXPath("//div[text()='Grand Total:']/div").getText();
		String sGrandTotal = sGrand.replaceAll("[^0-9]+","");
		System.out.println("Grand Total Amount-"+sGrandTotal);
		
		//14) Click Proceed
		driver.findElementByXPath("//span[text()='Proceed']").click();
		Thread.sleep(5000);
		
		//15) Click on Continue as Guest
		driver.findElementByXPath("//button[text()='CONTINUE AS GUEST']").click();
		Thread.sleep(3000);
		
		//16) Print the warning message (delay in shipment)
		String sWarningMsg = driver.findElementByXPath("//div[@class='layout horizontal p10 communication-msg mtb10']//div").getText();
		System.out.println("Warning Message-"+sWarningMsg);
		
		//17) Close all windows
		driver.quit();
	}

}
