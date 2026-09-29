package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action_DragDrop {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver =new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/dragDrop.html");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions=new Actions(driver);

        WebElement item1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item1")));
        WebElement targetContainer =driver.findElement(By.id("targetContainer"));


        //Ateempt 1: Frag And Drop built In Method
        actions.dragAndDrop(item1,targetContainer).perform();

        String result1=driver.findElement(By.id("result")).getText();
        if(result1.contains("Write Manual Testcases moved to Done")){
            System.out.println("Pass: Drag and Drop wokrd With DragAndDrop().");
        }else {
            System.out.println("Fail: DragAndDrop() did not register the move as Expected.");
        }
        Thread.sleep(1000);

        //-----Attempt2: MAnual clicked hold move relese sequence----///

        WebElement item2=driver.findElement(By.id("item2"));

        actions.clickAndHold(item2)
                .moveToElement(targetContainer)
                .pause(Duration.ofMillis(300))
                .release()
                .build()
                .perform();

        String result2=driver.findElement(By.id("result")).getText();
        if(result2.contains("Define Entry and Exit Criteria moved to Done")){
            System.out.println("Pass");
        }else {
            System.out.println("Fail");
        }

        driver.quit();
    }
}
