import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private SelenideElement usernameField = $(byCssSelector("[name='username']"));

    private SelenideElement passwordField = $(byAttribute("placeholder","Password"));

    private SelenideElement loginButton = $x("//button[@type=\"submit\"]");

    private SelenideElement errorMessage = $(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']"));

    private SelenideElement forgotPasswordLink = $(byClassName("orangehrm-login-forgot"));

    private SelenideElement logo = $("img[alt='company-branding']");

    private SelenideElement credSection =$(byClassName("orangehrm-demo-credentials"));

//    private SelenideElement RequiredFieldUsername = $(byCssSelector("[class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]"));
//    private SelenideElement RequiredFieldPassword = $(By.xpath("//*[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'])[2]"));


    public void enterUsername(String usernameValue) {
        usernameField.shouldBe(visible);
        usernameField.setValue(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        passwordField.setValue(passwordValue);
    }
    public void pushLoginButton(){
        loginButton.click();
    }
    public void invalidCredText(String expectedText){
        errorMessage.shouldBe(visible);
        errorMessage.shouldHave(text(expectedText));
    }

    public void followTheForgotPasswordLink() {
        forgotPasswordLink.shouldBe(visible);
        forgotPasswordLink.click();
    }

    public void logoIsDisplayed() {
        logo.shouldBe(visible);

    }

    public void logoImageIsCorrect(){
        logo.shouldHave(attributeMatching("src",
                ".*branding.png.*"));
    }

    public void credSectionIsDisplayed() {
        credSection.shouldBe(visible);

    }



}

