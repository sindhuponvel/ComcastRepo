package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
	public String readDataFromProperties(String key) throws Exception {
	FileInputStream fis = new FileInputStream("/comcastPractiseFramework/Config.data/CommonData1.properties");
	Properties pObj= new Properties();
	pObj.load(fis);
	String data = pObj.getProperty(key);
	return data;
	}
	
}
