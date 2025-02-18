package pages;

import dto.Student;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormPage extends BasePage {
    public PracticeFormPage(WebDriver driver){
        setDriver(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(driver,
                10), this);

    }
        @FindBy(xpath = "//input[@id='firstName']")
        // @FindBy (id="firstname")
        WebElement fieldName;
        @FindBy(xpath = "//input[@placeholder='Last Name']")
        WebElement fieldLastName;
        @FindBy(xpath = "//input[@placeholder='name@example.com']")
        WebElement fieldEmail;
        @FindBy (xpath = "//input[@placeholder='Mobile Number']")
        WebElement fieldMobile;
        @FindBy (id ="dateOfBirthInput")
        WebElement fieldDateOfBirth;
        @FindBy(id="currentAddress")
        WebElement fieldCurrentAdress;


    public void typePracticeForm(Student student) {
        hideBanner();
        hideFooter();
        fieldName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastname());
        fieldEmail.sendKeys(student.getEmail());
        fieldMobile.sendKeys(student.getMobile());
       typeDateOfBirth(student.getDateOfBirth());
        fieldCurrentAdress.sendKeys(student.getAddress());
    }
    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);
    }
    }
