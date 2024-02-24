//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Scanner;

public class Main {


    public static void main(String[]args)  {

        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\SHASHANK\\OneDrive\\Desktop\\selenium jars\\drivers\\chromedriver.exe");

        // Initialize the WebDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Launch the URL
        driver.get("https://demoqa.com/login");

        // Click on the "New User" button to go to the registration page
        WebElement newUserButton = driver.findElement(By.id("newUser"));
        newUserButton.click();

        // Fill registration details
        WebElement firstNameField = driver.findElement(By.id("firstname"));
        WebElement lastNameField = driver.findElement(By.id("lastname"));
        WebElement usernameField = driver.findElement(By.id("userName"));
        WebElement passwordField = driver.findElement(By.id("password"));


        // Enter registration details
        firstNameField.sendKeys("shashank");
        lastNameField.sendKeys("gudimetla");
        usernameField.sendKeys("shashank");
        passwordField.sendKeys("Password123@");

        // Handle "I am not a robot" checkbox (if needed)
        WebElement captchaCheckbox = driver.findElement(By.id("g-recaptcha"));
        if (!captchaCheckbox.isSelected()) {
            captchaCheckbox.click();
        }

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*// Click on the register button
        WebElement registerButton = driver.findElement(By.id("register"));
        registerButton.click();*/

        WebElement registerButton = driver.findElement(By.id("register"));
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", registerButton);
            registerButton.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            // Handle the exception
            System.out.println("ElementClickInterceptedException: Register button click intercepted");
        }

        // Wait for registration to complete
        // Handle the pop-up alert

        Duration duration = Duration.ofMillis(3000);
        try {
            WebDriverWait wait = new WebDriverWait(driver, duration); // Wait up to 3 seconds
            if (wait.until(ExpectedConditions.alertIsPresent()) != null) {
                Alert alert = driver.switchTo().alert();
                alert.accept(); // Click on the OK button in the alert
            }
        } catch (Exception e) {
            // Alert not present or other exception occurred
            e.printStackTrace();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click on the "Back to Login" button
        WebElement backToLoginButton = driver.findElement(By.id("gotologin"));
        backToLoginButton.click();

        // Fill login details with the newly registered user
        WebElement loginUsernameField = driver.findElement(By.id("userName"));
        WebElement loginPasswordField = driver.findElement(By.id("password"));

        // Enter username and password
        loginUsernameField.sendKeys("shashank");
        loginPasswordField.sendKeys("Password123@");

        // Click on the login button
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

        // Wait for a few seconds to see the result
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        // driver.quit();
    }
}

// FOR THE DEMO VIDEO PLS CHECK THE VIDEO IN THE ISUES
