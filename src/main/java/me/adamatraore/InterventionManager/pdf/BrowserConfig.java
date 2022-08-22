package me.adamatraore.InterventionManager.pdf;

import java.util.logging.Level;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserConfig {

    @Value("${chrome.driver-location}")
    private String driverLocation;

    @Bean
    public ChromeDriver webDriver() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions()
                .addArguments(
                        "--no-sandbox",
                        "--whitelisted-ips",
                        "--disable-extensions",
                        "--verbose",
                        "--headless"
                ).setHeadless(true);
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        options.setCapability( "goog:loggingPrefs", logPrefs);
        ChromeDriver driver = new ChromeDriver(options);
        driver.setLogLevel(Level.ALL);
        return driver;
    }
}