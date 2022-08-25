package com.revature.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class PokemonTest {

    @Test
    public void Name_Should_Save_Valid_Data(){
        //Arrange
        String expectedName = "Pikachu";
        Pokemon poketest = new Pokemon();

        //Act
        poketest.setName(expectedName);

        //Assert
        Class pokeClass = Pokemon.class;
        try {
            Field name = pokeClass.getDeclaredField("name");
            name.setAccessible(true);
            assertEquals(expectedName, name.get(poketest));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void Level_Should_Save_Valid_Data(){
        //Arrange
        int expectedLvl = 10;
        Pokemon poketest = new Pokemon();

        //Act
        poketest.setLevel(expectedLvl);

        //Assert
        Class pokeClass = Pokemon.class;
        try {
            Field name = pokeClass.getDeclaredField("level");
            name.setAccessible(true);
            assertEquals(expectedLvl, name.get(poketest));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
