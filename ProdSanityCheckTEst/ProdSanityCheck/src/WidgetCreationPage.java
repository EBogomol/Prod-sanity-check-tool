import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WidgetCreationPage extends EntityCreationPage{

    private WebElement basewidget;
    public  WebElement schemaTab;
    public  WebElement width;
    public WebElement height;

    BasePage basePage = new BasePage(webdriver);

    public WidgetCreationPage(WebDriver driver){
       super(driver);
    }

    public void createWidget() throws InterruptedException {
        basePage.openCreationPage("Widget");
        fillTitlefield("TestWidtetEntity");

        WebElement select = webdriver.findElement(By.name("BaseEntity"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Ask Banner Base Widget".equals(option.getText()))
                option.click();
        }
        Thread.sleep(2000);
        clickSubmitButton();
    }

}
