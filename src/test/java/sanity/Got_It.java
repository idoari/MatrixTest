package sanity;

import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class Got_It extends CommonOps {

/*
    @Test(description="test01 - add Users from CSV file")
    @Description("this test adds Users from CSV file")
    public static void Test01_AddUsers()  {
        MobileFlows.AddUsers();
    }
*/

    @Test(description="test02 - add tasks from CSV file")
    @Description("this test adds Tasks from CSV file to the appropriate")
    public static void  Test02_AddTasks()  {
        MobileFlows.AddTasks();
    }



}
