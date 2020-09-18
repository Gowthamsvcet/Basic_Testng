package crmfa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testBase.Test_base;

public class Crfma extends Test_base {
		String month="December, 2020";
public Crfma() throws IOException 
	{ super();}
@BeforeMethod
	public void Login() {
		intialize();
        String div = driver.getTitle();
        System.out.println(div);
	}
@Test
	public void Login1() throws IOException {
         WebElement ele = driver.findElement(By.cssSelector("input#username"));
			ele.sendKeys(prop.getProperty("username"));
		 WebElement Pass = driver.findElement(By.cssSelector("input#password"));
			Pass.sendKeys(prop.getProperty("password"));
		 WebElement button = driver.findElement(By.cssSelector("input.decorativeSubmit"));
			button.click();	
		driver.findElement(By.xpath("//a[contains(text(), 'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Opportunities')]")).click();
		//driver.findElement(By.id("ext-gen55")).click();
		//driver.findElement(By.name("accountName")).sendKeys("Gowtham");
		driver.findElement(By.xpath("//a[contains(text(), 'My Opportunities')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(), 'Create Lead')]")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Gowtham");
		WebElement dropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select mydrop = new Select(dropdown);
		mydrop.selectByVisibleText("Website");
		driver.findElement(By.xpath("//img[@alt=\"Lookup\"]")).click();
		String mainwindow = driver.getWindowHandle();
		System.out.printf( "Here parent Window Id", mainwindow);
		 Set <String> set = driver.getWindowHandles();
		 /*Iterator<String> IA = set.iterator();
		 while (IA.hasNext()) {
			 String childwindow = IA.next();
			 if(!mainwindow.equals(childwindow)) {
				  driver.switchTo().window(childwindow);
				  driver.findElement(By.xpath("//span[text()=\"Phone\"]")).click();
				  System.out.println(childwindow);
				  driver.findElement(By.xpath("//a[text()=\"accountlimit100\"]")).click();
				  
				  //driver.close();
				  }
		 }
				 driver.switchTo().window(mainwindow);*/
				 
		 ArrayList<String> tabs = new ArrayList<String>(set);
		 {
		    driver.switchTo().window(tabs.get(1));
		    driver.findElement(By.xpath("//span[text()=\"Phone\"]")).click();
			//System.out.println();
			driver.findElement(By.xpath("//a[text()=\"accountlimit100\"]")).click();
			
			driver.switchTo().window(mainwindow);
		 }
	    driver.findElement(By.xpath("//img[@id=\"createLeadForm_birthDate-button\"]")).click();
				 
		while(true) {
			String Cale = driver.findElement(By.xpath("//td[@class=\"title\"]")).getText();
			File Screen	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screen, new File("./Screenshot/Crmfa.png"));
			System.out.println(Cale);
			if(Cale.equals(month)) {
				break;
			}
			else {
				driver.findElement(By.xpath("//table/thead/tr[2]/td[4]")).click();
			     }
		 }
		driver.findElement(By.xpath("//td[text()=\"22\"]")).click();
		
		File Screen	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Screen, new File("./Screenshot/Crmfa.png"));
		}
		
        
	@AfterMethod
	public void Close() {

		driver.close();
	}
}
