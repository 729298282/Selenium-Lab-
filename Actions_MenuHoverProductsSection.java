package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Actions_MenuHoverProductsSection {
    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/actionClass_Menu.html#");
        try {
            //1) Products Menu ----//
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
            Actions actions=new Actions(driver);

            WebElement menuItem=driver.findElement(By.id("productsMenu"));
            actions.moveToElement(menuItem).perform();

            WebElement subMenuItem=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("productsSubmenu")));

            if(subMenuItem.isDisplayed()){
                System.out.println("Pass: SubMEnu "+subMenuItem + " Appererd on Hover");
            }else {
                System.out.println("Fail: SubMEnu "+subMenuItem + " Not Appererd on Hover");

            }

            actions.moveToElement(menuItem).perform();
            WebElement laptopLink=wait.until(ExpectedConditions.elementToBeClickable(By.id("laptopsLink")));
            laptopLink.click();

            String resultText=driver.findElement(By.id("result")).getText();
            if(resultText.equals("You clicked: Laptops")){
                System.out.println("Pass: Clicked Laptop");
            }else {
                System.out.println("Fail: Result Mismatched");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            driver.quit();
        }
    }

}
