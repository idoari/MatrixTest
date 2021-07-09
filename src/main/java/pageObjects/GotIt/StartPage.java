package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class StartPage {

    private AndroidDriver<AndroidElement> mobileDriver;

    public StartPage(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

     //contentDescription=accessibility
    @AndroidFindBy(accessibility = "start_button")
    public AndroidElement btn_start;

    @AndroidFindBy(xpath = "//*[@NAF='true' and @index=4]")
    public AndroidElement btn_login;

}
