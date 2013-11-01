import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EntityCreationPage {
    public WebDriver webdriver;
    public WebElement SubmitButton;
    public WebElement CancelButton;
    public WebElement titleField;
    public WebElement externalButton;
    public WebElement selectButton;


    public EntityCreationPage(WebDriver driver){
        webdriver = driver;
    }

        public void clickSubmitButton(){
            SubmitButton = webdriver.findElement(By.id("btnSubmit"));
            SubmitButton.click();
    }
        public void clickCancelButton(){
            CancelButton = webdriver.findElement(By.linkText("Cancel"));
            CancelButton.click();
        }
        public void uploadFile(String path){
            WebElement UploadButton =  webdriver.findElement(By.id("MediaFile_fUpload"));
            UploadButton.sendKeys(path);
        }
        public void fillTitlefield(String entityTitle){
            titleField = webdriver.findElement(By.id("EntityName"));
            titleField.sendKeys(entityTitle);
        }
        public void selectentity(String titleOfentity){
            selectButton = webdriver.findElement(By.className("bla"));
        }


}
