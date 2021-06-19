package cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scripts {

    public WebDriver driver;
	
	@BeforeTest(groups = {"somketesting"})
	public void openbrowser() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		
	}
	@BeforeClass(groups = {"sanity" })
	public void login() throws InterruptedException {
		driver.get("http://127.0.0.1:81/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Projects & Customers']")).click();	
		
	}
	
	@Test(groups = {"somketesting"})
	public void verify_Url() {
		String Url= driver.getCurrentUrl();
		System.out.println(Url);	
		
	}
	@AfterClass(groups = {"sanity" })
	public void logout() {
		driver.findElement(By.className("logoutImg")).click();
		String title = driver.getTitle();
		System.out.println(title);	
		
	}
	@AfterTest(groups = {"sanity" })
	public void closebrowser() {
		driver.close();
	}
	
}
