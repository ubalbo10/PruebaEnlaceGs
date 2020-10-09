package com.example.pruebaenlacegs.interfaces;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pruebaenlacegs.clases.Cliente;

import java.util.List;

@Dao
public interface DaoClientes {
    @Query("SELECT * FROM Cliente")
    List<Cliente> getAll();

    @Query("SELECT * FROM Cliente WHERE DUI = (:dui)")
    Cliente getCliente(String dui);

    @Update
    void updateCliente(Cliente cliente);


    @Insert(onConflict = 3)
    void insertCliente(Cliente cliente);

    @Delete
    void deleteCliente(Cliente cliente);
}
