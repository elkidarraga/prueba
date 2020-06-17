package com.proyecto.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactoPage extends Base {
	
	By contactoLocator = By.id("s4");
	By btnEmail =By.id("btEmail");
	By inpuPol =By.id("inputPol");
	

	public ContactoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void irContactanos() throws InterruptedException {
		click(contactoLocator);
		Thread.sleep(200);
		
		if(isDisplayed(btnEmail)) {
			for (int i = 0; i < ids.length; i++) {
				type(info[i], By.id(ids[i]));
				
			}
			click(inpuPol);
			//click(btnEmail);
		}else {
			System.out.println("No se encontro la pagina");
		}
	}

}
