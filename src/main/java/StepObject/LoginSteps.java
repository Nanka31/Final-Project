package StepObject;

import PageObject.LogInPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends LogInPage {
WebDriver driver;

    public LoginSteps(WebDriver driver1){                //კონსტრუქტორი

        driver =  driver1;
    }

    @Step ("იმეილის ველში მონაცემების ჩაწერა")
    public void emailinput (String e){
        driver.findElement(emailField).sendKeys(e);

    }
    @Step ("პაროლის ველში მონაცემების ჩაწერა")
    public void passwordinput (String p) {
        driver.findElement(passwordField).sendKeys(p);

    }
    @Step ("Login-ის ღილაკზე დაჭერა")
    public void loginButton(){
        driver.findElement(logInButton).click();

    }
    @Step ("Google ღილაკზე დაჭერა")
    public void gButton() {
        driver.findElement(googleButton).click();

    }
    @Step ("პორტალი ღილაკზე დაჭერა")
    public void portali() {
        driver.findElement(portaliButton).click();
    }
}
