package testClean;

import org.junit.Assert;
import org.junit.Test;
import pomPages.todoLy.MainPage;
import pomPages.todoLy.MenuSection;

public class LogOutTest {
    MainPage mainPage= new MainPage();
    MenuSection menuSection= new MenuSection();

    @Test
    public void verifySignUptodoly(){
        menuSection.logoutButton.click();
        Assert.assertTrue("ERROR, no se deslogueo",mainPage.signUpImage.controlIsDisplayed());
    }
}
