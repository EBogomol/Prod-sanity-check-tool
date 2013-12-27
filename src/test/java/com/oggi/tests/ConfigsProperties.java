package com.oggi.tests;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ebogomol
 * Date: 03.08.13
 * Time: 13:16
 * To change this template use File | Settings | File Templates.
 */

public class ConfigsProperties {

    public static String Login;
    public static String Password;
    public static String LinkToPortal;
    public static String CdnRootPage;
    public static List<String> EntityName;


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

}