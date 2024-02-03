package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Controller.interfaces.iGetModel;
import Controller.interfaces.iGetView;
import Model.Domain.Student;
import Model.ModelClass;
import View.ViewClass;
import View.ViewClassEng;

public class ControllerClass {

    private iGetModel model;
    private iGetView view;
    private iGetView viewEng;
    private List<Student> studBuffer = new ArrayList<>();

    public ControllerClass(iGetModel model, iGetView view, iGetView viewEng) {
        this.model = model;
        this.view = view;
        this.viewEng = viewEng;
    }

    private boolean testData(List<Student> stud) {

        if(stud.size() > 0) {
            return true;
        }
        else {
            return false;
        }

    }

    public void update(String Request) {
        // MVP
        studBuffer = model.getStudents();
        if(testData(studBuffer)) {
            view.printAllStudent(studBuffer);
        }
        else {
            System.out.println("Список студентов пуст");
        }


        // MVC
        // view.printAllStudent(model.getStudents());
    }

    public void run() {
        Command com = (Command)Command.NONE;
        boolean getNewIter = true;
        while(getNewIter) {
            String command = view.prompt("Введите команду: ");
            com = Command.valueOf(command.toUpperCase());
            switch(com) {
                case EXIT:
                    getNewIter = false;
                    System.out.println("Выход из программы");
                    break;
                case LIST:
                    view.printAllStudent(model.getStudents());
                    // view.printAllStudentEng(model.getStudents());
                    break;
                case LISTENG:
                    viewEng.printAllStudentEng(model.getStudents());
                    break;
                case DELETE:
                    Scanner scan = new Scanner(System.in);
                    try {
                        this.model.DeleteStudent(scan.nextInt());
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
            }
        }
    }
    
}
