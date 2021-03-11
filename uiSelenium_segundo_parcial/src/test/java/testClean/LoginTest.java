package testClean;

import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.SignUpModal;
import pomPages.todoLy.MainPage;
import pomPages.todoLy.MenuSection;


public class LoginTest extends  TestBaseTodoLy{

    MainPage mainPage= new MainPage();
    SignUpModal signUpModal = new SignUpModal();
    MenuSection menuSection= new MenuSection();
    String user="QASegundoParcial@upb.com";
    String pwd="1234";

    @Test
    public void verifySignUptodoly(){
        mainPage.signUpImage.click();
        signUpModal.emailTextBox.set(user);
        signUpModal.fullNameTextBox.set(user);
        signUpModal.pwdTextBox.set(pwd);
        signUpModal.agreeButton.click();
        signUpModal.loginButton.click();
        Assert.assertTrue("ERROR, no se logueo",menuSection.logoutButton.controlIsDisplayed());
    }


}
