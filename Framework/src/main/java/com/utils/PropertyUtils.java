package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.poifs.property.Property;

public class PropertyUtils {
	
	public static final String currentDir = System.getProperty("user.dir");
	public static String filePath = currentDir + "/src/test/resources/ ";
	
	public Properties getProperty(String fileName) throws IOException {
		FileInputStream fis=null;;
		Properties prop=null;
		
		try {
			fis=new FileInputStream(filePath+fileName);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			fis.close();
		}
		
	
		System.out.println("url is ::"+ prop.getProperty("url"));
		System.out.println("username::" + prop.getProperty("username"));
		System.out.println("password::" + prop.getProperty("password"));
		
		return prop;
	}

}
