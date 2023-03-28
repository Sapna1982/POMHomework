package com.demo.nopcommerce.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    WebDriver driver;
    static Properties prop;
    static FileInputStream file;

    public WebDriver InitialiseDriver(String browserName){

        if (browserName.equals("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browserName.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Browser Not Matched");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        return driver;

    }

    public Properties InitialiseProperties () throws FileNotFoundException {
         prop = new Properties();

    try {
        file = new FileInputStream("C:\\Users\\Sapna Sharma\\IdeaProjects\\PageObjectModel\\src\\test\\resources\\TestData\\config.properties");
        prop.load(file);
    }
    catch (FileNotFoundException e){
        System.out.println("config file is not found, please check...");
        }
    catch (IOException e){
        System.out.println("Properties could not be loaded");
    }
        return prop;

    }

}

