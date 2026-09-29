package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action_KeyBoardShortCutsClearAllContainer {
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
        targetText.click();

        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .perform();
        System.out.println("Sekect All performed on source container");
        targetText.click();

        actions.keyDown(Keys.DELETE)
                .perform();
        System.out.println("Clear all Contain");

        String clearResult = driver.findElement(By.id("result")).getText();
        if (clearResult.equals("Text in Target does not match Source yet.")){
            System.out.println("Pass:");
        }else {
            System.out.println("Fail:");
        }
        driver.quit();
    }
}
