package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExcuterHiddenButtonClicked {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        JavascriptExecutor js= (JavascriptExecutor) driver;

        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/hiddenElementJavascriptExecutor.html");
        WebElement hiddenBtn= driver.findElement(By.id("hiddenBtn"));
        Thread.sleep(1000);


        try {
            hiddenBtn.click();
            System.out.println("Click () succeessed");
        } catch (Exception e) {
            System.out.println("Clic () Failed");
        }
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();",hiddenBtn);
        String hiddenText = (String) js.executeScript("return arguments[0].textContent;",hiddenBtn) ;
        System.out.println("Hidden Button text: "+hiddenText);

        Thread.sleep(5000);

        String result2=driver.findElement(By.id("result")).getText();
        if(result2.equals("Hey Your Trasure will be at your doorstep, wait until TOMORROW !")){
            System.out.println("Pass: Hidden button cliked Correctly "+result2);
        }else {
            System.out.println("Fail: Hidden button Mismatched "+result2);
        }



        driver.quit();

     }
}
