package steps;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BigBacket {
	public static ChromeDriver driver;
	
	@Given("Launch the BigBacket URL")
	public void launch_the_BigBacket_URL() {
	    System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("mouse over on Shop by Category")
	public void mouse_over_on_Shop_by_Category() {
		WebElement eleShop = driver.findElementByXPath("//a[text()=' Shop by Category ']");
		Actions builder=new Actions(driver);
		builder.moveToElement(eleShop).pause(600)
		.moveToElement(driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]")).pause(600)
		.perform();
		
		
	}

	@Given("Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS")
	public void go_to_FOODGRAINS_OIL_MASALA_and_RICE_RICE_PRODUCTS() {
	    Actions builder=new Actions(driver);
	    builder.moveToElement(driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]")).perform();
	}

	@Given("Click on BOILED & STEAM RICE")
	public void click_on_BOILED_STEAM_RICE() {
		driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
	}

	@Given("Get the URL of the page and check eith with site navigation link\\(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)")
	public void get_the_URL_of_the_page_and_check_eith_with_site_navigation_link_HOME_FOODGRAINS_OIL_MASALA_RICE_RICE_PRODUCTS_BOILED_STEAM_RICE() {
	    String currentUrl = driver.getCurrentUrl();
	    String sSiteUrl = currentUrl.replaceAll("[^a-zA-Z]","");
	    if(sSiteUrl.contains("foodgrainsoilmasalaricericeproductsboiledsteamrice"))
	    	System.out.println("Verfied the Site navigation link (HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)");
	    else
	    	System.out.println("Verfication Failed the Site navigation link (HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)");
	}

	@Given("Choose the Brand as bb Royal")
	public void choose_the_Brand_as_bb_Royal() throws InterruptedException {
		driver.findElementByXPath("//span[text()='bb Royal']").click();
		Thread.sleep(3000);
	}

	@Given("Go to Ponni Boiled Rice and select {int}kg bag from Dropdown")
	public void go_to_Ponni_Boiled_Rice_and_select_kg_bag_from_Dropdown(Integer iKG) {
		List<WebElement> eleList = driver.findElementsByXPath("//div[@class='item prod-deck row ng-scope']");
		for (int i = 0; i < eleList.size(); i++) {
			int increament=i+1;
			String sRiceName = driver.findElement(By.xpath("(//div[@qa='product_name']//a)["+increament+"]")).getText();
			//System.out.println(sRiceName);
			if (sRiceName.equals("Ponni Boiled Rice - Super Premium")) {
				driver.findElement(By.xpath("(//div[@class='btn-group btn-input clearfix ng-scope']//button[@class='btn btn-default dropdown-toggle form-control'])["+increament+"]")).click();
				driver.findElement(By.xpath("(//ul[@class='dropdown-menu drop-select']/following::span[text()='"+iKG+" kg'])[3]")).click();
				
				
				//8) Click Add button
				driver.findElementByXPath("(//button[@qa='add'])["+increament+"]").click();
				driver.findElementByXPath("//a[text()='Continue']").click();
				
			}
		}
	}

	
	@Given("Add Toor\\/Arhar Dal {int}kg and set Qty {int} from the list")
	public void add_Toor_Arhar_Dal_kg_and_set_Qty_from_the_list(Integer iKG, Integer iQuantity) throws InterruptedException {
		driver.findElementByXPath("//input[@qa='searchBar']").sendKeys("Dal");
		Thread.sleep(3000);
		List<WebElement> eleDal = driver.findElementsByXPath("//p[@qa='prodNameAS']");
		for (int i = 0; i < eleDal.size(); i++) {
			int increamentDal=i+1;
			String sDalType = driver.findElementByXPath("(//p[@qa='prodNameAS'])["+increamentDal+"]").getText().replaceAll("[^a-zA-Z]+","");
			//System.out.println(sDalType);//Toor Dal/Arhar Dal - Desi
			String sKg = driver.findElementByXPath("(//div[@qa='pcsAS'])["+increamentDal+"]").getText(); //1 kg
			if(sDalType.equals("ToorArharDal") && sKg.equals(iKG+" kg") ) {
							
				driver.findElementByXPath("(//input[@qa='qtyAS'])["+increamentDal+"]").clear();
				driver.findElementByXPath("(//input[@qa='qtyAS'])["+increamentDal+"]").sendKeys(iQuantity.toString());
				
				//14) Click Add button
				driver.findElementByXPath("(//button[@qa='addBtnAS'])["+increamentDal+"]").click();
			}
		}
	}

	@Given("click Address")
	public void click_Address() {
	    JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement eleAddress = driver.findElementByXPath("//a[@qa='areaDD']");
		js.executeScript("arguments[0].click()",eleAddress);
	}

	@When("Select CHennai as City, Alandur{int},Chennai as Area and click Continue")
	public void select_CHennai_as_City_Alandur_Chennai_as_Area_and_click_Continue(Integer iPincode) throws InterruptedException {
	    driver.findElementByXPath("//input[@qa='areaInput']").sendKeys(iPincode.toString(),Keys.TAB);
	    Thread.sleep(2000);
	    driver.findElementByXPath("//button[@qa='continueBtn']").click();
	    Thread.sleep(2000);
	}

	@Then("Mouse over on My Basket take a screen shot")
	public void mouse_over_on_My_Basket_take_a_screen_shot() throws IOException {
		Actions builder=new Actions(driver);
		WebElement eleMyBasket = driver.findElementByXPath("//span[text()='My Basket']");
		builder.moveToElement(eleMyBasket).pause(3000).clickAndHold().perform();
	    File src = driver.getScreenshotAs(OutputType.FILE);
	    File desc = new File("./Mybasket.png");
	    FileUtils.copyFile(src, desc);
	}

	@Then("Click View Basket and Checkout")
	public void click_View_Basket_and_Checkout() throws InterruptedException {
	    driver.findElementByXPath("//button[text()='View Basket & Checkout']").click();
	    Thread.sleep(6000);
	}

	@Then("Click the close button and close the browser")
	public void click_the_close_button_and_close_the_browser() {
	    driver.close();
	}



}
