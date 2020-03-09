package ub.info.prog2.HuayllasMigueDiCore.vista;

import ub.info.prog2.HuayllasMiguelDiCore.model.LlistaFitxers;
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
    String rutaArchivo;
    File file;

    /**
     * Declarem la variable del menu per a fer referencia a les opcions del menu
     */
    static private enum OpcionesMenu {
        AGREGAR_FICHERO, ELIMINAR_FICHERO,
        MOSTRAR_LISTA, GUARDAR_LISTA, RECUPERAR_LISTA, SALIR
    }

    /**
     * Declarem las descripciones de cada opcio del menu
     */
    static private String[] desOpcionesMenu = {
            "Afegir un fitxer a la llista",
            "Eliminar un fitxer de la llista",
            "Mostra el contingut de la llista dels fitxers"
            , "Guardar el contingut de la llista en un fitxer",
            "Cargar una llista previamente guardada en un fitxer",
            "Sortir de la aplicacio"};

    //Creem una LlistaFitxers buida
    LlistaFitxers lista;

    /**
     * Fem el constructor amb tamany total 100
     */
    public ReproductorUB1() {
        lista = new LlistaFitxers();
    }

    /**
     * @param i
     * @deprecated Fem el constructor amb tamany total i
     */
    public ReproductorUB1(int i) {
        lista = new LlistaFitxers(i);
    }

    /**
     * Crearem un menu, l'imprimierm per pantalla, deixarem que el usari trii
     * la opcio que vulgui, i executarem aquella part del codi
     */
    public void gestionReproductorMusica() {
        Menu<OpcionesMenu> menu = new Menu<OpcionesMenu>("Menu Principal",
                OpcionesMenu.values());
        // Assignem els noms de les opcions
        menu.setDescripcions(desOpcionesMenu);
        // Obteim les opcions del menú i fem les accions necessaris
        OpcionesMenu opcion = null;
        // Fem un while que acaba nomes si l'usuari tria sortir en el menu
        /*
        Identifi. de la seq: successió de strings "s" o "n" o "S o  "N"
        Primer:    opcion = menu.getOpcio(sc)
        Següent(): opcion = menu.getOpcio(sc)
        FiSeq():   opcion == OpcionesMenu.SALIR
        Esquema:   cerca
        */
        do {
            // Mostrem el menu
            menu.mostrarMenu();
            // Sellecionem la opcio
            opcion = menu.getOpcio(sc);
            //Executem el codi necessari
            switch (opcion) {
                case AGREGAR_FICHERO:
                    System.out.println("\n" + desOpcionesMenu[0]);
                    afegirFitxer(lista);
                    break;

                case ELIMINAR_FICHERO:
                    System.out.println("\n" + desOpcionesMenu[1]);
                    eliminarFitxer(lista);
                    break;

                case MOSTRAR_LISTA:
                    System.out.println("\n" + desOpcionesMenu[2] + "\n");
                    imprimirLlista(lista);
                    break;

                case GUARDAR_LISTA:
                    System.out.println(desOpcionesMenu[3]);
                    guardarLlista(lista);
                    break;

                case RECUPERAR_LISTA:
                    System.out.println("\n" + desOpcionesMenu[4]);
                    lista = cargarLlista(lista);
                    break;
            }
        } while (opcion != OpcionesMenu.SALIR);
    }

    /**
     * Creara el file per a passar al metode addFitxer i fara el catch a la
     * exepcio ReproException si es dona
     *
     * @param llista
     */
    private void afegirFitxer(LlistaFitxers lista) {
        if (!lista.isFull()) { // Comprobem si el nou file cap
            System.out.println("\nQuin es el path del file que vols"
                    + " afegir?\n");
            rutaArchivo = sc.nextLine();
            try {
                file = new File(rutaArchivo);
                // Enviem el file i el seu path a LlistaFitxers
                lista.addFitxer(file);
                // Si el file no existeix, farem un catch del ReproException
            } catch (ReproException x) {
                System.out.println(x.getMessage());
            }
        } else {
            // Avisem a l'usuari que no caben mes fitxers
            System.out.println("\nLa llista esta plena. "
                    + "Necessites eliminar algun fitxer abans\n");
        }
    }

    /**
     * Creara el file per a passar al metode removeFitxer si es troba que
     * LlistaFitxers lista no esta buida
     *
     * @param lista
     */
    private void eliminarFitxer(LlistaFitxers lista) {
        //Comprovem que hi hagui fitxers per a borrara
        if (lista.getSize() == 0)
            System.out.println("\nNo hi ha cap fitxer per a "
                    + "eliminar\n");
        else {
            System.out.println("\nQuin es el path del file que vols"
                    + " eliminar?\n");
            rutaArchivo = sc.nextLine();
            file = new File(rutaArchivo);
            lista.removeFitxer(file);
        }
    }

    /**
     * Passara per cada element de la LlistaFitxers lista i els imprimira
     *
     * @param lista que conte els files que es vol imprimir
     */
    private void imprimirLlista(LlistaFitxers lista) {
        /*
        Identifi. de la seq: increment de x de 1
        Primer:    x=0
        Següent(): x=x+1
        FiSeq():   x = lista.getSize()
        Esquema:   recorregut
        */
        for (int x = 0; x < lista.getSize(); x++)
            System.out.println((x + 1) + ". " + lista.getAt(x));
        System.out.println();
    }

    /**
     * Escrivim un fitxer .dat per a guardar la LlistaFitxers lista que passem
     * per parametres
     *
     * @param lista
     */
    private void guardarLlista(LlistaFitxers lista) {
        // Mostrem la llista que l'usuari vol guardar
        System.out.println();
        System.out.println(lista.getSize());
        imprimirLlista(lista);
        System.out.println("Aquest es la llista que voleu guardar"
                + ".\n\nOn la voleu guardar?\n");
        rutaArchivo = sc.next();
        // Declarem els objectes necessaris
        file = null;
        FileOutputStream fos = null;
        ObjectOutputStream ous = null;
        // Creem la conexio
        try {
            // Comorovem si el fitxer existeix i el volen sobreescriure
            file = new File(rutaArchivo);
            if (file.exists()) {
                System.out.println("\nEl archiu ja existeix. El vol"
                        + " sobreescriure? Y/N\n");
                String op = sc.next();
                System.out.println(op);
                // Comprovem si l'usuari vol sobreescriure el fitxer
                if (op.equals("Y") || op.equals("y")) {
                    fos = new FileOutputStream(file);
                    ous = new ObjectOutputStream(fos);
                    ous.writeObject(lista);
                    // Tanquem els objectes
                    fos.close();
                    ous.close();
                    System.out.println("\nS'ha sobcreescrit el "
                            + "archiu " + rutaArchivo + "\n");
                } else if (op.equals("N") || op.equals("n")) {
                    System.out.println("\nEl archiu no es "
                            + "sboreescriura\n");
                } else {
                    System.out.println("\nOpcio invalida\n");
                    System.out.println(op);
                }
            } else {
                // Si el objecte no existeix ja, el creem
                fos = new FileOutputStream(file);
                ous = new ObjectOutputStream(fos);
                ous.writeObject(lista);
                // Tanquem els objectes
                fos.close();
                ous.close();
                System.out.println("\nCreant el archiu\n");
                System.out.println("La llista s'ha guardat "
                        + "correctament a " + rutaArchivo + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga la LlistaFitxers lista del document indicat
     *
     * @param lista que es vol sobreescriure amb els files del document indicat
     * @return LlistaFitxers
     */
    private LlistaFitxers cargarLlista(LlistaFitxers lista) {
        // Demanem el path del file per a cargar
        System.out.println("\nIntrodueix el path de la llista que "
                + "vol cargar\n");
        rutaArchivo = sc.next();
        try {
            // Comprobem que el fitxer existeixi
            file = new File(rutaArchivo);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                // Creem un objecte on carguem el file
                Object one = ois.readObject();
                fis.close();
                ois.close();
                /* Fem un cast del objecte cargat i li acomplem
                un alias (lista)*/
                lista = (LlistaFitxers) one;
                System.out.println("\nLlista en " + rutaArchivo + " "
                        + "cargada corectamnet\n");
                imprimirLlista(lista);
            } else
                System.out.println("\nError 404, file not found\n :(\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

