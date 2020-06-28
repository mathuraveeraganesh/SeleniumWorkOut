package steps;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Shiksha {
	public static ChromeDriver driver;
	
	HashMap<Double,String> map=new LinkedHashMap<>();
	List<Double> iList=new LinkedList<>();
	
	@Given("Launch the Shiksha WebSite")
	public void launch_the_Shiksha_WebSite() {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://studyabroad.shiksha.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Given("Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges")
	public void mouse_over_on_Colleges_and_click_MS_in_Computer_Science_Engg_under_MS_Colleges() throws InterruptedException {
	    Actions builder=new Actions(driver);
	    WebElement eleCollege = driver.findElementByXPath("//label[text()='Colleges ']");
		builder.moveToElement(eleCollege).pause(200).perform();
		driver.findElementByXPath("//a[text()='MS in Computer Science &Engg']").click();
		Thread.sleep(3000);
	}

	@Given("Click Change course country select box, choose course as BE or Btech and Choose specialization as Computer Science & Engineering")
	public void click_Change_coursecountry_select_box_choose_course_as_BE_Btech_and_Choose_specialization_as_Computer_Science_Engineering() throws InterruptedException {
	    driver.findElementByXPath("//a[@class='change-course']").click();
	    Thread.sleep(3000);
	    Select desiredCourse=new Select(driver.findElementByXPath("//select[@id='desiredCourse']"));
	    desiredCourse.selectByVisibleText("BE/Btech");
	    Thread.sleep(2000);
	    Select Specialization=new Select(driver.findElementByXPath("//select[@id='subCatSelect']"));
	    Specialization.selectByVisibleText("Computer Science & Engineering");
	    Thread.sleep(2000);
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click()",driver
	    		.findElementByXPath("//select[@id='countrySelect']"));
	    js.executeScript("arguments[0].click()",driver
	    		.findElementByXPath("//label[@for='0-flag']/span"));
	    js.executeScript("arguments[0].click()",driver
	    		.findElementByXPath("//label[@for='1-flag']/span"));
	    js.executeScript("arguments[0].click()",driver
	    		.findElementByXPath("//label[@for='5-flag']/span"));
	    Thread.sleep(3000);
	    driver.findElementByXPath("//input[@value='Update']").click();
	    Thread.sleep(8000);
	}

	@Given("In Filters Select IELTS and score as {double} & Below in Exam Accepted")
	public void in_Filters_Select_IELTS_and_score_as_Below_in_Exam_Accepted(Double double1) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()"
				,driver.findElementByXPath("//p[text()='IELTS']/preceding::span[1]"));
	    Thread.sleep(3000);
	    Select examScore=new Select(driver
	    		.findElementByXPath("(//select[@class='score-select-field'])[2]"));
	    examScore.selectByVisibleText("7.5 & below");
	    Thread.sleep(3000);
	}

	@Given("Total Fees as Max {int}L")
	public void total_Fees_as_Max_L(Integer int1) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()"
				,driver.findElementByXPath("//p[text()='Max 20 Lakhs']/preceding::span[1]"));
	    Thread.sleep(3000);
	}

	@Given("Capture the college Names and fees only if it is Engineering  course")
	public void capture_the_college_Names_and_fees_only_if_it_is_Engineering_course() {
	    List<WebElement> eleTotal = driver.findElementsByXPath("//div[@class='course-touple clearwidth']//a[@class='tuple-sub-title']");
	    int increament=1;
	    for (int i = 0; i < eleTotal.size(); i++) {
	    	String sCourseName = driver.findElementByXPath("(//div[@class='course-touple clearwidth']//a[@class='tuple-sub-title'])["+increament+"]").getText();
	    	if(sCourseName.contains("Engineering")) {
	    		String sCollegeName = driver.findElementByXPath("(//div[@class='tuple-title']/p[text()='Sponsored']/following::a[1])["+increament+"]").getText();
	    		String sFees = driver.findElementByXPath("(//div[@class='course-touple clearwidth']//a[@class='tuple-sub-title']/following::p[1])["+increament+"]").getText().replaceAll("[^0-9.]","");              
	    		double dFees = Double.parseDouble(sFees);
	    		iList.add(dFees);
	    		map.put(dFees, sCollegeName);
	    		System.out.println("College Name-"+sCollegeName+" and Fees-"+dFees);
	    		increament++;
	    	}
			
		}
	    Collections.sort(iList,Collections.reverseOrder());
	    System.out.println("Lowest Fees-"+iList.get(0)+"and the College Name-"+map.get(iList.get(0)));
	}

	@Given("Take {int} colleges by Click Next button and go to next page.")
	public void take_colleges_by_Click_Next_button_and_go_to_next_page(Integer int1) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",driver
				.findElementByXPath("//a[text()='Next']"));
	}

	@When("Search the college name in the search box based on low fees")
	public void search_the_college_name_in_the_search_box_based_on_low_fees() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//div[@id='seachTextBox']"));
		driver.findElementByXPath("//input[@id='mainSearchBox']")
		.sendKeys(map.get(iList.get(0)));
		js.executeScript("arguments[0].click()",driver.findElementByXPath("//button[@class='Btn SearchBox-submitBtn']"));
		Thread.sleep(4000);
	}

	@Then("Match the IELTS score, course Title and country from the University Page")
	public void match_the_IELTS_score_course_Title_and_country_from_the_University_Page() {
		
		String[] split = driver.findElementByXPath("(//p[contains(text(),'IELTS')])[1]").getText().split(",");
		
		String replaceAll = split[0].replaceAll("[^0-9.]","");
		
		double dScore = Double.parseDouble(replaceAll);
		if(dScore<7.5)
			System.out.println("Matched the IELTS-"+dScore);
		else
			System.out.println("Matching Failed the IELTS-"+dScore);
		
		String Title = driver.findElementByXPath("//div[@id='allC0']/a").getText();
		if(Title.contains("Engineering"))
			System.out.println("Verified Course Title-"+Title);
		else
			System.out.println("Verification Failed Course Title-"+Title);
		
	    String sCountry = driver.findElementByXPath("//span[@class='loc-icn']").getText().toUpperCase();
	    if(sCountry.contains("UK") || sCountry.contains("CANADA") || sCountry.contains("USA") )
	    	System.out.println("Verified country from the University Page-"+sCountry);
	    else
	    	System.out.println("Verification Failed country from the University Page-"+sCountry);
	}


}
