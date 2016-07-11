package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by professor on 11/07/2016.
 */
@Service
public class CocheService {
@Autowired

private CocheRepository cocheRepository;


    public void testCoches(){

        Coche coche = new Coche();
        coche.setMarca("Ferrari");
        coche.setModelo("GT-15");
        coche.setAñoFab(1998);
        coche.setPrecio(150000);
        coche.setMatricula("1234567-Y");

        cocheRepository.save(coche);

        Coche coche2 = new Coche();
        coche2.setMarca("Renault");
        coche2.setModelo("Megane");
        coche2.setAñoFab(2009);
        coche2.setPrecio(20000);
        coche2.setMatricula("456897-M");

        cocheRepository.save(coche2);

        Coche coche3 = new Coche();
        coche3.setMarca("Mercedes");
        coche3.setModelo("TX-50");
        coche3.setAñoFab(1997);
        coche3.setPrecio(50000);
        coche3.setMatricula("678325-B");

        cocheRepository.save(coche3);


        Coche coche4 = new Coche();
        coche4.setMarca("Ferrari");
        coche4.setModelo("Turbo-100");
        coche4.setAñoFab(2009);
        coche4.setPrecio(400000);
        coche4.setMatricula("378897-P");

        cocheRepository.save(coche4);


        System.out.println("Los coches en o despues del año 1998 son: ");
       System.out.println(cocheRepository.findByAñoFabGreaterThanEqual(1998));

        System.out.println("Los cohes fabricados en o  antes del 1998 ");
        System.out.println(cocheRepository.findByAñoFabLessThanEqual(1998));

        System.out.println("Entre 1997 y 1998");
        System.out.println(cocheRepository.findByAñoFabBetween(1997,1998));

        System.out.println("Los ferraris de la misma marca y modelo son:");
        System.out.println(cocheRepository.findByMarcaAndModelo("Ferrari","Turbo-100"));

        System.out.println("Los ferraris que valen 200000 es :");
        System.out.println(cocheRepository.findByMarcaAndPrecio("Ferrari",230000));

        System.out.println("Los ferraris que valen de 150000 son :");
        System.out.println(cocheRepository.findByMarcaAndPrecio("Ferrari",150000));

        System.out.println("Los ferraris que valen menos de 200000:");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Ferrari",200000));


        System.out.println("Los Renault de marca Megane que valen 20.000 es:");
        System.out.println(cocheRepository.findByMarcaAndModeloAndPrecioLessThanEqual("Renault","Megane",20000));










    }


}
