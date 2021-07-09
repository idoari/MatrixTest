package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private AndroidDriver<AndroidElement> mobileDriver;

    public LoginPage(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @password='false']")
    public AndroidElement txt_email;

    @AndroidFindBy(xpath = "//*[@password='true']")
    public AndroidElement txt_password;

    @AndroidFindBy(xpath = "//*[@NAF='true' and @index=3]")
    public AndroidElement btn_login;

}
