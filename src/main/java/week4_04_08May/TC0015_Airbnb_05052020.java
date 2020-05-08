package week4_04_08May;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 05/05/2020
===========
1) Go to https://www.airbnb.co.in/
2) Type Coorg in location and Select Coorg, Karnataka
3) Select the Start Date as June 1st and End Date as June 5th
4) Select guests as 6 adults, 3 child and Click Search
5) Click Cancellation flexibility and enable the filter and Save
6) Select Type of Place as Entire Place and Save
7) Set Min price as 3000 and  max price as 5000
8) Click More Filters and set 3 Bedrooms and 3 Bathrooms
9) Check the Amenities with Kitchen, Facilities with Free parking on premisses, Property as House and Host Language as English
    and click on Stays only when stays available
10) Click Prahari Nivas, the complete house
11) Click on "Show all * amenities"
12) Print all the Not included amenities
13) Verify the Check-in date, Check-out date and Guests
14) Read all the Sleeping arrangements and Print
15) Close all the browsers
 */
public class TC0015_Airbnb_05052020 {

	public static void main(String[] args) throws InterruptedException {
		//1) Go to https://www.airbnb.co.in/
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.airbnb.co.in/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//2) Type Coorg in location and Select Coorg, Karnataka
		Thread.sleep(4000);
		driver.findElementByXPath("//button[@class='optanon-allow-all accept-cookies-button']").click();
		driver.findElementByXPath("//input[@id='bigsearch-query-attached-query']").click();
		driver.findElementByXPath("//input[@id='bigsearch-query-attached-query']").sendKeys("Coorg");
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Coorg, Karnataka']/parent::div/preceding::div[1]/parent::li[1]").click();
		Thread.sleep(2000);
		
		//3) Select the Start Date as June 1st and End Date as June 5th
		driver.findElementByXPath("//td[contains(@aria-label,'June 1, 2020')]").click();
		driver.findElementByXPath("//td[contains(@aria-label,'June 5, 2020')]").click();
		Thread.sleep(2000);
		
		//4) Select guests as 6 adults, 3 child and Click Search
		driver.findElementByXPath("//div[text()='Guests']/parent::button").click();
		driver.findElementByXPath("//button[@aria-label='increase value']").click();
		driver.findElementByXPath("//button[@aria-label='increase value']").click();
		driver.findElementByXPath("//button[@aria-label='increase value']").click();
		driver.findElementByXPath("//button[@aria-label='increase value']").click();
		driver.findElementByXPath("//button[@aria-label='increase value']").click();
		driver.findElementByXPath("//button[@aria-label='increase value']").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//button[@aria-label='increase value'])[2]").click();
		driver.findElementByXPath("(//button[@aria-label='increase value'])[2]").click();
		driver.findElementByXPath("(//button[@aria-label='increase value'])[2]").click();
		Thread.sleep(2000);
		
		
		driver.findElementByXPath("//button[@type='submit']").click();
		Thread.sleep(5000);
		
		//5) Click Cancellation flexibility and enable the filter and Save
		driver.findElementByXPath("//span[text()='Cancellation flexibility']/parent::div/parent::span/parent::button").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[@id='filterItem-switch-flexible_cancellation-true']").click();
		driver.findElementById("filter-panel-save-button").click();
		Thread.sleep(5000);
		
		//6) Select Type of Place as Entire Place and Save
		driver.findElementByXPath("//span[text()='Type of place']/parent::div/parent::span/parent::button").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@name='Entire place']/following::span[1]").click();
		driver.findElementById("filter-panel-save-button").click();
		Thread.sleep(5000);
		
		//7) Set Min price as 3000 and  max price as 5000
		driver.findElementByXPath("//span[text()='Price']/parent::div/parent::span/parent::button").click();
		driver.findElementByXPath("//input[@id='price_filter_min']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='price_filter_min']").sendKeys("3000");
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='price_filter_max']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='price_filter_max']").sendKeys("5000");
		Thread.sleep(2000);
		driver.findElementById("filter-panel-save-button").click();
		Thread.sleep(5000);
		
		//8) Click More Filters and set 3 Bedrooms and 3 Bathrooms
		driver.findElementByXPath("//span[text()='More filters']/parent::button").click();
		Thread.sleep(2000);
		driver.findElementByXPath("(//button[@aria-label='increase value'])[2]").click();
		driver.findElementByXPath("(//button[@aria-label='increase value'])[2]").click();
		driver.findElementByXPath("(//button[@aria-label='increase value'])[2]").click();
		Thread.sleep(2000);
		
		driver.findElementByXPath("(//button[@aria-label='increase value'])[3]").click();
		driver.findElementByXPath("(//button[@aria-label='increase value'])[3]").click();
		driver.findElementByXPath("(//button[@aria-label='increase value'])[3]").click();
		Thread.sleep(2000);
		
		//9) Check the Amenities with Kitchen, Facilities with Free parking on premisses, Property as House and Host Language as English
		//    and click on Stays only when stays available
		driver.findElementByXPath("//input[@name='Kitchen']/following::span[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@name='Free parking on premises']/following::span[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@name='House']/following::span[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@name='English']/following::span[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//button[contains(text(),'Show')]").click();
		Thread.sleep(6000);
		
		//10) Click Prahari Nivas, the complete house
		driver.findElementByXPath("//a[@aria-label='Prahari Nivas, the complete house']").click();
		Thread.sleep(10000);
		
		//11) Click on "Show all * amenities"
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowlist=new ArrayList<>();
		allwindowlist.addAll(windowHandles);
		driver.switchTo().window(allwindowlist.get(1));
		driver.findElementByXPath("//a[contains(text(),'amenities')]").click();
		Thread.sleep(6000);
		
		//12) Print all the Not included amenities
		List<WebElement> eleAmities = driver.findElementsByXPath("//h3[text()='Not included']//parent::div//parent::div//del[@aria-hidden='true']");
		System.out.println("Print all the Not included amenities");
		for (WebElement eachAmities : eleAmities) {
			System.out.println(eachAmities.getText());
		}
		driver.findElementByXPath("//button[@aria-label='Close']").click();
		Thread.sleep(2000);
		
		//13) Verify the Check-in date, Check-out date and Guests
		String sCheckIn = driver.findElementByXPath("//div[text()='Check-in']/following::div[1]").getText();
		String sCheckOut = driver.findElementByXPath("//div[text()='Checkout']/following::div[1]").getText();
		String sGuest = driver.findElementByXPath("//div[@id='GuestPicker-book_it-trigger']//span").getText();
		if(sCheckIn.equals("06/01/2020") && sCheckOut.equals("06/05/2020") && sGuest.equals("9 guests")  )
			System.out.println("Verify the Check-in date-"+sCheckIn+" Check-out date-"+sCheckOut+" and Guests-"+sGuest);
		else
			System.out.println("Verification Failed the Check-in date-"+sCheckIn+" Check-out date-"+sCheckOut+" and Guests-"+sGuest);
		
		//14) Read all the Sleeping arrangements and Print
		List<WebElement> eleArrangement = driver.findElementsByXPath("//div[@style='transform: translateX(0%);']//span/following::div[2]");
		System.out.println("Read all the Sleeping arrangements and Print");
		for (WebElement eachArrangement : eleArrangement) {
			System.out.println(eachArrangement.getText());
		}
		
		//15) Close all the browsers
		driver.quit();

	}

}
