package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action_RigthClickedEleseWhere {
    public static void main(String[] args) throws  InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/rightClickContextMenuInteraction.html");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action=new Actions(driver);

        WebElement OutSidetargetBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > h2")));

        action.contextClick(OutSidetargetBox).perform();

        Boolean contextMenu=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("contextMenu")));
        if(contextMenu){
            System.out.println("Pass:Appered rigth-clicked on Outside of ContextBox");
        }else {
            System.out.println("Fail: did not apper");
        }


        driver.quit();

    }
}
