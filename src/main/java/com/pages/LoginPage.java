package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

// input user name
By byUsername = By.xpath("//input[@id='username']");

public LoginPage enterUserName(String username) {
    WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(byUsername));
    userNameField.clear();
    userNameField.sendKeys(username);
    return this;
}
   
// input pass
By byPassword = By.xpath("//input[@id='password']");

public LoginPage enterPassword(String pw) {
    WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword));
    passwordField.clear();
    passwordField.sendKeys(pw);
    return this;
}

// button login 
By byLoginBtn = By.xpath("//button[@class='btn px-4 btn-primary']");

public LoginPage enterLogin() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
    return this;
}

//  ======================================================================
//  ======================================================================
//  ======================================================================
//  ====================================================================== 


//     // button quên mâtk khẩu 
//     By byButtonForgetPassword = By.xpath("//a[text()='Quên mật khẩu?']");

//     public LoginPage clickForgetPassword() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonForgetPassword)).click();
//         return this;
//     }
//     // check box ghi nhớ mật khẩu 
//     By byCheckboxRememberPassword= By.xpath("//input[@id='rememberme']");

//     public LoginPage clickCheckboxRememberPassword() {
//         wait.until(ExpectedConditions.visibilityOfElementLocated(byCheckboxRememberPassword)).click();
//         return this;
//     }
// // email không đúng 
//  public By messageErroEmail= By.xpath("//ul[@class='woocommerce-error']/li[contains(text(), 'Địa chỉ email không xác định')]");
// // null email + nulll email  pass 
//  public By messageNullAccount= By.xpath("//li[strong = 'Lỗi:']/text()[contains(., 'Yêu cầu tên tài khoản')]");
//  // sai pass
//  public By messageNullPass = By.xpath("//li[strong[text() = 'Lỗi']]");
//  // null pass 
//  public By messageFailsePass = By.xpath("//ul[@class='woocommerce-error']/li/a[contains(text(), 'Bạn quên mật khẩu?')]");

}
