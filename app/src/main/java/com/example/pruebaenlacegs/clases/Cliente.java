package com.example.pruebaenlacegs.clases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cliente {
    @PrimaryKey
    public int idCliente;

    @ColumnInfo(name = "nombres")
    public String nombres;

    @ColumnInfo(name = "apellidos")
    public String apellidos;


    @ColumnInfo(name = "DUI")
    public String DUI;


    @ColumnInfo(name = "NIT")
    public String NIT;


    @ColumnInfo(name = "direccion")
    public String direccion;


    @ColumnInfo(name = "telefono")
    public String telefono;


    @ColumnInfo(name = "correo")
    public String correo;
}
