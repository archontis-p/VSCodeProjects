package com.example.demo.model;

import java.util.List;

public class Pokemon {

    public static final Pokemon PIKACHU = new Pokemon(25, "pikachu", 4, 60, List.of("electric"),
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png");

    private final int id;
    private final String name;
    private final int height;
    private final int weight;
    private final List<String> types;
    private final String sprite;

    public Pokemon(int id, String name, int height, int weight, List<String> types, String sprite) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.types = types;
        this.sprite = sprite;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public List<String> getTypes() {
        return types;
    }

    public String getSprite() {
        return sprite;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", height=" + height +
            ", weight=" + weight +
            ", types=" + types +
            ", sprite='" + sprite + '\'' +
            '}';
    }
}
