package steps;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.id.Ketika;

public class Naukri {
	public static ChromeDriver driver;
	@Given("Open naukri.com")
	public void open_naukri_com() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Thread.sleep(3000);
	}

	@Given("Get the company names from each pop up window and close it")
	public void get_the_company_names_from_each_pop_up_window_and_close_it() {
	    Set<String> windowHandles = driver.getWindowHandles();
	    List<String> allwindowlist=new ArrayList<>();
	    allwindowlist.addAll(windowHandles);
	    driver.switchTo().window(allwindowlist.get(1));
	    System.out.println("First Poup Company Name-"+driver.findElementByXPath("(//img)[1]").getAttribute("alt"));
	    driver.close();
	    driver.switchTo().window(allwindowlist.get(2));
	    System.out.println("Second Poup Company Name-"+driver.findElementByXPath("(//img)[1]").getAttribute("alt"));
	    driver.close();
	    driver.switchTo().window(allwindowlist.get(0));
	}

	@When("Now, click on the upload cv button and upload some random image.")
	public void now_click_on_the_upload_cv_button_and_upload_some_random_image() throws AWTException {
	    String filePath="C:\\Ganesh\\SeleniumAdv2019\\Selenium\\SeleniumWorkOut\\OrderItem.png";
	    Robot rb=new Robot();
	    driver.findElementById("wdgt-file-upload").click();
	    rb.setAutoDelay(2000);
	    StringSelection sc=new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sc, null);
	    rb.keyPress(KeyEvent.VK_CONTROL);
	    rb.keyPress(KeyEvent.VK_V);
	    rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	    
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    
	}

	@Then("Get the error message printed")
	public void get_the_error_message_printed() {
	    String sErrormsg = driver.findElementByXPath("//div[@class='error-header-desc error']").getText();
	    System.out.println("Error Message -"+sErrormsg);
	}
}
