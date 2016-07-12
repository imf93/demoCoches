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

    List<Coche> findByPrecioLessThanEqual(Integer precio);
    List<Coche>findByMarcaAndModelo(String marca,String modelo);
    List<Coche>findByMarcaAndPrecio(String marca,Integer precio);

    Coche findByMatriculaNumero(String matriculaNumero);
    List<Coche>findByMarcaAndPrecioLessThanEqual(String marca,Integer precio);
   List<Coche>findByMarcaAndModeloAndPrecioLessThanEqual(String marca,String modelo,Integer precio);

    @Query("SELECT AVG (c.precio) from Coche c where c.marca = :marca")
    Double obtenerMediaPorMarca(@Param("marca") String marca);
    }

