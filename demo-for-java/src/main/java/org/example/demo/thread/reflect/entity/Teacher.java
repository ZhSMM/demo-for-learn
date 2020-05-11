package org.example.demo.thread.reflect.entity;

/**
 * @author <a href="https://www.songfang.top"> ZhSMM </a>
 * @date 2020/04/30
 * @description details
 **/
public class Teacher extends People{
    private String subject;

    public Teacher() {
    }

    public Teacher(String subject) {
        this.subject = subject;
    }

    public Teacher(String name, Integer age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                "} " + super.toString();
    }
}
