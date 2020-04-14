package week1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * 1) Open https://www.myntra.com/
2) Mouse over on WOMEN (Actions -> moveToElement
3) Click Jackets & Coats
4) Find the total count of item (top) -> getText -> String

	 String str = driver.findElementByClassName("title-count").getText();
	 split, 
	 String text = str.replaceAll("\\D","") -> String
	 Integer.parseInt(text) -> int

5) Validate the sum of categories count matches
6) Check Coats
7) Click + More option under BRAND	
8) Type MANGO and click checkbox
9) Close the pop-up x
10) Confirm all the Coats are of brand MANGO
    findElements (brand) -> List<WebElement> 
    foreach -> getText of each brand 
    compare > if(condition)
11) Sort by Better Discount
12) Find the price of first displayed item
     findElements (price) -> List<WebElement> 
     get(0) -> WebElement -> getText -> String -> int
13) Mouse over on size of the first item
14) Click on WishList Now
15) Close Browser
 */
public class TC001_Myntra_04142020 {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		WebElement eleLink = driver.findElementByXPath("//a[text()='Women']");
		WebElement eleClick = driver.findElementByXPath("//a[text()='Jackets & Coats']");
		Actions builder=new Actions(driver);
		builder.moveToElement(eleLink).pause(200).click(eleClick).perform();
		Thread.sleep(5000);
		
		String sTotalCount = driver.findElementByXPath("//h1[text()='Coats & Jackets For Women']/following::span").getText();
		//System.out.println(sTotalCount);
		String sReplaceString = sTotalCount.replaceAll("[^0-9]+","");
		//System.out.println(sReplaceString);
		int iTotalCount = Integer.parseInt(sReplaceString);
		System.out.println("TotalCount-"+iTotalCount);
		
		String sJackets = driver.findElementByXPath("//label[text()='Jackets']//span").getText();
		String sJacketCount = sJackets.replaceAll("[^0-9]+","");
		int iJacketCount = Integer.parseInt(sJacketCount);
		System.out.println("Jacket Count-"+iJacketCount);
		
		String sCoats = driver.findElementByXPath("//label[text()='Coats']//span").getText();
		String sCoatsCount = sCoats.replaceAll("[^0-9]+","");
		int iCoatsCount = Integer.parseInt(sCoatsCount);
		System.out.println("Coats Count-"+iCoatsCount);
		
		//Validate sum of the categories count Matches
		int iSumCount=iJacketCount+iCoatsCount;
		if(iTotalCount==iSumCount)
			System.out.println("Validate Sum of the categories-"+iSumCount+" Count Matches TotalCount-"+iTotalCount);
		else
			System.err.println("Validation Failed Sum of the categories-"+iSumCount+" Count Not Matches TotalCount-"+iTotalCount);
		
		
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		Thread.sleep(3000);
		driver.findElementByClassName("brand-more").click();
		Thread.sleep(3000);
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("MANGO");
		Thread.sleep(3000);
		driver.findElementByXPath("(//label[text()='MANGO']//div)[2]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		
		List<WebElement> eleBrands = driver.findElementsByXPath("//div[@class='product-productMetaInfo']/h3");
		int BrandsCount=eleBrands.size();
		int count=0;
		for (WebElement eachBrands : eleBrands) {
			if(eachBrands.getText().equalsIgnoreCase("MANGO"))
				//System.out.println(eachBrands.getText());
				count++;
			
		}
		System.out.println("BrandsCount-"+BrandsCount);
		System.out.println("Brand TotalCount-"+count);
		if(BrandsCount==count)
			System.out.println("Confirm all the Coats are of brand MANGO");
		else
			System.out.println("Confirmation Failed all the Coats are not brand MANGO");
		
		driver.findElementByXPath("//label[text()='30% and above']").click();
		Thread.sleep(3000);
		
		List<WebElement> eleFirstPrice = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		String sFirstPrice = eleFirstPrice.get(0).getText();
		String sFirstDisplayedPrice = sFirstPrice.replaceAll("[^0-9]+","");
		System.out.println("First Displayed Price-"+sFirstDisplayedPrice);
		WebElement eleFirstItem = eleFirstPrice.get(0);
		WebElement eleClickWishList = driver.findElementByXPath("//span[text()='wishlist now']");
		
		Actions WishList=new Actions(driver);
		WishList.moveToElement(eleFirstItem).pause(200).click(eleClickWishList).perform();
		driver.close();
		
	}

}
