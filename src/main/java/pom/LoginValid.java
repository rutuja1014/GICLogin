package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginValid {
	public WebDriver driver;
	  @BeforeClass
		public void preLogin() throws InterruptedException {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.germanyiscalling.com/common/login/");
		Thread.sleep(2000);
	  }
		@Test
		public void correctlogin() throws InterruptedException {
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("rutujagaikwad949@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Rutuja10@");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://app.germanyiscalling.com/cv/cv-analysis/279/"));
		Thread.sleep(2000);
		}
		
		@AfterClass
		public void windowClose() {
			driver.close();
		}
}
