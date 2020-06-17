package com.qualitystream.prueba;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.proyecto.pom.ContactoPage;

public class Contantanos {
	private WebDriver driver;
	ContactoPage contactoPage;
	By inputBuscador = By.name("q");
	
	String[] ids = {"inputName", "inputEmail", "inputCompany", "inputTel" , "inputMessage", "inputSubject" };
	String [] info = {"Elkin Idarraga ", "elkindida96@gmail.com", "GreenSQA", "3153883819", "prueba para llenar cuestionario","Prueba de ingreso"};
	
	
	@Before
	public void setUp() throws Exception {
		
		contactoPage = new ContactoPage(driver);
		driver = contactoPage.chromeDriveConexion();
		//contactoPage.visit("https://ibiscreativa.co/");
		contactoPage.visit("https://www.google.com.co/");
		
		WebElement google = contactoPage.findElement(inputBuscador);
		google.sendKeys("ibis creativa s.a.s");
		google.submit();
		
		WebElement findElement=contactoPage.findElement(By.xpath("//*[@id='rso']//div//div//div//a"));
		
		if(findElement.getAttribute("href").equals("https://ibiscreativa.co/")) {
			contactoPage.visit(findElement.getAttribute("href"));
		}else {
			System.out.println("No se encontro la pagina");
		}
		
		/*
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='rso']/li[2]/div/h3/a")).click();
		
		
		
		String path = "ol[id='rso'] h3[class='r'] a";
		contactoPage.findElements(By.cssSelector(path)).get(0).click();
		
		
		
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("resultStats")));
		
		List<WebElement> findElements=contactoPage.findElements(By.xpath("//*[@id='rso']//h3/a"));
		
		
		contactoPage.visit(findElements.get(0).getAttribute("href"));
		
		*/	
	}

	@After
	public void tearDown() throws Exception {
		try {
			
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Test
	public void test() throws InterruptedException {
		contactoPage.irContactanos();
	}
	

}

