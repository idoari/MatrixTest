package pageObjects.GotIt;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class AddTask {

    private AndroidDriver<AndroidElement> mobileDriver;

    public AddTask(AndroidDriver<AndroidElement> mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    @AndroidFindBy(xpath = "//*[@text='Title']")
    public AndroidElement txt_title;

    @AndroidFindBy(xpath = "//*[@text='Sub task']")
    public AndroidElement txt_subtask;

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and ./*[@text='']]")
    public AndroidElement btn_upload;

    @AndroidFindBy(xpath = "//*[@class='android.view.ViewGroup' and ./*[@text='Create']]")
    public AndroidElement btn_create;

    @AndroidFindBy(id = "numberpicker_input")
    public AndroidElement lb_current_date;

    @AndroidFindBy(xpath = "//*[@id='pickerWrapper']/*[@index=0]")
    public AndroidElement grp1;

    @AndroidFindBy(xpath = "//*[@id='pickerWrapper']/*[@index=1]")
    public AndroidElement grp2;

    @AndroidFindBy(xpath = "//*[@id='pickerWrapper']/*[@index=2]")
    public AndroidElement grp3;


}
