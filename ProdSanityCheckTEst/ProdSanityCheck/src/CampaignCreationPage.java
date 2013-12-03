import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CampaignCreationPage extends EntityCreationPage {
    private WebElement CampaignName;
    private WebElement Sector;

    BasePage basePage = new BasePage(webdriver);

    public CampaignCreationPage(WebDriver driver) {
        super(driver);
    }

    public void createCampaignEntity() {
        basePage.openCreationPage("Campaign");
        CampaignName = webdriver.findElement(By.id("EntityName"));
        CampaignName.sendKeys("TestCampaignEntity");
        Sector = webdriver.findElement(By.id("Sector"));
        List<WebElement> options = Sector.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if("Automotive".equals(option.getTagName()));
                option.click();
        }
        clickSubmitButton();
    }
}
