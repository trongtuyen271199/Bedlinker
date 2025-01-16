package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.Utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @Given("the user is on the homepage")
    public void givenUserIsOnHomepage() {
        String url = "http://bedlinker.dev.ebk.vn/#/login";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @When("user enters username {string}")
    public void userEnterEmail(String usernamel) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail(usernamel);

    }

    @When("user enters password {string}")
    public void userEnterPass(String pass) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterPassword(pass);

    }

    @When("user submit login")
    public void userSubmitLogin() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterLogin();

        try {
            Thread.sleep(5000); // Dừng 5 giây (5000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    // sai user name 
    public boolean isMessageLoginErrorUsernameDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageErroUsernamel));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login error username {string}")
    public void verifyLoginErrorUsername(String expectedMessageLoginErrorUsernametDisplay) {
        boolean expectedMessageErrorUsername = Boolean.parseBoolean(expectedMessageLoginErrorUsernametDisplay); 
        boolean messageLoginErrorUsernameDisplayed = isMessageLoginErrorUsernameDisplayed();
        Assert.assertEquals(messageLoginErrorUsernameDisplayed, expectedMessageErrorUsername);
    }
    // sai pass
    public boolean isMessageLoginErrorPassDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageErroPass));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login error pass {string}")
    public void verifyLoginErrorPass(String expectedMessageLoginErrorPasstDisplay) {
        boolean expectedMessageErrorPass = Boolean.parseBoolean(expectedMessageLoginErrorPasstDisplay); 
        boolean messageLoginErrorPassDisplayed = isMessageLoginErrorPassDisplayed();
        Assert.assertEquals(messageLoginErrorPassDisplayed, expectedMessageErrorPass);
    }


    // null usser name 
    public boolean isMessageLoginNullUsernameDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageNullUsername));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    @Then("verify login null username {string}")
    public void verifyLoginNullUsername(String expectedMessageLoginNullrUsernametDisplay) {
        boolean expectedMessageNullUsername = Boolean.parseBoolean(expectedMessageLoginNullrUsernametDisplay); 
        boolean messageLoginNullUsernameDisplayed = isMessageLoginNullUsernameDisplayed();
        Assert.assertEquals(messageLoginNullUsernameDisplayed, expectedMessageNullUsername);
    }


// null pass

public boolean isMessageLoginNullPassDisplayed() {
    try {
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageNullPass));
        return true;
    } catch (Exception e) {
        return false;
    }

}
@Then("verify login null pass {string}")
public void verifyLoginNullPass(String expectedMessageLoginNullPasstDisplay) {
    boolean expectedMessageNullPass = Boolean.parseBoolean(expectedMessageLoginNullPasstDisplay); 
    boolean messageLoginNullPassDisplayed = isMessageLoginNullPassDisplayed();
    Assert.assertEquals(messageLoginNullPassDisplayed, expectedMessageNullPass);
}


public boolean isMessageLoginSuccessDisplayed() {
    try {
        LoginPage loginPage = new LoginPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageLoginSuccess));
        return true;
    } catch (Exception e) {
        return false;
    }

}

@Then("verify login successfully {string}")
public void verifyLoginSuccess(String expectedMessageLoginSuccesstDisplay) {
    boolean expectedLoginSuccess = Boolean.parseBoolean(expectedMessageLoginSuccesstDisplay);
    boolean messageLoginSuccessDisplayed = isMessageLoginSuccessDisplayed();
    Assert.assertEquals(messageLoginSuccessDisplayed, expectedLoginSuccess);

}

    @Then("user click avatar")
    public void userClickAvatar() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickAvatar();
    }

    @Then("user submit logout")
    public void userSubmitLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLogout();

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}