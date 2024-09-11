package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginInvalid {
	public WebDriver driver;
	  @BeforeClass
		public void preLogin() throws InterruptedException {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.germanyiscalling.com/common/login/");
		Thread.sleep(2000);
	  }
	  
	@Test
	public void incorrectLogin() throws InterruptedException {
driver.findElement(By.cssSelector("input[name='username']")).sendKeys("rutugaikwad949@gmail.com");
Thread.sleep(2000);
driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Rutuja");
Thread.sleep(2000);
driver.findElement(By.cssSelector("button[type='submit']")).click();
Thread.sleep(2000);

WebElement error = driver.findElement(By.xpath("//li[contains(text(),'Please enter a correct username and password. Note')]"));
if (error != null && error.isDisplayed()) {
  String text1 = error.getText();
  String text2 = "Invalid Credentials"; 
  Assert.assertTrue(text1.contains(text2), 
          "Please enter a correct username and password. Note that both fields may be case-sensitive. " + text1);
} else {
  Assert.fail("Error");
}
}
	@AfterClass
	public void windowClose() {
		driver.close();
	}
}
