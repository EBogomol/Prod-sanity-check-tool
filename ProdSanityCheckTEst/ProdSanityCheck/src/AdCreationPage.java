import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class AdCreationPage extends EntityCreationPage {
    public WebElement uploadButton;
    public AdCreationPage(WebDriver driver) {
        super(driver);
    }

       public void createADUpload(){

           fillTitlefield("testAdImageUpload");
           String pathToImage = new File("./resourses/testImage.jpg").getAbsolutePath().replace('\\','/');
           uploadFile("file:///"+pathToImage);
           clickSubmitButton();
       }
        public void createADExternal(){
            fillTitlefield("testAdImageExternal");
            uploadButton = webdriver.findElement(By.id("btnExternal"));
            uploadButton.click();
            externalButton = webdriver.findElement(By.id("MediaFile"));
            externalButton.sendKeys("http://cdn.oggifinogi.com/prod/2013-10/b87b0471-e628-4df6-aa34-344a39612f71_v1.jpg");
            clickSubmitButton();

        }



}
