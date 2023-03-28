package com.demo.nopcommerce;


import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.Properties;

public class RegisterTestPage {

    WebDriver driver;

    BasePage basePage = new BasePage();

    Properties prop = new Properties();

    RegisterPage registerPage;

    @BeforeMethod
    public void OpenBrowser () throws FileNotFoundException {
        basePage = new BasePage();
        prop = basePage.InitialiseProperties();
        String WebEngine = prop.getProperty("Browser");
        driver = basePage.InitialiseDriver(WebEngine);
        driver.get(prop.getProperty("URL"));
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void registerTest () throws InterruptedException {
        registerPage.clickOnRegisterLink();
        registerPage.clickOnGender();
        registerPage.doRegister(prop.getProperty("gender"), prop.getProperty("FirstName"), prop.getProperty("LastName"), prop.getProperty("Day"), prop.getProperty("Month"), prop.getProperty("Year"), prop.getProperty("Email"), prop.getProperty("CompanyName"), prop.getProperty("Password"), prop.getProperty("ConfirmPassword"));
        registerPage.clickOnRegister();
        Thread.sleep(3000);

    }
    @AfterMethod
    void CloseBrowser (){driver.close();}

    }

