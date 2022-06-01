package com.emergentes.modelo;

public class participantes {

    private int id;
    private String apellidos;
    private String nombres;
    private int id_seminario;
    private int confirmado;

    public participantes() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_sem) {
        this.id_seminario = id_sem;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

}
