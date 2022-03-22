package activities.whenDo;

import controles.Button;
import controles.Label;

import org.openqa.selenium.By;

public class MainScreen {
    public String taskname;
    public Label createdTask;
    public MainScreen(String taskName){
         this.createdTask = new Label(By.xpath("//android.widget.TextView[@text='"+taskName+"']"));
    }

    public Button addTaskButton = new Button(By.xpath("//android.widget.ImageButton[@resource-id='com.vrproductiveapps.whendo:id/fab']"));
    public Label noTasks = new Label(By.xpath("//android.widget.TextView[@text='No se agregaron tareas']"));



}
