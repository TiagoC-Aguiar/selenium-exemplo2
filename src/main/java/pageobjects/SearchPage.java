package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	private WebDriver driver;
	
	@FindBy(how = How.CSS, using = ".nm-product-name a span")
	private List<WebElement> resultados;

	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public boolean verificarResultadoValido(String termoBusca) {
		String result;
		
		for(int i = 0; i < resultados.size(); i++) {
			result = resultados.get(i).getText().toLowerCase();
			if(result.contains(termoBusca)) {
				return true;				
			}
		}
		return false;
	}
	
}
