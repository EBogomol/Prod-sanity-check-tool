import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WidgetCreationPage extends EntityCreationPage{
    public WebDriver webdriver;
    public WebElement basewidget;

    BasePage basePage = new BasePage(webdriver);

    public WidgetCreationPage(WebDriver driver){
        super(driver);
    }

    public void createWidget(){
        basePage.openCreationPage("Widget");
        fillTitlefield("TestWidtetEntity");
        this.basewidget = webdriver.findElement(By.name("BaseEntity"));
        this.basewidget.sendKeys("Ask Banner Base Widget");
        clickSubmitButton();
    }

}
