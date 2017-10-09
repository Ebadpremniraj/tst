package org.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	public static Properties getData = new Properties();
    public static Properties getLoc = new Properties();
    
       
    public static void readPropertyFile(String filePath) throws IOException {
                  //  String filePath1 = "Data\\data.properties";
                    String filePath2 = filePath;
                    
                    //File file1 = new File(filePath1);
                    File file2 = new File(filePath2);
                    
                  //  FileInputStream fileInputStream1 = new FileInputStream(file1);
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    
                    //getData.load(fileInputStream1);
                    getLoc.load(fileInputStream2);
    }
    
    public static String getLocatorFromLocFile(String Key) {
                    
                    return getLoc.getProperty(Key);
    }
    
    public static String getDataFromDataFile(String key) {
    
                    return getData.getProperty(key);
    }

	
}
