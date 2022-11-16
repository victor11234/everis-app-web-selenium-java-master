package com.everis.ct.web.util;

import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.Date;

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

    public static Date getDifferenceBetwenDates(Date dateInicio, Date dateFinal) {
        long milliseconds = dateFinal.getTime() - dateInicio.getTime();
        int seconds = (int) (milliseconds / 1000) % 60;
        int minutes = (int) ((milliseconds / (1000 * 60)) % 60);
        int hours = (int) ((milliseconds / (1000 * 60 * 60)) % 24);
        Calendar c = Calendar.getInstance();
        c.set(Calendar.SECOND, seconds);
        c.set(Calendar.MINUTE, minutes);
        c.set(Calendar.HOUR_OF_DAY, hours);
        return c.getTime();
    }


    public void creacionCarpetasReporte(String ruta){
        File file=new File(ruta);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    public void movimientoDeArchivos(String desde, String hacia){

        Path origenPath = FileSystems.getDefault().getPath(desde);
        Path destinoPath = FileSystems.getDefault().getPath(hacia);

        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
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
