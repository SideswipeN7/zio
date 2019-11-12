package com.whynot.zio.services;

import com.whynot.zio.Student;
import io.vavr.collection.List;

public class StudentService {
    private static List<Student> students = List.empty();


    public List<Student> getStudents() {
        return students;
    }

    public int addStudent(Student student) {
        var stud = new Student(students.size() + 1, student.name, student.number, student.groupName);
        students = students.prepend(stud);
        return students.size();
    }

    public List<Student> setStudent(int id, Student student) {
        students = students.update(id, student);
        return students;
    }

    public int remove(int id) {
        students = students.removeAt(id);
        return students.size();
    }
}
