
//Testirati rad kalkulatora https://testsheepnz.github.io/BasicCalculator.html.
// Testirati rad svih operacija posebno.
//
//Za njega napisati edge case-eve na koje naletite,
// ili ispunite neka matematicka pravila
// (deljenje sa nulom, jedinicom, veliki/mali brojevi itd).
// Napisati minimum 4 edge case-a po testnoj metodi, 16 ukupno (minimum), zanemarujuci Concatenate.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Calculator {

   private WebDriver driver;
   private WebElement firstNumber;
    WebElement secondNumber;
    private WebElement calculate;
    private WebElement answer;
    private WebElement operation;


    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Destop PC\\IdeaProjects\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("window.scrollBy(0,800)");

    }

    @BeforeMethod
    public void restart(){
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        firstNumber = driver.findElement(By.id("number1Field"));
        secondNumber = driver.findElement(By.id("number2Field"));
        calculate = driver.findElement(By.id("calculateButton"));
        answer = driver.findElement(By.id("numberAnswerField"));
        operation = driver.findElement(By.id("selectOperationDropdown"));
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    @Test
    public void add() throws InterruptedException {
        firstNumber.sendKeys("-5");
        secondNumber.sendKeys("5");
        calculate.click();
        String actualResult = answer.getAttribute("value");
        String expectedResult = "0";
        Assert.assertTrue(actualResult.equals(expectedResult));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);



        firstNumber.sendKeys("0");
        secondNumber.sendKeys("20000");
        calculate.click();
        String actualResult2 = answer.getAttribute("value");
        String expectedResult2 = "20000";
        Assert.assertTrue(actualResult2.equals(expectedResult2));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);



        firstNumber.sendKeys("-5");
        secondNumber.sendKeys("-5");
        calculate.click();
        String actualResult3 = answer.getAttribute("value");
        String expectedResult3 = "-10";
        Assert.assertTrue(actualResult3.equals(expectedResult3));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("-5");
        secondNumber.sendKeys("-5");
        calculate.click();
        String actualResult4 = answer.getAttribute("value");
        String expectedResult4 = "-10";
        Assert.assertTrue(actualResult4.equals(expectedResult4));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);

    }

    @Test
    public void subtract() throws InterruptedException {

        firstNumber.sendKeys("10");
        secondNumber.sendKeys("-5");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        operation.sendKeys("Subtract");
        calculate.click();
        String actualResult5 = answer.getAttribute("value");
        String expectedResult5 = "15";
        Assert.assertTrue(actualResult5.equals(expectedResult5));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);



        firstNumber.sendKeys("10");
        secondNumber.sendKeys("0");
        calculate.click();
        String actualResult6 = answer.getAttribute("value");
        String expectedResult6 = "10";
        Assert.assertEquals(actualResult6, expectedResult6);
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("-10");
        secondNumber.sendKeys("-5");
        calculate.click();
        String actualResult7 = answer.getAttribute("value");
        String expectedResult7 = "-5";
        Assert.assertEquals(actualResult7, expectedResult7);
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("10");
        secondNumber.sendKeys("10");
        calculate.click();
        String actualResult8 = answer.getAttribute("value");
        String expectedResult = "0";
        Assert.assertEquals(actualResult8, expectedResult);
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);
    }


    @Test
    public void multiply() throws InterruptedException {
        firstNumber.sendKeys("0");
        secondNumber.sendKeys("1");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        operation.sendKeys("Multiply");
        calculate.click();
        String actualResult9 = answer.getAttribute("value");
        String expectedResult9 = "0";
        Assert.assertTrue(actualResult9.equals(expectedResult9));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);



        firstNumber.sendKeys("0");
        secondNumber.sendKeys("-1");
        calculate.click();
        String actualResult10 = answer.getAttribute("value");
        String expectedResult10 = "0";
        Assert.assertTrue(actualResult10.equals(expectedResult10));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("-1");
        secondNumber.sendKeys("-1");
        calculate.click();
        String actualResult11 = answer.getAttribute("value");
        String expectedResult11 = "1";
        Assert.assertTrue(actualResult11.equals(expectedResult11));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("100");
        secondNumber.sendKeys("100");
        calculate.click();
        String actualResult12 = answer.getAttribute("value");
        String expectedResult12 = "10000";
        Assert.assertTrue(actualResult12.equals(expectedResult12));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);

    }


    @Test
    public void divide() throws InterruptedException {
        firstNumber.sendKeys("10");
        secondNumber.sendKeys("1");
        WebElement operation = driver.findElement(By.id("selectOperationDropdown"));
        operation.sendKeys("Divide");
        calculate.click();
        String actualResult13 = answer.getAttribute("value");
        String expectedResult13 = "10";
        Assert.assertTrue(actualResult13.equals(expectedResult13));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);



        firstNumber.sendKeys("10");
        secondNumber.sendKeys("10");
        calculate.click();
        String actualResult14 = answer.getAttribute("value");
        String expectedResult14 = "1";
        Assert.assertTrue(actualResult14.equals(expectedResult14));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("-10");
        secondNumber.sendKeys("-10");
        calculate.click();
        String actualResult15 = answer.getAttribute("value");
        String expectedResult15 = "1";
        Assert.assertTrue(actualResult15.equals(expectedResult15));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);


        firstNumber.sendKeys("10");
        secondNumber.sendKeys("-10");
        calculate.click();
        String actualResult16 = answer.getAttribute("value");
        String expectedResult16 = "-1";
        Assert.assertTrue(actualResult16.equals(expectedResult16));
        Thread.sleep(2000);
        firstNumber.clear();
        secondNumber.clear();
        Thread.sleep(2000);

    }



}
