package environment;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnvironmentManager {
    public static String OS = System.getProperty("os.name").toLowerCase();

    public static boolean checkSystem() {

        if (OS.contains("win")) {
            //Location from Chromedriver
            System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
            return true;
        } else {
            System.out.println("Syestem not supported");
            return false;
        }

    }

    public static void initWebDriver() {

        WebDriver driver = new ChromeDriver();
        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }
}
