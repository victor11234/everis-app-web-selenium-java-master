package com.everis.ct.web.util;

import com.github.javafaker.Faker;

public class General {

    private Faker faker = new Faker();

    public General() {
    }


    public String firstName() {
        return faker.name().firstName();
    }

    public String lastName() {
        return faker.name().lastName();
    }

    public String getRandomValue() {
        return faker.name().fullName();
    }

    public void tiempoEsperaFijo() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public String numeroAleatorio() {
        return String.valueOf((int) (Math.random() * 9999999 + 1));
    }


    //Convierte la primera letra de una palabra en mayuscula
    public String primeraLetraMayus(String valor) {


        String palabra = valor.substring(0, 1).toUpperCase() + valor.substring(1).toLowerCase();
        System.out.println(palabra);
        return palabra;

    }

    //Convierte toda la palabra en mayuscula
    public String todoMayus(String valor) {


        String palabra = valor.toUpperCase();
        System.out.println(palabra);
        return palabra;

    }

    //Convierte la primera letra de cada pabra en mayuscula
    public String primelaLetraDeCadaPalabra(String valor) {


        char[] caracteres = valor.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        for (int i = 0; i < valor.length() - 2; i++) {

            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')

                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);


        }System.out.println(caracteres);
        return new String(caracteres);
    }
}