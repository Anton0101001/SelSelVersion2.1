package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.Conversions.trim;


public class CashBackTest {
    private WebDriver driver;


    @BeforeAll

    public static void setUpAll() {
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");

    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;

    }

    @Test
    public void testCard1() {
        driver.get("http://localhost:9999/");
//        driver.findElement().sendKeys("Петров Иван");
//        driver.findElement().sendKeys("+79001112233");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        elements.get(0).sendKeys("Петров Иван");
        elements.get(1).sendKeys("+79001112233");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.className("button")).click();
        String actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        String expected = ("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.");
        assertEquals(expected, actualText.trim());


    }

}





