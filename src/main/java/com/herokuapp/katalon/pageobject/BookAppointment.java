package com.herokuapp.katalon.pageobject;

import com.herokuapp.katalon.logger.Logs;
import com.herokuapp.katalon.utilities.RandomDateGenerator;
import com.herokuapp.katalon.utilities.WebDriverUtils;
import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.herokuapp.katalon.utilities.RandomSelector.randomByText;

@Getter
public class BookAppointment {

    private final WebDriver driver;

    public BookAppointment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Logs logs = new Logs();

    @FindBy(id = "btn-make-appointment")
    private WebElement createNewProjectButton;

    @FindBy(id = "combo_facility")
    private WebElement facilityDropDownLocator;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement readmissionCheckmarkLocator;

    @FindBy(id = "txt_visit_date")
    private WebElement enterDateLocator;

    @FindBy(id = "txt_comment")
    private WebElement txtCommentLocator;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButtonLocator;

    @FindBy(id = "summary")
    private WebElement summaryLocator;

    @FindBy(css = "input[type='radio']")
    private List<WebElement> healthCareRadioButtonList;


    public void clickBookAppointmentButton() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", createNewProjectButton);
        logs.process("Successfully clicked");
    }

    public void fillFacilityDropDownByText(String text) {
        randomByText(facilityDropDownLocator, text);
    }

    public void checkHospitalReadmission() {
        readmissionCheckmarkLocator.click();
    }

    public void fillRandomDate() {
        enterDateLocator.sendKeys(RandomDateGenerator.fillRandomDate());
    }

    public void fillCommentField(String comment) {
        txtCommentLocator.sendKeys(comment);
    }

    public void submitAppointment() {
        bookAppointmentButtonLocator.click();
    }

    public boolean confirmationIsDisplayed() {
        WebDriverUtils.waitForElement(driver, summaryLocator, 30);
        return true;
    }
}



