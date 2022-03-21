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

public class CreateTaskWhenDo {

    private AppiumDriver appiumDriver;

    @BeforeEach
    public void openApplication() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("deviceName","Redmi Note 8");
        capabilities.setCapability("platformVersion","11.0");
        capabilities.setCapability("appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appActivity",".ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


        // implicit
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterEach
    public void closeApplication(){
        appiumDriver.quit();
    }

    @Test
    public void verifyCalculator() throws InterruptedException {
        String taskName="newTask";
        appiumDriver.findElement(By.xpath("//android.widget.ImageButton[@resource-id='com.vrproductiveapps.whendo:id/fab']")).click();
        appiumDriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.vrproductiveapps.whendo:id/noteTextTitle']")).sendKeys(taskName);
        appiumDriver.findElement(By.xpath("//android.widget.EditText[@text='Notas']")).sendKeys(taskName);
        appiumDriver.findElement(By.xpath("//android.widget.TextView[@content-desc='Guardar']")).click();
        Thread.sleep(2000);


        Assertions.assertTrue(appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='"+taskName+"']")).isDisplayed(),"Task was not created");

    }

}
