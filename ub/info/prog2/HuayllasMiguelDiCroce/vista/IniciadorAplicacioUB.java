package ub.info.prog2.HuayllasMiguelDiCroce.vista;

import java.util.Scanner;

/**
 * Este sera el main desde el cual ejecutaremos nuestro proyecto
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class IniciadorAplicacioUB {
    /**
     * El main llama a ReproductorUB que es el encargado de gestionar todo
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ReproductorUB repro = new ReproductorUB();
        repro.gestioReproductorUB(sc);
    }
}