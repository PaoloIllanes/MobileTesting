package testClean;

import activities.calculator.MainScreenCalc;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sesion.Session;

import java.net.MalformedURLException;

public class CalculatorTest {
    MainScreenCalc mainScreenCalc = new MainScreenCalc();
    @Test
    public void sumaTest() throws MalformedURLException {
        mainScreenCalc.twoButton.click();
        mainScreenCalc.plusButton.click();
        mainScreenCalc.fiveButton.click();
        mainScreenCalc.equalsButton.click();

        String expectResult="7";
        String actualResult= mainScreenCalc.resultLabel.getText();
        Assertions.assertEquals(expectResult,actualResult,"ERROR la suma es incorrecta");
    }

    @AfterEach
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
