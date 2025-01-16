package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By byUsername = By.xpath("//input[@id='username']");

    public LoginPage enterEmail(String uname) {
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(byUsername));
        userNameField.clear();
        userNameField.sendKeys(uname);
        return this;
    }

    By byPassword = By.xpath("//input[@id='password']");

    public LoginPage enterPassword(String pw) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword));
        passwordField.clear();
        passwordField.sendKeys(pw);
        return this;
    }

    By byLoginBtn = By.xpath("//button[@class='btn px-4 btn-primary']");

    public LoginPage enterLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        return this;
    }

    By byButtonForgetPassword = By.xpath("//a[@href='#/forgot-password']");

    public LoginPage clickForgetPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonForgetPassword)).click();
        return this;
    }

    public By messageLoginSuccess = By.xpath("//p[text()='Đăng nhập thành công.']");

    public By messageErroUsernamel = By.xpath("//p[text()='Tài khoản không tồn tại']");

    public By messageErroPass = By.xpath("//p[text()='Mật khẩu không hợp lệ']");

    public By messageNullUsername = By.xpath("//p[@class='m-1']//strong[text()='Tên đăng nhập']");

    public By messageNullPass = By.xpath("//p[@class='m-1']//strong[text()='Mật khẩu']");

    By byAvatar = By.xpath("//div[@class='c-avatar ml-3 avatar']");
    public LoginPage clickAvatar() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAvatar)).click();
        return this;
    }
    By byLogoutBtn = By.xpath("(//a[@role='menuitem'])[5]");
    public LoginPage clickLogout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutBtn)).click();
        return this;
    }

}