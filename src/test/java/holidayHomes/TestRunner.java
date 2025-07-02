package holidayHomes;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRunner {
	WebDriver driver;
	WebDriverWait wait;
	SearchLocation searchobj;
  
  
  @BeforeTest
  public void setUp() {
	  driver=new EdgeDriver();
	  wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	  driver.get("https://www.tripadvisor.in/");
	  driver.manage().window().maximize();
	  searchobj=new SearchLocation(driver, wait);
  }
  
  @Test(priority=1)
  public void searchLoaction()  {
	  
	  searchobj.searchingLocation();
  }
  
  @Test(priority=2)
  public void visitHolidayHome() throws InterruptedException {
	  
	  searchobj.clickHolidayHome();;
  }

}
