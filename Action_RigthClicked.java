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

public class Action_RigthClicked {
    public static void main(String[] args) throws  InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/rightClickContextMenuInteraction.html");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action=new Actions(driver);

        WebElement targetBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("targetBox")));

        action.contextClick(targetBox).perform();

        WebElement contextMenu=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contextMenu")));
        if(contextMenu.isDisplayed()){
            System.out.println("Pass: Context Menu Appered rigth-clicked");
        }else {
            System.out.println("Fail:Context Menu did not apper");
        }

        //Click"delete option---//
        WebElement deleteOption =wait.until(ExpectedConditions.elementToBeClickable(By.id("deleteOption")));
        deleteOption.click();

        String result=driver.findElement(By.id("result")).getText();
        if(result.equals("You selected: Delete")){
            System.out.println("Pass: 'Delete' Option selected correctly. Result "+result);

        }else {
            System.out.println("Fail: Result mismatch> Actual "+result);

        }
        driver.quit();

    }
}
