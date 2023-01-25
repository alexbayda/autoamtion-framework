package com.figma.beta.pageobject;

import com.figma.beta.logger.Logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage{

    private final WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logs logs = new Logs();

    @FindBy(id = "new-design-file-button")
    public WebElement createNewProjectButton;


    public void clickNewDesignButton() {
        createNewProjectButton.submit();
        logs.process("Successfully clicked");
    }
}



