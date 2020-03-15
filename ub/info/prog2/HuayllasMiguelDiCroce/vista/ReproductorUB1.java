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
    //Dades datos;
    //Menu menu;

    /**
     * Definicion de las variables del menu principal
     */
    static private enum OpcionesMenu {GESTIO_FITXERS, GUARDAR_DATOS, RECUPERAR_DATOS, SALIR}

    /**
     * Declarem las descripciones de cada opcio del menu principal
     */
    static private String[] desOpcionesMenu = {
            "Gestion de ficheros", "Guardar el contingut de la llista en un fitxer",
            "Cargar una llista previamente guardada en un fitxer",
            "Sortir de la aplicacio"
    };

    /**
     * Declaracion de la variables del submenu de GESTION_FITXERS
     */
    static private enum OpcionesSubMenu {CREAR_PORTAFOLIO, MOSTRAR_PORTAFOLIO, ELIMINAR_PORTAFOLIO, AFEGIR_FITXER_MULTIMEDIA, MOSTRAR_FITXERS, ELIMINAR_FITXERS_MULTIMEDIA, MENU_ANTERIOR}

    /**
     * Descripcion del submenu de GESTIO_FITXERS
     */
    static private String[] desOpcionesSubMenu_GESTIO_FITXERS = {
            "Crear un portafolio",
            "Mostrar portafolio",
            "Eliminar portafolio"
            , "Agregar fichero multimedia (repositorio o portafolio)",
            "Mostrar fichero (repositorio o portafolio)",
            "Eliminar fichero multimedia (repositorio o portafolio)",
            "Menu anterior"};

    /**
     * Declaracion de la variables del submenu de AFEGIR_FITXER_MULTIMEDIA
     */
    static private enum OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA {AGREGAR_AUDIO, AGREGAR_IMAGEN, MENU_ANTERIOR}

    /**
     * Descripcion de la variables del submenu de AFEGIR_FITXER_MULTIMEDIA
     */
    static private String[] descOpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA = {"Agregar fichero de audio", "Agregar fichero de imagen", "Menu anterior"};

    /**
     * El siguiente metedo se encarga de las principales opciones del menu
     * @param sc objeto tipo Scanner que servira para que el usuario entre por teclado las opciones del menu
     */
    public void gestioReproductorUB(Scanner sc) {
        //Creamos el menu
        Menu<OpcionesMenu> menu = new Menu<OpcionesMenu>("Menu Principal", OpcionesMenu.values());

        //Agregamos las descripciones
        menu.setDescripcions(desOpcionesMenu);

        //Designamos el objeto que sirve como opcion para cada menu
        OpcionesMenu opcion1 = null;

        do {
            //Mostramos el menu
            menu.mostrarMenu();
            //Demandamos una opcion
            opcion1 = menu.getOpcio(sc);
            //Ejecutamos las opciones necesarias
            switch (opcion1) {
                case GESTIO_FITXERS:
                    ///Entramos al menu Gestion Ficheros
                    gestionFicheros(sc);
                    break;
                case GUARDAR_DATOS:
                    //Guardamos los datos , aca llamamos a datos.guardar()
                    System.out.println("Entraste a Guardar datos");
                    break;
                case RECUPERAR_DATOS:
                    //Recuperamos  los datos , aca llamamos a datos.guardar()
                    System.out.println("Entraste a Recuperar datos");
                    break;
                case SALIR:
                    System.out.println("Hasta la vista :smile:");
                    break;
            }


        } while (opcion1 != OpcionesMenu.SALIR);

    }


    /**
     * El siguiente metedo gestion de ficheros se encargara de las principales funciones que involucran la manipulacion del repositorio y portfolios
     *
     * @param sc objeto tipo Scanner que servira para que el usuario entre por teclado las opciones del menu
     */
    private void gestionFicheros(Scanner sc) {
        //Creamos el menu
        Menu<OpcionesSubMenu> subMenuGestionFicheros = new Menu<OpcionesSubMenu>("Gestion de ficheros", OpcionesSubMenu.values());

        //Agregamos las descripciones de cada uno
        subMenuGestionFicheros.setDescripcions(desOpcionesSubMenu_GESTIO_FITXERS);

        //Designamos el objeto que sirve como opcion para cada menu
        OpcionesSubMenu opcion1_1 = null;

        do {
            //Mostramos el menu
            subMenuGestionFicheros.mostrarMenu();
            //Demandamos una opcion
            opcion1_1 = subMenuGestionFicheros.getOpcio(sc);
            switch (opcion1_1) {
                case CREAR_PORTAFOLIO:
                    System.out.println("Has entrado en crear portofolio");
                    break;
                case MOSTRAR_PORTAFOLIO:
                    System.out.println("Has entrado en mostrar portfolio");
                    break;
                case ELIMINAR_PORTAFOLIO:
                    System.out.println("Has entrado en eliminar portfolio");
                    break;
                case AFEGIR_FITXER_MULTIMEDIA:
                    System.out.println("Has entrado en Agregar Fichero");
                    agregarFicherosMult(sc);
                    break;
                case MOSTRAR_FITXERS:
                    System.out.println("Has entrado en Mostrat ficheros");
                    break;
                case ELIMINAR_FITXERS_MULTIMEDIA:
                    System.out.println("Has entrado en eliminar ficheros multimedia");
                    break;
                case MENU_ANTERIOR:
                    System.out.println("Has entrado en menu anterior");
                    break;
            }


        } while (opcion1_1 != OpcionesSubMenu.MENU_ANTERIOR);

    }


    /**
     * El siguiente metedo agregarFicheros se encarga de elegir el tipo de archivo que se agrega y en donde (repo o port)
     *
     * @param sc objeto tipo Scanner que servira para que el usuario entre por teclado las opciones del menu
     */
    private void agregarFicherosMult(Scanner sc) {
        //Creamos el menu
        Menu<OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA> subMenuAgregarFichero = new Menu<OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA>("Agregar Ficheros", OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA.values());

        //Agregamos las descripciones
        subMenuAgregarFichero.setDescripcions(descOpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA);

        //Designamos el objeto que sirve como opcion para cada menu
        OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA opcion1_1_1 = null;

        do {
            //Mostramos el menu
            subMenuAgregarFichero.mostrarMenu();
            //Demandamos una opcion
            opcion1_1_1 = subMenuAgregarFichero.getOpcio(sc);
            switch (opcion1_1_1) {
                case AGREGAR_AUDIO:
                    System.out.println("Has entrado en agregar audio");
                    break;
                case AGREGAR_IMAGEN:
                    System.out.println("Has entrado en  agregar imagen");
                    break;
                case MENU_ANTERIOR:
                    System.out.println("Has entrado en menu anterior ");
                    break;
            }


        } while (opcion1_1_1 != OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA.MENU_ANTERIOR);
    }






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

