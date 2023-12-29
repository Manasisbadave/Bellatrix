package com.bellatrix.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {

	public String getProperty(String filePath, String key) {

		String baseDir = System.getProperty("user.dir");

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(baseDir + filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		String value = "";
		try {
			prop.load(fis);
			value = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return value;

	}
}
