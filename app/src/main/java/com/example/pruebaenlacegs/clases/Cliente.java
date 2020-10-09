package com.example.pruebaenlacegs.clases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cliente {
    @PrimaryKey(autoGenerate = false)
    public int DUI;

    //@ColumnInfo(name = "DUI")
    //private String DUI;

    @ColumnInfo(name = "nombres")
    private String nombres;

    @ColumnInfo(name = "apellidos")
    private String apellidos;


    @ColumnInfo(name = "NIT")
    private String NIT;


    @ColumnInfo(name = "direccion")
    private String direccion;


    @ColumnInfo(name = "telefono")
    private String telefono;


    @ColumnInfo(name = "correo")
    private String correo;

    public Cliente(@NonNull int DUI, String nombres,String apellidos,@NonNull String NIT, String direccion,
                   String telefono, String correo) {
        this.setDUI(DUI);
        this.setNombres(nombres);
        this.setApellidos(apellidos);
        this.setNIT(NIT);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setCorreo(correo);
    }

    public int getDUI() {
        return DUI;
    }

    public void setDUI(int DUI) {
        this.DUI = DUI;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
