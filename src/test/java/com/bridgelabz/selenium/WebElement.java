package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebElement {
    WebDriver driver;

    @BeforeMethod
    public void initialization() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    /*Use Location method to validate Username & Password fields in login page to check whether they are aligned not */
    @Test
    public void check_Alignment_getLocation() {
        driver.get("https://app.hubspot.com/login");
        org.openqa.selenium.WebElement unTB = driver.findElement(By.id("username"));
        org.openqa.selenium.WebElement pwdTB = driver.findElement(By.id("password"));

        int username_Ycoordinate = unTB.getLocation().getY();
            System.out.println("Y Co-ordinate Email :" + username_Ycoordinate);
        int password_Ycoordinate = pwdTB.getLocation().getY();
            System.out.println("Y Co-ordinate Password :" + password_Ycoordinate);

        if (username_Ycoordinate == password_Ycoordinate) {
            System.out.println("Both username and password fields are aligned in the same row");
        } else {
            System.out.println("username and password fields are NOT aligned in the same row");
        }

        int username_x_coordinate = unTB.getLocation().getX();
            System.out.println("X Co-ordinate Email :" + username_x_coordinate);
        int password_Xcoordinate = pwdTB.getLocation().getX();
            System.out.println("X Co-ordinate Password :" + password_Xcoordinate);

            if (username_x_coordinate == password_Xcoordinate) {
            System.out.println("Both username and password fields are aligned in the same row");
        } else {
            System.out.println("username and password fields are NOT aligned in the same row");
        }
    }

    /* To validate whether the height and width of Username & Password fields are same or not */
    @Test
    public void verify_Dimension_getSize() {
        driver.get("https://app.hubspot.com/login");
        org.openqa.selenium.WebElement unTB = driver.findElement(By.id("username"));
        org.openqa.selenium.WebElement pwdTB = driver.findElement(By.id("password"));

        int username_width = unTB.getSize().getWidth();
        int username_height = unTB.getSize().getHeight();
        int password_width = pwdTB.getSize().getWidth();
        int password_height = pwdTB.getSize().getHeight();

            System.out.println("Height Of username Tab :" + username_height + "\nHeight Of Password Tab : "
                + password_height + "\nWidth Of username Tab : " + username_width + "\nWidth Of Password Tab : "
                + password_width);

        if (username_height == password_height && username_width == password_width) {
            System.out.println("Username and password fields are aligned");
        } else {
            System.out.println("Username and password fields are NOT aligned");
        }
    }

    /* To clear - remove values from the input elements */
    @Test
    public void remove_Value_clear() throws InterruptedException {
        driver.get("https://www.facebook.com/");
            Thread.sleep(2000);
        driver.findElement(By.name("email")).sendKeys("abc1 23@yahoo.com");
            Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("abc @123");
            Thread.sleep(4000);
        driver.findElement(By.name("email")).clear();
            Thread.sleep(2000);
        driver.findElement(By.name("pass")).clear();
            Thread.sleep(2000);

    // For removing value if clear() is not working
        driver.findElement(By.name("email")).sendKeys("xyz 123 @rediffmail.com");
            Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("xyz @ 123");
            Thread.sleep(4000);
        driver.findElement(By.name("email")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
            Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
            Thread.sleep(2000);
    }

    @Test
    public void checkBox_isSelected() throws InterruptedException {
        driver.get("https://app.hubspot.com/login");
            Thread.sleep(2000);
        org.openqa.selenium.WebElement rememberMe_Checkbox = driver.
                findElement(By.xpath("//i18n-string[contains(text(),'Remember me')]"));
        rememberMe_Checkbox.click();
            Thread.sleep(2000);

        if (rememberMe_Checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is NOT selected");
        }
    }

    @AfterMethod
    public void close_Driver() throws InterruptedException {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}