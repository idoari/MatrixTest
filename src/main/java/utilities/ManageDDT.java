package utilities;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


public class ManageDDT extends CommonOps{




    public static List<String> readCSV(String CSVfile)    {
        List<String> lines = new ArrayList<>();
        File file = new File(CSVfile);
        try {
            lines =Files.readAllLines(file.toPath(), StandardCharsets.UTF_8); // LIST = LIST
        } catch (IOException e) {
            System.out.println("An error occurred." + e);
        }
        return lines;
    }

    @Step("reading  CSV file to array")
    public static String[][] getDataFromCSV(String filepath,int arraysize) {
        List<String> csvData = readCSV(filepath);
        try {
            if (csvData.size() == 0) return null; //if the file empty
            String[][] data = new String[csvData.size()][arraysize];
            if (arraysize == 3) {
                for (int i = 0; i < csvData.size(); i++) {
                    data[i][0] = csvData.get(i).split(",")[0]; //email
                    data[i][1] = csvData.get(i).split(",")[1]; //name
                    data[i][2] = csvData.get(i).split(",")[2]; //password
                }
            }
            else { //if it tasks
                for (int i = 0; i < csvData.size(); i++) {
                    data[i][0] = csvData.get(i).split(",")[0]; //email
                    data[i][1] = csvData.get(i).split(",")[1]; //password
                    data[i][2] = csvData.get(i).split(",")[2]; //category
                    data[i][3] = csvData.get(i).split(",")[3]; //title
                    data[i][4] = csvData.get(i).split(",")[4]; //sub task
                    data[i][5] = csvData.get(i).split(",")[5]; //date
                    data[i][6] = csvData.get(i).split(",")[6]; //time
                }
            }
            return data;
            }
        catch (ArrayIndexOutOfBoundsException E) {
           return null;
        }
    }



}
