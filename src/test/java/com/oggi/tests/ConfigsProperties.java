package com.oggi.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class ConfigsProperties {

    public static String Login;
    public static String Password;
    public static String LinkToPortal;
    public static String CdnRootPage;
    public static String pathToImageAd;
    public static String pathToReUploadImage;
    public static String pathToInsertionOrder;
    public static String pathToSWf;
    public static String pathToWrongSWF;
    public static String pathToResourcesFolder;



    public static class SingletonHolder {
        public static final ConfigsProperties HOLDER_INSTANCE = new ConfigsProperties();
    }

    public static ConfigsProperties getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }

    public ConfigsProperties()
    {
        Properties configFile = new Properties();
        try{
            configFile.load(new FileInputStream("config.properties"));}
        catch(Exception e){}

       Login             =configFile.getProperty("LOGIN");
       Password          = configFile.getProperty("PASSWORD");
       LinkToPortal      = configFile.getProperty("LINK_TO_PORTAL");
       CdnRootPage      = configFile.getProperty("CDN_ROOT_PAGE");


    }
    public void getResources(){
        pathToResourcesFolder = new File("").getAbsolutePath().concat("\\resources");
        pathToImageAd = new File("").getAbsolutePath().concat("\\resources\\testImage.jpg");
        pathToReUploadImage = new File("").getAbsolutePath().concat("\\resources\\testImage2.jpg");
        pathToInsertionOrder = new File("").getAbsolutePath().concat("\\resources\\OggiClientInsertionOrder.xlsx");
        pathToSWf = new File("").getAbsolutePath().concat("\\resources\\VideoPlayerWithCarousel.swf");
        pathToWrongSWF = new File("").getAbsolutePath().concat("\\resources\\PrerollAdvanced.swf");
    }

}