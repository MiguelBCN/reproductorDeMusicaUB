package ub.info.prog2.HuayllasMiguelLucaDiCroce.vista;

import ub.info.prog2.utils.Menu;
import ub.info.prog2.utils.ReproException;

import java.util.Scanner;

import ub.info.prog2.HuayllasMiguelLucaDiCroce.controlador.Controlador;

/**
 * Utilitzarem la classe ReproductorUB1 com a base per a cridar altres metodes
 * i executar el codi
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class ReproductorUB {
    Controlador control;      //A esta variable se le delegara el control

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
     * Cosntructor de ReproductorUB
     */
    public ReproductorUB() {
        control = new Controlador();

    }

    /**
     * El siguiente metedo se encarga de las principales opciones del menu
     *
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
                    System.out.println("Introduce la ruta:");
                    try {
                        control.saveDades(sc.nextLine());
                        System.out.println("Se ha guardado con exito !");
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
                case RECUPERAR_DATOS:
                    //Recuperamos  los datos , aca llamamos a datos.guardar()
                    System.out.println("Entraste a Recuperar datos");
                    System.out.println("Introduce la ruta:");
                    try {
                        control.loadDades(sc.nextLine());
                        System.out.println("Se ha cargado con exito del archivo !");
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
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
                    String answer = null;
                    int size;
                    String opci;
                    System.out.println("Com voleu que es digui?");
                    answer = sc.nextLine();
                    System.out.println("Voleu definir el tamany? Y/N");
                    opci = sc.nextLine();
                    if (opci.equals("Y") || opci.equals("y")) {
                        System.out.println("Quin tamany voleu que tingui?");
                        size = sc.nextInt();
                        try {
                            control.addPortafoli(answer, size);
                        } catch (ReproException e) { //Por si el nombre ya esta ocupado (el portafoli tiene un metodo llamado getName) o (ya implementado) si el autorno encaja
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("El portafoli tindra tamany 100");
                        try {
                            control.addPortafoli(answer);
                        } catch (ReproException e) { //Por si el nombre ya esta ocupado (el portafoli tiene un metodo llamado getName) o (ya implementado) si el autorno encaja
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case MOSTRAR_PORTAFOLIO:
                    //System.out.println(controlador.printPortafolios()); Solo habremos de loopear por la lista de portafolios guardados en data e imprimirlos con indices
                    if (control.showPortafolis().size() == 0) {
                        System.out.println("No hay portafolios para mostrar");
                    } else {
                        for (int i = 0; i < control.showPortafolis().size(); i++) {
                            System.out.println("Titulo " + i + 1 + ": " + control.showPortafolis().get(i));
                        }
                    }
                    break;
                case ELIMINAR_PORTAFOLIO:
                    try {
                        if (control.showPortafolis().size() == 0)
                            throw new ReproException("No hay portafolios creados para eliminar..");
                        System.out.println("Has entrado en eliminar portfolio");
                        System.out.println("Aqui tienes una lista de los nombres de los portafolios disponibles");

                        for (int i = 0; i < control.showPortafolis().size(); i++) {
                            System.out.println("Titulo " + i + 1 + ": " + control.showPortafolis().get(i));
                        }
                        System.out.println("Quin es el nom del portafoli que voleu eliminar?");
                        String nameOfPortafoli = sc.nextLine();
                        control.removePortafoli(nameOfPortafoli);
                        System.out.println("Se ha eliminado el archivo correctamente");

                    } catch (ReproException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case AFEGIR_FITXER_MULTIMEDIA:

                    int opcion, posRepo;
                    String nombrePortafolio;

                    System.out.println("Has entrado en Agregar Fichero");
                    System.out.println("Deseas agregar el fichero en:");
                    System.out.println("1)Repositorio");
                    System.out.println("2)Portafolios");
                    opcion = sc.nextInt();

                    if (opcion == 1) {
                        agregarFicherosMult(sc);
                    } else if (opcion == 2) {
                        try {
                            if(control.showPortafolis().size()==0)
                                throw new ReproException("No hay portafolios para agregar archivos");

                            if (control.showRepositori().size() == 0)
                                throw new ReproException("No hay ficheros en el Repositorio para agregara");

                            System.out.println("Aqui tienes una lista de los portafolios disponibles,selecciona una por su nombre");
                            for (int i = 0; i < control.showPortafolis().size(); i++) {
                                System.out.println("Titulo " + i + 1 + ": " + control.showPortafolis().get(i));
                            }
                            System.out.println("Opcion de portafolio(nombre): ");
                            nombrePortafolio = sc.next();

                            System.out.println("Ahora selecciona del repositorio que archivo agregar elige el indice de tu archivo");
                            System.out.println(control.showRepositori());
                            System.out.println("Posicion del repositorio: ");
                            posRepo = sc.nextInt();
                            System.out.println(" Agregando fichero...");

                            control.addFitxer(nombrePortafolio, posRepo-1 );
                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("La opcion introducida no es valida");
                    }

                    break;
                case MOSTRAR_FITXERS:
                    System.out.println("Has entrado en Mostrat ficheros");
                    int opcion3;
                    String nombrePortafolio2;
                    System.out.println("Deseas agregar el fichero en:");
                    System.out.println("1)Repositorio");
                    System.out.println("2)Portafolios");
                    opcion3 = sc.nextInt();
                    if (opcion3 == 1) {
                        try {
                            if (control.showRepositori().size() == 0)
                                throw new ReproException("No hay archivos en el repositorio..");

                                for (int i = 0; i < control.showRepositori().size(); i++) {
                                    System.out.println(control.showRepositori().get(i));
                                }

                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }


                    } else if (opcion3 == 2) {
                        try {
                            if (control.showPortafolis().size() == 0)
                                throw new ReproException("No hay portafolios creados..");

                            System.out.println("Mostrando una lista con los nombres de los portafolios");
                            System.out.println(control.showPortafolis());
                            for (int i = 0; i < control.showPortafolis().size(); i++) {
                                System.out.println("Titulo " + i + 1 + ": " + control.showPortafolis().get(i));
                            }

                            System.out.println("Escriba el nombre de uno de ellos para mostar sus archivos:");
                            nombrePortafolio2 = sc.next();

                            System.out.println("Mostrando el portafolio " + nombrePortafolio2);

                            System.out.println(control.showPortafoli(nombrePortafolio2));
                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }

                    } else {
                        System.out.println("La opcion introducida no es valida");
                    }
                    break;
                case ELIMINAR_FITXERS_MULTIMEDIA:

                    int opcion2, posRepo2, posPortafolio;
                    String nombrePortafolio3 = null;

                    System.out.println("Has entrado en eliminar Fichero");
                    System.out.println("Deseas eliminar el fichero en:");
                    System.out.println("1)Repositorio");
                    System.out.println("2)Portafolios");
                    opcion2 = sc.nextInt();

                    if (opcion2 == 1) {
                        try {
                            if (control.showRepositori().size() == 0)
                                throw new ReproException("No hay archivos en el repositorio..");

                            System.out.println("Aqui tienes una lista de los archivos en repositorio selecciona una por su posicion");
                            for (int i = 0; i < control.showRepositori().size(); i++) {
                                System.out.println(control.showRepositori().get(i));
                            }
                            System.out.print("Cual deseas eliminar del repositorio: ");
                            posRepo2 = sc.nextInt();
                            System.out.println();
                            System.out.println("\n Eliminando fichero...");

                            control.removeFitxer(posRepo2-1);
                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }

                    } else if (opcion2 == 2) {
                        try {
                            if (control.showRepositori().size() == 0)
                                throw new ReproException("No hay archivos en el repositorio..");

                            if (control.showPortafolis().size() == 0)
                                throw new ReproException("No hay portafolios creados..");

                            System.out.println("Aqui tienes una lista de los portafolios disponibles,selecciona una por su nombre");
                            for (int i = 0; i < control.showPortafolis().size(); i++) {
                                System.out.println("Titulo " + i + 1 + ": " + control.showPortafolis().get(i));
                            }
                            System.out.print("Opcion de portafolio: ");
                            nombrePortafolio3 = sc.next();
                            System.out.println();

                            System.out.println("Ahora selecciona del portafolio  que archivo eliminar elige el indice de tu archivo");

                            System.out.println(control.showPortafoli(nombrePortafolio3));

                            System.out.print("Opcion de portafolio: ");
                            posPortafolio = sc.nextInt();
                            System.out.println("\n Eliminando fichero...");

                            control.removeFitxer(nombrePortafolio3, posPortafolio);
                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }


                    } else {
                        System.out.println("La opcion introducida no es valida");
                    }
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
                    String pathImatge = "C:\\Users\\MiguelDesktop\\Documents\\reproductorDeMusicaUB\\iconMusic.jpg";
                    int kbps;
                    System.out.println("Quin es el path del audio que voleu "
                            + "afegir?");
                    cami = sc.nextLine();
                    System.out.println("Voleu afegir una imatge com a caratula "
                            + "per el audio(Y/N)?");
                    temp = sc.nextLine().charAt(0);
                    if (temp == 'y' || temp == 'Y') {

                        String author, codec1;
                        int alcada, amplada;
                        System.out.println("Quin es el path de la imatge que voleu "
                                + "afegir?");
                        pathImatge = sc.nextLine();
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
                        try {
                            control.addImatge(pathImatge, author, codec1, alcada, amplada);
                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }
                    } else
                        System.out.println("Com es diu l'autor del file que voleu "
                                + "afegir?");
                    autor = sc.nextLine();
                    System.out.println("Quin es el codec del audio que voleu "
                            + "afegir?");
                    codec = sc.nextLine();
                    System.out.println("Quants kbps te el audio que voleu "
                            + "afegir?");
                    kbps = sc.nextInt();
                    try {
                        control.addAudio(cami, pathImatge, autor, codec, kbps);  //We need to convert this image into a string. Any ideas?
                    } catch (ReproException e) {
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

                    try {
                        control.addImatge(cami, autor, codec, alcada, amplada);
                    } catch (ReproException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case MENU_ANTERIOR:
                    System.out.println("Has entrado en menu anterior ");
                    break;
            }


        } while (opcion1_1_1 != OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA.MENU_ANTERIOR);
    }

}

