package com.whynot.zio.servlets;

import com.whynot.zio.Student;
import com.whynot.zio.services.StudentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PointsController {
    private final StudentService service;

    public PointsController(StudentService service) {
        this.service = service;
    }

    @GetMapping(value = "/student/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getStudents() {
        return service.getStudents();
    }

    @PostMapping(path = "/student/users", consumes = "application/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public int addStudent(@RequestBody Student name) {
        return service.addStudent(name);
    }

    @PutMapping(path = "/student/users/{id}", consumes = "application/json", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> modifyStudent(@RequestBody Student student, @PathVariable int id) {
        return service.setStudent(id, student);
    }

    @DeleteMapping(path = "/student/users/{id}")
    public int modifyStudent(@PathVariable int id) {
        return service.remove(id);
    }
}
