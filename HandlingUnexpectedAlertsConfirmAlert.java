package org.example.SeleniumDay3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingUnexpectedAlertsConfirmAlert {
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

            driver.findElement(By.id("confirmBtn")).click();
            Alert confirmAlert=wait.until(ExpectedConditions.alertIsPresent());

            String confirmMessage=driver.findElement(By.id("confirmResult")).getText();
            if(confirmMessage.equals("You clicked OK.")){
                System.out.println("Pass : Confirm Message Hanled");
            }else {
                System.out.println("FAil: Error Message Mismatch");
            }

            Thread.sleep(1000);
            System.out.println("Page Title: "+driver.getTitle());
            Thread.sleep(2000);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            driver.quit();
        }

    }
}
