package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ExistUser {

    private AndroidDriver<AndroidElement> mobileDriver;

    public ExistUser(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Error: [auth/email-already-in-use] The email address is already in use by another account.']")
    public AndroidElement lb_error;


}
