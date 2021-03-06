import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayListEntityCreation extends EntityCreationPage{
    public WebElement AdType;
    public WebElement screen;
    public WebElement smallwidget;

    MainPage basePage = new MainPage(webdriver);

    public PlayListEntityCreation(WebDriver driver) {
        super(driver);
    }

    public void createPlayListentity() {
        basePage.openCreationPage("Playlist");
        fillTitlefield("TestPlayListEntity");
        this.AdType = webdriver.findElement(By.id("UnitTypeId"));
        this.AdType.sendKeys("Collective TV");
        this.screen = webdriver.findElement(By.id("Screen"));
        this.screen.sendKeys("Desktop");
        this.smallwidget = webdriver.findElement(By.id("WidgetId_name"));
        this.smallwidget.sendKeys("TestWidtetEntity");
    }


}
