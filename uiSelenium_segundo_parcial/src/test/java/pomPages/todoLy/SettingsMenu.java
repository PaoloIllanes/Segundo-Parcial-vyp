package pomPages.todoLy;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SettingsMenu {
    public TextBox fullNameTextBox= new TextBox(By.xpath("//input[@id='FullNameInput']"));
    public Button aceptar= new Button(By.xpath("/html/body/div[9]/div[2]/div/button[1]/span"));
    public SettingsMenu(){}
    public void changeFullName(String NewName){
        fullNameTextBox.set("");
        fullNameTextBox.set(NewName);
        aceptar.click();

    }
}
