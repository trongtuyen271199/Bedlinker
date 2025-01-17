package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public By byLogoutBtn = By.xpath("//li[contains(@class,'logout')]");
    public HomePage clickLogout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLogoutBtn)).click();
        return this;
    }
// form seach
// Box seach
    By bySeachBox = By.xpath("//input[@placeholder='Tìm kiếm...'][1]");
    public HomePage inputSeach(String valueSeach) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySeachBox)).sendKeys(valueSeach);
        return this;
    }
// First Seach Result
    By byFirstSeachResult = By.xpath("//a[@class='tt-selectable' and contains(., 'Mercedes')]");
    public HomePage selectFirstSeachResult() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byFirstSeachResult)).click();
        return this;
    }
// icon seach 

// message thông báo login thành công 
public By byMessageLoginSuccess = By.xpath("//p[text()='Đăng nhập thành công.']");
}

