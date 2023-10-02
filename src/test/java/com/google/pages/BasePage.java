package com.google.pages;

import com.google.utils.LoadProps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
        String browser = props.getProperty("browserName");
        if (browser.equals("chrome")) {
            driver = WebDriverManager.chromedriver().capabilities(setChromeOptions()).create();
            navigateToBaseurl("chrome");
        } else if (browser.equals("firefox")) {
            driver = WebDriverManager.firefoxdriver().capabilities(setFireFoxOptions()).create();
            navigateToBaseurl("firefox");
        } else if (browser.equals("ie")) {
            driver = WebDriverManager.iedriver().create();
            navigateToBaseurl("ie");
        } else {
            System.out.println(browser + " is not supported");
        }
    }

    public WebDriver navigateToBaseurl(String browserType) throws IOException {
        switch (browserType) {
            case "chrome":
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
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-extensions"); // disabling extensions
        chromeOptions.addArguments("--no-sandbox");  // Bypass OS security model
        chromeOptions.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        chromeOptions.addArguments("--disable-incognito"); // Disable incognito mode
        chromeOptions.addArguments("--window-size=1920,1080"); // Set window size
        return chromeOptions;
    }

    private FirefoxOptions setFireFoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--disable-extensions"); // disabling extensions
        firefoxOptions.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        firefoxOptions.addArguments("--disable-incognito"); // Disable incognito mode
        firefoxOptions.addArguments("--window-size=1920,1080"); // Set window size
        return firefoxOptions;
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit(); // Quit the browser
        }
    }
}
