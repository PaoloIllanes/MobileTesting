package controles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sesion.Session;

import java.net.MalformedURLException;

public class AppiumControl {

    public WebElement control;
    public By locator;

    public AppiumControl(By locator){
        this.locator=locator;
    }

    public void find() throws MalformedURLException {
        this.control= Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click() throws MalformedURLException {
        this.find();
        this.control.click();
    }

    public boolean isControlDisplayed(){
        try {
            this.find();
            return this.control.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getText() throws MalformedURLException {
        this.find();
        return this.control.getText();
    }

    public String getValueAttribute(String attribute) throws MalformedURLException {
        this.find();
        return this.control.getAttribute(attribute);
    }

}
