package com.example.francisco.firebase;

/**
 * Created by francisco on 16/04/18.
 */

public class Alumno {

    public String nombre;
    public String nocontrol;

    public Alumno() {
    }

    public Alumno(String nombre, String nocontrol) {
        this.nombre = nombre;
        this.nocontrol = nocontrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNocontrol() {
        return nocontrol;
    }

    public void setNocontrol(String nocontrol) {
        this.nocontrol = nocontrol;
    }
}
