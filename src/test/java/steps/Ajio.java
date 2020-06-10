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

public class Ajio {
	
	public static ChromeDriver driver;
	
	@Given("Launch the Ajio URL")
	public void launch_the_Ajio_URL() {
	    System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.ajio.com/shop/women");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("Mouseover on Women, CATEGORIES and click on Kurtas")
	public void mouseover_on_Women_CATEGORIES_and_click_on_Kurtas() throws InterruptedException {
	    Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("//a[text()='WOMEN']"))
	    .pause(2000).moveToElement(driver.findElementByXPath("(//a[text()='CATEGORIES'])[2]"))
	    .pause(2000).click(driver.findElementByXPath("(//a[text()='Kurtas'])[2]")).perform();
	    Thread.sleep(5000);
	}

	@Given("Click on Brands and choose Ajio")
	public void click_on_Brands_and_choose_Ajio() throws InterruptedException {
	    driver.findElementByXPath("//span[text()='brands']").click();
	    WebElement eleBrands = driver.findElementByXPath("//label[contains(text(),'AJIO')]");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()", eleBrands);
	    Thread.sleep(6000);
	    
	}

	@Given("Check all the results are Ajio")
	public void check_all_the_results_are_Ajio() {
	    String sResult = driver.findElementByXPath("//input[@name='searchVal']").getAttribute("placeholder");
	    if(sResult.contains("AJIO"))
	    	System.out.println("All the results are Ajio Checked");
	    else
	    	System.out.println("All the results are Not Ajio Checked");
	}

	@Given("Set Sort by the result as Discount")
	public void set_Sort_by_the_result_as_Discount() throws InterruptedException {
	    Select sort=new Select(driver.findElementByXPath("//label[text()='Sort By']/following::select"));
	    sort.selectByVisibleText("Discount");
	    Thread.sleep(6000);
	}

	@Given("Select the Color and click ADD TO BAG")
	public void select_the_Color_and_click_ADD_TO_BAG() throws InterruptedException {
	    WebElement eleProduct = driver.findElementByXPath("(//a[@class='rilrtl-products-list__link'])[1]//div/div/img");
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()",eleProduct);
	    Thread.sleep(5000);
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowList=new ArrayList<>();
	    windowList.addAll(windowHandles);
	    driver.switchTo().window(windowList.get(1));
	    driver.findElementByXPath("//div[@class='color-swatch']/following::img[@alt='blue']").click();
	    Thread.sleep(5000);
	    driver.findElementByXPath("//span[text()='ADD TO BAG']/parent::div/parent::div").click();
	    Thread.sleep(2000);
	    
	}

	@Given("Verify the error message Select your size to know your estimated delivery date")
	public void verify_the_error_message_Select_your_size_to_know_your_estimated_delivery_date() {
		String sErrorMsg = driver.findElementByXPath("//span[@class='edd-pincode-msg-details']").getText();
	    if (sErrorMsg.equals("Select your size to know your estimated delivery date."))
	    	System.out.println("Verified the error message Select your size to know your estimated delivery date");
	    else
	    	System.out.println("Verification Failed the error message Select your size to know your estimated delivery date");
	}

	@Given("Select size and click ADD TO BAG")
	public void select_size_and_click_ADD_TO_BAG() throws InterruptedException {
	    driver.findElementByXPath("//div[@class='size-swatch']/div[text()='XS']").click();
	    Thread.sleep(3000);
	    
	    
	}

	@Given("click on Enter pin-code to know estimated delivery date")
	public void click_on_Enter_pin_code_to_know_estimated_delivery_date() {
		driver.findElementByXPath("//span[contains(text(),'Enter Pin-code')]").click();
	}

	@Given("Enter the pincode as {int} and click Confirm pincode")
	public void enter_the_pincode_as_and_click_Confirm_pincode(Integer pincode) {
	    driver.findElementByXPath("//input[@name='pincode']").sendKeys(pincode.toString());
	    driver.findElementByXPath("//button[text()='CONFIRM PINCODE']").click();
	}

	@When("Print the message and click Go to  Bag")
	public void print_the_message_and_click_Go_to_Bag() throws InterruptedException {
	    String sMessage = driver.findElementByXPath("//ul[@class='edd-message-success-details']").getText();
	    System.out.println("Print the message");
	    System.out.println(sMessage);
	    driver.findElementByXPath("//span[text()='ADD TO BAG']/parent::div/parent::div").click();
	    Thread.sleep(2000);
	}

	@Then("Click on Proceed to Shipping and clode the browser")
	public void click_on_Proceed_to_Shipping_and_clode_the_browser() throws InterruptedException {
	    Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("//div[@class='popup-blk cart-blk']")).pause(2000)
	    .click(driver.findElementByXPath("//a[@class='cart-block-bag']")).pause(2000).perform();
	    driver.findElementByXPath("//button[text()='Proceed to shipping']").click();
	    Thread.sleep(5000);
	    driver.quit();
	}



}
