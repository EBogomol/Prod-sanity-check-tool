import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PlayListEntityCreation extends EntityCreationPage{
    public WebElement AdType;
    public WebElement screen;
    public WebElement smallWidgetSelector;
    public WebElement smallWidgetEntity;
    public WebElement bigWidgetentity;
    public WebElement popupWindow;

    BasePage basePage = new BasePage(webdriver);

    public PlayListEntityCreation(WebDriver driver) {
        super(driver);
    }

    public void createPlayListentity(String smallwidgetID) throws InterruptedException {
        basePage.openCreationPage("Playlist");
        fillTitlefield("TestPlayListEntity");
        this.AdType = webdriver.findElement(By.id("UnitTypeId"));
        this.AdType.sendKeys("Collective TV");
        this.screen = webdriver.findElement(By.id("Screen"));
        this.screen.sendKeys("Desktop");
        this.smallWidgetSelector = webdriver.findElement(By.xpath(".//*[@id='WidgetId_dvInlinePicker']/button[1]"));
        this.smallWidgetSelector.click();
        Thread.sleep(1000);
        smallWidgetEntity = webdriver.findElement(By.id("picker_id_WidgetId_dvPickerDialog_" + smallwidgetID));
        smallWidgetEntity.click();
        clickSubmitButton();
    }


}
