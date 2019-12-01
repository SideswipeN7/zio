package com.whynot.zio.db;

import com.whynot.zio.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String number;
    private String groupName;

    public StudentRow(String name, String number, String groupName) {
        this.name = name;
        this.number = number;
        this.groupName = groupName;
    }

    public StudentRow() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setId(Student student) {
        this.groupName = student.groupName;
        this.name = student.name;
        this.number = student.number;
    }

    public Student toStudent(){
        return new Student(
                this.getId(),
                this.getName(),
                this.getNumber(),
                this.getGroupName());
    }
}
