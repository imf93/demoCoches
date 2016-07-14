package com.example;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by professor on 11/07/2016.
 */
@Service
public class CocheService {
    @Autowired
    private CocheRepository cocheRepository;


    @Autowired
    private PersonaRepository personaRepository;


    public void testCoches() {

        Coche coche = new Coche();
        coche.setMarca("Ferrari");
        coche.setModelo("GT-15");
        coche.setAñoFab(1998);
        coche.setPrecio(150000.88);
        coche.setMatriculaNumero("1234ENG");

        Persona persona = new Persona();
        persona.setNombre("Pedro");
        persona.setEdad(23);
        personaRepository.save(persona);

        coche.setPropietario(persona);


        cocheRepository.save(coche);

        Coche coche2 = new Coche();
        coche2.setMarca("Renault");
        coche2.setModelo("Megane");
        coche2.setAñoFab(2004);
        coche2.setPrecio(20000.70);
        coche2.setMatriculaNumero("4567MAD");

        Persona ivan = personaRepository.findOne(1L);
        coche2.setPropietario(ivan);


        cocheRepository.save(coche2);

        Coche coche3 = new Coche();
        coche3.setMarca("Mercedes");
        coche3.setModelo("TX-50");
        coche3.setAñoFab(1997);
        coche3.setPrecio(53500.23);
        coche3.setMatriculaNumero("9908BAC");
        coche3.setPropietario(ivan);

        cocheRepository.save(coche3);


        Coche coche4 = new Coche();
        coche4.setMarca("Ferrari");
        coche4.setModelo("Turbo-100");
        coche4.setAñoFab(2004);
        coche4.setPrecio(400000.00);

        coche4.setMatriculaNumero("3456ING");
        Persona noelia = personaRepository.findOne(2L);
        coche4.setPropietario(noelia);


        cocheRepository.save(coche4);


        System.out.println("Los coches en o despues del año 1998 son: ");
        System.out.println(cocheRepository.findByAñoFabGreaterThanEqual(1998));

        System.out.println("Los cohes fabricados en o  antes del 1998 ");
        System.out.println(cocheRepository.findByAñoFabLessThanEqual(1998));

        System.out.println("Entre 1997 y 1998");
        System.out.println(cocheRepository.findByAñoFabBetween(1997, 1998));

        System.out.println("Los ferraris de la misma marca y modelo son:");
        System.out.println(cocheRepository.findByMarcaAndModelo("Ferrari", "Turbo-100"));

        System.out.println("Los ferraris que valen 200000 es :");
        System.out.println(cocheRepository.findByMarcaAndPrecio("Ferrari", 230000.00));

        System.out.println("Los ferraris que valen de 150000 son :");
        System.out.println(cocheRepository.findByMarcaAndPrecio("Ferrari", 150000.00));

        System.out.println("Los ferraris que valen menos de 200000:");
        System.out.println(cocheRepository.findByMarcaAndPrecioLessThanEqual("Ferrari", 200000.00));


        System.out.println("Los Renault de marca Megane que valen 20.000 es:");
        System.out.println(cocheRepository.findByMarcaAndModeloAndPrecioLessThanEqual("Renault", "Megane", 20000.00));

        System.out.println("Los coches con precio inferior a 20.000 son:");
        System.out.println(cocheRepository.findByPrecioLessThanEqual(20000.00));


        System.out.println("Matricula 3456ING ");
        System.out.println(cocheRepository.findByMatriculaNumero("3456ING"));

        System.out.println("La media de los coches Renault es: ");
        System.out.println(cocheRepository.obtenerMediaPorMarca("Renault"));

        System.out.println("Los coches de ivan son: ");
        System.out.println(cocheRepository.obtenerCochePersona(ivan));

        System.out.println("Los ferraris de ivan mayor a 150000 son");
        System.out.println(cocheRepository.obtenerCochePersonaPrecio(ivan, 20000.00));

        System.out.println("Los ferraris de ivan mayor a 150000 y entre el 1995-2008 son :");
        System.out.println(cocheRepository.obtenerCochePersonaPrecioAño(ivan, 20000.00, 2003, 2005));
        System.out.println("Los coches de las personas que tienen menos de 21 años son:");
        System.out.println(cocheRepository.obtenerCochePorEdad(21));
        System.out.println("Los coches de las personas que tienen ente 20 y 23  años son:");
        System.out.println(cocheRepository.obtenerCochePorRangoEdad(25, 30));


        System.out.println("Coches que tienen como matricula  que contienen las letras ING son:");
        System.out.println(cocheRepository.obtenerMatriculaByLetras("ING"));


        System.out.println("Mostrar la media, el minimo y el máximo, del precio de los vehículos de cada marca");
        List<Object[]> marcaList = cocheRepository.obtenerMidMinMax();
        for (Object[] marca : marcaList) {
            System.out.println("Marca: " + marca[0] + " ");
            System.out.println("Media: " + marca[1] + " ");
            System.out.println("Max: " + marca[2] + " ");
            System.out.println("Min: " + marca[3] + " ");
        }

        System.out.println("Coches por año de fabricacion");
        List<Object[]> añoList = cocheRepository.ObtenerCocheAñoFab();

        for (Object[] añoFab : añoList) {
            //Para pasarle despues el año ponemos el cast de integer año
            Integer año = (Integer) añoFab[0];
            System.out.println("Año: " + añoFab[0]);
            System.out.println("Cantidad " + añoFab[1] + System.lineSeparator());
            //Hemos puesto en cocheRepositury la consulta find y solo le pasamos el año para que te muestre los cohes de dicho año
            System.out.println("Listado coches" + cocheRepository.findByAñoFab(año));

            System.out.println("-----------------------------------------------------------------");
        }



    }


}
