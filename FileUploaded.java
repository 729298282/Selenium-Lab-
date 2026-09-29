package org.example.SeleniumDay3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FileUploaded {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
       driver.get("file:///C:/Users/ccst/Desktop/Web%20Automationn-Selinium/SeleniumMaterial/fileUpload.html");

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement fileInpot = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileInput")));
        //fileInpot.click();

        String filepath= "C:\\Users\\ccst\\Desktop\\Web Automationn-Selinium\\SeleniumMaterial\\welcome.html";
        fileInpot.sendKeys(filepath);
        Thread.sleep(3000);

        System.out.println("File Send Succesfully!");

        WebElement fileNameLabel =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fileName")));

        if(fileNameLabel.getText().contains("welcome.html")){
            System.out.println("Pass: file selected and display correctly"+fileNameLabel);
        }else {
            System.out.println("Fail: file name displayed as expected .Actual "+fileNameLabel);
        }

        WebElement uploadBtn= driver.findElement(By.id("uploadBtn"));
        uploadBtn.click();

        WebElement result=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String message="File 'welcome.html' uploaded successfully!";
        if (result.getText().equals(message)) {
            System.out.println("Pass : File Upload Confirmed. Message "+result.getText());
        }else {
            System.out.println("Fail: File Not Uploded");
        }
        driver.quit();

    }
}
