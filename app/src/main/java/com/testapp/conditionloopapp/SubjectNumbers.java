package com.testapp.conditionloopapp;

public class SubjectNumbers {
    int obtNums;
    int totalNums;
    String subject;
    String grade;

    public SubjectNumbers(int obtNums, int totalNums, String subject) {
        this.obtNums = obtNums;
        this.totalNums = totalNums;
        this.subject = subject;
    }

    public SubjectNumbers(int obtNums, int totalNums, String subject, String grade) {
        this.obtNums = obtNums;
        this.totalNums = totalNums;
        this.subject = subject;
        this.grade = grade;
    }

    public int getObtNums() {
        return obtNums;
    }

    public void setObtNums(int obtNums) {
        this.obtNums = obtNums;
    }

    public int getTotalNums() {
        return totalNums;
    }

    public void setTotalNums(int totalNums) {
        this.totalNums = totalNums;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
