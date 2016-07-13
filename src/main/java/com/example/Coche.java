package com.example;

import javax.persistence.*;

/**
 * Created by professor on 11/07/2016.
 */
@Entity
public class Coche {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String marca;
    private String modelo;
    private Integer añoFab;
    private Double precio;
    private String matriculaNumero;
    @ManyToOne //Para decir que  coches puede pertenecer solo a una persona
    private Persona propietario;


    public Coche(String marca, String modelo, Integer añoFab, Double precio, String matriculaNumero) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFab = añoFab;
        this.precio = precio;
        this.matriculaNumero = matriculaNumero;
    }


    public Coche() {

    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAñoFab() {
        return añoFab;
    }

    public void setAñoFab(Integer añoFab) {
        this.añoFab = añoFab;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMatriculaNumero() {
        return matriculaNumero;
    }

    public void setMatriculaNumero(String matriculaNumero) {
        this.matriculaNumero = matriculaNumero;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", añoFab=" + añoFab +
                ", precio=" + precio +
                ", matriculaNumero='" + matriculaNumero + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche coche = (Coche) o;

        if (id != null ? !id.equals(coche.id) : coche.id != null) return false;
        if (marca != null ? !marca.equals(coche.marca) : coche.marca != null) return false;
        if (modelo != null ? !modelo.equals(coche.modelo) : coche.modelo != null) return false;
        if (añoFab != null ? !añoFab.equals(coche.añoFab) : coche.añoFab != null) return false;
        if (precio != null ? !precio.equals(coche.precio) : coche.precio != null) return false;
        return matriculaNumero != null ? matriculaNumero.equals(coche.matriculaNumero) : coche.matriculaNumero == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (marca != null ? marca.hashCode() : 0);
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (añoFab != null ? añoFab.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (matriculaNumero != null ? matriculaNumero.hashCode() : 0);
        return result;
    }
}