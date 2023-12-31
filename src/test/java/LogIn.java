import DataObject.LoginData;
import StepObject.LoginSteps;
import Utils.ChromeRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static DataObject.LoginData.*;

public class LogIn extends ChromeRunner {

    @Test (priority = 1)
    @Description ("დალოგინების მცდელობა არასწორი მეილის ფორმატით და არასწორი პაროლით.")
     @Severity(SeverityLevel.BLOCKER)
    public void LogInWithInvalidData() throws InterruptedException {

        LoginSteps step1 = new LoginSteps(driver);

        step1.emailinput(invalidEmailData);
        step1.passwordinput(invalidPasswordData);
        step1.loginButton();

        String actualTitle = driver.getTitle();
        String expectedTitle = "შესვლა - CLOUD9.GE";
       Assert.assertEquals(actualTitle, expectedTitle);



      Thread.sleep(500);
    }

    @Test (priority = 2)
    @Description ("დალოგინების მცდელობა სწორი (რეგისტრირებული) მეილით და არასწორი პაროლით.")
    @Severity(SeverityLevel.BLOCKER)


    public void logInWithValidEmail() throws InterruptedException {


        LoginSteps step2 = new LoginSteps(driver);

        step2.emailinput(validEmailData);
        step2.passwordinput(invalidPasswordData);
        step2.loginButton();


        Thread.sleep(5000);

    }
    @Test (priority = 3)
    @Description ("დალოგინების მცდელობა არასწორი მეილის ფორმატით და არსებული (სწორი) პაროლით.")
    @Severity(SeverityLevel.BLOCKER)

    public void logInWithValidPassword() throws InterruptedException {


        LoginSteps step3 = new LoginSteps(driver);

        step3.emailinput(invalidEmailData);
        step3.passwordinput(validPasswordData);
        step3.loginButton();


        Thread.sleep(5000);
    }

    @Test (priority = 4)
    @Description ("დალოგინების მცდელობა, როდესაც გვიწერია მხოლოდ პაროლი და მეილის ველი ცარიელია.")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithEmptyEmail() throws InterruptedException {


        LoginSteps step4 = new LoginSteps(driver);

        step4.emailinput(emptyEmailData);
        step4.passwordinput(validPasswordData);
        step4.loginButton();


        Thread.sleep(5000);
    }

    @Test (priority = 5)
    @Description ("დალოგინების მცდელობა, როდესაც გვიწერია მხოლოდ მეილი და პაროლის ველი ცარიელია.")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithEmptyPassword() throws InterruptedException {


        LoginSteps step5 = new LoginSteps(driver);

        step5.emailinput(validEmailData);
        step5.passwordinput(emptyPasswordData);
        step5.loginButton();



        Thread.sleep(5000);
    }
    @Test (priority = 6)
    @Description ("დალოგინების მცდელობა ცარიელი ველებით.")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithEmptyFields() throws InterruptedException {


        LoginSteps step6 = new LoginSteps(driver);

        step6.emailinput(emptyEmailData);
        step6.passwordinput(emptyPasswordData);
        step6.loginButton();

        Thread.sleep(5000);

    }


    @Test (priority = 7)
    @Description ("დალოგინების მცდელობა, სწორი ფორმატის არარეგისტრირებული მეილით და არსებული (სწორი) პაროლით.")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithUnregisteredEmail() throws InterruptedException {


        LoginSteps step7 = new LoginSteps(driver);

        step7.emailinput(unregisteredCorrectEmail);
        step7.passwordinput(validPasswordData);
        step7.loginButton();

        Thread.sleep(5000);
    }
    @Test (priority = 8)
    @Description ("დალოგინების მცდელობა, სწორი ფორმატის არარეგისტრირებული მეილით და არასწორი პაროლით.")
    @Severity(SeverityLevel.BLOCKER)
    public void logInWithUnregisteredEmailInvalidPass() throws InterruptedException {


        LoginSteps step8 = new LoginSteps(driver);

        step8.emailinput(unregisteredCorrectEmail);
        step8.passwordinput(invalidPasswordData);
        step8.loginButton();



                Thread.sleep(5000);
    }


    @Test (priority = 9)
    @Description ("მეილის გამოწერის მცდელობა")
    @Severity(SeverityLevel.MINOR)


    public void subscribe() throws InterruptedException {


        LoginSteps step9 = new LoginSteps(driver);

        //step9.secondEmailInput(validEmailforsubscription);
        //step9.subscribeButton();

         By secondEmailField  = By.name("email");
         By validEmailforsubscription = By.linkText("nanka.tughushi@gmail.com");
         driver.findElement(secondEmailField).sendKeys("nanka.tughushi@gmail.com");
         By subscribeButton = By.id("submitsubscribe");
         driver.findElement(subscribeButton).click();
         WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();

        Thread.sleep(5000);
    }
    @Test (priority = 10)
    @Description ("დალოგიების მცდელობა, სწორი მეილის და პაროლის ჩაწერის დროს.")
    @Severity(SeverityLevel.BLOCKER)


    public void logInWithValidData() throws InterruptedException {


        LoginSteps step10 = new LoginSteps(driver);

        step10.emailinput(validEmailData);

        By emailField = By.id("inputEmail");
        String actualResult = driver.findElement(emailField).getAttribute("value");
        Assert.assertEquals(actualResult, validEmailData);

        step10.passwordinput(validPasswordData);
        step10.loginButton();


        Thread.sleep(5000);
    }

    }

