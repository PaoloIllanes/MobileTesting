package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class basicAppium {

    private AppiumDriver appiumDriver;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","Redmi Note 8");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("appPackage","com.miui.calculator");
        capabilities.setCapability("appActivity",".cal.CalculatorActivity");
        capabilities.setCapability("platformName","Android");
        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApp(){
        appiumDriver.quit();
    }

    @Test
    public void verifyCalculator() throws InterruptedException {
       appiumDriver.findElement(By.id("android:id/button1")).click(); //android:id/button1
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_5_s")).click();
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();
        appiumDriver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();

        String expected= "7";
        String actual= appiumDriver.findElement(By.id("com.miui.calculator:id/result")).getText();
        Assertions.assertEquals(expected,actual);



        Thread.sleep(2000);
    }

}
