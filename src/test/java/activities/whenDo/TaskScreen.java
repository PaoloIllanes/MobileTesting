package activities.whenDo;

import controles.Button;
import controles.TextBox;
import org.openqa.selenium.By;

public class TaskScreen {

    public TextBox taskNameTextBox = new TextBox(By.xpath("//android.widget.EditText[@resource-id='com.vrproductiveapps.whendo:id/noteTextTitle']"));
    public TextBox taskNotesTextBox = new TextBox(By.xpath("//android.widget.EditText[@text='Notas']"));
    public Button saveButton = new Button(By.xpath("//android.widget.TextView[@content-desc='Guardar']"));
    public Button deleteButton = new Button(By.xpath("//android.widget.TextView[@content-desc='Eliminar']"));
    public Button confirmDeleteButton = new Button(By.xpath("//android.widget.Button[@text='ELIMINAR']"));



}
