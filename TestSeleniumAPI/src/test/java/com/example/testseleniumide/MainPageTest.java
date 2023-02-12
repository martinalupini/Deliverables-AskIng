package com.example.testseleniumide;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;


/*
The aim of the test is to verify that the traduction of the word "gatto" is done correctly by a translating website.
 */



public class MainPageTest {

    @Test
    public void testTraduction(){

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://context.reverso.net/traduzione/");

        driver.manage().window().setSize(new Dimension(600,800));
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[2]/button[2]")).click();


        WebElement textField=  driver.findElement(By.xpath("/html/body/div[3]/section[2]/div[1]/div[1]/input"));
        textField.sendKeys("gatto");

        driver.findElement(By.xpath("/html/body/div[3]/section[2]/div[1]/button")).click();

        WebElement text=  driver.findElement(By.xpath("/html/body/div[3]/section[1]/div[2]/section[4]/div[1]/div[2]/span[2]/a/em"));
        String traduction = text.getText();

        assertEquals(traduction, "cat");

    }

}
