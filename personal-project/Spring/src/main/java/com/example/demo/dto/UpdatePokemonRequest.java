package com.example.demo.dto;

import lombok.Value;

import java.util.List;

@Value
public class UpdatePokemonRequest {

    String name;
    int height;
    int weight;
    List<String> types;
    String sprite;

}
