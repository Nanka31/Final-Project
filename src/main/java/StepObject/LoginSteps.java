package StepObject;

import PageObject.LogInPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSteps extends LogInPage {
    WebDriver driver;

    public LoginSteps(WebDriver driver1) {

        driver = driver1;
    }

    @Step("იმეილის ველში მონაცემების ჩაწერა")
    public void emailinput(String e) {
        driver.findElement(emailField).sendKeys(e);



    }

    @Step("პაროლის ველში მონაცემების ჩაწერა")
    public void passwordinput(String p) {
        driver.findElement(passwordField).sendKeys(p);

    }

    @Step("Login-ის ღილაკზე დაჭერა")
    public void loginButton() {
        driver.findElement(logInButton).click();

    }

    @Step("მეორე მეილის ფილდში მეილის ჩაწერა")
    public void secondEmailInput (String str) {
        driver.findElement(secondEmailField).sendKeys(str);

    }

    @Step("გამოწერის ღილაკზე დაჭერა")
    public void subscribeButton() {
        driver.findElement(subscribeButton).click();
    }

}
