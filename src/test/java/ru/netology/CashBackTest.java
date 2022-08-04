package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CashBackTest {
    private WebDriver driver;


    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();

    }

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        driver = null;

    }

    @Test
    public void Card1() {
        driver.get("http://localhost:9999/");
        List<WebElement> elements = driver.findElements(By.className("input__control"));
        driver.findElement(By.cssSelector("[data-test-id='name'] input")).sendKeys("Иван Петров-Сидоров");
        driver.findElement(By.cssSelector("[data-test-id='phone'] input")).sendKeys("+79001112233");
        driver.findElement(By.cssSelector("[data-test-id=agreement] .checkbox__box")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualText = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText();
        String expected = ("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.");
        assertEquals(expected, actualText.trim());


    }

}





