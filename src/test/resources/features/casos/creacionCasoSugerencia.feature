#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creacionCasoSugerencia
  Esquema del escenario:creacionCasoSugerencia

    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <usuario> <clave>
    Y iniciamos sesion
    Y hacemos proceso de seleccion Cliente
    Y Desplegamos el menu de busqueda
    Y Entramos a nuevo caso, Seleccionamos el tipo de caso Sugerencia
    Y creamos un caso de Sugerencia <cuenta> <selectOrigenCaso> <prioridadCaso> <almacen> <asunto> <descripcion> <planesDeAccion> <estado>
    Entonces verificamos el caso creado




    Ejemplos:

      | usuario                                               | clave        | cuenta            |   selectOrigenCaso     |   prioridadCaso | almacen | asunto |descripcion | planesDeAccion | estado |
      | victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* |  victor lozano    |    Portal              |    Alta         | 68      | prueba  | prueba      |  prueb      | Nuevo  |









