package holidayHomes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchLocation {
	WebDriver driver;
	WebDriverWait wait;
	
	public SearchLocation(WebDriver driver,WebDriverWait wait) {
		this.driver=driver;
		this.wait=wait;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[contains(@placeholder,'Places to go')]") WebElement searchBtn;
	@FindBy(linkText="Holiday Homes") WebElement holidayHomesBtn;
	
	public void searchingLocation()  {
		WebElement searchBtn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@placeholder,'Places to go')]")));
		searchBtn.click();
		searchBtn.sendKeys("Nairobi");
		Actions act=new Actions(driver);
		act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
		
	}
	
	public void clickHolidayHome() throws InterruptedException {
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Holiday Homes"))).click();
	}
}
