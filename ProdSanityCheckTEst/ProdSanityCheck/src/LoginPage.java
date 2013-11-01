import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver webDriver;
    WebElement LoginField;
    WebElement PasswordField;
    WebElement OkButton;

    public LoginPage(WebDriver driver) {
        webDriver = driver;
    }
       public void loginToSystem(String login, String Password, String LinkToPortal){
           webDriver.get(LinkToPortal);

           LoginField = webDriver.findElement(By.id("ctl00_cphContent_ctl00_txtLogin"));
           LoginField.sendKeys(login);
           PasswordField = webDriver.findElement(By.id("ctl00_cphContent_ctl00_txtPassword"));
           PasswordField.sendKeys(Password);
           OkButton = webDriver.findElement(By.id("ctl00_cphContent_ctl00_btLogin"));
           OkButton.click();
       }
}
