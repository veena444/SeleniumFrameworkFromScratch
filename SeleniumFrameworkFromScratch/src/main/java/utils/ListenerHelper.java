package utils;

import static utils.ExtentReportHelper.getReportObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import lombok.SneakyThrows;

public class ListenerHelper implements ITestListener{
	
	private final ExtentReports extentReports = getReportObject();
    ExtentTest logger;
    //ThreadLocal to generate the report for parallel execution
   ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void onTestStart(ITestResult result)
    {
        logger = extentReports.createTest(result.getMethod().getMethodName(),
                "<b> Description for test:</b> "+result.getMethod().getDescription());
        extentTestThreadLocal.set(logger);
        logger.assignCategory(result.getMethod().getGroups());
        extentTestThreadLocal.get().log(Status.INFO, "Driver Start Time: "+ dtf.format(LocalDateTime.now()));
    }

    public void onTestSuccess(ITestResult result)
    {
        extentTestThreadLocal.get().log(Status.PASS, MarkupHelper.createLabel(result.getMethod().getMethodName()+"is successful!!", ExtentColor.GREEN));
    }

    @SneakyThrows
    public void onTestFailure(ITestResult result)
    {
        extentTestThreadLocal.get().log(Status.FAIL, MarkupHelper.createLabel((result.getMethod().getMethodName()+"is failed!!"), ExtentColor.RED));
        extentTestThreadLocal.get().log(Status.FAIL, result.getThrowable());
    }


    public void onTestSkipped(ITestResult result) {

        extentTestThreadLocal.get().log(Status.SKIP, MarkupHelper.createLabel((result.getMethod().getMethodName()+"is skipped!!"), ExtentColor.INDIGO));
        extentTestThreadLocal.get().log(Status.SKIP, result.getThrowable());

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        
    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        
    }

    public void onFinish(ITestContext context)
    {
        extentTestThreadLocal.get().log(Status.INFO, "Driver quit time:  "+ dtf.format(LocalDateTime.now()));
        extentReports.flush();
    }
}
