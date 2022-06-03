package com.bridgelabz.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Action_Class {
    WebDriver driver = null;

    @BeforeMethod
    public void initialization(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void mouse_Hover() throws InterruptedException {
        driver.get("https://meesho.com/");
        WebElement menu = driver.findElement
                (By.xpath("//div[@class='DesktopHeader__HeaderStyled-sc-r0p6o1-0 bOvSTC']//div[7]"));
        Actions actions = new Actions(driver);
            Thread.sleep(2000);
        actions.moveToElement(menu).perform();
            Thread.sleep(2000);
    }

    @Test
    public void drag_Drop() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
            Thread.sleep(2000);
        actions.dragAndDrop(driver.findElement(By.id("draggable")),
        driver.findElement(By.id("droppable"))).perform();
            Thread.sleep(2000);
    }

    @Test
    public void drop_Down_Menu() throws InterruptedException {
        driver.get("http://www.actimind.com/");
        WebElement menu = driver.findElement(By.xpath("//a[@class='c-link dropdown-toggle']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
//        WebElement submenu = driver.findElement(By.tagName("link"));
//        Thread.sleep(2000);
//        submenu.click();
    }
    @Test
    public void drag_Drop_Offset(){
        driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
        WebElement block1 = driver.findElement(By.xpath("//p[contains(text(),'Block 1 data')]"));
        WebElement block2 = driver.findElement(By.xpath("//p[contains(text(),'Block 2 data')]"));
        WebElement block3 = driver.findElement(By.xpath("//p[contains(text(),'Block 3 data')]"));
        Actions actions = new Actions(driver);
                System.out.println("Block 1 : "+ block1.getLocation()+ "Block 2 :"+block2.getLocation()+
                        "Block 3 :"+block3.getLocation());
        //Block 1 : (222, 286)Block 2 :(222, 385)Block 3 :(442, 286)
        actions.dragAndDropBy(block1, block3.getLocation().getX()+10,
                block3.getSize().getHeight()+10).perform();
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

