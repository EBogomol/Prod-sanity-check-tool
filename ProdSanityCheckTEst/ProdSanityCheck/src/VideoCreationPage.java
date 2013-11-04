import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VideoCreationPage extends EntityCreationPage {
    public  WebElement uploadButton;
    public WebElement inputField;

    MainPage basePage = new MainPage(webdriver);


    public VideoCreationPage(WebDriver driver) {
        super(driver);

    }

    public void createVideoEntity(){
        basePage.openCreationPage("Video");
        fillTitlefield("testVideoEntity");
        this.uploadButton = webdriver.findElement(By.id("btnMediaExternal"));
        this.uploadButton.click();
        this.inputField = webdriver.findElement(By.id("Media_MediaFile"));
        this.inputField.sendKeys("http://cdn.oggifinogi.com/prod/2013-10/08207e61-ce21-47ea-bba1-2826fce70232_v1.mp4");
        clickSubmitButton();
    }
}
