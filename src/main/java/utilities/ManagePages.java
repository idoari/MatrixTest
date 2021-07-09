package utilities;

public class ManagePages extends Base {


    public static void initGotIt() {
        gotitStart = new pageObjects.GotIt.StartPage(mobileDriver);
        gotitCreate = new pageObjects.GotIt.CreateUser(mobileDriver);
        gotitTasks = new pageObjects.GotIt.Tasks(mobileDriver);
        gotitLogout = new pageObjects.GotIt.UserLogout(mobileDriver);
        gotitConfirm = new pageObjects.GotIt.ConfirmLogout(mobileDriver);
        gotitLogin = new pageObjects.GotIt.LoginPage(mobileDriver);
        gotitExist = new pageObjects.GotIt.ExistUser(mobileDriver);
        gotitAddTask = new pageObjects.GotIt.AddTask(mobileDriver);
    }

}
