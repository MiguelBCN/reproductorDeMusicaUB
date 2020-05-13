package ub.info.prog2.HuayllasMiguel.vista;

import ub.info.prog2.utils.Menu;
import ub.info.prog2.utils.ReproException;

import java.util.Scanner;

import ub.info.prog2.HuayllasMiguel.controlador.Controlador;

/**
 * La clase Reproductor se usara para llamar a los metodos de las clases en controlador y que se muestren por pantalla
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class ReproductorUB {
    Controlador control;      //A esta variable se le delegara el control

    /**
     * Declaracion de las variables del menu principal
     */
    static private enum OpcionesMenu {GESTIO_FITXERS, CONTROL_REPRODUCCION_VISION, GUARDAR_DATOS, RECUPERAR_DATOS, SALIR}

    /**
     * Definicion las descripciones del menu principal
     */
    static private String[] desOpcionesMenu = {
            "Gestion de ficheros", "Control de Reproduccion y Visión", "Guardar el contenido de la lista en un fichero",
            "Cargar una lista de un fichero previamente guardado",
            "Salir de la aplicación"
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
            "Menu anterior"
    };

    /**
     * Declaracion de la variables del submenu de AFEGIR_FITXER_MULTIMEDIA
     */
    static private enum OpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA {AGREGAR_AUDIO, AGREGAR_IMAGEN, MENU_ANTERIOR}

    /**
     * Descripcion de la variables del submenu de AFEGIR_FITXER_MULTIMEDIA
     */
    static private String[] descOpcionesSubMenu_AFEGIR_FITXER_MULTIMEDIA = {"Agregar fichero de audio", "Agregar fichero de imagen", "Menu anterior"};

    /**
     * Declaracion de las variables del sub menu CONTROL_REPRODUCCION_VISION
     */
    static private enum OpcionesControlReproduccionVision {REPRODUCIR_FICHERO_MULTIMEDIA, REPRODUCIR_REPOSITORIO, REPRODUCIR_PORTAFOLIO, REPRODUCCION_CICLICA, REPRODUCCION_REVERSA, GESTION_REPRODUCCION, MENU_ANTERIOR}

    /**
     * Descripcion del submenu CONTROL_REPRODUCCION_VISION
     */
    static private String[] descOpcionesControlReproduccionVision = {
            "Permite reproducir un fichero multimedia del repositorio",
            "Permite reproducir todos los ficheros del repositorio",
            "Permite reproducir todos los ficheros de un portafolio",
            "Activa o desactiva la reporduccion ciclica del repositorio o cualquier portafolio",
            "Activa o desactiva la reporduccion en reversa del repositorio o cualquier portafolio",
            "Abre un menu para la gestion de la reproduccion actual sea del repositorio o de un portafolio",
            "Menu anterior"
    };

    /**
     * Declaracion de las variables del submenu de GESTION_REPRODUCCION
     */
    static private enum OpcionesGestionReproduccion {REACTIVAR, PAUSA, PARAR, SALTA, SALIR}

    /**
     * Descripcion del submenu GESTION_REPRODUCCION
     */
    static private String[] descOpcionesGestionReproduccion = {
            "Reactiva la reproduccion despues de una pausa o una parada",
            "Pausa la reproduccion", "Para la reproduccion",
            "Salta el fichero actual y pasar al siguiente/anterior fichero",
            "Menu anterior"
    };

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
                    //Entramos al menu Gestion Ficheros
                    gestionFicheros(sc);
                    break;
                case CONTROL_REPRODUCCION_VISION:
                    //Entramos al menu Control Reproduccion y vision
                    controlReproduccionVision(sc);
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
                    System.out.println("Como quieres que se llame el portafolio?");
                    answer = sc.nextLine();
                    System.out.println("Quieres definir un tamaño? Y/N");
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
                        System.out.println("El portafolio tendra tamaño de 100");
                        try {
                            control.addPortafoli(answer);
                        } catch (ReproException e) { //Por si el nombre ya esta ocupado (el portafoli tiene un metodo llamado getName) o (ya implementado) si el autorno encaja
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case MOSTRAR_PORTAFOLIO:
                    listarPortafolios();
                    break;
                case ELIMINAR_PORTAFOLIO:
                    try {
                        if (control.showPortafolis().size() == 0)
                            throw new ReproException("No hay portafolios creados para eliminar..");
                        System.out.println("Has entrado en eliminar portfolio");
                        System.out.println("Aqui tienes una lista de los nombres de los portafolios disponibles");
                        listarPortafolios();
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
                        //Llamo al submenu encargado de esta opcion
                        agregarFicherosMult(sc);
                    } else if (opcion == 2) {
                        try {
                            if (control.showPortafolis().size() == 0)
                                throw new ReproException("No hay portafolios para agregar archivos");

                            if (control.showRepositori().size() == 0)
                                throw new ReproException("No hay ficheros en el Repositorio para agregara");

                            System.out.println("Aqui tienes una lista de los portafolios disponibles,selecciona una por su nombre");
                            listarPortafolios();
                            System.out.println("Opcion de portafolio(nombre): ");
                            nombrePortafolio = sc.next();

                            System.out.println("Ahora selecciona del repositorio que archivo agregar elige el indice de tu archivo");
                            System.out.println(control.showRepositori());
                            System.out.println("Posicion del repositorio: ");
                            posRepo = sc.nextInt();
                            System.out.println(" Agregando fichero...");

                            control.addFitxer(nombrePortafolio, posRepo - 1);
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

                            listarRepositorio();

                        } catch (ReproException e) {
                            System.out.println(e.getMessage());
                        }


                    } else if (opcion3 == 2) {
                        try {
                            if (control.showPortafolis().size() == 0)
                                throw new ReproException("No hay portafolios creados..");

                            System.out.println("Mostrando una lista con los nombres de los portafolios");
                            //System.out.println(control.showPortafolis());
                            listarPortafolios();
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
                            listarRepositorio();
                            System.out.print("Cual deseas eliminar del repositorio: ");
                            posRepo2 = sc.nextInt();
                            System.out.println();
                            System.out.println("\n Eliminando fichero...");

                            control.removeFitxer(posRepo2 - 1);
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
                            listarPortafolios();
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

    /**
     * El siguiente metodo creara un menu pora gestion el control de la reproduccion y vision
     *
     * @param sc Este arguemnto sirve para las entradas por teclado del usuario
     */
    private void controlReproduccionVision(Scanner sc) {
        //Creamos el menu
        Menu<OpcionesControlReproduccionVision> submenuControlReproduccionVision = new Menu<OpcionesControlReproduccionVision>("Control Reproduccion y Visión", OpcionesControlReproduccionVision.values());
        //Agregamos las descripciones de cada uno
        submenuControlReproduccionVision.setDescripcions(descOpcionesControlReproduccionVision);
        //Designamos el objeto que sera usado por el usuario para escoger las opciones
        OpcionesControlReproduccionVision opcionControlReproVision = null;

        do {
            //Mostramos el menu
            submenuControlReproduccionVision.mostrarMenu();
            //Demandamos una opcion
            opcionControlReproVision = submenuControlReproduccionVision.getOpcio(sc);
            //Con el switch escogemos el caso de la opcion que queremos
            switch (opcionControlReproVision) {
                case REPRODUCIR_FICHERO_MULTIMEDIA:
                    System.out.println("Reproducir fichero multimedia");
                    int i;
                    System.out.println("Selecciona el indice de la lista de ficheros del repositorio para reproducir");
                    listarRepositorio();
                    System.out.println("Indica tu opcion:");
                    i = sc.nextInt();
                    try {
                        this.control.playFitxer(i-1);
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
                case REPRODUCIR_REPOSITORIO:
                    System.out.println("Reproducir repositorio");
                    try {
                        this.control.playLlista();
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }

                    break;
                case REPRODUCIR_PORTAFOLIO:
                    String nombre;
                    System.out.println("Reproducir portafolio");
                    System.out.println("Por favor escriba el nombre del portafolio a reproducir de la siguiente lista");
                    listarPortafolios();
                    System.out.println("Indica tu opcion:");
                    nombre = sc.nextLine();
                    try {
                        this.control.playLlista(nombre);
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
                case REPRODUCCION_CICLICA:
                    this.control.cambioCiclico();
                    if(this.control.getCiclico())
                        System.out.println("La Reproducir ciclica se ha encendido");
                    else
                        System.out.println("La Reproducir ciclica se ha apagado");
                    break;
                case REPRODUCCION_REVERSA:
                    this.control.cambioReverso();
                    if(this.control.getReverso())
                        System.out.println("La Reproducir reversa se ha encendido");
                    else
                        System.out.println("La Reproducir reversa se ha apagado");
                    break;
                case GESTION_REPRODUCCION:
                    //Aqui entramos el submenu de esta opcion
                    gestionReroduccion(sc);
                    break;

            }
        } while (opcionControlReproVision != OpcionesControlReproduccionVision.MENU_ANTERIOR);
    }

    private void gestionReroduccion(Scanner sc) {
        //Creamos el menu
        Menu<OpcionesGestionReproduccion> subMenuGestionReproduccion = new Menu<OpcionesGestionReproduccion>("Gestion de Reproduccion", OpcionesGestionReproduccion.values());

        //Agregamos las descripciones de cada uno
        subMenuGestionReproduccion.setDescripcions(descOpcionesGestionReproduccion);

        //Designamos el objeto que sirve como opcion para cada menu
        OpcionesGestionReproduccion opcionGestionReproduccion = null;

        do {
            //Mostrar el menu
            subMenuGestionReproduccion.mostrarMenu();
            //Demandar una opcion
            opcionGestionReproduccion = subMenuGestionReproduccion.getOpcio(sc);
            //Escoger el caso mas adecuado
            switch (opcionGestionReproduccion) {
                case REACTIVAR:
                    System.out.println("Reactivar");
                    try {
                        this.control.resumeReproduccio();
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
                case PAUSA:
                    System.out.println("Pausa");
                    try {
                        this.control.pauseReproduccio();
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
                case PARAR:
                    System.out.println("Parar");
                    try {
                        this.control.stopReproduccio();
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
                case SALTA:
                    System.out.println("Saltar ");
                    try {
                        this.control.jumpReproduccio();
                    } catch (ReproException e) {
                        e.printStackTrace();
                    }
                    break;
            }

        } while (opcionGestionReproduccion != OpcionesGestionReproduccion.SALIR);

    }

    private void listarRepositorio() {
        for (int i = 0; i < control.showRepositori().size(); i++) {
            System.out.println(control.showRepositori().get(i));
        }
    }

    private void listarPortafolios() {
        if (control.showPortafolis().size() == 0) {
            System.out.println("No hay portafolios para mostrar");

        } else {
            for (int i = 0; i < control.showPortafolis().size(); i++) {
                System.out.println("Titulo " + i + 1 + ": " + control.showPortafolis().get(i));
            }
        }
    }

}

