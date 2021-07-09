package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;


public class MobileActions extends CommonOps {

    @Step("click on mobile element")
    public static void Click(MobileElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("send text to element")
    public static void Sendkeys(MobileElement elem , String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step("Tap On Element")
    public static void tap(MobileElement elem,int duration) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        new TouchAction(mobileDriver).longPress(longPressOptions().withElement(element(elem)).withDuration(ofMillis(duration))).release().perform();
    }

    @Step("screen swipe")
    public static void swipe(int startX , int startY , int endX, int endY , int duration) {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        new TouchAction(mobileDriver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(duration))).moveTo(point(endX, endY)).release().perform();
    }

    @Step("zoom On Element")
    public static void zoom(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getCenter().x;
        int y = elem.getCenter().y;
        new TouchAction(mobileDriver).press(point(x-10,y)).moveTo(point(x-200,y)).release().perform();

    }

    @Step("pinch Element")
    public static void pinch(MobileElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getCenter().x;
        int y = elem.getCenter().y;
        new TouchAction(mobileDriver).press(point(x-200,y)).moveTo(point(x-10,y)).release().perform();

    }

    @Step("execute script")
    public static void executeScript(String script) {
        mobileDriver.executeScript(script);
    }

}




