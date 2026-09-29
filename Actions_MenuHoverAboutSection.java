package org.example.SeleniumDay3;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions_MenuHoverAboutSection {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/actionClass_Menu.html#");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action=new Actions(driver);

        WebElement menuItem= driver.findElement(By.id("aboutMenu"));
        action.moveToElement(menuItem).perform();

        WebElement subMenuItem=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("teamLink")));
        if(subMenuItem.isDisplayed()){
            System.out.println("Pass: SubMEnu "+subMenuItem + " Appererd on Hover");
        }else {
            System.out.println("Fail: SubMEnu "+subMenuItem + " Not Appererd on Hover");

        }

        action.moveToElement(menuItem).perform();
        WebElement laptopLink=wait.until(ExpectedConditions.elementToBeClickable(By.id("teamLink")));
        laptopLink.click();
        String resultText=driver.findElement(By.id("result")).getText();
        if(resultText.equals("You clicked: Team")){
            System.out.println("Pass: Clicked Support");
        }else {
            System.out.println("Fail: Result Mismatched");
        }
        driver.quit();


    }

}
