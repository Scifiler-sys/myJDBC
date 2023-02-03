package com.revature.models;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.PokemonDao;
import com.revature.services.PokemonService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/*
    Mocking is when you replace a real class into something that isn't real and usually hardcode a guaranteed response
    Why do this? Just so we can isolate the actual class we are testing from its dependencies

    Ex:
    PokemonDao methods. We are testing of the method is workign properly right?
    What if I tell you the database suddenly stopped working is the problem the class/implementation details of our methods OR the problem is somewhere else entirely?

    Well what if we mock the database and just tell it to ALWAYS return something regardless if the database is working or not
    If the method stopped working properly, do you think the problem is the class/implementation details of our methods OR the problem is somwhere else entirely?
*/
public class PokemonServiceTest {

    @Test
    public void Get_All_Instance_Should_Give_All_Pokemon()
    {
        //Arrange
        PokemonDao pokeDaoMock = Mockito.mock(PokemonDao.class);
        PokemonService pokeServ = new PokemonService(pokeDaoMock);
        List<Pokemon> expectedList = new ArrayList<>();
        expectedList.add(new Pokemon());
        expectedList.add(new Pokemon());

        //Mocking the method that depends to work
        Mockito.when(pokeDaoMock.getAllInstances()).thenReturn(expectedList);

        //Act
        List<Pokemon> actualList = pokeServ.getAllPokemon();

        //Assert
        Assertions.assertIterableEquals(expectedList, actualList);
    } 
    
    @Test
    public void Add_Instance_Should_Add_A_Pokemon()
    {
        
    }
}
