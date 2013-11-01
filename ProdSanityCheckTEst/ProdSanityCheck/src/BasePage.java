import com.gargoylesoftware.htmlunit.javascript.host.Popup;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public WebDriver webdriver;
    public static WebElement Title;
    public static WebElement Button;
    private WebElement deleteButton;
    public static String URL;
    public Popup SureWindow;


    public BasePage(WebDriver driver){
        webdriver = driver;
    }
    public String getTitle()throws Exception{
        try{
        Title = webdriver.findElement(By.xpath("//div[contains@class='span9']"));
        String PageTitle = Title.getAttribute("h1");

            return PageTitle;
        }
        catch(Exception e){
             return "Can't find page title";
        }

    }
    public void clickByButton(String buttonName){
        Button = webdriver.findElement(By.className(buttonName));
    }
    public void openCreationPage(String entityName){
        webdriver.get("http://portal.oggifinogi.com/Oggi/" + entityName + "/Create");
    }

    public void openEditPage(String entityName){
        webdriver.get("http://portal.oggifinogi.com/Oggi/" + entityName + "/edit");
    }
    public void deleteEntity(List<String> entityIds, List<String> entityName){
        for (String entID : entityIds) {
            for (String entName : entityName) {

                webdriver.get("http://portal.oggifinogi.com/Oggi/" + entID + entName);
                deleteButton = webdriver.findElement(By.xpath("//div[a/@class='btn btn-danger']"));
                deleteButton.click();
            }
        }

        // webdriver.switchTo().window();


    }

}
