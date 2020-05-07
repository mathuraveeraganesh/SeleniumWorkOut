package week4_04_08May;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 07/05/2020
==========
1) Go to https://azure.microsoft.com/en-in/
2) Click on Pricing
3) Click on Pricing Calculator
4) Click on Containers
5) Select Container Instances
6) Click on Container Instance Added View
7) Select Region as "South India"
8) Set the Duration as 180000 seconds
9) Select the Memory as 4GB
10) Enable SHOW DEV/TEST PRICING
11) Select Indian Rupee  as currency
12) Print the Estimated monthly price
13) Click on Export to download the estimate as excel
14) Verify the downloded file in the local folder
15) Navigate to Example Scenarios and Select CI/CD for Containers
16) Click Add to Estimate
17) Change the Currency as Indian Rupee
18) Enable SHOW DEV/TEST PRICING
19) Export the Estimate
20) Verify the downloded file in the local folder
https://github.com/TestLeafPages/Research/blob/master/PdfFileDownload.java
 */
public class TC0017_Azure_05072020 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://azure.microsoft.com/en-in/
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-infobars");
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://azure.microsoft.com/en-in/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Actions builder=new Actions(driver);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//2) Click on Pricing
		driver.findElementByXPath("//a[text()='Pricing']").click();
		Thread.sleep(3000);
		
		//3) Click on Pricing Calculator
		driver.findElementByXPath("//a[contains(text(),'Pricing calculator')]").click();
		Thread.sleep(5000);
		
		//4) Click on Containers
		driver.findElementByXPath("//button[text()='Containers']").click();
		Thread.sleep(2000);
		
		//5) Select Container Instances
		driver.findElementByXPath("(//span[text()='Container Instances'])[3]").click();
		Thread.sleep(2000);
		
		//6) Click on Container Instance Added View
		//7) Select Region as "South India"
		Select region=new Select(driver.findElementByXPath("//select[@name='region']"));
		region.selectByVisibleText("South India");
		Thread.sleep(2000);
		
		//8) Set the Duration as 180000 seconds
		driver.findElementByXPath("//label[text()='Seconds']/preceding::input[1]").clear();
		driver.findElementByXPath("//label[text()='Seconds']/preceding::input[1]").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//label[text()='Seconds']/preceding::input[1]").sendKeys("180000");
		
		//9) Select the Memory as 4GB
		Select Memory=new Select(driver.findElementByXPath("//select[@name='memory']"));
		Memory.selectByVisibleText("4 GB");
		Thread.sleep(2000);
		
		//10) Enable SHOW DEV/TEST PRICING
		driver.findElementByXPath("//button[@id='devtest-toggler']").click();
		Thread.sleep(2000);
		
		//11) Select Indian Rupee  as currency
		Select Currency=new Select(driver.findElementByXPath("//select[@class='select currency-dropdown']"));
		Currency.selectByVisibleText("Indian Rupee (₹)");
		Thread.sleep(2000);
		
		//12) Print the Estimated monthly price
		String sEstimatedPrice = driver.findElementByXPath("//select[@class='select currency-dropdown']/preceding::span[1]").getText();
		System.out.println("Print the Estimated monthly price-"+sEstimatedPrice);
		
		//13) Click on Export to download the estimate as excel
		driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']").click();
		Thread.sleep(5000);
		
		//14) Verify the downloded file in the local folder
		File dir = new File("C:\\Users\\MathuraveeraganeshMe\\Downloads");
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals("ExportedEstimate.xlsx")) {
		          System.out.println("File has been found");
		          dirContents[i].delete();
		       }
		        
		  	 }
		//15) Navigate to Example Scenarios and Select CI/CD for Containers
		WebElement eleExample = driver.findElementByXPath("//a[text()='Example Scenarios']");
		js.executeScript("arguments[0].click()", eleExample);
		Thread.sleep(2000);
		WebElement eleContainer = driver.findElementByXPath("//span[text()='CI/CD for Containers']/parent::span/parent::button");
		js.executeScript("arguments[0].click()", eleContainer);
		Thread.sleep(2000);
		
		//16) Click Add to Estimate
		WebElement eleEstimate = driver.findElementByXPath("//button[text()='Add to estimate']");
		js.executeScript("arguments[0].click()", eleEstimate);
		
		Thread.sleep(6000);
		
		//17) Change the Currency as Indian Rupee
		Select Currency2=new Select(driver.findElementByXPath("//select[@class='select currency-dropdown']"));
		Currency2.selectByVisibleText("Indian Rupee (₹)");
		Thread.sleep(2000);
		
		//18) Enable SHOW DEV/TEST PRICING
		WebElement eleEnable = driver.findElementByXPath("//button[@id='devtest-toggler']");
		js.executeScript("arguments[0].click()", eleEnable);
		Thread.sleep(5000);
		
		//19) Export the Estimate
		js.executeScript("arguments[0].click()", driver.findElementByXPath("//button[@class='calculator-button button-transparent export-button']"));
		Thread.sleep(5000);
		
		//20) Verify the downloded file in the local folder
		File dir1 = new File("C:\\Users\\MathuraveeraganeshMe\\Downloads");
		  File[] dirContents1 = dir1.listFiles();

		  for (int i = 0; i < dirContents1.length; i++) {
		      if (dirContents1[i].getName().equals("ExportedEstimate.xlsx")) {
		          System.out.println("File has been found");
		          dirContents1[i].delete();
		       }
		        
		  	 }
		  
	}

}
