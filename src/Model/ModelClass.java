package Model;

import Model.Domain.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import Controller.interfaces.iGetModel;

public class ModelClass implements iGetModel {
    
    private List<Student> students;

    public ModelClass(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public HashMap<Integer, Student> getStudent() {
        return null;
    }

    @Override
    public void DeleteStudent(int indexStudent) {
        // TODO Auto-generated method stub
        return;
    }
    
}
