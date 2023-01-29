package Domaci_26_1_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class Helper {
    public boolean elementExist(WebDriver driver, By by) {
        boolean exists = true;
        try {
            driver.findElement(by);
        } catch (NoSuchElementException error) {
            exists = false;
        }
        return exists;
    }
}
