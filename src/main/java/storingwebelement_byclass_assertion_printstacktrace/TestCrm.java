package storingwebelement_byclass_assertion_printstacktrace;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCrm {
	WebDriver driver;
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver = new ChromeDriver();	// making my code not run cos forgot to delete WebDriver
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
		
	}
	
	@Test
	public void loginTest() throws InterruptedException {
				
		//storing WebElement
		//declaring variable: type name or variable = value; 	value=driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"))
		WebElement userNameElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));	//driver.findElement()=obj variable to find Element, By.xpath() is a class; we can utilize it 
		WebElement userPasswordElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
		WebElement userLoginElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

		
		userNameElement.sendKeys("demo@techfios.com");
		userPasswordElement.sendKeys("abc1234");	//wrong password to printStackTrace Dashborad page
		userLoginElement.click();
//		userDashboardElement.click();
		
		//By.xpath is a class, we can utilize it by declaring variable type name or variable = value;	//how to fine type of variable = driver.findElement(By.x), then it will pop up what type.
//		By userNameField = By.xpath("/html/body/div/div/div/form/div[1]/input");	
//		By userPasswordField = By.xpath("/html/body/div/div/div/form/div[2]/input");	
//		By userLoginField = By.xpath("/html/body/div/div/div/form/div[3]/button");	
		By userDashboardField = By.xpath("/html/body/section/div/div[1]/div[2]/div/h2");	
//		By userSaleField = By.xpath("/html/body/section/div/nav/div/ul/li[6]/a");	
		//using by class variable
//		driver.findElement(userNameField).sendKeys("demo@techfios.com");
//		driver.findElement(userPasswordField).sendKeys("abc123");
//		driver.findElement(userLoginField).click();	
//		driver.findElement(userDashboardField).click();
		
		//identify element old style;
//		driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input")).sendKeys("demo@techfios.com");
//		driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input")).sendKeys("abc123");
//		driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button")).click();

		//assert to Dashboard page	//try()catch(){}
		
		boolean pageTitleDisplayStatus;
		try {
				WebElement userDashboardElement = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));	
				pageTitleDisplayStatus=true;
				
		}catch(Exception e) {
					pageTitleDisplayStatus=false;
					e.printStackTrace();
				}
//		WebElement userDashboardElement = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2")); //can't use at the top cos Dashboard page is clicked before clicking in userNameElement
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(userDashboardField));
		Assert.assertTrue("Dashboard page does not find", pageTitleDisplayStatus);

	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();

	}
}
