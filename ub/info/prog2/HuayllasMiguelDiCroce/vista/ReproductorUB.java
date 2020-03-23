package ub.info.prog2.HuayllasMiguelDiCroce.vista;

import ub.info.prog2.utils.Menu;
import ub.info.prog2.utils.ReproException;

import java.io.*;
import java.util.Scanner;
import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Controlador;
/**
 * Utilitzarem la classe ReproductorUB1 com a base per a cridar altres metodes
 * i executar el codi
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class ReproductorUB {
    Controlador control;      //A esta variable se le delagara el control

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
                    String answer = sc.nextLine();
                    int size = 100;
                    System.out.println("Com voleu que es digui?");
                    answer = sc.nextLine();
                    System.out.println("Voleu definir el tamany? Y/N");
                    if (answer=="Y"||answer=="y"){
                        System.out.println("Quin tamany voleu que tingui?");
                        size = sc.nextInt();
                        try{
                            control.addPortafoli(answer, size);
                        }catch(ReproException e){ //Por si el nombre ya esta ocupado (el portafoli tiene un metodo llamado getName) o (ya implementado) si el autorno encaja
                            System.out.println(e.getMessage());
                        }

                    }
                    else{
                        System.out.println("El portafoli tindra tamany 100");
                        try{
                            control.addPortafoli(answer);
                        }catch(ReproException e){ //Por si el nombre ya esta ocupado (el portafoli tiene un metodo llamado getName) o (ya implementado) si el autorno encaja
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case MOSTRAR_PORTAFOLIO:
                    //System.out.println(controlador.printPortafolios()); Solo habremos de loopear por la lista de portafolios guardados en data e imprimirlos con indices
                    break;
                case ELIMINAR_PORTAFOLIO:
                    System.out.println("Has entrado en eliminar portfolio");
                    //System.out.println(controlador.printPortafolios());
                    System.out.println("Quin es el nom del portafoli que voleu eliminar?");
                    String nameOfPortafoli = sc.nextLine();
                    try{
                        control.removePortafoli(nameOfPortafoli);
                    }catch (ReproException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case AFEGIR_FITXER_MULTIMEDIA:
                    System.out.println("Has entrado en Agregar Fichero");
                    /*ADD THE OPTION TO ADD TO THE PORTAFOLI PLS.
                    When you do, add this:
                    for(int x = 0; x<control.showPortafolis().size(); x++)
                        System.out.println(control.showPortafolis().get(x)+"\n"); //Loopear e indexar la lista de portafolis                    }
                    System.out.println("Com es diu el portafoli on vols afegir el fitxer?");
                    String namePortafoli = sc.nextLine();
                    try{
                        for(int x = 0; x<control.showPortafoli(namePortafoli).size(); x++)
                            System.out.println(control.showPortafoli(namePortafoli).get(x)+"\n"); //Loopear e indexar la lista de portafolis
                    }catch(ReproException e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Quin es el index del fitxer que vols afegir");
                    int indexOfFitxer = sc.nextInt();
                    try{
                    control.addFitxer(namePortafoli, indexOfFitxer);
                    }catch(ReproException e){
                    System.out.println(e.getMessage());
                    }
                    */
                    agregarFicherosMult(sc);
                    break;
                case MOSTRAR_FITXERS:
                    System.out.println("Has entrado en Mostrat ficheros");
                    //System.out.println(control.printRepositori);
                    break;
                case ELIMINAR_FITXERS_MULTIMEDIA:  //FALTA EL MENU
                    System.out.println("Has entrado en eliminar ficheros multimedia");
                    /* IF USER WANTS TO DELETE FILE FROM A CERTAIN PORTAFOLI
                    System.out.println(control.printLlistaDePortafolis); Loopear e indexar la lista de portafolis
                    System.out.println("Quin es el index del portafoli on vhi ha el fitxer a eliminar?");
                    answer2 = sc.nextInt();
                    System.out.println(control.printElementsOfPortafoli); Se imprime los elementos del portafoli. Utliza los metodos getName() y getAuthor()
                    System.out.println("Quin es el index del fitxer que vol eliminar?");
                    answer3 = sc.nextInt();
                    try{
                    control.deleteFileFromPortafoli(answer2, answer3);
                    }catch(ReproException e){
                    System.out.println(e.getMessage());
                    }


                    IF THE USER WANTS TO DELETE A FILE FROM THE REPOSITORI
                    System.out.println(control.printRepositori);
                    System.out.println("Quin es el index del fitxer que vols eliminar");
                    answer2 = sc.nextInt();
                    try{
                    control.deleteFile(answer2); //HABRAS DE LOOPEAR POR TODOS LOS PORTAFOLIS PARA COMPROBAR SI TIENEN EL FILE Y BORRARLO
                    }catch(ReproException e){
                    System.out.println(e.getMessage());
                    }
                    */
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
                    char temp;
                    String cami, autor, codec;
                    File fitxerImatge = null;
                    int kbps;
                    System.out.println("Quin es el path del audio que voleu "
                            + "afegir?");
                    cami = sc.nextLine();
                    System.out.println("Voleu afegir una imatge com a caratula "
                            + "per el audio?");
                    temp = sc.nextLine().charAt(0);
                    if(temp=='Y'||temp=='Y'){
                        /*Todo esto puede ser un metodo*/
                        String path, author, codec1;
                        int alcada, amplada;
                        System.out.println("Quin es el path de la imatge que voleu "
                                + "afegir?");
                        path = sc.nextLine();
                        System.out.println("Com es diu l'autor de la imatge que "
                                + "voleu afegir?");
                        author = sc.nextLine();
                        System.out.println("Quin es el codec de la imatge que voleu"
                                + " afegir?");
                        codec1 = sc.nextLine();
                        System.out.println("Quina alcada te la imatge que voleu "
                                + "afegir?");
                        alcada = sc.nextInt();
                        System.out.println("Quina amplada te la imatge que voleu "
                                + "afegir?");
                        amplada = sc.nextInt();
                        try{
                            control.addImatge(path, author, codec1, alcada, amplada);
                        }catch(ReproException e){
                            System.out.println(e.getMessage());
                        }
                    }else
                        fitxerImatge = new File("ADD HARCODED PATH HERE");
                    System.out.println("Com es diu l'autor del file que voleu "
                            + "afegir?");
                    autor = sc.nextLine();
                    System.out.println("Quin es el codec del audio que voleu "
                            + "afegir?");
                    codec = sc.nextLine();
                    System.out.println("Quants kbps te el audio que voleu "
                            + "afegir?");
                    kbps = sc.nextInt();
                    try{
                        control.addAudio(cami, "fitxerImatge", autor, codec, kbps);  //We need to convert this image into a string. Any ideas?
                    }catch(ReproException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case AGREGAR_IMAGEN:
                    int alcada, amplada;
                    System.out.println("Quin es el path de la imatge que voleu "
                            + "afegir?");
                    cami = sc.nextLine();
                    System.out.println("Com es diu l'autor de la imatge que "
                            + "voleu afegir?");
                    autor = sc.nextLine();
                    System.out.println("Quin es el codec de la imatge que voleu"
                            + " afegir?");
                    codec = sc.nextLine();
                    System.out.println("Quina alcada te la imatge que voleu "
                            + "afegir?");
                    alcada = sc.nextInt();
                    System.out.println("Quina amplada te la imatge que voleu "
                            + "afegir?");
                    amplada = sc.nextInt();

                    try{
                        control.addImatge(cami, autor, codec, alcada, amplada);
                    }catch (ReproException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_ANTERIOR:
                    System.out.println("Has entrado en menu anterior ");
                    break;
            }


        } while (opcion1_1_1 != OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA.MENU_ANTERIOR);
    }






    /*NOTA*/
    //EL ejercio nos pide un repositorio minimo asi que ese ya esta inicializado , en cambio el portafolio no y ese no se limnita a uno

        /*El reproductor tendrÃ¡ sÃ³lo un repositorio y un nÃºmero indeterminado de portafolios. los
    portafolios quedarÃ¡n identificados por su tÃ­tulo, y por tanto, no podremos tener tÃ­tulos
    repetidos. El usuario sÃ³lo podrÃ¡ aÃ±adir archivos al repositorio y aÃ±adir estos archivos a las
    listas de los portafolios, tantas veces como quiera. Es decir, los archivos de los portafolios han
    estar en el repositorio y no se pueden aÃ±adir directamente archivos a los portafolios si estos no
    han sido aÃ±adidos previamente al repositorio.*/

    /*DUDA POR CONTESTAR POR PARTE DEL PROFESOR*/
    /*Y por ultimo ahora que tenemos la clase Dades que estarÃ¡ en el paquete controlador , entiendo que el manipulara el repositorio  y los portafolios ,
    entonces la clase reproductorUB solo tendrÃ¡ una inicializacion a este objeto y la libreria menu para ir llamando a los mÃ©todos de la clase Dades no?*/
}

