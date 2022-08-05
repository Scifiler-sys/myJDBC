package com.revature.dao;

import java.util.List;

// Similar to DL for C#
//Basic CRUD operations
public interface IDao<T> {
    
    //Insert
    T insert(T instance);

    //Read
    List<T> getAll();
    
    //Update
    boolean update(T instance);

    //Delete
    boolean delete (T instance);
} 
