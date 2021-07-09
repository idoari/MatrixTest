package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;


public class Base {

    //general
    protected static WebDriverWait wait;
    protected static Actions action ;
    protected static SoftAssert softAssert ;
    protected static String platform ;

    //mobile
    protected static AndroidDriver<AndroidElement> mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static String[][] CSVusers; //mobile - users list
    protected static String[][] CSVtasks; //identify_user tasks by id=email

    //page objects - mobile
    protected static pageObjects.GotIt.StartPage gotitStart;
    protected static pageObjects.GotIt.CreateUser gotitCreate;
    protected static pageObjects.GotIt.Tasks gotitTasks;
    protected static pageObjects.GotIt.UserLogout gotitLogout;
    protected static pageObjects.GotIt.ConfirmLogout gotitConfirm;
    protected static pageObjects.GotIt.LoginPage gotitLogin;
    protected static pageObjects.GotIt.ExistUser gotitExist;
    protected static pageObjects.GotIt.AddTask gotitAddTask;



}
