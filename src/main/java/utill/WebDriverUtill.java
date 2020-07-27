package utill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class WebDriverUtill {
    public WebDriver getWebDriver() {
        URL res = getClass().getClassLoader().getResource("chromedriver.exe");
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
            String path = file.getAbsolutePath();
            System.setProperty("webdriver.chrome.driver", path);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        return webDriver;
    }
}
