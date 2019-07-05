package setup;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	public WebDriver webDriver() {
		System.setProperty("webdriver.chrome.driver", "/home/tiago/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		Dimension size = new Dimension(1400, 970);
		driver.manage().window().setSize(size);
		driver.get("http://www.casasbahia.com.br");		
		driver.manage().timeouts().implicitlyWait(1700, TimeUnit.MILLISECONDS);
		return driver;
	}
}
