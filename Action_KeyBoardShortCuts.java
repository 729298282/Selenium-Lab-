package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action_KeyBoardShortCuts {
    public static void main(String[] args) throws  InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/keyboardShortcuts.html");
        Actions actions=new Actions(driver);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement sourceText=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sourceText")));
        WebElement targetText = driver.findElement(By.id("targetText"));
        sourceText.click();

        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Sekect All performed on source container");

        actions.keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Copy all Text");

        targetText.click();

        actions.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Paste all Text in target Container");





        String result=driver.findElement(By.id("result")).getText();
        if(result.equals("Text copied successfully to Target !")){
            System.out.println("Pass: Text all copied in target Conatiner");
        }else {
            System.out.println("Fail: Text in Target does not match Source yet. ");
        }
        driver.quit();
    }
}
