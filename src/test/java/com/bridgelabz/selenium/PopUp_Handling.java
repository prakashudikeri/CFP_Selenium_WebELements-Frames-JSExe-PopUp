package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class PopUp_Handling {
    WebDriver driver = null;

    @BeforeMethod
    public void initialization(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void file_Upload_AutoIT_popUP() throws InterruptedException, IOException {       //  4
        driver.get("https://www.freepdfconvert.com/pdf-to-word");
            Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Choose PDF file')]")).click();
            Thread.sleep(3000);
        Runtime.getRuntime().exec("C:\\Users\\Prakash Udikeri\\Desktop\\FileUploadSample.exe");
    }


    @Test
    public void alert_Prompt_Popup() throws InterruptedException {      //  1
        driver.get("http://www.tizag.com/javascriptT/javascriptprompt.php");
        driver.findElement(By.xpath("//input[@value='Say my name!']")).click();
            Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
                System.out.println(alert.getText());
            Thread.sleep(2000);
        alert.sendKeys("Prakash");
            Thread.sleep(2000);
        alert.accept();
            Thread.sleep(2000);
                System.out.println(alert.getText());
//        alert.dismiss();

    }

    @Test
    public void file_Upload_PopUp() throws InterruptedException {       //  4
        driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple");
            Thread.sleep(2000);
        driver.findElement(By.xpath("//input[1]")).
                sendKeys("C:\\Users\\Prakash Udikeri\\Desktop\\New Text Document.txt");
            Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@class='btn btn-success btn-s']")).click();
            Thread.sleep(2000);
    }

    @Test
    public void file_Download_PopUp() throws InterruptedException {
        driver.get("http://www.seleniumhq.org/download/");
            Thread.sleep(3000);
        driver.findElement(By.linkText("4.2.1")).click();
            Thread.sleep(3000);
    }

    @Test
    public void child_Browser_Popup() throws InterruptedException {
        driver.get("https://www.naukri.com/");
            Thread.sleep(4000);
        driver.findElement(By.xpath("//div[contains(text(),'Jobs')]")).click();
            Thread.sleep(4000);
        Set<String> allWindowHandles = driver.getWindowHandles();
            Thread.sleep(4000);
        int count = allWindowHandles.size();
            Thread.sleep(4000);
        System.out.println("Number of browser windows opened on the system is : " + count);
            Thread.sleep(4000);

        for (String windowHandle : allWindowHandles) {
                driver.switchTo().window(windowHandle);
                String title = driver.getTitle();
                System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
        }
    }

    @Test           //Before - After Method (X)
    public void hidden_Division_Popup_C_Edge() throws InterruptedException {        //  2
        WebDriverManager.edgedriver().setup();
        //driver = new EdgeDriver();

        EdgeOptions option = new EdgeOptions();
        WebDriver driver = new EdgeDriver(option);
        driver.manage().window().maximize();
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-geolocation");
        option.addArguments("--ignore-certificate-errors");

        driver.get("https://www.naukri.com/browse-jobs");
            Thread.sleep(9000);

        driver.findElement(By.id("allow")).click();
       // driver.findElement(By.xpath("(//input[@placeholder='Pick a date'])[1]")).click();
            Thread.sleep(3000);
        driver.findElement(By.linkText("24")).click();
    }

        @AfterMethod
    public void close_Driver(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

}
