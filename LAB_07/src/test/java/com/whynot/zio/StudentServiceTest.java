package com.whynot.zio;

import com.whynot.zio.repo.StudentRepository;
import com.whynot.zio.services.StudentService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentRepository repository;

    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }

    @Test
    public void getEmptyList() {
        var controller = new StudentService(repository);
        Assert.assertTrue(controller.getStudents().isEmpty());
    }

    @Test
    public void addStudent() {
        var controller = new StudentService(repository);
        var student = new Student(1, "a","b", "c");
        int size = controller.addStudent(student);
        Assert.assertEquals(size, 1);
    }

    @Test
    public void addStudentIsReturned() {
        var controller = new StudentService(repository);
        var student = new Student(1, "a","b", "c");
        int size = controller.addStudent(student);
        Assert.assertEquals(size, 1);
        var students = controller.getStudents();
        var retrieved = students.get(0);
        Assert.assertEquals(retrieved.id, student.id);
        Assert.assertEquals(retrieved.name, student.name);
        Assert.assertEquals(retrieved.number, student.number);
        Assert.assertEquals(retrieved.groupName, student.groupName);
    }

    @Test
    public void addStudentHasNewId() {
        var controller = new StudentService(repository);
        var student1 = new Student(1, "a","b", "c");
        var student2 = new Student(1, "a","bb", "cc");
        Assert.assertEquals(student1.id, student2.id);
        controller.addStudent(student1);
        controller.addStudent(student2);

        var students = controller.getStudents();
        var first = students.get(0);
        var second = students.get(1);
        Assert.assertNotEquals(first.id, second.id);
    }
}
