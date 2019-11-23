package com.whynot.zio;

public class Student {
    public final long id;
    public final String name;
    public final String number;
    public final String groupName;

    public Student(long id, String name, String number, String group) {
        this.id = id;
        this.name = name;
        this.groupName = group;
        this.number = number;
    }
}
