
package View;
import Model.Domain.Student;
import java.util.List;
import java.util.Scanner;

import Controller.interfaces.iGetView;


public class ViewClassEng implements iGetView {
    public static void main(String[] args) {

                
    }

    public void printAllStudentEng(List<Student> students) {
        System.out.println("----------Students List----------");
        for(Student s: students) {
            System.out.println(s);
        }
        System.out.println("----------------------------------");
    }

    public String prompt(String msg) {
        Scanner in = new Scanner(System.in);
        System.out.println(msg);
        return in.nextLine();
    }

    @Override
    public void printAllStudent(List<Student> students) {
        return;
    }
}
