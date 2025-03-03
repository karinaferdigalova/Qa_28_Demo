package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {
    SoftAssert softAssert = new SoftAssert();
    //Maths,Physics,Chemistry

    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);

        Student student = new Student("Pablo", "Poblito",
                "pablo@meas.com", Gender.MALE, "0123456789",
                "12 Nov 2001", "Maths,Physics,Chemistry",
                hobbies, "", "street 1",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        //Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative(), "Test failed");
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(), "Test passed");
    }

    @Test
    public void studentRegFormPositiveTestValidateSoftAssert() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);

        Student student = new Student("Pablo", "Poblito",
                "pablo@meas.com", Gender.MALE, "0123456789",
                "12 Nov 2001", "Maths,Physics,Chemistry",
                hobbies, "", "street 1",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);

        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage(), "Test passed");
        softAssert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessageNegative(), "Test failed");
        softAssert.assertTrue(getDriver().findElement(By.xpath("//tbody/tr[2]/td[last()]"))
                .getText().contains(student.getEmail()),"email");
        System.out.println("============================");

        softAssert.assertAll();
    }
}
