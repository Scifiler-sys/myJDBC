package com.revature.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.PokemonDao;
import com.revature.models.Pokemon;
import com.revature.services.PokemonService;

public class PokemonController extends HttpServlet{
    
    private static PokemonService pokeserv = new PokemonService(new PokemonDao());
    private static ObjectMapper objmap = new ObjectMapper();

    /**
     * This method is responsible with handling all the get request right?
     * 
     * But what if we need multiple get requests from the same Controller??
     * Ex: 
     * Note - it is a POKEMON controller
     * So we should be able to grab a single 
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        /**
         * We are getting the very last part of the URI after
         * Ex:
         * http://localhost:8080/rest/allpokemon -> allpokemon is left
         * http://localhost:8080/rest/pokemon -> pokemon is left
         */

        final String URI = req.getRequestURI().replace("/rest/", "");

        // This was used to show case how URI differs from URL
        // resp.getWriter().write(req.getRequestURI() + "\n");
        // resp.getWriter().write(URI+ "\n");

        //We are setting that we are returning a JSON file
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String jsonString;


        //By getting the last part we can use a switch statement to change our functionality based on the endpoint
        //So in this way, we can have multiple functionalities with the same controller in the same doGet method
        switch (URI) {
            case "pokemon":
                // resp.getWriter().write("Getting one pokemon ");

                int id = Integer.parseInt(req.getParameter("id"));

                Pokemon poke = pokeserv.getPokemonById(id);

                jsonString = objmap.writeValueAsString(poke);

                // resp.getWriter().write("\n" + poke.getName());
                
                // How to return the jsonString
                resp.getWriter().println(jsonString);

                break;
            case "allpokemon":
                // resp.getWriter().write("Getting multiple pokemons");

                List<Pokemon> listOfPoke = pokeserv.getAllPokemon();
                jsonString = objmap.writeValueAsString(listOfPoke);

                // for (Pokemon pokemon : listOfPoke) {
                //     resp.getWriter().write("\n"+pokemon.getName());
                // }

                //How to return the jsonString
                resp.getWriter().println(jsonString);
                break;
            default:
                resp.setStatus(405);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException
    {
        final String URI = req.getRequestURI().replace("/rest/", "");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String jsonString;

        switch (URI) {
            case "addpokemon":
                // resp.getWriter().println("You are trying to add a pokemon");

                //Converting the request body into a jsonString
                jsonString = req.getReader().lines().collect(Collectors.joining());

                //Use the jsonString to convert it back into a pokemon obj
                Pokemon poke = objmap.readValue(jsonString, Pokemon.class);

                //Service logic to add the pokemon
                poke = pokeserv.addPokemon(poke);

                //Convert back to jsonString to return it back with the generated Id
                jsonString = objmap.writeValueAsString(poke);

                resp.getWriter().println(jsonString);
                break;
            default:
                resp.setStatus(405);
                break;
        }
    }
}
