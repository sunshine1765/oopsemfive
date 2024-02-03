package Controller.interfaces;

import java.util.List;

import Model.Domain.Student;

import java.io.IOException;
import java.util.HashMap;

public interface iGetModel {
    public List<Student> getStudents();
    public HashMap<Integer, Student> getStudent();
    public void DeleteStudent(int indexStudent) throws IOException;
}
