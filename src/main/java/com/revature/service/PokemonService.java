package com.revature.service;

import java.util.List;

import com.revature.dao.IDao;
import com.revature.models.Pokemon;

/**
 * For C#, this is similar to BL
 * 
 * Business Layer is responsible for further validation or process of data obtained from the database or the user
 * What kind of process? That all depends on the type of functionality you will be doing
 */
public class PokemonService {

    //================== Dependency Injection ==================
    private IDao<Pokemon> pdao;

    public PokemonService(IDao<Pokemon> pDao) {
        this.pdao = pDao;
    }
    //==========================================================

    public Pokemon createPokemon(Pokemon instance){
        return pdao.insert(instance);
    }

    public List<Pokemon> getAllPokemon(){
        return pdao.getAll();
    }
}
