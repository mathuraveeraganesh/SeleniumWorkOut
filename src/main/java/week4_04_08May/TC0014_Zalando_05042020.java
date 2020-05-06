package week4_04_08May;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 04/05/2020
===========
1) Go to https://www.zalando.com/
2) Get the Alert text and print it
3) Close the Alert box and click on Zalando.uk
4) Click Women--> Clothing and click Coat 
5) Choose Material as cotton (100%) and Length as thigh-length
6) Click on Q/S designed by MANTEL - Parka coat
7) Check the availability for Color as Olive and Size as 'M'
8) If the previous preference is not available, check  availability for Color Navy and Size 'M'
9) Add to bag only if Standard Delivery is free
10) Mouse over on Your Bag and Click on "Go to Bag"
11) Capture the Estimated Deliver Date and print
12) Mouse over on FREE DELIVERY & RETURNS*, get the tool tip text and print
13) Click on Start chat in the Start chat and go to the new window
14) Enter you first name and a dummy email and click Start Chat
15) Type Hi, click Send and print thr reply message and close the chat window.
 */
public class TC0014_Zalando_05042020 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://www.zalando.com/
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://www.zalando.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Alert sAlert=driver.switchTo().alert();
		Actions builder=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//2) Get the Alert text and print it
		String sAlertText = sAlert.getText();
		System.out.println("Get the Alert text-"+sAlertText);
		
		//3) Close the Alert box and click on Zalando.uk
		sAlert.accept();
		driver.findElementByXPath("//a[text()='Zalando.uk']").click();
		Thread.sleep(4000);
		driver.findElementById("uc-btn-accept-banner").click();
		
		//4) Click Women--> Clothing and click Coat
		WebElement eleWomen = driver.findElementByXPath("(//span[text()='Women'])[2]/parent::a");
		js.executeScript("arguments[0].click()",eleWomen);
		Thread.sleep(4000);
		driver.findElementByXPath("//span[text()='Clothing']/parent::a").click();
		Thread.sleep(4000);
		driver.findElementByXPath("(//a[text()='Coats'])[3]").click();;
		
		Thread.sleep(2000);
		
		
		//5) Choose Material as cotton (100%) and Length as thigh-length
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[text()='Material']/parent::span/parent::button"));
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[text()='cotton (100%)']/parent::li"));
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//button[text()='Save']"));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[contains(@class,'cat_loader')]")));
		Thread.sleep(3000);
		
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[text()='Length']/parent::span/parent::button"));
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[text()='thigh-length']/parent::li"));
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//button[text()='Save']"));
		//wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[contains(@class,'cat_loader')]")));
		Thread.sleep(3000);
		
		//6) Click on Q/S designed by MANTEL - Parka coat
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//div[text()='Q/S designed by']/preceding::a[1]"));
		Thread.sleep(3000);
		
		//7) Check the availability for Color as Olive and Size as 'M'
		driver.findElementByXPath("(//img[@alt='olive'])[2]").click();
		Thread.sleep(5000);
		driver.findElementById("picker-trigger").click();
		driver.findElementByXPath("//span[text()='M']/parent::div/parent::li").click();
		
		//8) If the previous preference is not available, check  availability for Color Navy and Size 'M'
		String sStock = driver.findElementByXPath("//div[@id='z-pdp-topSection']//h2").getText();
		System.out.println(sStock);
		if(sStock.equals("Out of stock")) {
			driver.findElementByXPath("(//img[@alt='navy'])[2]").click();
			Thread.sleep(5000);
			driver.findElementById("picker-trigger").click();
			driver.findElementByXPath("//span[text()='M']/parent::div/parent::li").click();
			Thread.sleep(5000);
		}
		else
			System.out.println("Previous preference is Available");
		
			
		//9) Add to bag only if Standard Delivery is freesStock
		String sFree = driver.findElementByXPath("//span[text()='Standard delivery']/following::span[1]").getText();
		if(sFree.equals("Free")) {
				driver.findElementByXPath("//span[text()='Add to bag']/parent::button").click();
				Thread.sleep(2000);
		}
		else
			System.out.println("Standard Delivery is Not freesStock");
		
		//10) Mouse over on Your Bag and Click on "Go to Bag"
		builder.moveToElement(driver.findElementByXPath("//span[text()='Your bag']")).pause(200).perform();
		driver.findElementByXPath("//div[text()='Go to bag']/parent::a").click();
		Thread.sleep(5000);
		
		//11) Capture the Estimated Deliver Date and print
		String sEstimateDate = driver.findElementByXPath("//div[@data-id='delivery-estimation']/span").getText();
		System.out.println("Estimated Deliver Date-"+sEstimateDate);
		
		//12) Mouse over on FREE DELIVERY & RETURNS*, get the tool tip text and print
		builder.moveToElement(driver.findElementByXPath("//a[text()='Free delivery & returns*']")).perform();
		
		String sToolTip = driver.findElementByXPath("//a[text()='Free delivery & returns*']/parent::span").getAttribute("title");
		System.out.println("Tool Tip Text-"+sToolTip);
		//13) Click on Start chat in the Start chat and go to the new window
		//14) Enter you first name and a dummy email and click Start Chat
		//15) Type Hi, click Send and print thr reply message and close the chat window.
	}

}
