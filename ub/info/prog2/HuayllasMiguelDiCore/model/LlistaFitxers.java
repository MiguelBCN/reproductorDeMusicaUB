package ub.info.prog2.HuayllasMiguelDiCore.model;

import ub.info.prog2.utils.InFileList;

import java.util.Scanner;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import ub.info.prog2.utils.ReproException;


/**
 * Utilitzarem la classe LlistaFitxers per a extendre i organitzar la classe
 * ArrayList tal com la necessitem
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class LlistaFitxers implements InFileList, Serializable {
    ArrayList<File> ficheros;
    int totalSize;

    /**
     * Constructor de LlistaFitxers, que l'ha inicialitza a 100
     */
    public LlistaFitxers() {
        totalSize = 100;
        ficheros = new ArrayList<File>(totalSize);
    }

    /**
     * Constructor de LlistaFitxers no utilitzat
     *
     * @param i marca el tamany de l'ArrayList ficheros
     * @deprecated
     */
    public LlistaFitxers(int i) {
        totalSize = i;
        ficheros = new ArrayList<File>(totalSize);
    }

    @Override
    /**
     * @return el tamany del ArrayList ficheros
     */
    public int getSize() {
        return ficheros.size();
    }

    /**
     * Utilitzem el file per a portar el path del fitxer que l'usuari vol afegir
     * i inicialitzarem la variable vect de tipus FitxerMultimedia, que
     * inicalitzarem amb el path proporcionat pel file i, si el usuari vol, el
     * nom de l'autor
     *
     * @param file
     * @throws ReproException
     */
    public void addFitxer(File file) throws ReproException {
        // Comprovem que el file existeixi en l'ordinador
        if (file.exists()) {
            Scanner sc = new Scanner(System.in);
            // creem un FitxerMultimedia vect sense inicialitzar
            FitxerMultimedia vect;
            System.out.println("\nVols afegir un autor? Y/N\n");
            String answer = sc.nextLine();
            if (answer.equals("Y") || answer.equals("y")) {
                System.out.println("\nCom es diu l'autor?\n");
                String a = sc.nextLine();
                // Inicalitzem el vect amb el path del file i el nom de l'autor
                vect = new FitxerMultimedia(file.getAbsolutePath(), a);
            } else
                // Inicalitzem el vect amb nomes el path del file
                vect = new FitxerMultimedia(file.getAbsolutePath());
            ficheros.add(vect);
            System.out.println("\nEl file " + vect + " s'ha afegit correctamnet\n");
        } else
            throw new ReproException("Error 404, file not found\n :(");
    }

    /**
     * Utilitzem el file per a portar el path del fitxer que l'usuari vol
     * eliminar
     *
     * @param file que es vol eliminar
     */
    public void removeFitxer(File file) {
        // Comprovem que el file existeixi en l'ordinador
        if (file.exists()) {
            // Comprovem que el file estigui en la llista
            if (ficheros.contains(file)) {
                ficheros.remove(file);
                System.out.println("\nFile deleted correctly\n");
            } else
                System.out.println("\nError 404, file not found\n :(\n");
        } else
            System.out.println("\nError 404, file not found\n :(\n");
    }

    @Override
    /**
     * @return el file en la posicio i del ArrayList ficheros
     */
    public File getAt(int i) {
        return ficheros.get(i);
    }

    @Override
    /**
     * Elimina tots els elements del ArrayList ficheros
     */
    public void clear() {
        ficheros.clear();
    }

    @Override
    /**
     * @return false si hi ha espai per a introduir mes fitxers, i true si no
     */
    public boolean isFull() {
        // Comprobem que es podria introduir mes fitxers
        if (ficheros.size() < totalSize - 1)
            return false;
        return true;
    }

    /**
     * @return res
     * @deprecated
     */
    public String toString() {
        return "You shoudn't have seen this message!!";
    }
}

