package com.figma.beta.pageobject;

import com.figma.beta.logger.Logs;
import com.figma.beta.utilities.WaitToLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookAppointment {

    private final WebDriver driver;

    public BookAppointment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    Logs logs = new Logs();

    @FindBy(id = "btn-make-appointment")
    public WebElement createNewProjectButton;

    @FindBy(id = "combo_facility")
    public WebElement facilityDropDownLocator;

    @FindBy(id = "chk_hospotal_readmission")
    public WebElement readmissionCheckmarkLocator;

    @FindBy(id = "radio_program_none")
    public WebElement noneRadioButtonLocator;

    @FindBy(id = "txt_visit_date")
    public WebElement enterDateLocator;

    @FindBy(id = "txt_comment")
    public WebElement txtCommentLocator;

    @FindBy(id = "btn-book-appointment")
    public WebElement bookAppointmentButtonLocator;

    @FindBy(id = "summary")
    public WebElement summaryLocator;

    @FindBy(xpath = "/html/body/div/div[1]/table/tbody/tr[4]/td[5]")
    public WebElement todayDateLocator;

    public void clickBookAppointmentButton() {
        createNewProjectButton.click();
        logs.process("Successfully clicked");
    }

    public void fillAppointmentForm(){
        facilityDropDownLocator.findElements(By.xpath("//*[@id=\"combo_facility\"]/option[2]"));
        facilityDropDownLocator.click();
        readmissionCheckmarkLocator.click();
        noneRadioButtonLocator.click();
        enterDateLocator.click();
        todayDateLocator.click();
        bookAppointmentButtonLocator.click();
    }

    public boolean isElementDisplayed(WebElement element) {
        WaitToLoad.waitForElement(driver, element, 30);
        return true;
    }
}



