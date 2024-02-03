package Controller.interfaces;

import java.util.List;

import Model.Domain.Student;

public interface iGetView {
    public void printAllStudent(List<Student> students);
    public String prompt(String msg);
    public void printAllStudentEng(List<Student> students);
}
