package ub.info.prog2.HuayllasMiguelDiCroce.vista;


import java.util.Scanner;

/**
 * Activem tot el programa
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class IniciadorAplicacioUB {
    /**
     * Main
     *
     * @param args
     */
    public static void main(String[] args) {
        // Inicialitzarem repro com a un new ReproductorUB1() (tamany 100)
        Scanner sc =new Scanner(System.in);
        ReproductorUB repro = new ReproductorUB();
        repro.gestioReproductorUB(sc);
    }
}