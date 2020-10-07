package service;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    private static Map<Integer,Student> students;

    static {
    students = new HashMap<>();
    students.put(1, new Student(1,"Lâm", "lam@gmail.com", "hanoi"));
    students.put(2, new Student(2, "thường", "thuong@gmail.com", "nghean"));
    students.put(3, new Student(3, "nghĩa nguyễn", "nghianguyen@gmail.com", "nghean"));
    students.put(4, new Student(4, "nghĩa vũ", "nghiavu@gmail.com", "longbien"));
    students.put(5,new Student(5, "văn", "van@gmail.com", "thaibinh"));
    }


    @Override
    public List findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }

    @Override
    public void update(int id, Student student) {
        students.put(id, student);
    }

    @Override
    public void remove(int id) {
        students.remove(id);
    }
}
