package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBasketJuices {
	
	public static ChromeDriver driver;
	
	@Given("Launch BigBasket Juices URL")
	public void go_to_https_www_bigbasket_com() {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("mouse over on  Shop by Category")
	public void mouse_over_on_Shop_by_Category() throws InterruptedException {
		
		WebElement eleShop = driver.findElementByXPath("//a[text()=' Shop by Category ']");
		Actions builder=new Actions(driver);
		builder.moveToElement(eleShop).pause(2000)
		.moveToElement(driver.findElementByXPath("(//a[text()='Beverages'])[2]")).pause(2000).perform();
		builder.moveToElement(driver.findElementByXPath("(//a[text()='Fruit Juices & Drinks'])[2]"))
		.pause(2000).perform();
		driver.findElementByXPath("(//a[text()='Juices'])[2]").click();
		Thread.sleep(5000);
	}
	/*
	 * And Go to Beverages and Fruit juices & Drinks
	And Click on JUICES
	 */
	

	@Given("click Tropicana and Real under Brand")
	public void click_Tropicana_and_Real_under_Brand() throws InterruptedException {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[text()='Real']"));
	    js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[text()='Tropicana']"));
	    Thread.sleep(4000);
	}
	
	@Given("Check count of the products from each Brands and total count")
	public void check_count_of_the_products_from_each_Brands_and_total_count() throws InterruptedException {
	    List<WebElement> eleProduct = driver.findElementsByXPath("//div[@qa='product_name']");
	    int increament=1,iReal=0,iTropicana=0,iAvailableProd=0;;
	    for (int i = 0; i < eleProduct.size(); i++) {
			String sBrand = driver.findElementByXPath("(//h6[@class='ng-binding'])["+increament+"]").getText();
			if(sBrand.equalsIgnoreCase("Real"))
					iReal++;
			else if(sBrand.equalsIgnoreCase("Tropicana")) {
				iTropicana++;
			}
			if(driver.findElementsByXPath("(//div[@qa='product_name']/following::button[@qa='add'])["+increament+"]").size()!=0) {
				
				iAvailableProd++;
				
			}
			increament++;
		}
	    System.out.println("Real Brand Count-"+iReal);
	    System.out.println("Tropicana Brand Count-"+iTropicana);
	    System.out.println("Total Count of the products"+eleProduct.size());
	    System.out.println("Available Product with Add Button-"+iAvailableProd);
	    driver.findElementByXPath("(//div[@qa='product_name']/following::button[@qa='add'])[1]").click();
	}

	/*@Given("Check whether the products is availabe with Add button.")
	public void check_whether_the_products_is_availabe_with_Add_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Given("Add the First listed available product")
	public void add_the_First_listed_available_product() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}*/

	@Given("click on Change Address")
	public void click_on_Change_Address() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement eleAddress = driver.findElementByXPath("//a[@qa='areaDD']");
		js.executeScript("arguments[0].click()",eleAddress);
	}

	@When("Select CHennai as City, Alandur{int},Chennai as Area  and click Continue")
	public void select_CHennai_as_City_Alandur_Chennai_as_Area_and_click_Continue(Integer iPincode) throws InterruptedException {
		driver.findElementByXPath("//input[@qa='areaInput']").sendKeys(iPincode.toString(),Keys.TAB);
	    Thread.sleep(2000);
	    driver.findElementByXPath("//button[@qa='continueBtn']").click();
	    Thread.sleep(2000);
	}

	@Then("Mouse over on My Basket print the product name. count and price.")
	public void mouse_over_on_My_Basket_print_the_product_name_count_and_price() {
		Actions builder=new Actions(driver);
		WebElement eleMyBasket = driver.findElementByXPath("//span[text()='My Basket']");
		builder.moveToElement(eleMyBasket).pause(3000).clickAndHold().perform();
		String sProductName = driver.findElementByXPath("//div[@class='product-name']/a").getText();
		String[] split = driver.findElementByXPath("//div[@qa='pcsMB']").getText().split("x");
		System.out.println("Print the Product Name-"+sProductName);
		System.out.println("Print the Count-"+split[0]);
		System.out.println("Print the Price-"+split[1]);
	}

	@Then("Click View Basker and Checkout")
	public void click_View_Basker_and_Checkout() throws InterruptedException {
		driver.findElementByXPath("//button[text()='View Basket & Checkout']").click();
	    Thread.sleep(6000);
	}
	
	@Then("Click the Small close button and close the browser")
	public void Click_the_Small_close_button_and_close_the_browser() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//span[@class='login-icon login-icon-close']"));
		Thread.sleep(4000);
		driver.close();
	}


}
