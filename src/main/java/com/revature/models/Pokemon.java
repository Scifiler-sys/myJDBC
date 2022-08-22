package com.revature.models;

//POJO of pokemon for us to mess with in our REST
public class Pokemon {
    private int id;
    private String name;
    private int level;
    private int health;
    private int damage;

    public Pokemon() { }

    public Pokemon(int id, String name, int level, int health, int damage) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
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
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Pokemon [damage=" + damage + ", health=" + health + ", id=" + id + ", level=" + level + ", name=" + name
                + "]";
    }
}
