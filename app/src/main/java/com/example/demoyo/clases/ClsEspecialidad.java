package com.example.demoyo.clases;

public class ClsEspecialidad {
    private int id_especialidad;
    private String nombre_especialidad;
    private String icono_especialidad;

    // Constructor, getters y setters
    public ClsEspecialidad(int id_especialidad, String nombre_especialidad, String icono_especialidad) {
        this.id_especialidad = id_especialidad;
        this.nombre_especialidad = nombre_especialidad;
        this.icono_especialidad = icono_especialidad;
    }

    public int getId_especialidad() {
        return id_especialidad;
    }

    public void setId_especialidad(int id_especialidad) {
        this.id_especialidad = id_especialidad;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public String getIcono_especialidad() {
        return icono_especialidad;
    }

    public void setIcono_especialidad(String icono_especialidad) {
        this.icono_especialidad = icono_especialidad;
    }
}
