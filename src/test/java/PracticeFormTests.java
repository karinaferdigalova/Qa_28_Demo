import dto.Student;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegFormPositiveTest(){
        Student student = new Student("Kiara","Mironov",
                "miro@gmail.com","female","0678954311",
                "16 Apr 2004","Physiccs,Maths,Chemisry",
                "sport","","street 1","NCR","Delhi");
     new HomePage(getDriver()).clickBtnForms();
     new FormsPage((getDriver())).clickBtnPracticeForm();
     new PracticeFormPage(getDriver()).typePracticeForm(student);


    }

}
