package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_base {
	public static WebDriver driver;
	public static Properties prop;

	public  Test_base() throws IOException {
		try
		{
			prop =new Properties();
			FileInputStream ip = new FileInputStream("E:\\Eclipse JS Project\\CRMFA\\src\\main\\java\\Resouurce\\Config.properties");
			prop.load(ip);}
		catch(FileNotFoundException e) {
			e.printStackTrace();}
	}
	
	public static void intialize() {
		
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse JS Project\\CRMFA\\Driver85\\chromedriver.exe");
	        driver = new ChromeDriver();
	        }
		else {
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse JS Project\\CRMFA\\Driver85\\chromedriver.exe");
	        driver = new ChromeDriver();}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	}
	
	}
