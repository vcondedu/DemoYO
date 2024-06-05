package com.example.demoyo.clases;

public class ClsDoctor {
    private int id_doctor;
    private String nombre_solo;
    private String horario_disponible;
    private String apellido_solo;
    private String nombre_especialidad;
    private Double descontento;

    public ClsDoctor(int id_doctor, String nombre_solo, String horario_disponible, String apellido_solo, String nombre_especialidad, Double descontento) {
        this.id_doctor = id_doctor;
        this.nombre_solo = nombre_solo;
        this.horario_disponible = horario_disponible;
        this.apellido_solo = apellido_solo;
        this.nombre_especialidad = nombre_especialidad;
        this.descontento = descontento;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getNombre_solo() {
        return nombre_solo;
    }

    public void setNombre_solo(String nombre_solo) {
        this.nombre_solo = nombre_solo;
    }

    public String getHorario_disponible() {
        return horario_disponible;
    }

    public void setHorario_disponible(String horario_disponible) {
        this.horario_disponible = horario_disponible;
    }

    public String getApellido_solo() {
        return apellido_solo;
    }

    public void setApellido_solo(String apellido_solo) {
        this.apellido_solo = apellido_solo;
    }

    public String getNombre_especialidad() {
        return nombre_especialidad;
    }

    public void setNombre_especialidad(String nombre_especialidad) {
        this.nombre_especialidad = nombre_especialidad;
    }

    public Double getDescontento() {
        return descontento;
    }

    public void setDescontento(Double descontento) {
        this.descontento = descontento;
    }
}
