import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends BaseTest {

    @Test
    public void successLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.pushLoginButton();
        dashboardPage.correctHeaderText();
    }

    @Test
    public void invalidPassword(){
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin");
        loginPage.pushLoginButton();
        loginPage.invalidCredText("Invalid credentials");
    }

//    @Test
//    public void emptyInputFields(){
//        //Leave password and username empty
//        //check error messages "Required"
//    }

    @Test
    public void forgetPassword(){
        loginPage.followTheForgotPasswordLink();
        //check that we on Reset Password page
        resetPasswordPage.checkResetPasswordTittle();
        //check URL is correct  metod in class urlIsCorrect
        resetPasswordPage.urlIsCorrect();


    }

@Test
    public void elementsAreVisible(){
        loginPage.logoIsDisplayed();
        loginPage.credSectionIsDisplayed();
        loginPage.logoImageIsCorrect();


    }

}