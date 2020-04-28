package week3_27_01May;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * 27/04/2020
============
1) https://www.justdial.com/
2) Set the Location as Chennai
3) Click Auto Care in the left menu
4) Click Car Repair
5) Click Car Brand as Hyundai
6) Click Make as Hyundai Xcent
7) Click on Location and Enter Porur
8) Select Porur from the dropdown list
9) Select Distance starting from 1 km
10) Identify all the Service Center having Ratings >=4.5 and Votes >=50
11) Save all the Service Center name and Phone number matching the above condition in excel 
12) Close the browser
 */
public class TC0010_JustDial_04272020 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) https://www.justdial.com/
		System.setProperty("webdriver.chrome.driver","./drivers/ChromeDriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.justdial.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//2) Set the Location as Chennai
		driver.findElementById("city").clear();
		driver.findElementById("city").sendKeys("Chennai");
		Thread.sleep(200);
		driver.findElementByXPath("//a[@id='Chennai']").click();
		
		//3) Click Auto Care in the left menu
		driver.findElementByXPath("//span[text()='Auto care']/parent::a").click();
		Thread.sleep(4000);
		
		//4) Click Car Repair
		driver.findElementByXPath("//span[text()='Car Repair']/parent::a").click();
		Thread.sleep(2000);
		
		//5) Click Car Brand as Hyundai
		driver.findElementByXPath("//span[text()='Hyundai']/parent::a").click();
		Thread.sleep(2000);
		
		//6) Click Make as Hyundai Xcent
		driver.findElementByXPath("//span[text()='Hyundai Xcent']/parent::a").click();
		Thread.sleep(1000);
		
		/*//7) Click on Location and Enter Porur
		driver.findElementByXPath("//a[text()='Location']").click();
		Thread.sleep(2000);
		
		//8) Select Porur from the dropdown list
		driver.findElementById("sortbydist").sendKeys("Porur");
		Thread.sleep(200);
		driver.findElementByXPath("//a[contains(@id,'Porur')]").click();
		
		//9) Select Distance starting from 1 km
		driver.findElementByXPath("//span[text()='Distance ']").click();
		Thread.sleep(200);
		driver.findElementByXPath("//a[text()='1 km']").click();
		Thread.sleep(2000);*/
		
		//10) Identify all the Service Center having Ratings >=4.5 and Votes >=50
		List<WebElement> eleStore = driver.findElementsByXPath("//span[@class='green-box']");
		HashMap<Integer,String> map=new LinkedHashMap<>();
		for (int i = 0; i < eleStore.size(); i++) {
			int increament=i+1;
			
			String sRatings=driver.findElementByXPath("(//span[@class='green-box'])["+increament+"]").getText();
			double dRatings=Double.parseDouble(sRatings);
			String sVotes = driver.findElementByXPath("(//p[@class='newrtings ']/a/span[3])["+increament+"]").getText().replaceAll("[^0-9]+","");
			int iVotes = Integer.parseInt(sVotes);
			if(dRatings>=4.5 && iVotes>=50) {
				String sServiceCenter = driver.findElementByXPath("(//span[@class='lng_cont_name'])["+increament+"]").getText();
				//System.out.println(sServiceCenter);
				map.put(increament,sServiceCenter);
			}
				
		}
		System.out.println(map);
		
		//11) Save all the Service Center name and Phone number matching the above condition in excel
		
		 // Blank workbook 
        XSSFWorkbook workbook = new XSSFWorkbook(); 
  
        // Create a blank sheet 
        XSSFSheet sheet = workbook.createSheet("ServiceCenter Details");
        
        // This data needs to be written (Object[]) 
        Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
        data.put("1", new Object[]{ "S.No", "Service Center", "Phone Number" }); 
        for (Entry EachMap :map.entrySet()) {
			
		}
        data.put("2", new Object[]{ 1,map.get(1),"9876540645" }); 
        
     // Iterate over data and write to sheet 
        Set<String> keyset = data.keySet(); 
        int rownum = 0; 
        for (String key : keyset) { 
            // this creates a new row in the sheet 
            Row row = sheet.createRow(rownum++); 
            Object[] objArr = data.get(key); 
            int cellnum = 0; 
            for (Object obj : objArr) { 
                // this line creates a cell in the next column of that row 
                Cell cell = row.createCell(cellnum++); 
                if (obj instanceof String) 
                    cell.setCellValue((String)obj); 
                else if (obj instanceof Integer) 
                    cell.setCellValue((Integer)obj); 
            } 
        } 
        try { 
            // this Writes the workbook gfgcontribute 
            FileOutputStream out = new FileOutputStream(new File("Service Center Details.xlsx")); 
            workbook.write(out); 
            out.close(); 
            System.out.println("Service Center Details.xlsx written successfully on disk."); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
 
	
}
