package com.example.user.proyectlistgridapp.models;

import java.io.Serializable;

/**
 * Created by USER on 26/03/2018.
 */

public class Fruta implements  Serializable {
    private int id;
    private String nombre;
    private int image;
    private String ciudad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImage() { return image;}

    public void setImage(int image) {
        this.image = image;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
