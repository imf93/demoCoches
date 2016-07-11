package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private Integer precio;
    private String matricula;

    public Coche(String marca, String modelo, Integer añoFab, Integer precio, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.añoFab = añoFab;
        this.precio = precio;
        this.matricula = matricula;
    }

    public Coche() {
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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", añoFab=" + añoFab +
                ", precio=" + precio +
                ", matricula='" + matricula + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coche coche = (Coche) o;

        if (getId() != null ? !getId().equals(coche.getId()) : coche.getId() != null) return false;
        if (getMarca() != null ? !getMarca().equals(coche.getMarca()) : coche.getMarca() != null) return false;
        if (getModelo() != null ? !getModelo().equals(coche.getModelo()) : coche.getModelo() != null) return false;
        if (getAñoFab() != null ? !getAñoFab().equals(coche.getAñoFab()) : coche.getAñoFab() != null) return false;
        if (getPrecio() != null ? !getPrecio().equals(coche.getPrecio()) : coche.getPrecio() != null) return false;
        return getMatricula() != null ? getMatricula().equals(coche.getMatricula()) : coche.getMatricula() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        result = 31 * result + (getAñoFab() != null ? getAñoFab().hashCode() : 0);
        result = 31 * result + (getPrecio() != null ? getPrecio().hashCode() : 0);
        result = 31 * result + (getMatricula() != null ? getMatricula().hashCode() : 0);
        return result;
    }
}