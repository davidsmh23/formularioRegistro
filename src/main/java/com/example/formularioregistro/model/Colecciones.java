package com.example.formularioregistro.model;

import java.util.Map;
import java.util.TreeMap;

public class Colecciones {
    private static Map<String, String> listaGeneros = new TreeMap<>();
    private static Map<String, String> listaPaises = new TreeMap<>();
    private static Map<String, String> listaDepartamentos = new TreeMap<>();

    static {
        //Generos
        listaGeneros.put("Femenino", "Femenino");
        listaGeneros.put("Masculino", "Masculino");
        listaGeneros.put("Otros", "Otros");

        //Paises
        listaPaises.put("Andorra", "Andorra");
        listaPaises.put("España", "España");
        listaPaises.put("Francia", "Francia");
        listaPaises.put("Italia", "Italia");
        listaPaises.put("Portugal", "Portugal");

        //Departamentos
        listaDepartamentos.put("Marketing", "Marketing");
        listaDepartamentos.put("Ventas", "Ventas");
        listaDepartamentos.put("Recursos Humanos", "Recursos Humanos");
        listaDepartamentos.put("Tecnología", "Tecnología");
    }

    public static Map devuelveListaGeneros() {
        return listaGeneros;
    }

    public static Map devuelveListaPaises() {
        return listaPaises;
    }

    public static Map devuelveListaDepartamento() {
        return listaDepartamentos;
    }

}
