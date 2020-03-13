package ub.info.prog2.HuayllasMiguelDiCroce.vista;

import ub.info.prog2.HuayllasMiguelDiCroce.model.LlistaFitxers;
import ub.info.prog2.utils.Menu;
import ub.info.prog2.utils.ReproException;

import java.io.*;
import java.util.Scanner;

/**
 * Utilitzarem la classe ReproductorUB1 com a base per a cridar altres metodes
 * i executar el codi
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class ReproductorUB1 {
    Scanner sc = new Scanner(System.in);
    String rutaArchivo;     //Ruta de la carpeta/archivo que se pasara como parametro
    File file;              //Variable File que se pasa como parametro al cargar y guardar la lista
    LlistaFitxers lista;    //Principal objeto con el que gestionaremos

    /**
     * Definicion de las variables del menu principal
     */
    static private enum OpcionesMenu {GESTIO_FITXERS, GUARDAR_DATOS, RECUPERAR_DATOS, SALIR}

    /**
     * Declarem las descripciones de cada opcio del menu principal
     */
    static private String[] desOpcionesMenu = {
            "Gestion de ficheros"
            , "Guardar el contingut de la llista en un fitxer",
            "Cargar una llista previamente guardada en un fitxer",
            "Sortir de la aplicacio"
    };

    /**
     * Declaracion de la variables del submenu de GESTION_FITXERS
     */
    static private enum OpcionesSubMenu {CREAR_PORTAFOLIO, MOSTRAR_PORTAFOLIO, ELIMINAR_PORTAFOLIO, AFEGIR_FITXER_MULTIMEDIA, MOSTRAR_FITXERS, ELIMINAR_FITXERS_MULTIMEDIA}

    /**
     * Descripcion del submenu de GESTIO_FITXERS
     */
    static private String[] desOpcionesSubMenu_GESTIO_FITXERS = {
            "Crear un portafolio",
            "Mostrar portafolio",
            "Eliminar portafolio"
            , "Agregar fichero multimedia (repositorio o portafolio)",
            "Mostrar fichero (repositorio o portafolio)",
            "Eliminar fichero multimedia (repositorio o portafolio)"};

    /*NOTA*/
    //EL ejercio nos pide un repositorio minimo asi que ese ya esta inicializado , en cambio el portafolio no y ese no se limnita a uno

        /*El reproductor tendrá sólo un repositorio y un número indeterminado de portafolios. los
    portafolios quedarán identificados por su título, y por tanto, no podremos tener títulos
    repetidos. El usuario sólo podrá añadir archivos al repositorio y añadir estos archivos a las
    listas de los portafolios, tantas veces como quiera. Es decir, los archivos de los portafolios han
    estar en el repositorio y no se pueden añadir directamente archivos a los portafolios si estos no
    han sido añadidos previamente al repositorio.*/

    /*DUDA POR CONTESTAR POR PARTE DEL PROFESOR*/
    /*Y por ultimo ahora que tenemos la clase Dades que estará en el paquete controlador , entiendo que el manipulara el repositorio  y los portafolios ,
    entonces la clase reproductorUB solo tendrá una inicializacion a este objeto y la libreria menu para ir llamando a los métodos de la clase Dades no?*/


}

