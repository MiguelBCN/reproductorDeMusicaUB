package ub.info.prog2.HuayllasMigueDiCore.vista;

import ub.info.prog2.HuayllasMiguelDiCore.model.LlistaFitxers;
import ub.info.prog2.utils.Menu;
import ub.info.prog2.utils.ReproException;
import java.io.*;
import java.util.Scanner;

public class ReproductorUB1 {
    //Declarem la variable del menu para hacer referencia a las opciones del menu
    static private enum OpcionesMenu {
        AGREGAR_FICHERO, ELIMINAR_FICHERO,
        MOSTRAR_LISTA, GUARDAR_LISTA, RECUPERAR_LISTA, SALIR
    }

    //Declaro las descripciones de cada menu
    static private String[] desOpcionesMenu = {
            "Afegir un fitxer a la llista",
            "Eliminar un fitxer de la llista",
            "Mostra el contingut de la llista dels fitxers"
            , "Guardar el contingut de la llista en un fitxer",
            "Cargar una llista previamente guardada en un fitxer",
            "Sortir de la aplicacio"};

    //Creem una LlistaFitxers buida
    LlistaFitxers lista;

    public ReproductorUB1(int i) {
        lista = new LlistaFitxers(i);
    }

    //La inicialitzarem amb un tamany total de 100
    public ReproductorUB1() {
        lista = new LlistaFitxers();
    }

    public void gestionReproductorMusica() {
        Scanner sc = new Scanner(System.in);
        String rutaArchivo;
        /*Creem el objecte Menu i le passem el enum cam les opcions del
        Menu principal*/
        Menu<OpcionesMenu> menu = new Menu<OpcionesMenu>("Menu Principal", OpcionesMenu.values());
        //Assignem els noms de les
        menu.setDescripcions(desOpcionesMenu);
        //Obteim les opcions del menú i feem les accions necessaris
        OpcionesMenu opcion = null;
        do {
            //Mostrem el menu
            menu.mostrarMenu();
            //Sellecionem la opció
            opcion = menu.getOpcio(sc);
            //Executem les opcions necessaries
            switch (opcion) {
                case AGREGAR_FICHERO:  //ADD CACTH
                    System.out.println("\n" + desOpcionesMenu[0]);
                    if (!lista.isFull()) {
                        System.out.println("\nQuin es el path del file que vols "
                                + "afegir?\n");
                        try {
                            File add = new File(sc.nextLine());
                            lista.addFitxer(add);
                        }catch (ReproException x){
                            System.out.println("\nFile Already Present\n");
                        }
                    } else {
                        System.out.println("\nLa llista esta plena. Necessites "
                                + "eliminar algun fitxer abans\n");
                    }
                    break;
                case ELIMINAR_FICHERO:
                    System.out.println("\n" + desOpcionesMenu[1]);
                    if(lista.getSize()==0)
                        System.out.println("\nNo hi ha cap fitxer per a "
                                + "eliminar\n");
                    else{
                        System.out.println("\nQuin es el path del file que vols "
                                + "eliminar?\n");
                        String path = sc.nextLine();
                        File file = new File(path);
                        lista.removeFitxer(file);
                    }
                    break;

                case MOSTRAR_LISTA:
                    System.out.println("\n" + desOpcionesMenu[2] + "\n");
                    for(int x = 0; x<lista.getSize(); x++)
                        System.out.println((x+1)+". "+lista.getAt(x).toString());
                    break;

                case GUARDAR_LISTA:
                    System.out.println(desOpcionesMenu[3]);
                    //Pedir al usuario donde se guardara
                    System.out.println("\nDonde desea guardar el archivo?\n");
                    rutaArchivo = sc.next();
                    //Declaro los objetos necesarios para guardar la lista en un fichero
                    File file = null;
                    FileOutputStream fos = null;
                    ObjectOutputStream ous = null;
                    //Crear la conexion
                    try {
                        //Comprobamos si el archivo existe y si se desea sobreescribi
                        file = new File(rutaArchivo);
                        if (file.exists()) {
                            System.out.println("\nEl archivo ya existe desea sobreescribirlo Y/N\n");
                            String op=sc.next();
                            System.out.println(op);
                            if (op.equals("Y") || op.equals("y") ) {
                                fos = new FileOutputStream(file);
                                ous = new ObjectOutputStream(fos);
                                ous.writeObject(lista);
                                //Cierro los objetos y doy un mensaje de confirmacion al usuario
                                fos.close();
                                ous.close();
                                System.out.println("\nSe ha sobreescrito el archivo " + rutaArchivo+"\n");
                            } else if (op.equals("N") || op.equals("n") ) {
                                System.out.println("\nEntendido no se sobreescribira\n");
                            } else{
                                System.out.println("\nOpcion no valida\n");
                                System.out.println(op);}
                        } else {
                            //Si el objeto no existe en el sistema lo creamos
                            fos = new FileOutputStream(file);
                            ous = new ObjectOutputStream(fos);
                            ous.writeObject(lista);
                            //Cierro los objetos y doy un mensaje de confirmacion al usuario
                            fos.close();
                            ous.close();
                            System.out.println("\nCreando el archivo\n");
                            System.out.println("La lista se a guardado correctamente en " + rutaArchivo + "\n");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case RECUPERAR_LISTA:
                    System.out.println("\n" + desOpcionesMenu[4]);
                    //Pedir al usuario el archivo desde el cual vamos a recuperar
                    System.out.println("\nIntroduzca al ruta del archivo del cual quiere recuperar la lista\n");
                    rutaArchivo = sc.next();
                    try {
                        //Comprobamos que el archivo exista
                        file = new File(rutaArchivo);
                        if (file.exists()){
                            FileInputStream fis = new FileInputStream(file);
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            //Creamos el objeto donde cargamos el archivo
                            Object one = ois.readObject();
                            System.out.println(one);
                            fis.close();
                            ois.close();
                            //Hacemos un cast del objeto cargado y le acoplamos un alias (lista)
                            lista=(LlistaFitxers)one;
                        }else
                            System.out.println("\nEl archivo no existe en tu computadora\n");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } while (opcion != OpcionesMenu.SALIR);
    }
}