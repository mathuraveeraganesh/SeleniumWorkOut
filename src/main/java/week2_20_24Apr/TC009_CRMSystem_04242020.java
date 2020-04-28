package week2_20_24Apr;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
 * 24/04/2020
============
1) Go to https://demo.1crmcloud.com/
2) Give username as admin and password as admin
3) Choose theme as Claro Theme
4) Click on Sales and Marketting 
5) Click Create contact
6) Select Title and type First name, Last Name, Email and Phone Numbers
7) Select Lead Source as "Public Relations"
8) Select Business Roles as "Sales"
9) Fill the Primary Address, City, State, Country and Postal Code and click Save
10) Mouse over on Today's Activities and click Meetings
11) Click Create 
12) Type Subject as "Project Status" , Status as "Planned" 
13) Start Date & Time as tomorrow 3 pm and Duration as 1hr
14) Click Add paricipants, add your created Contact name and click Save
15) Go to Sales and Marketting-->Contacts
16) search the lead Name and click the name from the result
17) Check weather the Meeting is assigned to the contact under Activities Section.
 */
public class TC009_CRMSystem_04242020 {

	public static void main(String[] args) throws InterruptedException {
		//1) Go to https://demo.1crmcloud.com/
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Actions builder=new Actions(driver);
		driver.manage().window().maximize();
		driver.get("https://demo.1crmcloud.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//2) Give username as admin and password as admin
		driver.findElementById("login_user").sendKeys("admin");
		driver.findElementById("login_pass").sendKeys("admin");
		
		//3) Choose theme as Claro Theme
		WebElement eleTheme = driver.findElementById("login_theme");
		Select sThemeList=new Select(eleTheme);
		sThemeList.selectByVisibleText("Claro Theme");
		driver.findElementById("login_button").click();
		Thread.sleep(5000);
		
		//4) Click on Sales and Marketting 
		driver.findElementByXPath("//div[text()='Sales & Marketing']").click();
		Thread.sleep(3000);
		
		//5) Click Create contact
		driver.findElementByXPath("//div[text()='Create Contact']").click();
		Thread.sleep(8000);
		
		//6) Select Title and type First name, Last Name, Email and Phone Numbers
		driver.findElementByXPath("//div[@id='DetailFormsalutation-input']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='Mr.']").click();
		driver.findElementById("DetailFormfirst_name-input").sendKeys("mathura");
		driver.findElementById("DetailFormlast_name-input").sendKeys("ganesh1");
		driver.findElementById("DetailFormemail1-input").sendKeys("test@gmail.com");
		driver.findElementById("DetailFormphone_work-input").sendKeys("9876543210");
		
		//7) Select Lead Source as "Public Relations"
		driver.findElementByXPath("//div[@id='DetailFormlead_source-input']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='Public Relations']").click();
		
		//8) Select Business Roles as "Sales"
		driver.findElementById("DetailFormbusiness_role-input").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='Sales']").click();
		
		//9) Fill the Primary Address, City, State, Country and Postal Code and click Save
		driver.findElementById("DetailFormprimary_address_street-input").sendKeys("MIG 147,Sholinganallur");
		driver.findElementById("DetailFormprimary_address_city-input").sendKeys("Chennai");
		driver.findElementById("DetailFormprimary_address_state-input").sendKeys("Tamil Nadu");
		driver.findElementById("DetailFormprimary_address_country-input").sendKeys("India",Keys.TAB);
		driver.findElementById("DetailFormprimary_address_postalcode-input").sendKeys("600119");
		driver.findElementById("DetailForm_save2-label").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//span[text()='Save']").click();
		Thread.sleep(4000);
		
		//10) Mouse over on Today's Activities and click Meetings
		builder.moveToElement(driver.findElementByXPath("//a[@class='menubar-link']")).pause(300).perform();
		driver.findElementByXPath("//div[text()='Meetings']").click();
		Thread.sleep(3000);
		
		//11) Click Create 
		driver.findElementByXPath("//span[text()='Create']").click();
		Thread.sleep(8000);
		
		//12) Type Subject as "Project Status" , Status as "Planned" 
		driver.findElementById("DetailFormname-input").sendKeys("Project Status");
		
		//13) Start Date & Time as tomorrow 3 pm and Duration as 1hr
		driver.findElementByXPath("//div[@class='input-label datetime-label text-number']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[@class='card-body panel-body grid-body']//div[text()='27']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input").sendKeys("15:00",Keys.ENTER);
		
		//driver.findElementByClassName("active-icon uii-accept uii-lg uii").click();
		Thread.sleep(300);
		driver.findElementById("DetailFormduration-time").clear();
		driver.findElementById("DetailFormduration-time").sendKeys("1",Keys.TAB);
		Thread.sleep(3000);
		
		//14) Click Add paricipants, add your created Contact name and click Save
		driver.findElementByXPath("//span[text()=' Add Participants']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[@id='app-search-text']/input").sendKeys("mathura ganesh1");
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='mathura ganesh1']").click();
		Thread.sleep(200);
		driver.findElementById("DetailForm_save2-label").click();
		Thread.sleep(8000);
		
		//15) Go to Sales and Marketting-->Contacts
		builder.moveToElement(driver.findElementByXPath("//div[text()='Sales & Marketing']")).pause(300).perform();
		driver.findElementByXPath("//div[text()='Contacts']").click();
		Thread.sleep(2000);
		
		//16) search the lead Name and click the name from the result
		driver.findElementByXPath("//div[@class='input-field input-field-group input-search filter']/input").sendKeys("mathura ganesh1");
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='input-field input-field-group input-search filter']/input").sendKeys(Keys.ENTER);
		//driver.findElementByXPath("//span[text()='Quick View (Contacts)']/following::div[text()='Mr. mathura ganesh1']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//a[text()='Mr. mathura ganesh1']").click();
		Thread.sleep(6000);
		
		//17) Check weather the Meeting is assigned to the contact under Activities Section.
	}

}
