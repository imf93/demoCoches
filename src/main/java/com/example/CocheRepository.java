package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by professor on 11/07/2016.
 */



    public interface CocheRepository extends JpaRepository<Coche,Long> {

   List<Coche>findByAñoFabGreaterThanEqual(Integer añofab );
    List<Coche>findByAñoFabLessThanEqual(Integer añofab );
    List<Coche>findByAñoFabBetween(Integer añofab,Integer añofab2 );

    List<Coche> findByPrecioGreaterThanEqual(Integer precio);

    List<Coche> findByPrecioLessThanEqual(Double precio);
    List<Coche>findByMarcaAndModelo(String marca,String modelo);

    List<Coche> findByMarcaAndPrecio(String marca, Double precio);

    Coche findByMatriculaNumero(String matriculaNumero);

    List<Coche> findByMarcaAndPrecioLessThanEqual(String marca, Double precio);

    List<Coche> findByMarcaAndModeloAndPrecioLessThanEqual(String marca, String modelo, Double precio);

    @Query("SELECT AVG (coche.precio) from Coche coche where coche.marca = :marca")
    Double obtenerMediaPorMarca(@Param("marca") String marca);

 @Query("SELECT coche FROM Coche coche WHERE coche.propietario =:propietario")
 List<Persona> obtenerCochePersona(@Param("propietario") Persona propietario);


 @Query("SELECT coche FROM Coche coche WHERE coche.propietario =:propietario and coche.precio>:precio")
 List<Persona> obtenerCochePersonaPrecio(@Param("propietario") Persona propietario, @Param("precio") Double precio);


    }

