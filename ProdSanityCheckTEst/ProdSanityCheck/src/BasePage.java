import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver webdriver;
    private Logger logger = LogManager.getLogger(MainPage.class.getName());

    public BasePage(WebDriver driver){
        webdriver = driver;
    }

    public void waitForPageLoaded() {

        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("document.readyState").equals("complete");
                    }
                };

        Wait<WebDriver> wait = new WebDriverWait(webdriver,30);
        try {
            wait.until(expectation);
        } catch(Throwable error) {
            logger.info("Timeout waiting for Page Load Request to complete.");
        }
    }

}
