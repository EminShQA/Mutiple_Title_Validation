package core;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Selenium_multiple_args {
	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("No arguments!");
			System.exit(1);
		}

		WebDriver driver = new HtmlUnitDriver();
		
		for (int i = 0; i < args.length; i++) {

			String text_case_id = "WT-TP-001.0" + (i + 1);
			String param[] = args[i].split("\\;");

			String url = param[0];
			String expected_result = param[1];
			
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			String actual_result = driver.getTitle();
				System.out.println("");
			if (expected_result.equals(actual_result)) {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + expected_result);
				System.out.println("Title Actual: \t\t" + actual_result);
				System.out.println("Test Case Result: \t" + "PASSED");
			} else {
				System.out.println("Test Case ID: \t\t" + text_case_id);
				System.out.println("URL: \t\t\t" + url);
				System.out.println("Title Expected: \t" + expected_result);
				System.out.println("Title Actual: \t\t" + actual_result);
				System.out.println("Test Case Result: \t" + "FAILED");
			}
			
		}
	
		driver.quit();
	}
}