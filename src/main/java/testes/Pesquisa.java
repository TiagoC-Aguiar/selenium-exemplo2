package testes;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import pageobjects.HomePage;
import pageobjects.SearchPage;
import setup.Driver;

public class Pesquisa {

	WebDriver driver;
	
	@Before
	public void criarDriver() {
		Driver wdriver = new Driver();
		driver = wdriver.webDriver();
	}
	
	@Test
	public void fazerPesquisaValida() {
		String termoBusca = "Panela".toLowerCase();
		HomePage homePage = new HomePage(driver);	
		homePage.fazerPesquisa(termoBusca);
		
		SearchPage searchPage = new SearchPage(driver);		
		boolean result = searchPage.verificarResultadoValido(termoBusca);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		try {
			FileUtils.copyFile(src, new File("/home/tiago/Imagens/fotinha.png"));
			System.out.println("Tira fotinha!!!");
		} catch (IOException e) {
			System.out.println("Não tirou fotinha");
			e.printStackTrace();
		}
		
		Assert.assertTrue(result);		
	}	
	
	@After
	public void fecharDriver() {
		driver.close();
		driver.quit();
	}
	

}
