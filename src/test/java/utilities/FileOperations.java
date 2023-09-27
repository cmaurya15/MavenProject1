package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileOperations 
{
	public String ReadPropertyFile(String key) throws Exception 
	{
		
		File file = new File(".\\src\\test\\java\\config.properties");
		FileInputStream fileInputStream= new FileInputStream(file);
		
		Properties prop=new Properties();
		prop.load(fileInputStream);
		String value=  prop.getProperty(key);
		
		return value;
	}

}
