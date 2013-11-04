import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestLogin extends BasePage{
    Logger logger = LogManager.getLogger(TestLogin.class.getName());


    public TestLogin(WebDriver driver){
        super(driver);
    }
       public void checkAccessToPortal() throws IOException {
          String SearchPageURL = webdriver.getCurrentUrl();
           if(SearchPageURL.equals("http://portal.oggifinogi.com/Oggi/Search?entityDef=All"))
               logger.info("Login to system is successfully performed");
           else{
               logger.info("Wasn't able to go to system");
           }
       }
}
