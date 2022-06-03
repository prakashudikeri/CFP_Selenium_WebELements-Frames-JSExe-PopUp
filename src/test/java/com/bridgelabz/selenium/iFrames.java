package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class iFrames {
    WebDriver driver;
    @BeforeMethod
    public void initialization() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void frame_Demo() throws InterruptedException {
        driver.get("C:\\Users\\Prakash Udikeri\\IdeaProjects\\CFP - Automation Testing\\" +
                "JavaScript\\src\\main\\resources\\iFrame2.html");
        driver.findElement(By.id("t2")).sendKeys("T2 Text Field");
            Thread.sleep(4000);

        driver.switchTo().frame("f1");
        driver.findElement(By.id("t1")).sendKeys("T1 text Field");
            Thread.sleep(4000);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("f3");
        driver.findElement(By.id("t3")).sendKeys("T3 text Field");
            Thread.sleep(4000);

        driver.switchTo().defaultContent();
            Thread.sleep(4000);

        driver.findElement(By.id("t2")).clear();
    }

    @AfterMethod
    public void close_Driver() throws InterruptedException {
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
