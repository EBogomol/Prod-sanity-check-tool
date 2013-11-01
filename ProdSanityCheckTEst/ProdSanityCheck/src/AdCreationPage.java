import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdCreationPage extends EntityCreationPage {
    public WebElement uploadButton;
    public AdCreationPage(WebDriver driver) {
        super(driver);
    }
     EntityCreationPage entityCreationPage = new EntityCreationPage(webdriver);
       public void createADUpload(){
           entityCreationPage.fillTitlefield("testAdImageUpload");
           entityCreationPage.uploadFile("file:///C:/Users/ebogomol/Pictures/testPicute.jpg");
           entityCreationPage.clickSubmitButton();
       }
        public void createADExternal(){
            entityCreationPage.fillTitlefield("testAdImageExternal");
            uploadButton = webdriver.findElement(By.id("btnExternal"));
            uploadButton.click();
            externalButton = webdriver.findElement(By.id("MediaFile"));
            externalButton.sendKeys("http://cdn.oggifinogi.com/prod/2013-10/b87b0471-e628-4df6-aa34-344a39612f71_v1.jpg");
            entityCreationPage.clickSubmitButton();

        }



}
