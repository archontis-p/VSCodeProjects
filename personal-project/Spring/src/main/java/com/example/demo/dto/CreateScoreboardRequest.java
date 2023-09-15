package com.example.demo.dto;

import lombok.Value;

import java.util.List;

@Value
public class CreateScoreboardRequest {
    int id;
    String category;
    String score;
    String timestamp;
}
