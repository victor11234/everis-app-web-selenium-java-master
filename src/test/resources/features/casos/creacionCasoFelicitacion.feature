#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creacionCasoFelicitaciones
  Esquema del escenario: Creacion de caso

    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <usuario> <clave>
    Y iniciamos sesion
    Y hacemos proceso de seleccion Cliente
    Y Desplegamos el menu de busqueda
    Y Entramos a nuevo caso, Seleccionamos el tipo de caso Felicitaciones
    Y creamos un caso de felicitaciones <cuenta> <selectOrigenCaso> <prioridadCaso> <almacen> <asunto> <descripcion> <planesDeAccion> <estado>




    Ejemplos:

      | usuario                                               | clave        | cuenta            |   selectOrigenCaso     |   prioridadCaso | almacen | asunto |descripcion | planesDeAccion | estado |
      | victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* |  victor lozano    |    Portal              |    Alta         | 68      | dasda  | sdasd      |  ewqeqwew      | Nuevo  |









