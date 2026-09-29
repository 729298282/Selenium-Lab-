package org.example.SeleniumDay3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingUnexpectedAlertsPromptAlert {
    public static void main(String[] args) {
        // -----SETUP: Configure driver to auto-handle unexpected alerts----///

        ChromeOptions options = new ChromeOptions();
        options.setCapability("unhandledPromptBehavior","accept");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {

            driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/javascriptAlerts.html");

           WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));

            WebElement promptMessage = driver.findElement(By.id("promptBtn"));
            promptMessage.click();

            Alert promptAlert =wait.until(ExpectedConditions.alertIsPresent());
            Thread.sleep(1000);
            promptAlert.sendKeys("Hello");
            Thread.sleep(1000);

            String resultMesage = driver.findElement(By.id("promptResult")).getText();
            System.out.println(resultMesage);
            if(resultMesage.equals("You entered: Hello")){
                System.out.println("Pass: Prompt Message Hanled ");
            }else {
                System.out.println("Fail:Prompt message Mismatched");
            }



            

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            driver.quit();
        }

    }
}
