package ub.info.prog2.HuayllasMigueDiCore.vista;

import ub.info.prog2.HuayllasMiguelDiCore.model.LlistaFitxers;
import ub.info.prog2.utils.Menu;

import java.io.*;
import java.util.Scanner;

public class ReproductorUB1 {

    //Declaro la variables del menu para hacer referencia a las opciones del menu
    static private enum OpcionesMenu {  //SWITCHED FROM "OpcionesMenu" TO "OpcionesMenu" (las otras referencias tambien)
        AGREGAR_FICHERO, ELIMINAR_FICHERO,
        MOSTRAR_LISTA, GUARDAR_LISTA, RECUPERAR_LISTA, SALIR
    }

    //Declaro las descripciones de cada menu
    static private String[] desOpcionesMenu = {
            "Demandar datos del fichero y agregarlo a la lista de ficheros",
            "Eliminar un fichero de la lista",
            " Mostra el contenido de la lista de ficheros mostrando delante de cada  su numero de posicion comenzando por el 1"
            , "Guardar el contenido de la lista en un fichero",
            "Cargar una lista previamente guardada en un fichero",
            "Salir de la aplicacion"};
    //Creamos el objeto lista
    LlistaFitxers lista=null;

    public ReproductorUB1(int i) {
        lista = new LlistaFitxers(i);
    }

    public ReproductorUB1() {
        lista = new LlistaFitxers();
    }

    public void gestionReproductorMusica() {
        Scanner sc = new Scanner(System.in);
        String rutaArchivo;
        //Creamos el objeto Menu y le pasamos el enum con las opciones del Menu principal
        Menu<OpcionesMenu> menu = new Menu<OpcionesMenu>("Menu Principal", OpcionesMenu.values());

        //Asignamos las descripciones de las opciones
        menu.setDescripcions(desOpcionesMenu);

        //Obtenemos las opciones del menu y hacemos las acciones pertinentes
        OpcionesMenu opcion = null;
        do {
            //Mostramos las opciones del menu
            menu.mostrarMenu();

            //Demandamos una opcion
            opcion = menu.getOpcio(sc);

            //Hacemos las acciones necesarias
            switch (opcion) {
                case AGREGAR_FICHERO:
                    System.out.println(desOpcionesMenu[0]);
                    if (!lista.isFull()) {
                        System.out.println("Cual es el path del file que quieres añadir?");  //ADDED
                        File add = new File(sc.nextLine());
                        lista.addFitxer(add);
                    } else
                        System.out.println("List is full. You must delete some files before you can add some");
                    break;
                case ELIMINAR_FICHERO:
                    System.out.println(desOpcionesMenu[1]);
                    System.out.println("Cual es el path del file que quieres eliminar?");  //MODIFIED
                    File del = new File(sc.nextLine());
                    lista.removeFitxer(del);
                    break;
                case MOSTRAR_LISTA:
                    System.out.println(desOpcionesMenu[2]);
                    System.out.println(lista);
                    break;
                case GUARDAR_LISTA:
                    System.out.println(desOpcionesMenu[3]);
                    //Pedir al usuario donde se guardara
                    System.out.println("Donde desea guardar el archivo?");
                    rutaArchivo=sc.next();
                    File file=new File(rutaArchivo);
                    //Crear la conexion
                    try  {
                        FileOutputStream fos=new FileOutputStream(file);
                        ObjectOutputStream ous= new ObjectOutputStream(fos);
                        ous.writeObject(lista);

                        fos.close();
                        ous.close();
                        System.out.println("La lista se a guardado correctamente en "+rutaArchivo);

                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case RECUPERAR_LISTA:
                    System.out.println(desOpcionesMenu[4]);
                    //Pedir al usuario el archivo desde el cual vamos a recuperar
                    System.out.println("Introduzca al ruta del archivo del cual quiere recuperar la lista");
                    rutaArchivo=sc.next();
                    try{
                        //Hay otro file tambien en GUARDAR
                        file=new File(rutaArchivo);
                        FileInputStream fis=new FileInputStream(file);
                        ObjectInputStream ois=new ObjectInputStream(fis);

                        //Creamos el objeto donde cargamos el archivo
                        Object one=ois.readObject();
                        System.out.println(one);
                        fis.close();
                        ois.close();
                    }catch(IOException | ClassNotFoundException e){e.printStackTrace();}
                    break;
            }

        } while (opcion != OpcionesMenu.SALIR);

    }


}
