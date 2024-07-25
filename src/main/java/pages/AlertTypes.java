package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;


public class AlertTypes extends BaseClass {
	
	public AlertTypes (RemoteWebDriver commonDriver) {
		this.driver=commonDriver;
	}
	
	public AlertTypes alert1(String alertMsg1) throws InterruptedException {
		
		 WebElement clickOkandcancelButton = driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']"));
         clickOkandcancelButton.click();
         
         Thread.sleep(5000);
         
         WebElement alertmessageText = driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
         String actualAlert1=alertmessageText.getText();
         String expectedAlert1=alertMsg1;
         if(actualAlert1.equals(expectedAlert1)) {
        	 System.out.println("Valid alert message1 displayed");
        	 
         }
		
		return this;
	}

}
