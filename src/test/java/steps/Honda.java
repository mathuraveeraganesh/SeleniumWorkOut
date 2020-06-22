package steps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Honda {
	public static ChromeDriver driver;
	HashMap<String,String> ActivaMap=new LinkedHashMap<>();
	HashMap<String,String> DioMap=new LinkedHashMap<>();
	
	@Given("Launch the Honda URL")
	public void launch_the_Honda_URL() {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.honda2wheelersindia.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("Click on scooters and click dio")
	public void click_on_scooters_and_click_dio() throws InterruptedException {
		driver.findElementByXPath("//button[@class='close']").click();
		Thread.sleep(3000);
		driver.findElementById("link_Scooter").click();
		Thread.sleep(300);
		String sScotter1 = driver.findElementByXPath("//a[@href='/dio-BS-VI/']").getAttribute("href");
		String[] aScotter1 = sScotter1.split("/");
		String sScooterName1=aScotter1[3];
		
		driver.findElementByXPath("//a[@href='/dio-BS-VI/']/img").click();
	}

	@Given("Click on Specifications and mouseover on Engine")
	public void click_on_Specifications_and_mouseover_on_Engine() throws InterruptedException {
		driver.findElementByLinkText("Specifications").click();
		Thread.sleep(3000);
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).pause(200).perform();
	}

	@Given("Put all the details as key and value into Map")
	public void put_all_the_details_as_key_and_value_into_Map() {
		List<WebElement> eleDioDetails = driver.findElementsByXPath("//div[contains(@class,'engine part')]//li");
		int increament=2;
		for (int i = 1; i < eleDioDetails.size()-1; i++) {
			
			String specification = driver.findElementByXPath("(//div[contains(@class,'engine part')]//li/span[1])["+increament+"]").getText();
			String value = driver.findElementByXPath("(//div[contains(@class,'engine part')]//li/span[2])["+increament+"]").getText().replaceAll("[ ]", "").toLowerCase();
			increament++;
			DioMap.put(specification, value);
			
		}
		System.out.println(DioMap);
	}

	@Given("Go to Scooters and click Activa {int}")
	public void go_to_Scooters_and_click_Activa(Integer int1) throws InterruptedException {
		driver.findElementById("link_Scooter").click();
		String sScooter2 = driver.findElementByXPath("//a[@href='/activa125-BS-VI/']").getAttribute("href");
		String[] aScooter2 = sScooter2.split("/");
		String sScooterName2=aScooter2[3];
		driver.findElementByXPath("//a[@href='/activa125-BS-VI/']/img").click();
		driver.findElementByLinkText("Specifications").click();
		Thread.sleep(3000);
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).pause(200).perform();
	}

	@Given("Put All its Engine Specification into another Map same as like dio")
	public void put_All_its_Engine_Specification_into_another_Map_same_as_like_dio() {
		List<WebElement> eleActivaDetails = driver.findElementsByXPath("//div[contains(@class,'engine part')]//li");
		int increament=2;
		for (int i = 1; i < eleActivaDetails.size()-1; i++) {
			
			String specification = driver.findElementByXPath("(//div[contains(@class,'engine part')]//li/span[1])["+increament+"]").getText();
			String value = driver.findElementByXPath("(//div[contains(@class,'engine part')]//li/span[2])["+increament+"]").getText().replaceAll("[ ]", "").toLowerCase();
			increament++;
			ActivaMap.put(specification, value);
			
		}
		System.out.println(ActivaMap);
	}
	

	@Given("Compare Dio and Activa Maps and print the different values of the samekeys.")
	public void compare_Dio_and_Activa_Maps_and_print_the_different_values_of_the_samekeys() {
		System.out.println("Print the Dio different values of the samekeys ");
		for (Entry<String,String> Diocompare : DioMap.entrySet()) {
			   String DioValue = Diocompare.getValue();
			   
			   if(!ActivaMap.containsValue(DioValue)) {
				   System.out.println("Description-"+Diocompare.getKey()+" and the Value"+Diocompare.getValue());
			   }
		}
		System.out.println();
		System.out.println("Print the Activa different values of the samekeys ");
	   for (Entry<String,String> compare : ActivaMap.entrySet()) {
		   String activaValue = compare.getValue();
		   
		   if(!DioMap.containsValue(activaValue)) {
			   System.out.println("Description-"+compare.getKey()+" and the Value"+compare.getValue());
		   }
	}
	}

	@Given("Click FAQ from Menu and Click dio under Browse By Product")
	public void click_FAQ_from_Menu_and_Click_dio_under_Browse_By_Product() throws InterruptedException {
		driver.findElementByXPath("//a[text()='FAQ']").click();
		Thread.sleep(6000);;
	}

	@Given("Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit")
	public void click_Vehicle_Price_and_Select_scooter_Dio_BS_VI_from_the_dropdown_and_click_submit() throws InterruptedException {
	    driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//a[text()=' Vehicle Price']").click();
		Thread.sleep(2000);
		
		String sSelected = driver.findElementByXPath("//select[@id='ModelID6']/option[@selected='selected']").getText();
		if(sSelected.equals("Activa 125 BS-VI")) {
			System.out.println("Activa 125 BS-VI selected Sucessfully");
			driver.findElementByXPath("//button[@id='submit6']").click();
			Thread.sleep(2000);		
		}

		else
			System.out.println("Activa 125 BS-VI selected Unsucessfully");
		
	}

	@Given("click the price link,  Go to the new Window and select the state, city")
	public void click_the_price_link_Go_to_the_new_Window_and_select_the_state_city() throws InterruptedException {
		driver.findElementByXPath("//a[contains(text(),'Activa 125 BS-VI')]").click();
		Thread.sleep(6000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindowList=new ArrayList<>();
		allWindowList.addAll(windowHandles);
		driver.switchTo().window(allWindowList.get(1));
		
		WebElement eleState = driver.findElementById("StateID");
		Select State=new Select(eleState);
		State.selectByVisibleText("Tamil Nadu");
		Thread.sleep(2000);
		
		WebElement eleCity = driver.findElementById("CityID");
		Select City=new Select(eleCity);
		City.selectByVisibleText("Chennai");
		Thread.sleep(2000);
	}

	@Given("Print the price and model")
	public void print_the_price_and_model() throws InterruptedException {
		driver.findElementByXPath("//button[text()='Search']").click();
		Thread.sleep(3000);
		WebElement eleTable = driver.findElementById("gvshow");
		List<WebElement> eleRow = eleTable.findElements(By.tagName("tr"));
		for (int i = 0; i < eleRow.size(); i++) {
			List<WebElement> eleData = eleRow.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < eleData.size(); j++) {
				System.out.println(eleData.get(j).getText());
			}
			
		}
	}

	@When("Click Product Enquiry and Fill all the * field except Mobile, check the terms and conditions box and click submit")
	public void click_Product_Enquiry_and_Fill_all_the_field_except_Mobile_check_the_terms_and_conditions_box_and_click_submit() throws InterruptedException {
	    driver.findElementByXPath("//span[text()='Product Enquiry ']").click();
	    Thread.sleep(4000);
	    Select model=new Select(driver.findElementByXPath("//select[@id='ModelID']"));
	    model.selectByVisibleText("Activa 125 BS-VI");
	    Select State=new Select(driver.findElementByXPath("//select[@id='StateID']"));
	    State.selectByVisibleText("Tamil Nadu");
	    Thread.sleep(2000);
	    Select City=new Select(driver.findElementByXPath("//select[@id='CityID']"));
	    City.selectByVisibleText("Chennai");
	    Select Dealer=new Select(driver.findElementByXPath("//select[@id='DealerID']"));
	    Dealer.selectByVisibleText("B M Honda");
	    Select title=new Select(driver.findElementByXPath("//select[@id='TitleID']"));
	    title.selectByVisibleText("Mr.");
	    driver.findElementByXPath("//input[@id='Name']").sendKeys("Ganesh");
	    driver.findElementByXPath("//input[@id='Email']").sendKeys("test@gmail.com");
	    driver.findElementByXPath("//input[@id='TermsAndConditions']").click();
	    driver.findElementByXPath("//button[text()='Submit']").click();
	    Thread.sleep(3000);
	    
	}

	@Then("Verify the error message under the mobile number field.")
	public void verify_the_error_message_under_the_mobile_number_field() {
	    String sErrorMessage = driver.findElementByXPath("//span[@for='MobileNo']").getText();
	    if(sErrorMessage.equals("Please enter mobile no.")) 
	    	System.out.println("Verified the error message under the mobile number field");
	    else
	    	System.out.println("Verification Failed the error message under the mobile number field");
	    
	}
	
	@Then("Close the Honda Browser")
	public void closeHondaBrowser() {
		driver.quit();
	}


}
