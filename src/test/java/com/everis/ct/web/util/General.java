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

    public void tiempoEsperaFijo(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.getMessage();
        }
    }

    public String numeroAleatorio(){
        return  String.valueOf((int) (Math.random() * 9999999 + 1));
    }
}
