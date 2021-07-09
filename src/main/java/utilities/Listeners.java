package utilities;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class Listeners extends CommonOps implements ITestListener {

    public void onStart(ITestContext test)
    {
        System.out.println("--------------------------------Starting Execution--------------------------------");
    }

    public void onFinish(ITestContext test)
    {
        System.out.println("--------------------------------Ending Execution--------------------------------");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test)
    {
        // TODO implement this....
    }

    public void onTestSkipped(ITestResult test)
    {
        System.out.println("--------------------------------Skipping Test: " + test.getName()+ " ---------------");
    }

    public void onTestStart(ITestResult test)
    {
        System.out.println("--------------------------------Starting Test: " + test.getName()+ " ---------------");

    }


    public void onTestSuccess(ITestResult test)
    {
        System.out.println("--------------------------------Test: " + test.getName() + " passed---------------");

        //stop recording
        try {
            monteScreenRecorder.stopRecord();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //delete recorded file
        try {
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete()) {
                System.out.println("file " + test.getName() + ".avi deleted successfully");
            } else {
                System.out.println("Fail to delete file : " + test.getName() + ".avi");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void onTestFailure(ITestResult test) {

        System.out.println("--------------------------------Test: " + test.getName() + " failed---------------");
        saveScreenshot();
        //stop recording
        try {
            monteScreenRecorder.stopRecord();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
      return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }

}
