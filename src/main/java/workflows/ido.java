/*import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class AppiumTest {

    AndroidDriver driver;
    WebDriverWait wait;
    String AppURL = "http://cgi-lib.berkeley.edu/ex/fup.html";



    @Test
    public void testSearchAppium() throws IOException {


        //Switch to Native_App
        Set<String> contextNames = driver.getContextHandles();
        for (String strContextName : contextNames) {
            if (strContextName.contains("NATIVE_APP")) {
                driver.context("NATIVE_APP");
                break;
            }
        }

        //Click on 'Allow' - permission
        By elementView = By.id("com.android.permissioncontroller:id/permission_allow_button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementView));
        driver.findElement(elementView).click();

        //Click on files
        By eleFile = By.xpath("//*[@text="Files"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(eleFile));
        driver.findElement(eleFile).click();

        //select pdf file from downloads (location of pdf file)
        By eleDoc = By.id("com.android.documentsui:id/thumbnail");
        wait.until(ExpectedConditions.visibilityOfElementLocated(eleDoc));
        driver.findElement(eleDoc).click();

        //Switch to Chrome browser
        Set<String> contextNames1 = driver.getContextHandles();
        for (String strContextName : contextNames1) {
            if (strContextName.contains("CHROMIUM")) {
                driver.context("CHROMIUM");
                break;
            }
        }

        //Click on submit button
        WebElement btnElement = driver.findElement(By.cssSelector("input[type=submit]"));
        wait.until(ExpectedConditions.visibilityOf(btnElement));
        btnElement.click();

        //Add a simple assertion
        By nextPageHeader = By.cssSelector("h1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageHeader));
        Assert.assertTrue(driver.findElement(nextPageHeader).getText().equals("File Upload Results"));



    }



}
*/
