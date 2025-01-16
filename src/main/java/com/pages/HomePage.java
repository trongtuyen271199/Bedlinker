package com.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.Utils;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void waitForPageToLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(driver -> js.executeScript("return document.readyState").equals("complete"));
    }

 

    // Element Box seach
    public By byTxtWelcome = By.xpath(
            "//div[@class='container-fluid']//div[@class='container animate-background-color']//h1[text()='Welcome!!!!']");

    // Element Đơn hàng
    public By byOrder = By.xpath("(//li[@class='c-sidebar-nav-dropdown' and @data-v-afcd1a82])[1]");

    public HomePage clickOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOrder)).click();
        return this;
    }

    // Element Danh sách đơn hàng
    public By byOrderList = By.xpath("//a[@href='#/order/order-booking-list']");

    public HomePage clickOrderList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOrderList)).click();
        return this;
    }

}
