package ub.info.prog2.HuayllasMigueDiCore.vista;

import ub.info.prog2.HuayllasMiguelDiCore.model.LlistaFitxers;
import ub.info.prog2.utils.Menu;

import java.util.Scanner;

public class ReproductorUB1 {

    //Declaro la variables del menu para hacer referencia a las opciones del menu
    static private enum OpcionesMeu {
        AGREGAR_FICHERO, ELIMINAR_FICHERO,
        MOSTRAR_LISTA, GUARDAR_LISTA, RECUPERAR_LISTA, SALIR
    }

    ;

    //Declaro las descripciones de cada menu
    static private String[] desOpcionesMenu = {
            "Demandar datos del fichero y agregarlo a la lista de ficheros",
            "Eliminar un fichero de la lista",
            " Mostra el contenido de la lista de ficheros mostrando delante de cada  su numero de posicion comenzando por el 1"
            , "Guardar el contenido de la lista en un fichero",
            "Cargar una lista previamente guardada en un fichero",
            "Salir de la aplicacion"};
    //Creamos el objeto lista
    LlistaFitxers lista;

    public ReproductorUB1(int i) {
        lista = new LlistaFitxers(i);
    }

    public ReproductorUB1() {
        lista = new LlistaFitxers();
    }

    public void gestionReproductorMusica() {
        Scanner sc = new Scanner(System.in);
        //Creamos el objeto Menu y le pasamos el enum con las opciones del Menu principal
        Menu<OpcionesMeu> menu = new Menu<OpcionesMeu>("Menu Principal", OpcionesMeu.values());

        //Asignamos las descripciones de las opciones
        menu.setDescripcions(desOpcionesMenu);

        //Obtenemos las opciones del menu y hacemos las acciones pertinentes
        OpcionesMeu opcion = null;
        do {
            //Mostramos las opciones del menu
            menu.mostrarMenu();

            //Demandamos una opcion
            opcion = menu.getOpcio(sc);

            //Hacemos las acciones necesarias
            switch (opcion) {
                case AGREGAR_FICHERO:
                    System.out.println(desOpcionesMenu[0]);
                    //lista.addFitxer();
                    break;
                case ELIMINAR_FICHERO:
                    System.out.println(desOpcionesMenu[1]);
                    //lista.removeFitxer();
                    break;
                case MOSTRAR_LISTA:
                    System.out.println(desOpcionesMenu[2]);
                    break;
                case GUARDAR_LISTA:
                    System.out.println(desOpcionesMenu[3]);
                    break;
                case RECUPERAR_LISTA:
                    System.out.println(desOpcionesMenu[4]);
                    break;
            }

        } while (opcion != OpcionesMeu.SALIR);

    }


}
