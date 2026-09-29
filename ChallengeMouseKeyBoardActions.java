package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChallengeMouseKeyBoardActions {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("file:///C:/Users/ccst/Downloads/challenge_MouseKeyboardActions.html");

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action= new Actions(driver);

        WebElement documentmenu= driver.findElement(By.id("documentsMenu"));
        action.moveToElement(documentmenu).perform();

        WebElement documentBtm=wait.until(ExpectedConditions.elementToBeClickable(By.id("uploadDocLink")));
        documentBtm.click();
        System.out.println("Click on upload button");

        WebElement uploadSection=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("documentsSubmenu")));
        if(uploadSection.isDisplayed()){
            System.out.println("Pass: Scroll Down ");
        }else {
            System.out.println("Fail:Scroll no happen");
        }

        String filePath="C:\\Users\\ccst\\Desktop\\gitDemo\\Hello.html";
        WebElement fileInput=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileInput")));
        fileInput.sendKeys(filePath);

        WebElement uploadBtm=driver.findElement(By.id("uploadBtn"));
        uploadBtm.click();

        String result=driver.findElement(By.id("result")).getText();
        if(result.equals("You greedy fellow !!")){
            System.out.println("Pass: 'You greedy fellow !!' Message Handled correctly");
        }else {
            System.out.println("Fail: Message Mismatched");
        }

    driver.quit();
    }
}
