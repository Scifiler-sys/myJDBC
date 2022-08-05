package com.revature;

import com.revature.dao.PokemonDao;
import com.revature.models.Pokemon;
import com.revature.service.PokemonService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Saving pikachu to db" );

        Pokemon pika = new Pokemon("charizard", 5);

        PokemonService pokeserv = new PokemonService(new PokemonDao());

        pokeserv.createPokemon(pika);

        System.out.println(pika.getId());

        for (Pokemon pokemon : pokeserv.getAllPokemon()) {
            System.out.println(pokemon);
        }
    }
}
