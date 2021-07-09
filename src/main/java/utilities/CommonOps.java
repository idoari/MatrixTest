package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import java.lang.reflect.Method;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {


    @BeforeClass
    public void startSession()  {
        initMobile();
        softAssert = new SoftAssert();
    }

    @AfterClass
    public void closeSession () {
        mobileDriver.quit();
    }

   @BeforeMethod
    public void beforeMethod(Method method) { //start screen record
        try {
            monteScreenRecorder.startRecord(method.getName()); //start the screen record
        } catch (Exception e) {
            System.out.println("Error Occurred while starting screen record: " + e);
        }
   }

    public static void initMobile() {

        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("gotIt_APPPackage"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("gotIt_APPActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("error occurred. see details : " + e);
            System.exit(0);
        }
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("TimeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("TimeOut")));
        CSVusers=ManageDDT.getDataFromCSV(getData("DDTUsers"),3); //fill the array with the users to be added
        CSVtasks=ManageDDT.getDataFromCSV(getData("DDTTasks"),7); //fill the array with the tasks to be added to each user
        ManagePages.initGotIt(); //initilize the page objects of the mobile app

    }



    public static String getData (String nodeName) //read from xml config file
    {
        String value="";
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Error Occurred while reading XML file: " + e);
            System.exit(0);
        }
        doc.getDocumentElement().normalize();
        try {
            value = doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
        catch (Exception e) {
            System.out.println("error while getting TagName " + nodeName + ". see details :" + e);
            System.exit(0);
        }
        return value;
    }



}
