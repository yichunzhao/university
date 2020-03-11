package com.ynz.university.domain;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@EqualsAndHashCode
@ToString
public class Student {
    @Id
    @GeneratedValue //default strategy is auto
    @Column(name = "student_id")
    private Integer studentId;

    @Embedded
    private Person attendee;

    @Column(name = "student_fullTime")
    private boolean fullTime;

    @Column(name = "student_age")
    private int age;

    @ManyToMany
    @JoinTable(name = "student_course", //join table name
            joinColumns = @JoinColumn(name = "student_id_fk", referencedColumnName = "student_id"),//owning side
            inverseJoinColumns = @JoinColumn(name = "course_id_fk", referencedColumnName = "course_id")//inverse side
    )
    private List<Course> studentCourses = new ArrayList<>();

    public Student() {
    }

    public Student(Person person, boolean fullTime, int age) {
        this.attendee = person;
        this.fullTime = fullTime;
        this.age = age;
    }

    public Student(String firstName, String lastName, boolean fullTime, int age) {
        this.attendee = new Person(firstName, lastName);
        this.fullTime = fullTime;
        this.age = age;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Person getAttendee() {
        return attendee;
    }

    public boolean isFullTime() {
        return fullTime;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setAttendee(Person attendee) {
        this.attendee = attendee;
    }

    public void setFullTime(boolean fullTime) {
        this.fullTime = fullTime;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudentCourses(List<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
