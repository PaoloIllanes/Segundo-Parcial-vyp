package pomPages.todoLy;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SignUpModal {
    public TextBox fullNameTextBox= new TextBox(By.xpath("//input [@name='ctl00$MainContent$SignupControl1$TextBoxFullName']"));
    public TextBox emailTextBox= new TextBox(By.xpath("//input [@name='ctl00$MainContent$SignupControl1$TextBoxEmail']"));
    public TextBox pwdTextBox= new TextBox(By.xpath("//input [@name='ctl00$MainContent$SignupControl1$TextBoxPassword']"));
    public Button loginButton= new Button(By.xpath("//input[@id='ctl00_MainContent_SignupControl1_ButtonSignup']"));
    public Button agreeButton = new Button(By.xpath("//span//input[@type='checkbox']"));
    public SignUpModal(){}

    public void signUpAction(String user, String pwd){
        emailTextBox.set(user);
        fullNameTextBox.set(user);
        pwdTextBox.set(pwd);
        agreeButton.click();
        loginButton.click();
    }

}
