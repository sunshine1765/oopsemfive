
package Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Controller.interfaces.iGetModel;
import Model.Domain.Student;

public class ModelClassFile implements iGetModel {
    private String fileName;

    public ModelClassFile(String fileName) {
        this.fileName = fileName;

        try(FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

   // @Override
    public List<Student> getStudents() {
        List<Student> students  = new ArrayList<Student>();
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line!=null)
            {
                String[] param = line.split(" ");
                Student pers = new Student(param[0], Integer.parseInt(param[1]));
                students.add(pers);
                line = reader.readLine();
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

        return students;
    }

    public void saveAllStudentToFile(List<Student> students)
    {
        try(FileWriter fw = new FileWriter(fileName, true))
        {
            for(Student pers : students)
            {
                fw.write(pers.getName()+" "+pers.getAge()+" "+pers.getId());
                fw.append('\n');
            }
            fw.flush();    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public HashMap<Integer, Student> getStudent() {
        return null;
    }

    @Override
    public void DeleteStudent(int indexStudent) throws IOException {
        String line;
        File file = new File(fileName);
        File outPutFile = new File("out.csv");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter("out.csv"));
        while ((line = reader.readLine()) != null) {
            // System.out.println(String.valueOf(Character.toString(line.charAt(line.length() - 1))));
            if (Integer.parseInt(Character.toString(line.charAt(line.length() - 1))) != indexStudent) {
                writer.write(line);
                writer.newLine();
            }
        }
        reader.close();
        writer.close(); 
        file.delete();
        outPutFile.renameTo(file); 
    }
}

