package com.training.utilities;
 import java.io.FileInputStream;
 

 import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.Properties;


import static com.training.utilities.Constants.USER_DIR;
import static com.training.utilities.Constants.FILE_SEPARATOR;
import static com.training.utilities.Constants.APPLICATION_PROPERTIES;

public class CommonUtilities {
	
	public String getProperty(String key) throws IOException {
		
		//filepath
		String Spath =USER_DIR +FILE_SEPARATOR + APPLICATION_PROPERTIES;
		
		//fileInputStream
		FileInputStream fileinput = new FileInputStream(Spath);
		Properties prop = new Properties();
		prop.load(fileinput);
		String value = prop.getProperty(key);
		return value;
		
	}

}
