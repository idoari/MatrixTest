package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.*;
import java.util.concurrent.TimeUnit;

public class MobileFlows extends CommonOps {

    @Step("create new user")
    public static void AddUsers() {
        if (CSVusers != null) { //if the user array is NOT empty
            for (int i = 0; i < CSVusers.length; i++) { //add all users from CSV file
                LogoutUser(); //if a user is connected - logout
                MobileActions.Click(gotitStart.btn_start);
                if (CreateAndVerifyUser(CSVusers[i][0], CSVusers[i][1], CSVusers[i][2]) == true)
                    continue; //if the user already exist - skip
                else {
                    wait.until(ExpectedConditions.visibilityOf(gotitTasks.btn_avatar));
                    MobileActions.Click(gotitTasks.btn_avatar);
                    MobileActions.Click(gotitLogout.btn_logout);
                    MobileActions.Click(gotitConfirm.btn_yes);
                    //if the user did not created successfully, send a message and continue
                    softAssert.assertTrue(CreateAndVerifyUser(CSVusers[i][0], CSVusers[i][1], CSVusers[i][2]), "error while creating user" + CSVusers[i][0]);
                }
            }
        }
    }

    @Step("create new user and return true if it already exist and false if does not")
    public static Boolean CreateAndVerifyUser(String email, String name, String password) {
        wait.until(ExpectedConditions.visibilityOf(gotitCreate.txt_email));
        MobileActions.Sendkeys(gotitCreate.txt_email, email); //email
        MobileActions.Sendkeys(gotitCreate.txt_name, name); //name
        MobileActions.Sendkeys(gotitCreate.txt_password, password); //password
        MobileActions.Sendkeys(gotitCreate.txt_retype, password); //retype password
        MobileActions.Click(gotitCreate.btn_create);
        Uninterruptibles.sleepUninterruptibly(4000, TimeUnit.MILLISECONDS); //wait 4 seconds for error message
        if (gotitExist.lb_error != null) { //check if the error message appears
            return true;
        } else
            return false;
    }

    @Step("Add User's tasks")
    public static void AddTasks() {
        for (int i = 0; i < CSVusers.length; i++) {
            LogoutUser(); //if a user is connected - logout
            MobileActions.Click(gotitStart.btn_login);
            wait.until(ExpectedConditions.visibilityOf(gotitLogin.btn_login));
            MobileActions.Sendkeys(gotitLogin.txt_email, CSVusers[i][0]); //email
            MobileActions.Sendkeys(gotitLogin.txt_password, CSVusers[i][2]); //password
            MobileActions.Click(gotitLogin.btn_login);
            MobileActions.Click(gotitTasks.btn_add);
            /// i was busy building the internal methods so i didn't had enough time

        }
    }

    public static void LogoutUser() {
        try {
            MobileActions.Click(gotitTasks.btn_avatar);
            wait.until(ExpectedConditions.visibilityOf(gotitLogout.btn_logout));
            MobileActions.Click(gotitLogout.btn_logout);
            MobileActions.Click(gotitConfirm.btn_yes);
        } catch (Exception e) {
            //ignore the Exception
        }
    }

    public static void GetToDate(int day, int month) {
        //swipe to the date picker
        MobileActions.swipe(mobileDriver.manage().window().getSize().width / 2, mobileDriver.manage().window().getSize().height, mobileDriver.manage().window().getSize().width / 2, 0, 500);

        String[] arr;
        if (gotitAddTask.lb_current_date.getText().equals("היום")) {  //if it today split today's date
            arr = java.time.LocalDate.now().toString().split("-"); //0=year 1=month 2=day
            //replace then rows location to be compatiabler with the "label mode"
            arr[0] = arr[1]; //month
            arr[1] = arr[2]; //day
        } else { //otherwise split the date in the label
            //string = "יום ו׳ 16 ביולי"
            arr = gotitAddTask.lb_current_date.getText().split(" ");
            switch (arr[0]) { //convert the month to number
                case "ביולי":
                    arr[0] = "7";
                    break;
                case "באוג'":
                    arr[0] = "8";
                    break;
                case "בספט'":
                    arr[0] = "9";
                    break;
                case "באוק'":
                    arr[0] = "10";
                    break;
                case "בנוב'":
                    arr[0] = "11";
                    break;
                case "בדצמ'":
                    arr[0] = "12";
                    break;
                case "בינו'":
                    arr[0] = "1";
                    break;
                default:
                    System.out.println("");
            }

        }

    }
}
