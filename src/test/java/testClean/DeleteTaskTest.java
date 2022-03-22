package testClean;

import activities.calculator.MainScreenCalc;
import activities.whenDo.MainScreen;
import activities.whenDo.TaskScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sesion.Session;

import java.net.MalformedURLException;

public class DeleteTaskTest {
    String task ="new task";
    MainScreen mainScreen = new MainScreen(task);
    TaskScreen taskScreen = new TaskScreen();
    @Test
    public void deleteTaskVerify() throws InterruptedException, MalformedURLException {

        mainScreen.addTaskButton.click();;
       taskScreen.taskNameTextBox.setValue(task);
       taskScreen.taskNotesTextBox.setValue(task+" notes");
       taskScreen.saveButton.click();
       Thread.sleep(2000);
       Assertions.assertTrue(mainScreen.createdTask.isControlDisplayed());
       mainScreen.createdTask.click();
       taskScreen.deleteButton.click();
       taskScreen.confirmDeleteButton.click();
       Thread.sleep(2000);
       Assertions.assertTrue(mainScreen.noTasks.isControlDisplayed());

    }

    @AfterEach
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }

}
