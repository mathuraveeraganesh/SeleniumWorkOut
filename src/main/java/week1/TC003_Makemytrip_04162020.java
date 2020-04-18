package week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 16/04/2020  
================  
1) Go to https://www.makemytrip.com/  
2) Click Hotels  
3) Enter city as Goa, and choose Goa, India  
4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5  
5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.  
6) Click Search button  
7) Select locality as Baga  
8) Select 5 start in Star Category under Select Filters  
9) Click on the first resulting hotel and go to the new window  
10) Print the Hotel Name  
11) Click MORE OPTIONS link and Select 3Months plan and close  
12) Click on BOOK THIS NOW  
13) Print the Total Payable amount  
14) Close the browser

Java to handle Date logic:
//         //get current date time with Date()
         Date date = new Date();
//         //Get only the date(and not month,year,time,etc)
        DateFormat dateFormat = new SimpleDateFormat("dd");          
//         // Now format the date
         String today= dateFormat.format(date);    
         int tommorow = Integer.parseInt(today)+1;
//          Print the tommorow's date
         System.out.println(tommorow);
 */
public class TC003_Makemytrip_04162020 {

	public static void main(String[] args) throws InterruptedException {
	
	
	//1) Go to https://www.makemytrip.com/
	System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	//2) Click Hotels
	driver.findElementByXPath("//li[@class='menu_Hotels']/a").click();
	Thread.sleep(3000);
	
	//3) Enter city as Goa, and choose Goa, India  
	driver.findElementByXPath("//div[@class='hsw_inputBox selectHtlCity  ']").click();
	driver.findElementByXPath("//input[contains(@class,'autosuggest__input')]").sendKeys("Goa");
	driver.findElementByXPath("//div[@class='flexOne']").click();
	
	//4) Enter Check in date as Next month 15th (May 15) and Check out as start date+5 
	WebElement eleStart = driver.findElementByXPath("//div[contains(@aria-label,'May 15')]");
	String sStartDate = eleStart.getText();
	int iStartDate = Integer.parseInt(sStartDate);
	eleStart.click();
	
	//Check out as start date+5
	int sCheckOutDate=iStartDate+5;
	driver.findElementByXPath("//div[contains(@aria-label,'May "+sCheckOutDate+"')]").click();
		
	//5) Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.
	driver.findElementByXPath("//div[@class='hsw_inputBox roomGuests  ']").click();
	driver.findElementByXPath("//ul[contains(@class,'guestCounter')]/li[2]").click();
	driver.findElementByXPath("(//ul[contains(@class,'guestCounter')])[2]/li[2]").click();
	driver.findElementByXPath("//button[text()='APPLY']").click();
	
	//6) Click Search button
	driver.findElementByXPath("//button[text()='Search']").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//div[@class='mmBackdrop wholeBlack']").click();
		
	//7) Select locality as Baga  
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='mmLocality_checkbox_35']")));
	driver.findElementByXPath("//label[@for='mmLocality_checkbox_35']").click();
	
	//8) Select 5 start in Star Category under Select Filters 
	WebElement eleStar = driver.findElementByXPath("//label[text()='5 Star']");
	Thread.sleep(500);
	wait.until(ExpectedConditions.elementToBeClickable(eleStar));
	eleStar.click();
	
	//9) Click on the first resulting hotel and go to the new window
	List<WebElement> eleHotelList = driver.findElementsByXPath("//p[@id='hlistpg_hotel_name']/span[1]");
	eleHotelList.get(0).click();
	Set<String> windowHandles = driver.getWindowHandles();
	List<String> allwindowHandles=new ArrayList<>();
	allwindowHandles.addAll(windowHandles);
	driver.switchTo().window(allwindowHandles.get(1));
	
	//10) Print the Hotel Name  
	String sHotelName = driver.findElementByXPath("//h1[@id='detpg_hotel_name']").getText();
	System.out.println("Hotel Name-"+sHotelName);
	
	//11) Click MORE OPTIONS link and Select 3Months plan and close  
	driver.findElementByXPath("//span[text()='MORE OPTIONS']").click();
	Thread.sleep(2000);
	driver.findElementByXPath("//span[text()='SELECT']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//span[@class='close']").click();
	
	//12) Click on BOOK THIS NOW
	driver.findElementByXPath("//a[text()='BOOK THIS NOW']").click();
	Thread.sleep(5000);
	
	//13) Print the Total Payable amount
	String sTotalPayableAmount = driver.findElementById("revpg_total_payable_amt").getText().replaceAll("[^0-9]+","");
	System.out.println("Total Payable amount-"+sTotalPayableAmount);
	
	//14) Close the browser
	driver.quit();
	
	}

}
