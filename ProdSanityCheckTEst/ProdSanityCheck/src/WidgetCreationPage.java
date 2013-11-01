import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        this.basewidget = webdriver.findElement(By.name("BaseEntity"));
        this.basewidget.sendKeys("Watch and Register Preroll 4:3");
        this.schemaTab = webdriver.findElement(By.partialLinkText("Schema"));
        this.schemaTab.click();
        Thread.sleep(2000);
        this.width = webdriver.findElement(By.id("Width"));
        this.width.sendKeys("400");
        this.height = webdriver.findElement(By.id("Height"));
        this.height.sendKeys("300");
        clickSubmitButton();
    }

}
