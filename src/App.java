import java.util.ArrayList;
import java.util.List;
import javax.swing.text.View;
import Model.ModelClassFile;
import Controller.ControllerClass;
import Controller.interfaces.iGetModel;
import Controller.interfaces.iGetView;
import Model.ModelClass;
import Model.Domain.Student;
import View.ViewClass;
import View.ViewClassEng;

public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Ivan", 21);
        Student student2 = new Student("Anna", 25);
        Student student3 = new Student("Vasya", 22);
        Student student4 = new Student("Nastya", 27);
        Student student5 = new Student("Vasilisa", 26);
        Student student6 = new Student("Karina", 25);
        Student student7 = new Student("Andrey", 22);
        Student student8 = new Student("Masha", 27);
        Student student9 = new Student("Irina", 28);
        Student student10 = new Student("Nikolay", 30);

        List<Student> studList = new ArrayList<>();
        studList.add(student1);
        studList.add(student2);
        studList.add(student3);
        studList.add(student4);
        studList.add(student5);
        studList.add(student6);
        studList.add(student7);
        studList.add(student8);
        studList.add(student9);
        studList.add(student10);
    
        iGetModel model = new ModelClass(studList);
        iGetView view = new ViewClass();
        iGetView viewEng = new ViewClassEng();
        iGetModel fmodel = new ModelClassFile("student.csv");

        ControllerClass controller = new ControllerClass(fmodel, view, viewEng);

        // controller.update("Масса и мет");l
        // controller.run();
        controller.run();

    }
}
