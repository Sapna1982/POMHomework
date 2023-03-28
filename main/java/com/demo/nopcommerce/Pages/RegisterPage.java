package com.demo.nopcommerce.Pages;

import com.demo.nopcommerce.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver driver;
    Utils utils;

    By RegisterLink = By.className("ico-register");
    By GFM = By.id("gender-female");
    By FName = By.id("FirstName");
    By LName = By.id("LastName");
    By DayDOB = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]");
    By MonthDOB = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[2]");
    By YearDOB = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[3]");
    By Emails = By.id("Email");
    By CName = By.id("Company");
    By Pass = By.id("Password");
    By ConfirmPass = By.id("ConfirmPassword");
    By RegisterButton = By.xpath("//*[@id=\"register-button\"]");

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        utils = new Utils(driver);

    }

    public void clickOnRegisterLink() {
        utils.doClick(RegisterLink);
    }
    public void clickOnRegister() {
        utils.doClick(RegisterButton);
    }

    public void clickOnGender() {
        utils.doClick(GFM);
    }

    public void doRegister(String gender, String FirstName, String LastName, String Day, String Month, String Year, String Email, String CompanyName, String Password,String ConfirmPassword){
        utils.doSendkey(GFM, gender);
        utils.doSendkey(FName, FirstName);
        utils.doSendkey(LName, LastName);
        utils.doSendkey(DayDOB, Day);
        utils.doSendkey(MonthDOB, Month);
        utils.doSendkey(YearDOB, Year);
        utils.doSendkey(Emails, Email);
        utils.doSendkey(CName, CompanyName);
        utils.doSendkey(Pass, Password);
        utils.doSendkey(ConfirmPass, ConfirmPassword);
        utils.doClick(RegisterButton);

    }
}
