package com.google.pages;

import com.google.utils.LoadProps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class BasePage {
    public static WebDriver driver;
    private static final LoadProps props = new LoadProps();

    @BeforeTest
    public void setUp() throws IOException {
        instantiateBrowserDriver("chrome");
    }

    public WebDriver instantiateBrowserDriver(String browserType) throws IOException {
        switch (browserType) {
            case "chrome":
                driver = new ChromeDriver(setChromeOptions());
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.of(5, SECONDS)); // Set implicit wait
                driver.get(props.getProperty("baseUrl")); // Navigate to the Google Home Page URl
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println(browserType + " is not supported");
        }
        return driver;
    }

    private ChromeOptions setChromeOptions() throws IOException {
        System.setProperty("webdriver.http.factory", "jdk-http-client"); // Set HTTP client factory
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--no-sandbox");  // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--disable-incognito"); // Disable incognito mode
        options.addArguments("--window-size=1920,1080"); // Set window size

        return options;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit(); // Quit the browser
        }
    }
}
