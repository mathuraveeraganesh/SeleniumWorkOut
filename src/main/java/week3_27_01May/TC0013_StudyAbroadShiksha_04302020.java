package week3_27_01May;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * 30/04/2020
==========
1) Go to https://studyabroad.shiksha.com/
2) Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
3) Select GRE under Exam Accepted and Score 300 & Below 
4) Max 10 Lakhs under 1st year Total fees, USA under countries
5) Select Sort By: Low to high 1st year total fees
6) Click Add to compare of the College having least fees with Public University, Scholarship and Accomadation
7) Select the first college under Compare with similar colleges 
8) Click on Compare College>
9) Select When to Study as 2021
10) Select Preferred Countries as USA
11) Select Level of Study as Masters
12) Select Preferred Course as MS
13) Select Specialization as "Computer Science & Engineering"
14) Click on Sign Up
15) Print all the warning messages displayed on the screen for missed mandatory fields
 */
public class TC0013_StudyAbroadShiksha_04302020 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Go to https://studyabroad.shiksha.com/
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		Actions builder=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver,90);
		
		driver.manage().window().maximize();
		driver.get("https://studyabroad.shiksha.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//2) Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
		WebElement eleCollege = driver.findElementByXPath("//label[text()='Colleges ']");
		builder.moveToElement(eleCollege).pause(200).perform();
		driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
		
		//3) Select GRE under Exam Accepted and Score 300 & Below 
		driver.findElementByXPath("//p[text()='GRE']/preceding::span[1]").click();
		WebElement eleLoading = driver.findElementById("loadingImage");
		wait.until(ExpectedConditions.visibilityOf(eleLoading));
		Thread.sleep(2000);
		
		WebElement eleScore = driver.findElementByClassName("score-select-field");
		Select ScoreSelect=new Select(eleScore);
		ScoreSelect.selectByVisibleText("300 & below");
		//wait.until(ExpectedConditions.visibilityOf(eleLoading));
		Thread.sleep(4000);
		
		//4) Max 10 Lakhs under 1st year Total fees, USA under countries
		driver.findElementByXPath("//p[text()='Max 10 Lakhs']/preceding::span[1]").click();
		//wait.until(ExpectedConditions.visibilityOf(eleLoading));
		Thread.sleep(4000);
		
		//5) Select Sort By: Low to high 1st year total fees
		WebElement eleSort = driver.findElementById("categorySorter");
		Select sort=new Select(eleSort);
		sort.selectByVisibleText("Low to high 1st year total fees");
		//wait.until(ExpectedConditions.visibilityOf(eleLoading));
		Thread.sleep(4000);
		
		//6) Click Add to compare of the College having least fees with Public University, Scholarship and Accomadation
		HashMap<Float,String> map=new LinkedHashMap<>();
		List<Float> isort=new ArrayList<>();
		List<WebElement> eleColleges = driver.findElementsByXPath("//div[@class='course-touple clearwidth']");
		for (int i = 0; i < eleColleges.size(); i++) {
			int increament=i+1;
			
			String sCollegeName = driver.findElementByXPath("(//div[@class='tuple-title']/p[2]/a)["+increament+"]").getText();
			String sFees = driver.findElementByXPath("(//strong[text()=' 1st Year Total Fees']/following::p[1])["+increament+"]").getText().replaceAll("[^0-9.]+","");
			Float iFees=Float.parseFloat(sFees);
		
			 String sPublicuniversity = driver.findElementByXPath("(//strong[text()=' 1st Year Total Fees']/following::p[text()='Public university']/span)["+increament+"]").getAttribute("class");
			 String sScholarship = driver.findElementByXPath("(//strong[text()=' 1st Year Total Fees']/following::p[text()='Scholarship']/span)["+increament+"]").getAttribute("class");
			 String sAccommodation = driver.findElementByXPath("(//strong[text()=' 1st Year Total Fees']/following::p[text()='Accommodation']/span)["+increament+"]").getAttribute("class");
			 
			 if(sPublicuniversity.equalsIgnoreCase("tick-mark") && sScholarship.equalsIgnoreCase("tick-mark") && sAccommodation.equalsIgnoreCase("tick-mark")) {
				 //System.out.println(sPublicuniversity);
				// System.out.println(sScholarship);
				// System.out.println(sAccommodation);			
				map.put(iFees, sCollegeName);
				isort.add(iFees);
			}
		}
		System.out.println(map);
		Collections.sort(isort);
		//System.out.println(isort);
		//College having least fees with Public University, Scholarship and Accomadation
		String sCollegeLeastFees=map.get(isort.get(0));
		System.out.println(sCollegeLeastFees);
		WebElement eleLeasetFees = driver.findElementByXPath("//a[text()='"+sCollegeLeastFees+"']/following::p[text()='Add to compare']");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",eleLeasetFees);
		Thread.sleep(3000);
		
		//7) Select the first college under Compare with similar colleges 
		driver.findElementByXPath("(//a[@class='add-tag-title'])[1]").click();
		Thread.sleep(3000);
		
		//8) Click on Compare College>
		driver.findElementByXPath("//strong[text()='Compare Colleges >']/parent::a").click();
		Thread.sleep(3000);
		
		//9) Select When to Study as 2021
		driver.findElementByXPath("//strong[text()='2021']/preceding::span[1]").click();
		Thread.sleep(200);
		
		//10) Select Preferred Countries as USA
		driver.findElementByXPath("//div[text()='Preferred Countries']/following::div[1]").click();
		driver.findElementByXPath("//label[contains(@for,'USA')]/span").click();
		Thread.sleep(200);
		
		//11) Select Level of Study as Masters
		driver.findElementByXPath("//strong[text()='Masters']/preceding::span[1]").click();
		Thread.sleep(200);
		
		//12) Select Preferred Course as MS
		driver.findElementByXPath("//div[text()='Preferred Course']/following::div[1]").click();
		driver.findElementByXPath("//div[@class='city-lr prefCourse']//li[text()='MS']").click();
		Thread.sleep(2000);
		
		//13) Select Specialization as "Computer Science & Engineering"
		driver.findElementByXPath("//div[text()='Preferred Specialisations']/following::div[1]").click();
		driver.findElementByXPath("//div[@class='city-lr']//li[text()='Computer Science & Engineering']").click();
		Thread.sleep(200);
		
		//14) Click on Sign Up
		driver.findElementById("signup").click();
		Thread.sleep(3000);
		
		//15) Print all the warning messages displayed on the screen for missed mandatory fields
		List<WebElement> eleErrorMsg = driver.findElementsByXPath("//div[@class='helper-text']");
		System.out.println("Print all the warning messages displayed on the screen for missed mandatory fields");
		for (WebElement eachErrorMsg : eleErrorMsg) {
			
			System.out.println(eachErrorMsg.getText());
		}
	}

}
