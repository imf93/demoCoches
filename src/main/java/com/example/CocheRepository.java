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
 List<Coche> obtenerCochePersona(@Param("propietario") Persona propietario);


 @Query("SELECT coche FROM Coche coche WHERE coche.propietario =:propietario and coche.precio>:precio")
 List<Coche> obtenerCochePersonaPrecio(@Param("propietario") Persona propietario, @Param("precio") Double precio);

 @Query("SELECT coche FROM Coche coche WHERE coche.propietario =:propietario and coche.precio>:precio and  coche.añoFab  BETWEEN :año1 AND :año2 ")
 List<Coche> obtenerCochePersonaPrecioAño(@Param("propietario") Persona propietario, @Param("precio") Double precio, @Param("año1") Integer año1, @Param("año2") Integer año2);

 @Query("SELECT coche FROM Coche coche WHERE coche.propietario.edad<:edad")
 List<Coche> obtenerCochePorEdad(@Param("edad") Integer edad);


 @Query("SELECT coche FROM Coche coche WHERE coche.propietario.edad between  :edad and :edad1")
 List<Coche> obtenerCochePorRangoEdad(@Param("edad") Integer edad, @Param("edad1") Integer edad1);

 @Query("SELECT coche from Coche coche where coche.matriculaNumero LIKE(CONCAT('%', :letras,'%'))")
 List<Coche> obtenerMatriculaByLetras(@Param("letras") String letras);

 @Query("SELECT (coche.marca), AVG(coche.precio), MIN (coche.precio), MAX (coche.precio) from Coche coche GROUP BY marca")
 List<Object[]> obtenerMidMinMax();

 @Query("SELECT coche.añoFab, COUNT(coche) FROM Coche coche group BY añoFab")
 List<Object[]> ObtenerCocheAñoFab();
    }

