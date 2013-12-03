
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SanityCheck {
         static FirefoxDriver driver;
         static String WidgetEntityID;

    public void performSanityCheck() throws Exception {
        ConfigsProperties configs = ConfigsProperties.getInstance();
        Report.clear(configs.FileReportLocation);
        Report.create(configs.FileReportLocation, configs.FileReporName);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);

        TestLogin testLogin = new TestLogin(driver);

        BasePage basePage = new BasePage(driver);

        AdCreationPage adCreationPage = new AdCreationPage(driver);

        TestADExternalImage testADExternalImage = new TestADExternalImage(driver);

        TestADUploadImage testADUploadImage = new TestADUploadImage(driver);

        VideoCreationPage videoCreationPage = new VideoCreationPage(driver);

        TestVideoEntityCreation testVideoEntityCreation = new TestVideoEntityCreation(driver);

        BaseWidgetCreationPage baseWidgetCreationPage = new BaseWidgetCreationPage(driver);

        TEstBaseWidgetCreation tEstBaseWidgetCreation = new TEstBaseWidgetCreation(driver);

        WidgetCreationPage widgetCreationPage = new WidgetCreationPage(driver);

        TestwidgetCreation testwidgetCreation = new TestwidgetCreation(driver);

        PlayListEntityCreation playListEntityCreation = new PlayListEntityCreation(driver);

        TestPlayListEntityCreation testPlayListEntityCreation = new TestPlayListEntityCreation(driver);
        CampaignCreationPage campaignCreationPage = new CampaignCreationPage(driver);

        loginPage.loginToSystem(configs.Login, configs.Password, configs.LinkToPortal);


        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        String url = driver.getCurrentUrl();
        testLogin.checkAccessToPortal();

//        basePage.openCreationPage("ad");
//        adCreationPage.createADExternal();
//        testADExternalImage.checkAbilityToCreateAd();
//        basePage.openCreationPage("ad");
//        adCreationPage.createADUpload();
//        testADUploadImage.checkAbilityToCreateAd();
//        videoCreationPage.createVideoEntity();
//        testVideoEntityCreation.checkAbilityToCreateVideo();
//        baseWidgetCreationPage.createBaseWidgetEntity();
//        tEstBaseWidgetCreation.checkabilityToCreateBW();
        widgetCreationPage.createWidget();
        testwidgetCreation.checkAbilityToCreateWidget();


        basePage.URL = driver.getCurrentUrl();
        WidgetEntityID = basePage.getEntityID(basePage.URL);
        playListEntityCreation.createPlayListentity(WidgetEntityID);
        testPlayListEntityCreation.checkAbilityToCreatePlaylist();
        campaignCreationPage.createCampaignEntity();
    }


}


