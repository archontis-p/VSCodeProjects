package com.example.demo.model;

public class Scoreboard {
    int id;
    String category;
    String score;
    String timestamp;

    public Scoreboard(int Id, String category,  String score, String  timestamp) {
        this.id = Id;
        this.category = category;
        this.score = score;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String q) {
        this.category = q;
    }

    public String getScore() {return score;}
    public void setScore(String score) {
        this.score = score;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public String toString() {
        return "Scoreboard{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", score='" + score + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }


}
