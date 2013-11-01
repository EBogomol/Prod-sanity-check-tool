import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseWidgetCreationPage extends EntityCreationPage{
    public WebElement width;
    public WebElement height;
    public WebElement schema;
    public List<WebElement> options;

          BasePage basePage= new BasePage(webdriver);

    public BaseWidgetCreationPage(WebDriver driver){
        super(driver);
    }
    public void createBaseWidgetEntity() throws InterruptedException {
        basePage.openCreationPage("basewidget");
        fillTitlefield("TestBaseWidgetPage");
        this.width = webdriver.findElement(By.id("Width"));
        this.width.sendKeys("300");
        this.height = webdriver.findElement(By.id("Height"));
        this.height.sendKeys("400");
        uploadFile("file:///D:/Components%20testing/AnimationButton.swf");
        this.schema = webdriver.findElement(By.id("CommonSchema"));
        this.schema.sendKeys("Preroll Schema");
        clickSubmitButton();
        Thread.sleep(5);
        clickSubmitButton();

    }
}
