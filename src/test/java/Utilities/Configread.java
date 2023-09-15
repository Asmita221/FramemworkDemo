package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configread {
    Properties properties;
    String pro_path ="C:\\Users\\NTS-Asmita Raut\\IdeaProjects\\Custom_framework\\Configuration\\config.properties";
    public Configread()  {
        properties = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream(pro_path);
            properties.load(ip);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //fetch url
    public String geturl(){
        String url = properties.getProperty("appurl");
        return url;
    }
    public String getbrowser(){
        String bro = properties.getProperty("browser");
        return bro;
    }
    public String getcreataccounturl(){
        String creataccount = properties.getProperty("createaccturl");
        return creataccount;
    }
}
