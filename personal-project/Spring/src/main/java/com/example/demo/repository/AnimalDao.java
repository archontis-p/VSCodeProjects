package com.example.demo.repository;

import java.util.List;

public class AnimalDao {

    int id;
    String question;
    String correct;
    String a;
    String b;
    String c;
    String d;

    public AnimalDao() {
    }

    public AnimalDao(int id, String question, String correct, String a, String b, String c, String d) {
        this.id = id;
        this.correct = correct;
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String q) {
        this.question = q;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "AnimalDao{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", correct='" + correct + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }
}