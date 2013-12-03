import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WidgetCreationPage extends EntityCreationPage{

    private WebElement basewidget;


    BasePage basePage = new BasePage(webdriver);

    public WidgetCreationPage(WebDriver driver){
       super(driver);
    }

    public void createWidget() throws InterruptedException {
        basePage.openCreationPage("Widget");


        WebElement select = webdriver.findElement(By.name("BaseEntity"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("f7e27ea9-4fb1-48d5-86c2-035a25429367".equals(option.getAttribute("value")))
                option.click();
        }
        fillTitlefield("TestWidgetEntity");
        Thread.sleep(7000);
        clickSubmitButton();
        Thread.sleep(5000);

    }
}
