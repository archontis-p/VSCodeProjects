package com.example.demo.repository;

import java.util.List;

public class PokemonDao {

    int id;
    String name;
    int height;
    int weight;
    List<String> types;
    String sprite;

    public PokemonDao() {
    }

    public PokemonDao(int id, String name, int height, int weight, List<String> types, String sprite) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "PokemonDao{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", height=" + height +
            ", weight=" + weight +
            ", types=" + types +
            ", sprite='" + sprite + '\'' +
            '}';
    }
}
