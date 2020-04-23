package week2_20_24Apr;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 21/04/2020
=============
1) Go to https://www.bigbasket.com/
2) mouse over on  Shop by Category 
3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 
4) Click on Boiled & Steam Rice
5) Choose the Brand as bb Royal
6) Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
7) print the price of Rice
8) Click Add button
9) Verify the success message displayed 
10) Type Dal in Search field and enter
12) Go to Toor/Arhar Dal and select 2kg & set Qty 2 
13) Print the price of Dal
14) Click Add button
15) Mouse hover on My Basket 
16) Validate the Sub Total displayed for the selected items
17) Reduce the Quantity of Dal as 1 
18) Validate the Sub Total for the current items
19) Close the Browser
 */
public class TC006_BigBasket_04212020 {

	public static void main(String[] args) throws InterruptedException {
	
	int iRicePrice=0;
	int iDalPrice=0;
	
	//1) Go to https://www.bigbasket.com/
	System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
	ChromeDriver driver= new ChromeDriver();
	WebDriverWait wait=new WebDriverWait(driver, 30);
	driver.manage().window().maximize();
	driver.get("https://www.bigbasket.com/");
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	//2) mouse over on  Shop by Category
	//3)Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS
	WebElement eleShop = driver.findElementByXPath("//a[text()=' Shop by Category ']");
	Actions builder=new Actions(driver);
	builder.moveToElement(eleShop).pause(600)
	.moveToElement(driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]")).pause(600)
	.perform();
	builder.moveToElement(driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]")).perform();
	
	//4) Click on Boiled & Steam Rice
	driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
		
	//5) Choose the Brand as bb Royal
	driver.findElementByXPath("//span[text()='bb Royal']").click();
	WebElement eleLoadingBB = driver.findElementByXPath("//div[@class='pd-overlay']/img");
	wait.until(ExpectedConditions.invisibilityOf(eleLoadingBB));
	Thread.sleep(3000);
	
	//6) Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
	//7) print the price of Rice
	List<WebElement> eleList = driver.findElementsByXPath("//div[@class='item prod-deck row ng-scope']");
	for (int i = 0; i < eleList.size(); i++) {
		int increament=i+1;
		String sRiceName = driver.findElement(By.xpath("(//div[@qa='product_name']//a)["+increament+"]")).getText();
		//System.out.println(sRiceName);
		if (sRiceName.equals("Rice - Boiled, Tamil Ponni")) {
			driver.findElement(By.xpath("(//div[@class='btn-group btn-input clearfix ng-scope']//button[@class='btn btn-default dropdown-toggle form-control'])["+increament+"]")).click();
			driver.findElement(By.xpath("(//ul[@class='dropdown-menu drop-select']/following::span[text()='5 kg'])")).click();
			String sPrice = eleList.get(i).findElement(By.xpath("(//span[@class='discnt-price'])["+increament+"]")).getText().replaceAll("[^0-9]","");
			iRicePrice = Integer.parseInt(sPrice);
			//7) print the price of Rice
			System.out.println("Price of the Rice-"+sPrice);
			
			//8) Click Add button
			driver.findElementByXPath("(//button[@qa='add'])["+increament+"]").click();
			driver.findElementByXPath("//a[text()='Continue']").click();
			
		}
	}
	

	
	//9) Verify the success message displayed 
	//10) Type Dal in Search field and enter
	driver.findElementByXPath("//input[@qa='searchBar']").sendKeys("Dal");
	Thread.sleep(3000);
	
	//12) Go to Toor/Arhar Dal and select 2kg & set Qty 2 
	List<WebElement> eleDal = driver.findElementsByXPath("//p[@qa='prodNameAS']");
	for (int i = 0; i < eleDal.size(); i++) {
		int increamentDal=i+1;
		String sDalType = driver.findElementByXPath("(//p[@qa='prodNameAS'])["+increamentDal+"]").getText().replaceAll("[^a-zA-Z]+","");
		//System.out.println(sDalType);//Toor Dal/Arhar Dal - Desi
		String sKg = driver.findElementByXPath("(//div[@qa='pcsAS'])["+increamentDal+"]").getText(); //1 kg
		if(sDalType.equals("ToorDalArharDalDesi") && sKg.equals("1 kg") ) {
			
			//13) Print the price of Dal
			String sDalPrice = driver.findElementByXPath("(//span[@qa='priceAS'])["+increamentDal+"]").getText().replaceAll("[^0-9]","");
			 double dDalPrice = Double.parseDouble(sDalPrice);
			System.out.println("Price of Dal-"+sDalPrice);
			driver.findElementByXPath("(//input[@qa='qtyAS'])["+increamentDal+"]").clear();
			driver.findElementByXPath("(//input[@qa='qtyAS'])["+increamentDal+"]").sendKeys("2");
			
			//14) Click Add button
			driver.findElementByXPath("(//button[@qa='addBtnAS'])["+increamentDal+"]").click();
		}
	}
		
	//15) Mouse hover on My Basket 
	WebElement eleMyBasket = driver.findElementByXPath("//span[text()='My Basket']");
	builder.moveToElement(eleMyBasket).pause(300).perform();
	
	//16) Validate the Sub Total displayed for the selected items
	Thread.sleep(6000);
	 String sSubTotalSelected = driver.findElementByXPath("//span[@qa='subTotalMB']").getText();
	 //System.out.println("The Sub Total"+sSubTotalSelected);
	  
	double dSubTotalSelected = Double.parseDouble(sSubTotalSelected);
	List<WebElement> eleBacket = driver.findElementsByXPath("//a[@qa='prodNameMB']");
	double iSelectedItems=0.0;
	for (int i = 0; i < eleBacket.size(); i++) {
		int increament=i+1;
		driver.findElementByXPath("(//a[@qa='prodNameMB'])["+increament+"]");
		String sPrice = driver.findElementByXPath("(//span[@qa='priceMB'])["+increament+"]").getText();
		String sMultiple = driver.findElementByXPath("(//div[@qa='pcsMB'])["+increament+"]").getText().substring(0,1);
		double dMultiple = Double.parseDouble(sMultiple);
		double dPrice=  Double.parseDouble(sPrice);
		//double iMultiple = Double.parseDouble(sMultiple);
		iSelectedItems=iSelectedItems+(dPrice*dMultiple);
		
	}
	
	 if(dSubTotalSelected==iSelectedItems)
		 System.out.println("Validated the Sub Total displayed- "+dSubTotalSelected+" for the selected items-"+iSelectedItems);
	 else
		 System.out.println("Validated Failed the Sub Total displayed- "+dSubTotalSelected+" for the selected items-"+iSelectedItems);
	
	//17) Reduce the Quantity of Dal as 1 
	//18) Validate the Sub Total for the current items
	 
	 List<WebElement> eleBacket2 = driver.findElementsByXPath("//a[@qa='prodNameMB']");
	double iSelectedItems2=0.0;
	for (int i = 0; i < eleBacket2.size(); i++) {
		int increament=i+1;
		String sProduct = driver.findElementByXPath("(//a[@qa='prodNameMB'])["+increament+"]").getText();
		//System.out.println(sProduct);
		if(sProduct.contains("Dal")){
			driver.findElementByXPath("(//button[@qa='decQtyMB'])["+increament+"]").click();
			Thread.sleep(8000);
		}
		String sPrice = driver.findElementByXPath("(//span[@qa='priceMB'])["+increament+"]").getText();
		String sMultiple = driver.findElementByXPath("(//div[@qa='pcsMB'])["+increament+"]").getText().substring(0,1);
		double dMultiple = Double.parseDouble(sMultiple);
		double dPrice=  Double.parseDouble(sPrice);
		
		iSelectedItems2=iSelectedItems2+(dPrice*dMultiple);
			
		}
	String sSubTotalSelected2 = driver.findElementByXPath("//span[@qa='subTotalMB']").getText();
	
	  
	double dSubTotalSelected2 = Double.parseDouble(sSubTotalSelected2);
	if(dSubTotalSelected2==iSelectedItems2)
		 System.out.println("Validated the Sub Total displayed- "+dSubTotalSelected2+" for the Current items-"+iSelectedItems2);
	 else
		 System.out.println("Validated Failed the Sub Total displayed- "+dSubTotalSelected2+" for the Current items-"+iSelectedItems2);
	
	

	driver.close();
	
	
 
	}

}
