package selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Sample {
	
	private WebDriver driver;
	
	@BeforeClass
	public void beforeClass() {
		//driver = new ChromeDriver(executable_path=r'C:\path\to\chromedriver.exe');
		System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");  //chrome binary location specified here
		options.addArguments("start-maximized");
		//((options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		//options.setExperimentalOption("useAutomationExtension", false);
		driver = new ChromeDriver(options);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void test() {
        driver.get("http://www.google.com");
        String search_text = "Google Search";
        WebElement search_button = driver.findElement(By.name("btnK"));

        String text = search_button.getAttribute("value");
        try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Assert.assertEquals(text, search_text, "Text not found!");
        
	}

}
