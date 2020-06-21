package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CRMSystem {
	
	public static ChromeDriver driver;
	
	@Given("Launch the CRM System")
	public void launch_the_CRM_System() {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.1crmcloud.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("Give username as admin and password as admin")
	public void give_username_as_admin_and_password_as_admin() {
		driver.findElementById("login_user").sendKeys("admin");
		driver.findElementById("login_pass").sendKeys("admin");
	}

	@Given("Choose theme as Claro Theme")
	public void choose_theme_as_Claro_Theme() throws InterruptedException {
		WebElement eleTheme = driver.findElementById("login_theme");
		Select sThemeList=new Select(eleTheme);
		sThemeList.selectByVisibleText("Claro Theme");
		driver.findElementById("login_button").click();
		Thread.sleep(5000);
	}

	@Given("Go to Sales and Marketting and click Sales Home")
	public void go_to_Sales_and_Marketting_and_click_Sales_Home() throws InterruptedException {
		driver.findElementByXPath("//div[text()='Sales & Marketing']").click();
		Thread.sleep(3000);
	}

	@Given("Click Create contact")
	public void click_Create_contact() throws InterruptedException {
		driver.findElementByXPath("//div[text()='Create Contact']").click();
		Thread.sleep(8000);
	}

	@Given("Select Title and type First name, Last Name, Email and Phone Numbers")
	public void select_Title_and_type_First_name_Last_Name_Email_and_Phone_Numbers() throws InterruptedException {
		driver.findElementByXPath("//div[@id='DetailFormsalutation-input']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='Mr.']").click();
		driver.findElementById("DetailFormfirst_name-input").sendKeys("mathura");
		driver.findElementById("DetailFormlast_name-input").sendKeys("ganesh1");
		driver.findElementById("DetailFormemail1-input").sendKeys("test@gmail.com");
		driver.findElementById("DetailFormphone_work-input").sendKeys("9876543210");
	}

	@Given("Select Lead Source as Public Relations and Business Roles")
	public void select_Lead_Source_as_Public_Relations_and_Business_Roles() throws InterruptedException {
		driver.findElementByXPath("//div[@id='DetailFormlead_source-input']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='Public Relations']").click();
		driver.findElementById("DetailFormbusiness_role-input").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='Sales']").click();
	}

	@Given("Fill the Primary Address, City, State, Country and Postal Code and click Save")
	public void fill_the_Primary_Address_City_State_Country_and_Postal_Code_and_click_Save() throws InterruptedException {
		driver.findElementById("DetailFormprimary_address_street-input").sendKeys("MIG 147,Sholinganallur");
		driver.findElementById("DetailFormprimary_address_city-input").sendKeys("Chennai");
		driver.findElementById("DetailFormprimary_address_state-input").sendKeys("Tamil Nadu");
		driver.findElementById("DetailFormprimary_address_country-input").sendKeys("India",Keys.TAB);
		driver.findElementById("DetailFormprimary_address_postalcode-input").sendKeys("600119");
		Thread.sleep(2000);
		driver.findElementById("DetailForm_save2-label").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//span[text()='Save']").click();
		Thread.sleep(4000);
	}

	@Given("Click create and Leads")
	public void click_create_and_Leads() throws InterruptedException {
	    driver.findElementByXPath("(//span[text()='Create'])[2]").click();
	    Thread.sleep(4000);
	}

	@Given("Fill First & Last name, Status as In Process, Title as Manager and Department as Sales")
	public void fill_First_Last_name_Status_as_In_Process_Title_as_Manager_and_Department_as_Sales() {
	   driver.findElementByXPath("//input[@name='first_name']").sendKeys("Mathura");
	   driver.findElementByXPath("//input[@name='last_name']").sendKeys("Ganesh");
	   driver.findElementByXPath("//div[@id='QuickCreateForm_0status-input']").click();
	   driver.findElementByXPath("//div[text()='In Process']").click();
	   driver.findElementByXPath("//input[@name='title']").sendKeys("Manager");
	   driver.findElementByXPath("//input[@name='department']").sendKeys("Sales");
	   
	}

	@Given("Select Lead as Public Relations and fill department, Email and Phone Number")
	public void select_Lead_as_Public_Relations_and_fill_department_Email_and_Phone_Number() throws InterruptedException {
	    driver.findElementByXPath("//div[@id='QuickCreateForm_0status-input-label']").click();
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()",driver.findElementByXPath("//div[text()='In Process']"));
	    driver.findElementByXPath("//div[@id='QuickCreateForm_0lead_source-input']").click();
	    js.executeScript("arguments[0].click()",driver.findElementByXPath("(//div[text()='Public Relations'])[2]"));
	    
	    driver.findElementByXPath("//textarea[@name='description']").sendKeys("Test");
	    driver.findElementByXPath("//input[@name='phone_work']").sendKeys("9003187314");
	    driver.findElementByXPath("//input[@name='email1']").sendKeys("test@gmail.com");
	    Thread.sleep(4000);
	}

	@Given("Click Save and View")
	public void click_Save_and_View() throws InterruptedException {
	    driver.findElementByXPath("//span[@id='QuickCreateForm_0_save_view-label']").click();
	    Thread.sleep(4000);
	    driver.findElementByXPath("//span[text()='Save']").click();
		Thread.sleep(4000);
	}

	@Given("Mouse over on Today's Activities and click Meetings")
	public void mouse_over_on_Today_s_Activities_and_click_Meetings() throws InterruptedException {
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[@class='menubar-link']")).pause(300).perform();
		driver.findElementByXPath("//div[text()='Meetings']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='Create']").click();
		Thread.sleep(8000);
	}
	@Given("Type Subject as Project Status Status as Planned and Time as tomorrow {int} p.m")
	public void type_Subject_as_Project_Status_Status_as_Planned_and_Time_as_tomorrow_p_m(Integer int1) throws InterruptedException {
		driver.findElementById("DetailFormname-input").sendKeys("Project Status");
		
		driver.findElementByXPath("//div[@class='input-label datetime-label text-number']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[@class='card-body panel-body grid-body']//div[text()='22']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[@id='DetailFormdate_start-calendar-text']//input").sendKeys("15:00",Keys.ENTER);
		
		//driver.findElementByClassName("active-icon uii-accept uii-lg uii").click();
		Thread.sleep(300);
		driver.findElementById("DetailFormduration-time").clear();
		driver.findElementById("DetailFormduration-time").sendKeys("1",Keys.TAB);
		Thread.sleep(3000);
		
	}

	@Given("Click Add paricipants, add your created Lead name and click Save")
	public void click_Add_paricipants_add_your_created_Lead_name_and_click_Save() throws InterruptedException {
		driver.findElementByXPath("//span[text()=' Add Participants']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//div[@id='app-search-text']/input").sendKeys("mathura ganesh1");
		Thread.sleep(200);
		driver.findElementByXPath("//div[text()='mathura ganesh1']").click();
		Thread.sleep(200);
		driver.findElementById("DetailForm_save2-label").click();
		Thread.sleep(8000);
	}

	@When("Click contacts under Sales and Marketting, search the lead Name and click the name from the result")
	public void click_contacts_under_Sales_and_Marketting_search_the_lead_Name_and_click_the_name_from_the_result() throws InterruptedException {
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//div[text()='Sales & Marketing']")).pause(300).perform();
		driver.findElementByXPath("//div[text()='Contacts']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='input-field input-field-group input-search filter']/input").sendKeys("mathura ganesh1");
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='input-field input-field-group input-search filter']/input").sendKeys(Keys.ENTER);
		//driver.findElementByXPath("//span[text()='Quick View (Contacts)']/following::div[text()='Mr. mathura ganesh1']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//a[text()='Mr. mathura ganesh1']").click();
		Thread.sleep(6000);
		
	}

	@Then("Check weather the Meeting is assigned to the contact.")
	public void check_weather_the_Meeting_is_assigned_to_the_contact() {
	    String sStatus = driver.findElementByXPath("//table[contains(@id,'listView')]//tr/td[5]").getText();
	    if(sStatus.equalsIgnoreCase("Planned"))
	    	System.out.println("The Meeting is Assigned to the contact");
	    else
	    	System.out.println("The Meeting is Not Assigned to the contact");
	}


}
