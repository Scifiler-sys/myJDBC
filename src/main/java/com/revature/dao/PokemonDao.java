package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Pokemon;
import com.revature.utils.ConnectionUtil;

public class PokemonDao implements Dao<Pokemon> {

    @Override
    public Pokemon addInstance(Pokemon instance) {
        String sql = "insert into Pokemon(name, pokelevel, health, damage) values(?,?,?,?) returning id";

        try (Connection con = ConnectionUtil.getConnection()) {
            PreparedStatement prstmt = con.prepareStatement(sql);

            prstmt.setString(1, instance.getName());
            prstmt.setInt(2, instance.getLevel());
            prstmt.setInt(3, instance.getHealth());
            prstmt.setInt(4, instance.getDamage());

            ResultSet rs = prstmt.executeQuery();
            rs.next();

            instance.setId(rs.getInt("id"));
            
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return instance;
    }

    @Override
    public List<Pokemon> getAllInstances() {
        String sql = "select * from Pokemon";

        List<Pokemon> listOfPokemon = new ArrayList<>();

        try (Connection con = ConnectionUtil.getConnection()) {
            
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            //next() method will check if there is another row in our sql table
            while (rs.next()) {
                
                //The actual mapping of the sql table into java obj
                listOfPokemon.add(new Pokemon(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("pokelevel"),
                    rs.getInt("health"),
                    rs.getInt("damage")
                ));
            }

        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        return listOfPokemon;
    }

    @Override
    public Pokemon updateInstance(Pokemon instance) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Pokemon deleteInstance(Pokemon instance) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
