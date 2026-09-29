package org.example.SeleniumDay3;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import  java.lang.Double;

public class JavaScriptExcuterZoomIn {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor js= (JavascriptExecutor) driver;

        double zoomLevelBefore = (double) js.executeScript("return window.devicePixelRatio");
        System.out.println("Current zoom Ratio: "+zoomLevelBefore);

        Actions actions=new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("+").keyUp(Keys.CONTROL).perform();

        Thread.sleep(2000);

        double zoomLevelAfter= (double) js.executeScript("return window.devicePixelRatio");
        System.out.println("Current zoom Ratio: "+zoomLevelAfter);

        driver.quit();

     }
}
