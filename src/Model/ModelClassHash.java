package Model;

import java.util.List;
import java.util.HashMap;
import Controller.interfaces.iGetModel;
import Model.Domain.Student;


public class ModelClassHash implements iGetModel{

    private HashMap<Integer, Student> students;

    public List<Student> getStudents() {
        return null;
    }

    @Override
    public HashMap<Integer, Student> getStudent() {
       return students;
    }

    @Override
    public void DeleteStudent(int indexStudent) {
        return;
    }
}
