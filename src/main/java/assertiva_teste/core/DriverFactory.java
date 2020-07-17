package assertiva_teste.core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver;


	public static WebDriver getDriver() {
		if (driver == null) {
			String caminhoProjeto = System.getProperty("user.dir");
			String barra = File.separator;
			System.setProperty("webdriver.chrome.driver", caminhoProjeto + barra + "src" + barra + "main" + barra
					+ "resources" + barra + "webdrivers" + barra + "chromedriver");
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		return driver;
	}

	public static void fecharDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
