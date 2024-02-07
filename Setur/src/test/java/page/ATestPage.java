package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ATestPage {

    protected WebDriver driver;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private ATestPage() {
        // initially left empty
    }

    public ATestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        logger.info("{} Initialization completed.", this.getClass().getSimpleName());
    }

}
