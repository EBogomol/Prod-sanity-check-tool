import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestLogin {

         private WebDriver webDriver;

    public TestLogin(WebDriver driver){
        webDriver = driver;
    }
       public void checkAccessToPortal() throws IOException {
           ConfigsProperties configs = ConfigsProperties.getInstance();
           Report reportCreator = new Report();

          String SearchPageURL = webDriver.getCurrentUrl();
           if(SearchPageURL.equals("http://portal.oggifinogi.com/Oggi/Search?entityDef=All"))
            reportCreator.write("Login to system is successfully performed", configs.FileReportLocation, configs.FileReporName);
           else{
              reportCreator.write("Wasn't able to go to system", configs.FileReportLocation, configs.FileReporName);
           }
       }
}
