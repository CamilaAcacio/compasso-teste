package assertiva_teste.core;


import static assertiva_teste.core.DriverFactory.getDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class DSL {
	private Integer ESPERA_PADRAO = 2;

	public DSL() {
	}

	public DSL visitarPagina(String url) {
		getDriver().get(url);
		return this;
	}
	
	public DSL fechar() {
		fechar();
		return this;
	}
	
	public DSL digitar(String xpath, String texto) {
		WebElement elemento = encontrar(xpath);
		elemento.clear();
		elemento.sendKeys(texto);	
		return this;
	}
	
	public DSL clicar(String xpath) {
		this.clicarElemento(xpath);
		return this;
	}
	
	public DSL esperarAteExistente(String xPath) {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), ESPERA_PADRAO);
		espera.until(ExpectedConditions.presenceOfElementLocated((By.xpath(xPath))));
		return this;
	}
	
	private DSL scrollAteElemento(WebElement elemento) {
		executarJavascript("arguments[0].scrollIntoView(true);", elemento);
		return this;
	}
	
	private WebElement getElemento(String xpath) {
		esperarAteExistente(xpath);
		return getDriver().findElement(By.xpath(xpath));
	}
	
	private WebElement clicarElemento(String xpath) {
		WebElement elemento = null;
		try {
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			elemento.click();
		} catch (WebDriverException e) {
			scrollAteElemento(getElemento(xpath));
			elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			try {
				elemento.click();
			}
			catch (ElementClickInterceptedException cl) {
				elemento = (new WebDriverWait(getDriver(), ESPERA_PADRAO))
						.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
				elemento.click();
			}
			
		}
		return elemento;
	}
	
	private WebElement encontrar(String campo) {
		esperarAteExistente(campo);
		return getDriver().findElement(By.xpath(campo));
	}
	
	private Object executarJavascript(String codigo, Object... parametros) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		return js.executeScript(codigo, parametros);
	}
	
	public boolean estaPresenteComEspera(String campo) {
		boolean encontrou = true;
		try {
			encontrar(campo);
		} catch (NoSuchElementException e) {
			encontrou = false;
		}
		return encontrou;
	}
	
}
