package util;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils {
	public static WebDriver driver;
	public static Properties prop;

	public static WebDriver init()
	{
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Eclipse Oxygen\\Eclipse_Workspace\\TeaCompany\\src\\main\\java\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Eclipse Oxygen\\Eclipse_Workspace\\TeaCompany\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\Eclipse Oxygen\\Eclipse_Workspace\\TeaCompany\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}



}
