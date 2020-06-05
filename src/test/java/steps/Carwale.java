package steps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Carwale {
	
	public static ChromeDriver driver; 
	
	
	List<Integer> sCarKMList=new ArrayList<>();
	HashMap<Integer,String> sCarNaKM=new LinkedHashMap<>();
	List<Integer> sSortValidateKMList=new ArrayList<>();
	
	@Given("Launch the URL")
	public void go_to_https_www_carwale_com() {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.carwale.com");
	}

	@Given("Click on Used")
	public void click_on_Used() {
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
	}

	@Given("Select the City as Chennai")
	public void select_the_City_as_Chennai() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElementByXPath("//input[@id='usedCarsList']").sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
		Thread.sleep(2000);
	}

	@Given("Select budget min-8L and max-12L and Click Search")
	public void select_budget_min_L_and_max_L_and_Click_Search() throws InterruptedException {
		driver.findElementById("minInput").sendKeys("8",Keys.TAB);
		driver.findElementById("maxInput").sendKeys("12",Keys.TAB);
		Thread.sleep(2000);
		driver.findElementById("btnFindCar").click();
		Thread.sleep(4000);
	}

	@Given("Select Cars with Photos under Only Show Cars With")
	public void select_Cars_with_Photos_under_Only_Show_Cars_With() throws InterruptedException {
		driver.findElementByXPath("//span[text()='Cars with Photos']").click();
		Thread.sleep(4000);
	}

	@Given("Select Manufacturer as Hyundai --> Creta")
	public void select_Manufacturer_as_Creta() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		WebElement eleHyundai = driver.findElementByXPath("//span[text()=' Hyundai ']");
		js.executeScript("arguments[0].click()", eleHyundai);
		Thread.sleep(3000);
		WebElement eleCreta = driver.findElementByXPath("//span[text()='Creta']");
		js.executeScript("arguments[0].click()", eleCreta);
		Thread.sleep(3000);
	}

	@Given("Select Fuel Type as Petrol")
	public void select_Fuel_Type_as_Petrol() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement eleFuel = driver.findElementByXPath("//div[@name='fuel']/h3");
		js.executeScript("arguments[0].click()", eleFuel);
		Thread.sleep(300);
		WebElement elePetrol = driver.findElementByXPath("//span[text()='Petrol']");
		js.executeScript("arguments[0].click()", elePetrol);
		Thread.sleep(3000);
	}

	@Given("Select Best Match as KM: Low to High")
	public void select_Best_Match_as() throws InterruptedException {
		WebElement eleMatch = driver.findElementById("sort");
		Select sKM=new Select(eleMatch);
		sKM.selectByVisibleText("Price: Low to High");
		Thread.sleep(3000);
	}
	
	@Given("Validate the Cars are listed with KMs Low to High")
	public void validate_the_Cars_are_listed_with_KMs_Low_to_High() {
		List<WebElement> eleCarList = driver.findElementsByXPath("//div[@class='stock-detail']");
		
		
		for (int i = 0; i < eleCarList.size(); i++) {
			int increament=i+1;
			String sCarName = driver.findElementByXPath("(//span[@data-carname-id='carname'])["+increament+"]").getText();
			String sCarKM = driver.findElementByXPath("(//span[@class='slkms vehicle-data__item'])["+increament+"]").getText().replaceAll("[^0-9]+","");
			int iCarKM=Integer.parseInt(sCarKM);
			sCarKMList.add(iCarKM);
			sSortValidateKMList.add(iCarKM);
			sCarNaKM.put(iCarKM, sCarName);
			//System.out.println(sCarName);
			//System.out.println(sCarNaKM);
		}
	
		Collections.sort(sCarKMList);
		if(sCarKMList.get(0)==sSortValidateKMList.get(0))
			System.out.println("Validate the Cars are listed with KMs Low to High Before Sort-"+sSortValidateKMList.get(0)+" and After Sort-"+sCarKMList.get(0));
		else
			System.out.println("Validation Failed the Cars are listed with KMs Low to High Before Sort-"+sSortValidateKMList.get(0)+" and After Sort-"+sCarKMList.get(0));
	}

	@Given("Add the least KM ran car to Wishlist")
	public void add_the_least_KM_ran_car_to_Wishlist() {
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String sLeastKMCarName = sCarNaKM.get(sCarKMList.get(0));
		System.out.println("The Least Km-"+sCarKMList.get(0)+" and the Car Name-"+sLeastKMCarName );
		WebElement eleLeastCarKM = driver.findElementByXPath("//span[text()='"+sLeastKMCarName+"']/preceding::span[2]");
		js.executeScript("arguments[0].click()",eleLeastCarKM);
	}

	@Given("Go to Wishlist and Click on More Details")
	public void go_to_Wishlist_and_Click_on_More_Details() throws InterruptedException {
		driver.findElementByXPath("//li[@class='action-box shortlistBtn']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='More details »']").click();
		Thread.sleep(3000);
	}

	@When("Print all the details under Overview in the Same way as displayed in application")
	public void print_all_the_details_under_Overview_in_the_Same_way_as_displayed_in_application() {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowList=new ArrayList<>();
		allwindowList.addAll(windowHandles);
		driver.switchTo().window(allwindowList.get(1));
		List<WebElement> eleOverView = driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//li");
		System.out.println("Print all the details under Overview ");
		for (WebElement eachOverView : eleOverView) {
			System.out.println(eachOverView.getText());
			
		}
	}

	@Then("Close the browser.")
	public void close_the_browser() {
	    driver.quit();
	}


}
