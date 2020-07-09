package util;


import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperMethods {
	
	public void getScreenshot(WebDriver driver, String fileName) throws Exception
	{
		System.out.println("In GetScreenshot Method");
		TakesScreenshot ts = (TakesScreenshot) driver;
		System.out.println("Before GetScreenshot");
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println("After Screenshot");
		FileUtils.copyFile(source, new File("D:\\Eclipse Oxygen\\Eclipse_Workspace\\TeaCompany\\Screenshots\\"+fileName+".jpg"));
	}
}
