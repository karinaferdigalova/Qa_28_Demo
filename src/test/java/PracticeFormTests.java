import dto.Student;
import enums.Gender;
import enums.Hobbies;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        List<Hobbies>hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);


        Student student = new Student("Kiara","Mironov",
                "miro@gmail.com", Gender.FEMALE,"0678954311",
                "16 Apr 2004","Physics,Maths,Chemisry",
                hobbies,"","street 1","NCR","Delhi");
     new HomePage(getDriver()).clickBtnForms();
     new FormsPage((getDriver())).clickBtnPracticeForm();
     new PracticeFormPage(getDriver()).typePracticeForm(student);


    }

}
