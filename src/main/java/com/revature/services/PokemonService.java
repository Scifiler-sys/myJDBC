package com.revature.services;

import java.util.List;
import java.util.Optional;

import com.revature.dao.Dao;
import com.revature.models.Pokemon;

/**
 * What are Services/Business Logic?
 * 
 * This is if we need any further process or actual heavy logical thinking on what we need to do when we grab our data from the database
 * 
 * In the enterprise world, we hate accessing the database as much as possible since it takes waaay too long to do
 * So we created services that will do some caching logic and optimize ways to reduce accessing the db
 * 
 * We will not do caching logic since that itself is a monster to optimize
 * Instead, we will utilize Services to do more customizable things
 */

public class PokemonService {
    //============ Dependency Injection ====================
    //It is a design pattern that will ensure that you have to provide an object during this particular class object creation
    //why? Because it DEPENDS on it to function properly
    //This just ensure whoever tries to make this PokemonServ obj needs to also supply a PokemonDao obj

    private Dao<Pokemon> pokedao;

    public PokemonService(Dao<Pokemon> pokedDao) {
        this.pokedao = pokedDao;
    }

    //=====================================================

    //In the event where you don't need any logical processing what's so ever you can just do this and call it a day
    //In a normal world, this method would've have some extensive logic to do caching and so on
    public List<Pokemon> getAllPokemon(){
        return pokedao.getAllInstances();
    }

    public Pokemon getPokemonById(int Id){
        
        Optional<Pokemon> foundPoke = getAllPokemon().stream()
                .filter(poke -> poke.getId() == Id)
                .findFirst();

        if (foundPoke.isPresent()) {
            return foundPoke.get();
        }
        else {
            
            Pokemon noPoke = new Pokemon();
            noPoke.setName("No pokemon was found");

            //We could've just returned a null but... that usually is very error-prone
            //So another way is just making a pokemon obj but stating that it isn't a pokemon
            return noPoke;
        }
    }

    public Pokemon addPokemon(Pokemon poke){
        return pokedao.addInstance(poke);
    }
    
}
