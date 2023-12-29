package com.bellatrix.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.bellatrix.utilities.Screenshot;


public class myListener implements ITestListener {

	public void onTestFailure(ITestResult result) {

		Screenshot screenshot=new Screenshot();
		try {
			screenshot.captureFullPageScreenshot(result.getMethod().getMethodName());
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
}
