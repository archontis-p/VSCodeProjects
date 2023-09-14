package com.example.demo.dto;

import lombok.Value;

import java.util.List;

@Value
public class CreatePokemonRequest {
    String name;
    int height;
    int weight;
    List<String> types;
    String sprite;

}
