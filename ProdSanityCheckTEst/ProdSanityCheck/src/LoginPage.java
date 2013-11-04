import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LoginPage  extends BasePage {

    WebElement LoginField;
    WebElement PasswordField;
    WebElement OkButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
       public void loginToSystem(String login, String Password, String LinkToPortal){
           webdriver.get(LinkToPortal);

           LoginField = webdriver.findElement(By.id("ctl00_cphContent_ctl00_txtLogin"));
           LoginField.sendKeys(login);
           PasswordField = webdriver.findElement(By.id("ctl00_cphContent_ctl00_txtPassword"));
           PasswordField.sendKeys(Password);
           OkButton = webdriver.findElement(By.id("ctl00_cphContent_ctl00_btLogin"));
           OkButton.click();
       }
}
