#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creacionCasoFelicitaciones
  Esquema del escenario: Creacion de caso

    Dado que ingresamos a la pagina de Salesforce
    Y iniciamos sesion <Usuario> <clave>
    Y hacemos proceso de seleccion Cliente
    Y Desplegamos el menu de busqueda
    Y Entramos a nuevo caso, Seleccionamos el tipo de caso PAK
    Y creamos un caso de PAK selectEstado




    Ejemplos:

      | Usuario                           | clave        | selectEstado |
      | 1035922188@colcomercio.com.co.uat | Pruebas2023* | Solicitud Aprobada |








