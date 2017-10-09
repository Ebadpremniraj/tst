package org.utility;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportUtility {
	private File SrcFile;
	private ExtentTest extntreport;
	private TakesScreenshot screenShot;
	
	public ReportUtility(ExtentTest extntreport, TakesScreenshot screenShot) {
		this.extntreport = extntreport;
		this.screenShot = screenShot;
	}
	public void ReportPassEvent_ScreenShot(String msg)
    {
           SrcFile                    = screenShot.getScreenshotAs(OutputType.FILE);
           extntreport.log(LogStatus.PASS, msg + extntreport.addScreenCapture(SrcFile.getAbsolutePath()));
    }
    public void ReportFailEvent_ScreenShot(String msg)
    {
           SrcFile                    = screenShot.getScreenshotAs(OutputType.FILE);
           extntreport.log(LogStatus.FAIL, msg + extntreport.addScreenCapture(SrcFile.getAbsolutePath()));
    }
    public void ReportInfoEvent_ScreenShot(String msg)
    {
           SrcFile                    = screenShot.getScreenshotAs(OutputType.FILE);
           extntreport.log(LogStatus.INFO, msg + extntreport.addScreenCapture(SrcFile.getAbsolutePath()));
    }
    public void ReportSkipEvent_ScreenShot(String msg)
    {
           SrcFile                    = screenShot.getScreenshotAs(OutputType.FILE);
           extntreport.log(LogStatus.SKIP, msg + extntreport.addScreenCapture(SrcFile.getAbsolutePath()));
    }
    public void ReportPassEvent(String msg)
    {
           
           extntreport.log(LogStatus.PASS, msg );
    }
    public void ReportFailEvent(String msg)
    {
           
           extntreport.log(LogStatus.FAIL, msg);
    }
    public void ReportInfoEvent(String msg)
    {
           
           extntreport.log(LogStatus.INFO, msg );
    }
    public void ReportSkipEvent(String msg)
    {
           
           extntreport.log(LogStatus.SKIP, msg);
    }

}
