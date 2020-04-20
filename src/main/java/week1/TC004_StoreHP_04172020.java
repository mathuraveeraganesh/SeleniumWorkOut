package week1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 17/04/2020
===============
1) Go to https://store.hp.com/in-en/
2) Mouse over on Laptops menu and click on Pavilion
3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
4) Hard Drive Capacity -->More than 1TB
5) Select Sort By: Price: Low to High
6) Print the First resulting Product Name and Price
7) Click on Add to Cart
8) Click on Shopping Cart icon --> Click on View and Edit Cart
9) Check the Shipping Option --> Check availability at Pincode
10) Verify the order Total against the product price
11) Proceed to Checkout if Order Total and Product Price matches
12) Click on Place Order
13) Capture the Error message and Print
14) Close Browser
 */
public class TC004_StoreHP_04172020 {

	public static void main(String[] args) throws InterruptedException {
				
		//1) Go to https://store.hp.com/in-en/
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Actions builder=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		driver.manage().window().maximize();
		driver.get("https://store.hp.com/in-en/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		EventFiringWebDriver event1= new EventFiringWebDriver(driver);
		WebListen listen = new WebListen(event1);
		event1.register(listen);
		
		
		//2) Mouse over on Laptops menu and click on Pavilion
		WebElement eleCloseCookies = driver.findElementByXPath("//button[@class='optanon-alert-box-close banner-close-button']");
		wait.until(ExpectedConditions.elementToBeClickable(eleCloseCookies));
		eleCloseCookies.click();
		WebElement eleLapTop = driver.findElementByXPath("//span[text()='Laptops']");
		builder.moveToElement(eleLapTop).perform();
		driver.findElementByXPath("//span[text()='Pavilion']").click();
		Thread.sleep(3000);
		
		//3) Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7
		//wait.until(ExpectedConditions.elementToBeClickable(eleCloseCookies));
		//eleCloseCookies.click();
		WebElement eleProcessor = driver.findElementByXPath("(//span[text()='Processor'])[2]");
		builder.moveToElement(eleProcessor).click().perform();
		driver.findElementByXPath("//span[text()='Intel Core i7']").click();
		WebElement eleLoading = driver.findElementByXPath("//img[@alt='Loading...']");
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		
		//4) Hard Drive Capacity -->More than 1TB
		WebElement eleHardDrive = driver.findElementByXPath("//span[text()='More than 1 TB']");
		wait.until(ExpectedConditions.elementToBeClickable(eleHardDrive));
		eleHardDrive.click();
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		Thread.sleep(3000);
		
		//5) Select Sort By: Price: Low to High
		WebElement eleSorter = driver.findElementById("sorter");
		//wait.until(ExpectedConditions.elementToBeSelected(eleSorter));
		eleSorter.click();
		Select sorter=new Select(eleSorter);
		sorter.selectByValue("price_asc");
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		Thread.sleep(3000);
		
		//6) Print the First resulting Product Name and Price
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product details product-item-details']")));
		List<WebElement> eleProducts = event1.findElements(By.xpath("//div[@class='product details product-item-details']"));
		String sFirstProductName = eleProducts.get(0).findElement(By.xpath("//a[@class='product-item-link']")).getText();
		String sFirstProductPrice = eleProducts.get(0).findElement(By.xpath("//span[@class='price-wrapper ']/span")).getText().replaceAll("[^0-9]+","");
		int iFirstProductPrice=Integer.parseInt(sFirstProductPrice);
		System.out.println("First Resulting Product Name-"+sFirstProductName);
		System.out.println("First Resulting Product Price-"+sFirstProductPrice);
		
		//7) Click on Add to Cart
		eleProducts.get(0).findElement(By.xpath("//button[@class='action tocart primary']")).click();
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		//Thread.sleep(3000);
		
		//8) Click on Shopping Cart icon --> Click on View and Edit Cart
		event1.findElement(By.xpath("//a[@class='action showcart']")).click();
		event1.findElement(By.xpath("//a[@class='action primary viewcart']")).click();
		
		//9) Check the Shipping Option --> Check availability at Pincode
		Thread.sleep(5000);
		event1.findElement(By.xpath("//input[@name='pincode']")).sendKeys("600119");
		event1.findElement(By.xpath("//button[@class='primary standard_delivery-button']")).click();
		//WebElement eleWaiting = driver.findElement(By.xpath("//button[text()='waiting...']"));
		//wait.until(ExpectedConditions.invisibilityOf(eleWaiting));
		Thread.sleep(3000);
		
		//10) Verify the order Total against the product price
		//11) Proceed to Checkout if Order Total and Product Price matches
		String sOrderTotal = event1.findElement(By.xpath("//tr[@class='grand totals']//span")).getText().replaceAll("[^0-9]+","");
		int iOrderTotal=Integer.parseInt(sOrderTotal);
		if(iOrderTotal==iFirstProductPrice) { 
			System.out.println("Verified the order Total-"+sOrderTotal+" against the product price-"+sFirstProductPrice);
			driver.findElementByXPath("//button[@class='action primary checkout']").click();
		}
		else
			System.err.println("Verification Failed the order Total-"+sOrderTotal+" against the product price-"+sFirstProductPrice);
		
		//12) Click on Place Order
		wait.until(ExpectedConditions.invisibilityOf(eleLoading));
		Thread.sleep(3000);
		event1.findElement(By.xpath("//div[@class='place-order-primary']/button")).click();
		
		//13) Capture the Error message and Print
		System.out.println("Capture the Error message");
		List<WebElement> eleErrorMessage = event1.findElements(By.xpath("//div[contains(@id,'error')]"));
		for (WebElement ListErrorMsg : eleErrorMessage) {
			System.out.println(ListErrorMsg.getText());
		}
		
		//14) Close Browser
		driver.close();
	}

}
