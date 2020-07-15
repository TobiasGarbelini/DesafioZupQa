package core;

import static core.DriverFactory.getDriver;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	public void preencheInputPorId(String id, String valor) {
		getDriver().findElement(By.id(id)).sendKeys(valor);
	}	
		
	public void esperaElementoclicavelLinkText(String link) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText(link)));
	}

	public void esperaElementoclicavelCSSSelector(String cssSelector) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
	}

	public void esperaElementoclicavelId(String id) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
	}
	
	public void esperaElementoclicavelXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void esperaAlert(String id) {
		WebDriverWait wait = new WebDriverWait(getDriver(), 60);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void clickLinkText(String link) {
		getDriver().findElement(By.linkText(link)).click();
	}

	public void clickCSSSelector(String cssSelector) {
		getDriver().findElement(By.cssSelector(cssSelector)).click();
	}

	public void clickid(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clickXpath(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();
	}

	public void maximizaTela() {
		getDriver().manage().window().maximize();
	}

	public void verificaCSSSelector(String cssSelector, String valor) {
		assertThat(getDriver().findElement(By.cssSelector(cssSelector)).getText(), is(valor));
	}

	public void verificaId(String id, String valor) {
		assertThat(getDriver().findElement(By.id(id)).getText(), is(valor));
	}
	
	public void verificaClasse(String classe, String valor) {
		assertThat(getDriver().findElement(By.className(classe)).getText(), is(valor));
	}
	
	public float pegaValorClasse(String classe) {
		String valor = getDriver().findElement(By.className(classe)).getText();
		valor = valor.replace("R", "0");
		valor = valor.replace("$", "0");
		valor = valor.replace(" ", "0");
		valor = valor.replace(",", ".");
		
		Float valorProduto =  Float.parseFloat(valor);
		return valorProduto;
	}
	
	public String pegaValorStringClasse(String classe) {
		String valor = getDriver().findElement(By.className(classe)).getText();
		return valor;
	}
	
	public String pegaStringId(String id) {
		String valor = getDriver().findElement(By.id(id)).getText();
		return valor;
	}
	
	public void moverMouseParaClasse(String classe) throws AWTException {
		Point coordinates = getDriver().findElement(By.className(classe)).getLocation();
		 Robot robot = new Robot();
		robot.mouseMove(coordinates.getX(),coordinates.getY()+120);
	}
	
}
