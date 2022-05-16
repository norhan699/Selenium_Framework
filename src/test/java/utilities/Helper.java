package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
//Method to take screen shot when test case fails
	public static void captureScreenshot(WebDriver driver, String ScreenshotName) {//static so call it like this-->Helper.captureScreenshot
		Path destination = Paths.get("./Screenshots", ScreenshotName+".png");
		try {
			Files.createDirectories(destination.getParent());
			FileOutputStream out = new FileOutputStream(destination.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			System.out.println("Exception while taking screen shot"+e.getMessage());
		}
	}
}
