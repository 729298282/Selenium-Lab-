package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JavaScriptExcuterGetTitle {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor js= (JavascriptExecutor) driver;

        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/hiddenElementJavascriptExecutor.html");
        WebElement hiddenBtn= driver.findElement(By.id("hiddenBtn"));
        Thread.sleep(1000);


        String title = (String) js.executeScript("return document.title;");
        System.out.println("Title is: "+title);

        Thread.sleep(2000);


        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement scroolTargetBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("scrollTargetBtn")));
        js.executeScript("arguments[0].scrollIntoView(true);",scroolTargetBtn);
        Thread.sleep(3000);


        if(scroolTargetBtn.isDisplayed()){
            System.out.println("Pass:ScollButton is Displed");
        }else {
            System.out.println("Fail: Scrool Button Not Displyed");
        }

        //js.executeScript("arguments[0].click();",scroolTargetBtn);
        scroolTargetBtn.click();
        Thread.sleep(2000);

        String result=driver.findElement(By.id("result")).getText().trim();
        if(result.equals("Better Luck Next Time :-)")){
            System.out.println("Pass: Message Handled GraceFully");
        }else {
            System.out.println("Fail: Message Mismatched");
        }



        driver.quit();

     }
}
