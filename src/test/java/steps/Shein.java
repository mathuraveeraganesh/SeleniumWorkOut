package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shein {
	
	public static ChromeDriver driver;
	
	
	@Given("Launch the Shein URL")
	public void open_https_www_shein_in() {
	    System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.shein.in/");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("Mouseover on Clothing and click Jeans")
	public void mouseover_on_Clothing_and_click_Jeans() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElementByXPath("//div[@class='c-coupon-box']/i").click();
	    Thread.sleep(2000);
	    Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("//span[text()='CLOTHING']"))
	    .pause(2000).perform();
	    driver.findElementByXPath("//a[contains(text(),'Jeans')]").click();
	    Thread.sleep(4000);
	}

	@Given("Choose Black under Jeans product count")
	public void choose_Black_under_Jeans_product_count() throws InterruptedException {
	    driver.findElementByXPath("//a[text()='Black']").click();
	    Thread.sleep(4000);
	}

	@Given("check size as medium")
	public void check_size_as_medium() throws InterruptedException {
	    driver.findElementByXPath("//span[text()='Size']").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//div[@class='attr-group j-attr-group attr-group-size']/span[4]//span").click();
	    Thread.sleep(8000);
	}

	
	@Given("check whether the color is black")
	public void check_whether_the_color_is_black() {
	    String sColor = driver
	    		.findElementByXPath("//span[text()='Color']/following::span[@class='attr-item-pic j-attr-item']/a/span").getText();
	 
	    if(sColor.contains("Black"))
	    	System.out.println("Verified The color is Black");
	    else
	    	System.out.println("Verification Failed The color is not Black");
	}

	@Given("Click first item to Add to Bag")
	public void click_first_item_to_Add_to_Bag() {
		Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("//div[@class='c-goodsitem__ratiowrap']/a"))
	    .pause(2000).click(driver.findElementByXPath("//button[contains(text(),'Add to Bag')]")).perform();
	}

	@Given("Click the size as M abd click Submit")
	public void click_the_size_as_M_abd_click_Submit() throws InterruptedException {
	    driver.findElementByXPath("(//div[@class='c-opt']//span)[3]").click();
	    Thread.sleep(3000);
	    driver.findElementByXPath("//button[contains(text(),'Submit')]").click();
	    Thread.sleep(4000);
	    
	}

	@Given("Click view Bag")
	public void click_view_Bag() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()"
				,driver.findElementByXPath("//i[@class='iconfont-critical icon-gouwudai']"));
	    
	}

	@When("Check the size is Medium or not.")
	public void check_the_size_is_Medium_or_not() {
	    String sSize = driver.findElementByXPath("//div[@class='gd-color-size editable']//span").getText();
	 
	    if(sSize.contains("M"))
	    	System.out.println("Checked the size is Medium");
	    else
	    	System.out.println("Checked the size is Not Medium");
	}
	
	@Then("Close Shein browser.")
	public void closeShein() {
		driver.close();
	}


}
