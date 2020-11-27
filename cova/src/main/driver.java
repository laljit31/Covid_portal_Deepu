package main;

import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class driver {
	
	//static WebDriver driver=new ChromeDriver(); 
	

	public static void main(String[] args) throws Exception {
		
		

        // System Property for Chrome Driver   
		System.setProperty("webdriver.chrome.driver", "C:\\TransportPlus\\workspace\\selenium\\jar\\chromedriver.exe");  
       
          // Instantiate a ChromeDriver class.     
		WebDriver driver=new ChromeDriver();  
     
		//WebDriverWait wait = new WebDriverWait(driver, 15);
		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
		
     
		//Maximize the browser  
		driver.manage().window().maximize();  
       
		// Launch Website  
		driver.navigate().to("http://cova.punjab.gov.in/");  
     
		textbox(driver, "//input[@type='text']", "dcmohali");
       
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("dcmohali");
		//Thread.sleep(1000);
     
		textbox(driver, "//input[@type='password']", "dcmoh@123");
		
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("dcmoh@123");
		
		JOptionPane.showMessageDialog(null, "Start Again");
		
		click(driver, "//button[@ng-disabled='loginForm.$invalid']");
		//driver.findElement(By.xpath("//button[@ng-disabled='loginForm.$invalid']")).click();
     
        // Click on the data management button 
		//Thread.sleep(3000);
		
		JOptionPane.showMessageDialog(null, "Start Again");
		
		//driver.findElement(By.xpath("//a[@id='dropdownSubMenu3']")).click();
		click(driver, "//a[@id='dropdownSubMenu3']");
		
		//Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//a[@href='/idsppatient']")).click();
		click(driver, "//a[@href='/idsppatient']");
     
		//Thread.sleep(3000);
		//JOptionPane.showMessageDialog(null, "Start Again");
		
		dropdown(driver,"//select[@name='traceable']", "Traceable");
		
		dropdown(driver,"//select[@name='id_type']", "SRF ID");
		
		textbox(driver,"//input[@name='id_number']","112122");
	
		driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
		
		dropdown(driver,"//select[@name='icmr_category1']", "Symptomatic international traveller in last 14 days");
		
		dropdown(driver,"//select[@name='patient_region']", "Rural");
		
		textbox(driver,"//input[@name='patient_name']", "CHARAN DASS");
		
		
		
		dropdown(driver,"//select[@name='patient_sex']", "Male");
		
		textbox(driver,"//input[@name='patient_age']","60");
		
		textbox(driver,"//input[@name='patient_mobile']","6284183779");
		
		
		dropdown(driver,"//select[@name='patient_district_id']", "KAPURTHALA");
		
		dropdown(driver, "//select[@name='patient_sub_district_id']", "Bhulath");
		
		dropdown(driver, "//select[@ng-model='patientModel.patient_block']", "Nadala");
		
		textbox(driver,"//input[@id='patient_village_id']","DHARIWAL"); 
		
		textbox(driver,"//input[@name='patient_address']","VPO DHARIWAL");
		
		dropdown(driver,"//select[@name='patient_occupation']", "Health Worker");
		
		textbox(driver,"//input[@name='patient_designation']","Test");
		
		dropdown(driver,"//select[@ng-change='activechange()']", "Active (Will impact bed occupancy count)");
		
		String travel="No";
		dropdown(driver,"//select[@ng-change='changecat3fun();']",travel);
		
		
		if("Yes".equalsIgnoreCase(travel)) {
			dropdown(driver,"//select[@name ='travel_type']","International");
			textbox(driver, "//input[@name ='country_state_name']", "Test");
			textbox(driver, "//input[@name ='date_of_return']", "2020-11-20");
			
					
		}
		String comorbid="No";
		dropdown(driver, "//select[@name ='comorbid_condition']", comorbid);
		
		if("Yes".equalsIgnoreCase(comorbid)) {
			
		dropdown(driver, "//div[@selected-model='br_comorbid_model']//button[@ng-class='settings.buttonClasses']", "value");
		}
		
		String type_admission="Symptomatic";
		dropdown(driver, "//select[@name='type_admission']", type_admission);
		
		if("Symptomatic".equalsIgnoreCase(type_admission)) {
			
			date(driver, "date_of_symptoms", "2020-11-20");
			
			//dropdown(driver, "//div[@selected-model='br_symptoms_model']//button[@ng-class='settings.buttonClasses']", "value");
			dropdown(driver, "//select[@name='type_symptoms']", "Mild");
			dropdown(driver, "//select[@name='nature_symptoms']", "SARI");		
			
		}
		
		
		String type_case="Contact case of Other Positive cases";
		
		dropdown(driver, "//select[@name='type_case']", type_case);
		
		if("Contact case of Other Positive cases".equalsIgnoreCase(type_case)) {
			textbox(driver, "//input[@name='name_positive_case']", "Test");
			
			textbox(driver, "//input[@name='srf_id_positive_case']", "Test");
			
			textbox(driver, "//input[@name='contact_patient_mobile']", "9876126262");
				
		}
		
		dropdown(driver, "//select[@name='is_member_special_event']", "Yes");
		
		date(driver, "date_of_sample_collection", "2020-11-20");
		
		dropdown(driver, "//select[@name='lab_type']", "Government");
		dropdown(driver, "//select[@name='lab_name']", "Government Medical College, Amritsar");
		
		date(driver, "date_tested_positive", "2020-11-20");
		
		dropdown(driver, "//select[@name='test_type']", "CBNAAT");
		
		String type_isolation="Institutional Isolation ";
		
		dropdown(driver, "//select[@name='type_isolation']", type_isolation);
		
		if ("Institutional Isolation ".equalsIgnoreCase(type_isolation)){
			
			dropdown(driver, "//select[@name='institutional_level']", "Level 1");
			textbox(driver, "//input[@name='bed_number']", "12344");
			dropdown(driver, "//select[@name='bed_type']", "L1 - (CCC)");
			dropdown(driver, "//select[@name='bed_still_occupied']", "Yes");
			dropdown(driver, "//select[@name='institutional_type']", "Private");
			dropdown(driver, "//select[@name='institutional_facility']", "NRI Hospital ( Level 1 - PRIVATE HOSPITAL)");
			Thread.sleep(2000);
			
			
			
		}
		else if ("Refer to Other District Institutional Isolation ".equalsIgnoreCase(type_isolation)){
			
			dropdown(driver, "//select[@name='admitted_district_Id']", "S.A.S Nagar");
			dropdown(driver, "//select[@name='institutional_level']", "Level 2");
			
			textbox(driver, "//input[@name='bed_number']", "12344");
			dropdown(driver, "//select[@name='bed_type']", "COVID BED WITH OXYGEN");
			dropdown(driver, "//select[@name='bed_still_occupied']", "Yes");
			dropdown(driver, "//select[@name='institutional_type']", "Private");
			dropdown(driver, "//select[@name='institutional_facility']", "CHC Dhakoli ( Level 2 - GOVT. HOSPITAL)");
			Thread.sleep(2000);
			
			
		}
		
		
		
		date(driver, "date_of_isolation", "2020-11-10");
		
		String outcome="Recovered";
		
		dropdown(driver, "//div[@class='col-sm-4']//select[@ng-model='patientModel.outcome']", outcome);
		
		if("Death".equalsIgnoreCase(outcome)||"Discharged".equalsIgnoreCase(outcome)) {
			
			dropdown(driver, "//select[@name='time_of_isolation_Id']", "24 - 48 hours ");
			dropdown(driver, "//div[@class='col-sm-4']//select[@name='time_of_outcome_Id']", "48 - 72 hours ");
			
			
		}
		
		else if("Transfer".equalsIgnoreCase(outcome)) {
			
			dropdown(driver, "//select[@name='patient_transfer_type_id']", "Intra-State");
			dropdown(driver, "//select[@name='patient_transfer_district_id']", "AMRITSAR");
			
		}
		
		date(driver, "date_outcome", "2020-11-10");
		
		
		System.out.println("Completed");
		
		
		
		  
   

	}
	
	public static void dropdown(WebDriver driver, String xpath, String value) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		Select patientTraceable=new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))));
		patientTraceable.selectByVisibleText(value);
		Thread.sleep(1000);
	 
		
	}
	public static void textbox(WebDriver driver, String xpath, String value) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		
		WebElement textbox= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		textbox.clear();
		textbox.sendKeys(value);
		Thread.sleep(1000);
	 
		
	}
public static void click(WebDriver driver, String xpath) throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement button= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
		button.click();
		Thread.sleep(1000);	 
		
	}

public static void date(WebDriver driver, String xpath, String value) throws InterruptedException {
	

	((JavascriptExecutor)driver).executeScript ("document.getElementById('"+xpath+"').removeAttribute('readonly',0);"); 
	WebElement date= driver.findElement(By.id(xpath));
	date.clear();
	date.sendKeys(value); 
	date.sendKeys(Keys.TAB);
	Thread.sleep(1000);	 
}

}
