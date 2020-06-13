package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Trivago {
	
	public static ChromeDriver driver;
	
	@Given("Launch the Website")
	public void go_to_https_www_trivago_com() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    driver.get("https://www.trivago.com");
	    Thread.sleep(6000);
	    driver.findElementByXPath("//button[@id='onetrust-accept-btn-handler']").click();
	    Thread.sleep(4000);
	}

	@Given("Type Agra in Destination and select Agra, Uttar Pradesh.")
	public void type_Agra_in_Destination_and_select_Agra_Uttar_Pradesh() throws InterruptedException {
		driver.findElementByXPath("//input[@id='querytext']").click();
		driver.findElementByXPath("//input[@id='querytext']").sendKeys("Agra");
		Thread.sleep(4000);
		driver.findElementByXPath("//span[text()='City - Uttar Pradesh, India']/parent::div/parent::li").click();
		Thread.sleep(2000);
	}

	@Given("Choose May {int} as check in and June {int} as check out")
	public void choose_May_as_check_in_and_June_as_check_out(Integer iCheckInDate, Integer iCheckOutDate) throws InterruptedException {
		driver.findElementByXPath("//span[text()='"+iCheckInDate+"']/parent::time/parent::td").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//span[text()='"+iCheckOutDate+"']/parent::time/parent::td").click();
		Thread.sleep(2000);
	}

	@Given("Select Room as Family Room")
	public void select_Room_as_Family_Room() throws InterruptedException {
	    driver.findElementByXPath("//span[text()='Family rooms']/parent::div/parent::button").click();
	    Thread.sleep(2000);
	}

	@Given("Choose Number of Adults {int}, Childern {int} and set Child's Age as {int}")
	public void choose_Number_of_Adults_Childern_and_set_Child_s_Age_as(Integer iAdult, Integer iChildren, Integer iChildage) throws InterruptedException {
	    Select adult=new Select(driver.findElementByXPath("//select[contains(@id,'select-num-adults')]"));
	    adult.selectByVisibleText(iAdult.toString());
	    Thread.sleep(2000);
	    Select Children=new Select(driver.findElementByXPath("//select[contains(@id,'select-num-children')]"));
	    Children.selectByVisibleText(iChildren.toString());
	    Thread.sleep(2000);
	    Select ChildAge=new Select(driver.findElementByXPath("//select[contains(@id,'select-ages-children')]"));
	    ChildAge.selectByVisibleText(iChildage.toString());
	    Thread.sleep(2000);
	    
	}

	@Given("Click Confirm button and click Search")
	public void click_Confirm_button_and_click_Search() throws InterruptedException {
	    driver.findElementByXPath("//span[text()='Confirm']/parent::button").click();
	    Thread.sleep(6000);
	    driver.findElementByXPath("//span[text()='Search']/parent::button").click();
	    Thread.sleep(4000);
	}

	@Given("Select Accommodation type as Hotels only and choose {int} stars")
	public void select_Accommodation_type_as_Hotels_only_and_choose_stars(Integer iStar) {
	    WebElement eleAccomdation = driver.findElementByXPath("//strong[text()='Accommodation']");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()",eleAccomdation);
	    driver.findElementByXPath("//label[text()='Hotels only']/preceding::input[1]").click();
	    
	    driver.findElementByXPath("//span[text()='"+iStar+"-star hotels']/parent::button").click();
	}

	@Given("Select Guest rating as Very Good")
	public void select_Guest_rating_as_Very_Good() {
		 WebElement eleRating = driver.findElementByXPath("//strong[text()='Guest rating']");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",eleRating);
		 driver.findElementByXPath("//span[text()='Very good']/parent::button").click();
	}

	@Given("Set Hotel Location as Agra Fort and click Done")
	public void set_Hotel_Location_as_Agra_Fort_and_click_Done() {
		WebElement eleHotel = driver.findElementByXPath("//strong[text()='Hotel location']");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",eleHotel);
		 Select eleLocation= new Select(driver.findElementByXPath("//select[@id='pois']"));
		 eleLocation.selectByVisibleText("Agra Fort");
		 driver.findElementByXPath("//button[text()='Done']").click();
	}

	@Given("In more Filters, select Air conditioning, Restaurant and WiFi and click Done")
	public void in_more_Filters_select_Air_conditioning_Restaurant_and_WiFi_and_click_Done() throws InterruptedException {
		WebElement eleFilter = driver.findElementByXPath("//strong[text()='More filters']");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()",eleFilter);
		 js.executeScript("arguments[0].click()",driver.findElementByXPath("//label[text()='Air conditioning']"));
		 js.executeScript("arguments[0].click()",driver.findElementByXPath("//label[text()='Restaurant']"));
		 js.executeScript("arguments[0].click()",driver.findElementByXPath("//label[text()='WiFi']"));
		 Thread.sleep(4000);
		 driver.findElementByXPath("//button[text()='Done']").click();
	}

	@When("Sort the result as Rating & Recommended")
	public void sort_the_result_as_Rating_Recommended() throws InterruptedException {
	    Select sort=new Select(driver.findElementByXPath("//select[@data-qa='sorting']"));
	    sort.selectByVisibleText("Rating & Recommended");
	    Thread.sleep(4000);
	}

	@Then("Print the Hotel name, Rating, Number of Reviews and Click View Deal")
	public void print_the_Hotel_name_Rating_Number_of_Reviews_and_Click_View_Deal() throws InterruptedException {
	    String sHotelName = driver.findElementByXPath("(//span[@data-qa='item-name'])[1]").getText();
	    System.out.println("Hotel Name-"+sHotelName);
	    String sRating = driver.findElementByXPath("(//span[@itemprop='ratingValue'])[1]").getText();
	    System.out.println("Rating-"+sRating);
	    String sReview = driver.findElementByXPath("(//span[@class='details-paragraph details-paragraph--rating'])[1]").getText();
	    System.out.println("Number of Reviews-"+sReview);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()"
	    		,driver.findElementByXPath("(//span[text()='View Deal'])[1]"));
	    Thread.sleep(8000);
	}

	@Then("Print the URL of the Page")
	public void print_the_URL_of_the_Page() {
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> allwindowHandles=new ArrayList<>();
	    allwindowHandles.addAll(windowHandles);
	    driver.switchTo().window(allwindowHandles.get(1));
	    System.out.println("Url of the page-"+driver.getCurrentUrl());
	}

	@Then("Print the Price of the Room and click Choose Your Room")
	public void print_the_Price_of_the_Room_and_click_Choose_Your_Room() throws InterruptedException {
	    String sPrice = driver.findElementByXPath("//div[@class='bui-price-display__value prco-text-nowrap-helper prco-inline-block-maker-helper']").getText();
	    System.out.println("Price of the Room-"+sPrice);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()"
	    		,driver.findElementByXPath("(//span[contains(text(),'Choose your room')])[1]"));
	    Thread.sleep(5000);
	}

	@Then("Click Reserve and I'll Reserve")
	public void click_Reserve_and_I_ll_Reserve() {
	    driver.findElementByXPath("(//span[contains(text(),'Reserve')])[3]").click();
	    driver.findElementByXPath("//button[contains(@class,'txp-bui-main-pp bui-button bui-button--primary ')]").click();
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    driver.quit();
	}



}
