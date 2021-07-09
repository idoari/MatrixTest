package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ConfirmLogout {

    private AndroidDriver<AndroidElement> mobileDriver;

    public ConfirmLogout(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='YES']")
    public AndroidElement btn_yes;
}
