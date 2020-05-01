package week3_27_01May;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 29/04/2020
==========
1) Go to https://www.carwale.com/
2) Click on Used
3) Select the City as Chennai
4) Select budget min (8L) and max(12L) and Click Search
5) Select Cars with Photos under Only Show Cars With
6) Select Manufacturer as "Hyundai" --> Creta
7) Select Fuel Type as Petrol
8) Select Best Match as "KM: Low to High"
9) Validate the Cars are listed with KMs Low to High
10) Add the least KM ran car to Wishlist
11) Go to Wishlist and Click on More Details
12) Print all the details under Overview 
13) Close the browser.
 */

public class TC0012_CarWale_04292020 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://www.carwale.com/
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		
	
		Actions builder=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,30);
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		
		driver.manage().window().maximize();
		driver.get("https://www.carwale.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//2) Click on Used
		driver.findElementByXPath("//li[@data-tabs='usedCars']").click();
		
		//3) Select the City as Chennai
		driver.findElementByXPath("//input[@id='usedCarsList']").sendKeys("Chennai");
		Thread.sleep(200);
		driver.findElementByXPath("//a[@cityname='chennai,tamilnadu']").click();
		Thread.sleep(200);
		
		//4) Select budget min (8L) and max(12L) and Click Search
		driver.findElementById("minInput").sendKeys("8",Keys.TAB);
		driver.findElementById("maxInput").sendKeys("12",Keys.TAB);
		Thread.sleep(2000);
		driver.findElementById("btnFindCar").click();
		Thread.sleep(4000);
		
		//5) Select Cars with Photos under Only Show Cars With
		driver.findElementByXPath("//span[text()='Cars with Photos']").click();
		Thread.sleep(4000);
		
		//6) Select Manufacturer as "Hyundai" --> Creta
		WebElement eleHyundai = driver.findElementByXPath("//span[text()=' Hyundai ']");
		js.executeScript("arguments[0].click()", eleHyundai);
		Thread.sleep(3000);
		WebElement eleCreta = driver.findElementByXPath("//span[text()='Creta']");
		js.executeScript("arguments[0].click()", eleCreta);
		Thread.sleep(3000);
		
		//7) Select Fuel Type as Petrol
		WebElement eleFuel = driver.findElementByXPath("//div[@name='fuel']/h3");
		js.executeScript("arguments[0].click()", eleFuel);
		Thread.sleep(300);
		WebElement elePetrol = driver.findElementByXPath("//span[text()='Petrol']");
		js.executeScript("arguments[0].click()", elePetrol);
		Thread.sleep(3000);
		
		//8) Select Best Match as "KM: Low to High"
		WebElement eleMatch = driver.findElementById("sort");
		Select sKM=new Select(eleMatch);
		sKM.selectByVisibleText("Price: Low to High");
		Thread.sleep(3000);
		
		//9) Validate the Cars are listed with KMs Low to High
		List<WebElement> eleCarList = driver.findElementsByXPath("//div[@class='stock-detail']");
		List<Integer> sCarKMList=new ArrayList<>();
		List<Integer> sSortValidateKMList=new ArrayList<>();
		HashMap<Integer,String> sCarNaKM=new LinkedHashMap<>();
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
		
		//10) Add the least KM ran car to Wishlist
		String sLeastKMCarName = sCarNaKM.get(sCarKMList.get(0));
		System.out.println("The Least Km-"+sCarKMList.get(0)+" and the Car Name-"+sLeastKMCarName );
		WebElement eleLeastCarKM = driver.findElementByXPath("//span[text()='"+sLeastKMCarName+"']/preceding::span[1]");
		js.executeScript("arguments[0].click()",eleLeastCarKM);
		
		//11) Go to Wishlist and Click on More Details
		driver.findElementByXPath("//li[@class='action-box shortlistBtn']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='More details »']").click();
		Thread.sleep(3000);
		
		//12) Print all the details under Overview 
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindowList=new ArrayList<>();
		allwindowList.addAll(windowHandles);
		driver.switchTo().window(allwindowList.get(1));
		List<WebElement> eleOverView = driver.findElementsByXPath("//div[@class='overview-list padding-bottom10']//li");
		System.out.println("Print all the details under Overview ");
		for (WebElement eachOverView : eleOverView) {
			System.out.println(eachOverView.getText());
			
		}
		//13) Close the browser.
		driver.quit();
	}
	
	
	
	
	
}
