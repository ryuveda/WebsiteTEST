
package utilities;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class TestBaseBeforeMethodAfterMethod {
    protected Logger logger  = LoggerFactory.getLogger(this.getClass());

    protected WebDriver driver;


    @Before
    public void setUp() {
        // System.setProperty("webdriver.chrome.driver", "C:\chromeDriver\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}