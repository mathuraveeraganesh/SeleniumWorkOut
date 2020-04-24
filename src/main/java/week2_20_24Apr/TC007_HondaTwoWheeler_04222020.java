package week2_20_24Apr;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/*
 * 22/04/2020
=============
1) Go to https://www.honda2wheelersindia.com/
2) Click on scooters and click dio
3) Click on Specifications and mouseover on ENGINE
4) Get Displacement value
5) Go to Scooters and click Activa 125
6) Click on Specifications and mouseover on ENGINE
7) Get Displacement value
8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
9) Click FAQ from Menu 
10) Click Activa 125 BS-VI under Browse By Product
11) Click  Vehicle Price 
12) Make sure Activa 125 BS-VI selected and click submit
13) click the price link
14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
15) Click Search
16) Print all the 3 models and their prices
17) Close the Browser
 */
public class TC007_HondaTwoWheeler_04222020 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		List<Double> list=new LinkedList<>();
		Map<Double,String> map=new LinkedHashMap<Double, String>();
		
		//1) Go to https://www.honda2wheelersindia.com/
		driver.get("https://www.honda2wheelersindia.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
		//2) Click on scooters and click dio
		driver.findElementByXPath("//button[@class='close']").click();
		driver.findElementById("link_Scooter").click();
		Thread.sleep(300);
		String sScotter1 = driver.findElementByXPath("//a[@href='/dio-BS-VI/']").getAttribute("href");
		String[] aScotter1 = sScotter1.split("/");
		String sScooterName1=aScotter1[3];
		
		driver.findElementByXPath("//a[@href='/dio-BS-VI/']/img").click();
		
		//3) Click on Specifications and mouseover on ENGINE
		driver.findElementByLinkText("Specifications").click();
		Thread.sleep(3000);
		Actions builder=new Actions(driver);
		builder.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).pause(200).perform();
		
		//4) Get Displacement value
		String sDioDisplacementval = driver.findElementByXPath("//span[text()='Displacement']/following::span").getText();
		System.out.println("Dio Displacement value-"+sDioDisplacementval);
		String sDioReplace = sDioDisplacementval.replaceAll("[^0-9]+","");
		double dScooter1CC = Double.parseDouble(sDioReplace);
		list.add(dScooter1CC);
		map.put(dScooter1CC, sScooterName1);
		
		//5) Go to Scooters and click Activa 125
		driver.findElementById("link_Scooter").click();
		String sScooter2 = driver.findElementByXPath("//a[@href='/activa125-BS-VI/']").getAttribute("href");
		String[] aScooter2 = sScooter2.split("/");
		String sScooterName2=aScooter2[3];
		
		
		driver.findElementByXPath("//a[@href='/activa125-BS-VI/']/img").click();
		
		//6) Click on Specifications and mouseover on ENGINE
		driver.findElementByLinkText("Specifications").click();
		Thread.sleep(3000);
		builder.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).pause(200).perform();
		
		//7) Get Displacement value
		String sActivaDisplacementval = driver.findElementByXPath("//span[text()='Displacement']/following::span").getText();
		System.out.println("Activa 125 Displacement value-"+sActivaDisplacementval);
		String sActivaReplace = sDioDisplacementval.replaceAll("[^0-9]+","");
		double dScooter2CC = Double.parseDouble(sActivaReplace);
		list.add(dScooter2CC);
		map.put(dScooter2CC, sScooterName2);
		
		//8) Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.
		Collections.sort(list, Collections.reverseOrder());
		String ScooterName = map.get(list.get(0));
		System.out.println(ScooterName+"-Scotter have Better Displayment");
		
		//9) Click FAQ from Menu
		driver.findElementByXPath("//a[text()='FAQ']").click();
		Thread.sleep(6000);
		
		//10) Click Activa 125 BS-VI under Browse By Product
		driver.findElementByXPath("//a[text()='Activa 125 BS-VI']").click();
		Thread.sleep(5000);
		
		//11) Click  Vehicle Price 
		driver.findElementByXPath("//a[text()=' Vehicle Price']").click();
		Thread.sleep(2000);
		
		//12) Make sure Activa 125 BS-VI selected and click submit
		String sSelected = driver.findElementByXPath("//select[@id='ModelID6']/option[@selected='selected']").getText();
		if(sSelected.equals("Activa 125 BS-VI")) {
			System.out.println("Activa 125 BS-VI selected Sucessfully");
			driver.findElementByXPath("//button[@id='submit6']").click();
			Thread.sleep(2000);		
		}

		else
			System.out.println("Activa 125 BS-VI selected Unsucessfully");
		
		//13) click the price link
		driver.findElementByXPath("//a[contains(text(),'Activa 125 BS-VI')]").click();
		Thread.sleep(6000);
		
		//14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
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
		
		//15) Click Search
		driver.findElementByXPath("//button[text()='Search']").click();
		Thread.sleep(3000);
		
		//16) Print all the 3 models and their prices
		WebElement eleTable = driver.findElementById("gvshow");
		List<WebElement> eleRow = eleTable.findElements(By.tagName("tr"));
		for (int i = 0; i < eleRow.size(); i++) {
			List<WebElement> eleData = eleRow.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < eleData.size(); j++) {
				System.out.println(eleData.get(j).getText());
			}
			
		}
		
		//17) Close the Browser
		driver.quit();
		
	}

}
