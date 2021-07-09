package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class CreateUser {

    private AndroidDriver<AndroidElement> mobileDriver;

    public CreateUser(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(accessibility = "image_picker")
    public AndroidElement btn_avatar;

    @AndroidFindBy(accessibility = "email_input")
    public AndroidElement txt_email;

    @AndroidFindBy(accessibility = "user_name_input")
    public AndroidElement txt_name;

    @AndroidFindBy(accessibility = "password_input")
    public AndroidElement txt_password;

    @AndroidFindBy(accessibility = "repeat_password_input")
    public AndroidElement txt_retype;

    @AndroidFindBy(accessibility = "create_account_button")
    public AndroidElement btn_create;



}
