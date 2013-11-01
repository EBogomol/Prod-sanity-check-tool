import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class TestPlayListEntityCreation {
    private WebDriver webdriver;
    private WebElement settingModule;


    ConfigsProperties configs = ConfigsProperties.getInstance();

    Report reportCreator = new Report();

    public TestPlayListEntityCreation(WebDriver driver){
        webdriver = driver;
    }

    public void checkAbilityToCreatePlaylist() throws IOException, InterruptedException {

        Thread.sleep(7);
        settingModule = webdriver.findElement(By.id("properties"));

        if (settingModule.isDisplayed()){
            reportCreator.write("Playlist entity is successfully created", configs.FileReportLocation, configs.FileReporName);
        }
        else{
            reportCreator.write("Playlist entity is unsuccessfully created", configs.FileReportLocation, configs.FileReporName);
        }

    }
}

