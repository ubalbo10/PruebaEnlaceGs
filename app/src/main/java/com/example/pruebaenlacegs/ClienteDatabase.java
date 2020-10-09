package com.example.pruebaenlacegs;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.pruebaenlacegs.clases.Cliente;
import com.example.pruebaenlacegs.interfaces.DaoClientes;

@Database(entities = {Cliente.class}, version = 3)
abstract class ClientesDatabase extends RoomDatabase {
    public abstract DaoClientes clienteDao();
}

