package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Pokemon;
import com.revature.util.ConnectionUtil;

public class PokemonDao implements IDao<Pokemon> {

    @Override
    public Pokemon insert(Pokemon instance) {
        try (Connection con = ConnectionUtil.getConnection()) {

            //Created a sql statement that should work in DBeaver but replaced the hardcoded value we usually play with "?"
            String sql = "insert into pokemon(pokeName, pokeLevel) values(?, ?) returning pokeId";

            //Essentially stating that our String sql variable is actually going to be a sql statment by utilizing PreparedStatement class
            PreparedStatement statement = con.prepareStatement(sql);

            //Changing the ? into actual values we get from our instance argument
            statement.setString(1, instance.getName());
            statement.setInt(2, instance.getLevel());

            //Grabs the result of that query into ResultSet
            //It is a class that can essentially grab the table format result into a java object
            ResultSet rs = statement.executeQuery();

            //Grabs the very first row that came from this query
            rs.next();

            //Sets the autogenerate Id back to our instance argument
            instance.setId(rs.getInt("pokeid"));

            //Returning our pokemon instance with the updated Id
            return instance;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Pokemon> getAll() {

        //Sql statement required to grab all rows from Pokemon Table
        String sql = "Select * From Pokemon";

        //Setting up a variable that will store our many pokemon objs
        List<Pokemon> listOfPoke = new ArrayList<Pokemon>();

        try (Connection con = ConnectionUtil.getConnection()) {

            //We used Statement class instead because our sql statement doesn't have any parameters (it doesn't have any "?" needed)
            Statement statement = con.createStatement();
            
            ResultSet rs = statement.executeQuery(sql);

            //Used a while loop to go through all the rows of our table
            //We don't really know how many rows there are so we have a condition that will keep running as long as there is a next row
            while (rs.next()) {

                //Mapping result for table into a Pokemon object to be stored in an arraylist collection
                listOfPoke.add(new Pokemon(
                    rs.getInt("pokeid"), 
                    rs.getString("pokename"), 
                    rs.getInt("pokelevel")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listOfPoke;
    }

    @Override
    public boolean update(Pokemon instance) {

        return false;
    }

    @Override
    public boolean delete(Pokemon instance) {
        // TODO Auto-generated method stub
        return false;
    }

    
}
