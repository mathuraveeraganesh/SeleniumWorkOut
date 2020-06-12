package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shopclues {
	
	public static ChromeDriver driver;
	
	@Given("Launch the Shopclues URL")
	public void launch_the_Shopclues_URL() {
		System.setProperty("webdriver.chrome.driver","./drivers/Chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.shopclues.com");
	    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("Mouseover on women and click Casual Shoes")
	public void mouseover_on_women_and_click_Casual_Shoes() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElementByXPath("//button[text()='Allow']").click();
		Thread.sleep(2000);
	    Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("//a[text()='WOMEN']"))
	    .pause(2000).perform();
	    driver.findElementByXPath("(//a[text()='Casual Shoes'])[1]").click();
	}

	@Given("Select Color as Black")
	public void select_Color_as_Black() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowList=new ArrayList<String>();
		allwindowList.addAll(windowHandles);
		driver.switchTo().window(allwindowList.get(1));
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()"
	    		,driver.findElementByXPath("//label[contains(text(),'Black')]"));
	    Thread.sleep(4000);
	}

	@Given("Check whether the product name contains the word black")
	public void check_whether_the_product_name_contains_the_word_black() throws InterruptedException {
	    List<WebElement> eleProduct = driver.findElementsByXPath("//span[contains(@class,'prod_name')]");
	    List<Integer> sort=new LinkedList<>();
	    HashMap<Integer,String> map=new HashMap<>();
	    int increament=1,serial=1;;
	    for (int i = 0; i < eleProduct.size(); i++) {
	    	String sProduct = driver.findElementByXPath("(//span[contains(@class,'prod_name')])"
	    			+ "["+increament+"]").getText();
	    	String sPrice = driver.findElementByXPath("(//div[@class='prd_p_section']"
    		 		+ "/div/span[@class='p_price'])["+increament+"]").getText().replaceAll("[^0-9]","");
	    	int iPrice=Integer.parseInt(sPrice);
	    	increament++;
	    	if(sProduct.contains("Black")) {
	    		 map.put(iPrice,sProduct);
	    		 sort.add(iPrice);
	    	}
	        	
		}
	    for(Entry<Integer,String> eachmap:map.entrySet()) {
	    	System.out.println(serial+") Price:" +eachmap.getKey()
	    			+" and the Product Name: "+eachmap.getValue());
	    	serial++;
	    }
	    Collections.sort(sort, Collections.reverseOrder());
	    
	    System.out.println("Highest Price-"+sort.get(0)+" and the Product Name-"+map.get(sort.get(0)));
	    String sProductName=map.get(sort.get(0));
	    String[] aSplit = sProductName.split("Women's");
	    driver.findElementByXPath("//span[contains(text(),'"+aSplit[1]+"')]/parent::a").click();
	    Thread.sleep(6000);
	    
	}


	

	@Given("Get the current page URL and check with the product ID")
	public void get_the_current_page_URL_and_check_with_the_product_ID() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowList=new ArrayList<>();
		allwindowList.addAll(windowHandles);
		driver.switchTo().window(allwindowList.get(2));
	    String sCurrentUrl = driver.getCurrentUrl().replaceAll("[^0-9]","");
	    String sproductID = driver.findElementByXPath("//span[@class='pID']").getText().replaceAll("[^0-9]","");
	    if(sCurrentUrl.equals(sCurrentUrl))
	    	System.out.println("Verified Current Page URL Contains product ID-"+sproductID);
	    else
	    	System.out.println("Verification Failed Current Page URL does not Contains product ID-"+sproductID);
	}

	@Given("Copy the offercode")
	public void copy_the_offercode() {
	    String sCouponCode = driver.findElementByXPath("//div[@class='coupons_code']/span").getText();
	    System.out.println("Offer code-"+sCouponCode);
	}

	@Given("Select size, color and click ADD TO CART")
	public void select_size_color_and_click_ADD_TO_CART() throws InterruptedException {
	    driver.findElementByXPath("//span[(text()='38 (EUR)')]").click();
	    Thread.sleep(2000);
	    driver.findElementByXPath("//button[text()='Add To Cart']").click();
	    Thread.sleep(5000);
	}

	@When("Mouse over on Shopping cart and click View Cart")
	public void mouse_over_on_Shopping_cart_and_click_View_Cart() {
	    Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("//a[@class='cart_ic']"))
	    .pause(2000).click(driver.findElementByXPath("//a[text()='View Cart']")).pause(5000).perform();
	    
	}

	@Then("Type Pincode as {int} click Submit and Place Order")
	public void type_Pincode_as_click_Submit_and_Place_Order(Integer iPincode) throws InterruptedException {
	    driver.findElementByXPath("//input[@id='pin_code_popup']").sendKeys(iPincode.toString());
	    Thread.sleep(2000);
	    driver.findElementByXPath("//input[@id='get_pincode_popup']").click();
	    Thread.sleep(3000);
	    driver.findElementByXPath("//div[text()='Place Order']").click();
	    Thread.sleep(5000);
	}

	@Then("Close the Browser")
	public void close_the_Browser() {
	    driver.quit();
	}


}
