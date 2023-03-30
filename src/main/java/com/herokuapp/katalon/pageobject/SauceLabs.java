package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.logger.Logs;
import com.herokuapp.katalon.testdatalayer.dto.UserDto;
import com.herokuapp.katalon.utilities.CSVUtilities;
import com.herokuapp.katalon.utilities.JSONUtilities;
import com.herokuapp.katalon.utilities.TakeScreenshot;
import com.herokuapp.katalon.utilities.WebDriverUtils;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

import static com.herokuapp.katalon.utilities.RandomSelector.getRandom;
import static org.testng.Assert.assertSame;
import static org.testng.Assert.assertTrue;

@Getter
public class SauceLabs {

    private final WebDriver driver;

    public SauceLabs(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logs logs = new Logs();

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    private WebElement loginBox;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordBox;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    private WebElement loginButton;

    @FindBy(css = ".btn")
    private List<WebElement> addToCardButtonList;

    @FindBy(css = ".shopping_cart_container")
    private WebElement shoppingCartBadge;

    @FindBy(css = ".inventory_list")
    private WebElement inventoryList;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cart;

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    @FindBy(css = "#first-name")
    private WebElement checkOutFirstName;

    @FindBy(css = "#last-name")
    private WebElement checkOutLastName;

    @FindBy(css = "#postal-code")
    private WebElement checkOutPostalCode;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement checkOutContinueButton;

    @FindBy(css = "#finish")
    private WebElement finishCheckoutButton;

    public void openHomePage(){
        driver.get("https://www.saucedemo.com/");
        WebDriverUtils.waitForElement(driver, loginBox, 15);
        assertTrue(passwordBox.isDisplayed());
        logs.process("Home Page successfully opened");
        takeScreenshot("Home Page successfully opened");
    }

    private void takeScreenshot(String screenShotName){
        try{
        TakeScreenshot.takeScreenshot(driver, screenShotName);}
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void signInFromJSONFile() {
        JSONUtilities jsonUsers = new JSONUtilities();
        for (UserDto user : jsonUsers.getUsersList()){
            loginBox.sendKeys(user.getUsername());
            passwordBox.sendKeys(user.getPassword());
            loginButton.click();
            WebDriverUtils.waitForElement(inventoryList, 15);
        }
    }

    public void buyRandomItem(){ //export as individual method
        getRandom(getAddToCardButtonList());
        assertTrue(shoppingCartBadge.isDisplayed()); //wrap into try/catch + screenshot
        cart.click();
        assertSame(addToCardButtonList,addToCardButtonList);
        WebDriverUtils.waitForElement(checkoutButton, 15);
        checkoutButton.click();
        WebDriverUtils.waitForElement(checkOutFirstName, 15);
    }


    public void fillFormFromCsvAndBuy(){
        CSVUtilities utilities = new CSVUtilities();
        for (UserDto user : utilities.usersList){
            checkOutFirstName.sendKeys(user.getName());
            checkOutLastName.sendKeys(user.getSurname());
            checkOutPostalCode.sendKeys(user.getPostalCode());
        }
        WebDriverUtils.waitForElement(checkOutContinueButton, 15);
        checkOutContinueButton.click();
        WebDriverUtils.waitForElement(finishCheckoutButton, 15);
        finishCheckoutButton.click();
    }

//    public void verifyAddedItem(){
//        List<String> itemNames = new ArrayList<>();
//        for (WebElement item : getAddToCardButtonList()){
//        String itemName = item.findElement(By.xpath("//*[@id=\"inventory_container\"]/div"))
//                .getText();
//            itemNames.add(itemName);
//        }
//        assertTrue(addToCardButtonList.contains(itemNames));
//    }
}

