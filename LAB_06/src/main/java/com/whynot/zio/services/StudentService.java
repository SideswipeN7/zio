package com.whynot.zio.services;

import com.whynot.zio.Student;
import com.whynot.zio.db.StudentRow;
import com.whynot.zio.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getStudents() {
        List<Student> list = new ArrayList<>();
        repository.findAll().forEach(getStudentRowConsumer(list));
        return list;
    }

    private Consumer<StudentRow> getStudentRowConsumer(List<Student> list) {
        return dbObj->
                list.add(new Student(
                    dbObj.getId(),
                    dbObj.getName(),
                    dbObj.getNumber(),
                    dbObj.getGroupName()));
    }

    public int addStudent(Student student) {
        repository.save(new StudentRow(
                student.name,
                student.number,
                student.groupName));
        return List.of(repository.findAll()).size();

    }

    public List<Student> setStudent(int id, Student student) {
        repository.findById((long) id).get().setId(student);
        return getStudents();
    }

    public int remove(long id) {
        repository.delete(repository.findById(id).get());
        return List.of(repository.findAll()).size();
    }
}
