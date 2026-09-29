package org.example.SeleniumDay3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExcuterHighlight {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor js= (JavascriptExecutor) driver;

        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/TestcasesClassAssignment-drivingLicenseUI.html");
       Thread.sleep(3000);
        WebElement heading = driver.findElement(By.xpath("//h2"));

        js.executeScript("arguments[0].style.border='3px solid red'",heading);
        Thread.sleep(3000);


        driver.quit();

     }
}
