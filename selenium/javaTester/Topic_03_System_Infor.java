package javaTester;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

import java.io.File;

public class Topic_03_System_Infor {

    public static void main(String[] args) {
        String osName = System.getProperty("os.name");
        System.out.println(osName);


        String projectPath = System.getProperty("user.dir");

        String hcmName = "HCM.jpg";
        String dlName = "DaLat.jpg";
        String pyName = "PhuYen.jpg";

//        String hcmFilePath = projectPath + "\\upploadFiles\\" + hcmName;
//        String dlFilePath = projectPath + "\\upploadFiles\\" + dlName;
//        String pyFilePath = projectPath + "\\upploadFiles\\" + pyName;

        String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";

        String hcmFilePath = projectPath + character + "upploadFiles" + character + hcmName;
        String dlFilePath = projectPath + character + "upploadFiles" + character + dlName;
        String pyFilePath = projectPath + character + "upploadFiles" + character + pyName;


       // String pyFilePath = projectPath + File.separator + "upploadFiles" + File.separator + pyName;
    }
}
