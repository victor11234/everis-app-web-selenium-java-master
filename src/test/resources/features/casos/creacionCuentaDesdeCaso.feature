#language:es
@DEMO
Característica: Prueba de concepto SpringBoot + Cucumber - sandBox


  @creaCuentaDesdeCasos
  Esquema del escenario:creaCuentaDesdeCasos

    Dado que ingresamos a la pagina de Salesforce
    Y ingresamos los datos de inicio de sesion <usuario> <clave>
    Y iniciamos sesion
    Y hacemos proceso de seleccion Cliente
    Y Desplegamos el menu de busqueda
    Y Entramos a nuevo caso, Seleccionamos el tipo de caso Felicitaciones
    Y entramos al tipo de caso y creamos la cuenta <cuenta> Persona <cuenta> <apellidoPersona>
    Y creamos un caso de felicitaciones. <selectOrigenCaso> <prioridadCaso> <almacen> <asunto> <descripcion> <planesDeAccion> <estado>
    Entonces verificamos el caso creado



    Ejemplos:

      | usuario                                               | clave        | cuenta      |apellidoPersona|   selectOrigenCaso     |   prioridadCaso | almacen | asunto |descripcion | planesDeAccion | estado |
      | victor.manuel.lozano.cardona@colcomercio.com.co.alkqa | Pruebas2023* |  fulano     | detal         |    Portal              |    Alta         | 68      | dasda  | sdasd      |  ewqeqwew      | Nuevo  |









