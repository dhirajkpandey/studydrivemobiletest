package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.Activity;
import java.net.MalformedURLException;
import java.net.URL;

public class RegisterUser {
    WebDriver driver;
    DesiredCapabilities cap = new DesiredCapabilities();
    @BeforeClass
    public void setUp() throws InterruptedException, MalformedURLException {

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(CapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M32");

            //this is my device id and should be replaced with the one on which it will run
            caps.setCapability(MobileCapabilityType.UDID, "RF8T40FGMAF");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            Thread.sleep(5000);

        }
            @Test
            public void signUp () {
                driver.get("https://www.studydrive.net/");
                WebElement signupButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
                signupButton.click();
                WebElement acceptCookie = driver.findElement(By.xpath("//button[contains(text(),'Accept all')]"));
                JavascriptExecutor executor = (JavascriptExecutor) driver;
                executor.executeScript("arguments[0].click();", acceptCookie);
                acceptCookie.click();
                WebElement userEmail = driver.findElement(By.xpath("//input[@type= 'email']"));
                userEmail.sendKeys("mastertest7291@gmail.com");
                WebElement userPass = driver.findElement(By.xpath("//input[@type= 'password']"));
                userPass.sendKeys("Qa@studydrive");
                WebElement registerSignUpButton = driver.findElement(By.xpath("//span[text() = 'Sign up for free']"));
                registerSignUpButton.click();
            }
        }
