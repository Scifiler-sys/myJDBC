package com.revature.models;

public class Pokemon {

    private int Id;
    private String name;
    private int level;

    public Pokemon() {
        
    }

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public Pokemon(int id, String name, int level) {
        Id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemon [Id=" + Id + ", level=" + level + ", name=" + name + "]";
    }

    
}
