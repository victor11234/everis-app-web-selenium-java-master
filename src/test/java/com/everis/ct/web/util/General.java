package com.everis.ct.web.util;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class General {

    private Faker faker = new Faker();
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    DateFormat dateFormatCompleto = new SimpleDateFormat("dd:MM:yy HH:mm:ss");
    DateFormat dateFormatHoy = new SimpleDateFormat("dd/MM/yy");
    Date dateInicial;
    Date dateFinal;
    Date fechaHoy;
    Date difference;

    String rutaFechaReporte="";

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


    //Convierte toda la palabra en mayuscula
    public String todoMayus(String valor) {


        String palabra = valor.toUpperCase();
        return palabra;

    }

    //Convierte la primera letra de cada pabra en mayuscula
    public String primelaLetraDeCadaPalabra(String valor) {


        char[] caracteres = valor.toCharArray();
        caracteres[0] = Character.toUpperCase(caracteres[0]);
        for (int i = 0; i < valor.length() - 2; i++) {

            if (caracteres[i] == ' ' || caracteres[i] == '.' || caracteres[i] == ',')

                caracteres[i + 1] = Character.toUpperCase(caracteres[i + 1]);


        }
        return new String(caracteres);
    }
    public void obtenerHoraInicial() {
        dateInicial = new Date();
        System.out.println("Hora inicial: " + dateFormat.format(dateInicial));
    }
    public void obtenerHoraFinal() {
        dateFinal = new Date();
        System.out.println("Hora final: " + dateFormat.format(dateFinal));
    }
    public void procesoReporte() {

        //Proceso de hora
        difference = getDifferenceBetwenDates(dateInicial,dateFinal);
        System.out.println(dateFormat.format(difference)); //00:02:00

        //Proceso de creación de carpeta general
        creacionCarpetasReporte(System.getProperty("user.dir") + "//reportes//indicadores");
        //Proceso de creación de carpeta hora y ejecucion
        rutaFechaReporte = System.getProperty("user.dir") + "//reportes//indicadores//"+dateFormatCompleto.format(dateInicial).replaceAll(":",".").replaceAll(" ","_");

        creacionCarpetasReporte(rutaFechaReporte);

    }

    public  void modificacionCeldas(String feature) {
        try {
            String directorioExcel = System.getProperty("user.dir") + "\\Indicadores.xlsx";
            // Se crea una referencia al documento excel
            File archivo = new File(directorioExcel);
            FileInputStream file = new FileInputStream(archivo);
            Workbook workbook = WorkbookFactory.create(file);
            workbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            Sheet sheet = workbook.getSheet(feature);
            Cell cell;
            Row row;
            int numeroCeldaEscribir=0;
            int rowCount = sheet.getLastRowNum()+ sheet.getFirstRowNum();
            for (int i = 0; i < rowCount; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    System.out.println(row.getCell(0).getStringCellValue());
                    if(row.getCell(0).getStringCellValue().isEmpty()){
                        numeroCeldaEscribir=i;
                        break;
                    }
                }
            }


            row = sheet.getRow(numeroCeldaEscribir);
            //campo feature
            cell = row.getCell(0);
            if (cell == null) {
                cell = row.getCell(0);
            }
            if (feature != null) {
                cell.setCellValue(feature);
            }

            cell = row.getCell(1);
            if (cell == null) {
                cell = row.getCell(1);
            }
            fechaHoy = new Date();
            if (fechaHoy != null) {
                cell.setCellValue(dateFormatHoy.format(fechaHoy).toString());
            }

            //campo Tiempo
            cell = row.getCell(2);
            if (cell == null) {
                cell = row.createCell(2);
            }
            if (difference != null) {
                cell.setCellValue(dateFormat.format(difference).toString());
            }

            //campo resultado
            cell = row.getCell(3);
            if (cell == null) {
                cell = row.createCell(3);
            }
           // if (feature != null) {
                cell.setCellValue("Succes");
            //}

            //campo ruta
            cell = row.getCell(4);
            if (cell == null) {
                cell = row.createCell(4);
            }
            if (rutaFechaReporte != null) {
                cell.setCellValue(rutaFechaReporte);
            }

            FileOutputStream outputStream = new FileOutputStream(directorioExcel);
            workbook.setForceFormulaRecalculation(true);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
