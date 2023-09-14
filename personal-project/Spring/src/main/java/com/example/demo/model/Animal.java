package com.example.demo.model;

import java.util.List;


public class Animal {

    int id;
    String question;
    String correct;
    String a;
    String b;
    String c;
    String d;


    public Animal(int Id, String Question,  String Correct, String  A, String B, String  C, String  D) {
        this.id = Id;
        this.correct = Correct;
        this.question = Question;
        this.a = A;
        this.b = B;
        this.c = C;
        this.d = D;
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
