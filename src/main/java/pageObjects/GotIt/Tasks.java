package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Tasks {

    private AndroidDriver<AndroidElement> mobileDriver;

    public Tasks(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and @clickable='true']")
    public AndroidElement btn_avatar;

    @AndroidFindBy(accessibility = "bottom_bar_create_button")
    public AndroidElement btn_add;
}
