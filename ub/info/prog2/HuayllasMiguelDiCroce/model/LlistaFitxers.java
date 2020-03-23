package ub.info.prog2.HuayllasMiguelDiCroce.model;
import ub.info.prog2.utils.InFileList;
import java.util.Scanner;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import ub.info.prog2.utils.ReproException;


/**
 * Utilitzarem la classe LlistaFitxers per a extendre i organitzar la classe
 * ArrayList tal com la necessitem
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class LlistaFitxers implements InFileList, Serializable {
    ArrayList<File> ficheros;
    int totalSize;
    /**
     * Constructor de LlistaFitxers, que l'ha inicialitza a 100
     */
    public LlistaFitxers() {
        ficheros = new ArrayList<File>();
    }

    /**
     * Constructor de LlistaFitxers no utilitzat
     * @param i marca el tamany de l'ArrayList ficheros
     */
    public LlistaFitxers(int i) {
        ficheros = new ArrayList<File>(i);
        totalSize = i;
    }

    /**
     * @return el tamany del ArrayList ficheros
     */
    @Override
    public int getSize() {
        return ficheros.size();
    }

    /**
     * Utilitzem el file per a portar el path del fitxer que l'usuari vol afegir
     *  i inicialitzarem la variable vect de tipus FitxerMultimedia, que
     * inicalitzarem amb el path proporcionat pel file i, si el usuari vol, el
     * nom de l'autor
     * @param file
     * @throws ReproException
     */
    public void addFitxer(File file) throws ReproException {
        // Comprovem que el file existeixi en l'ordinador
        if (file.exists()) {
           /*
            All this can be sent to main

            Scanner sc = new Scanner(System.in);
            // creem un FitxerMultimedia vect sense inicialitzar
            FitxerMultimedia vect;
            System.out.println("\nVols afegir un autor? Y/N\n");
            String answer = sc.nextLine();
            if (answer.equals("Y") || answer.equals("y") ){
                System.out.println("\nCom es diu l'autor?\n");
                String a = sc.nextLine();
                // Inicalitzem el vect amb el path del file i el nom de l'autor
                vect = new FitxerMultimedia(file.getAbsolutePath(), a);
            }else
                // Inicalitzem el vect amb nomes el path del file
                vect = new FitxerMultimedia(file.getAbsolutePath());
            */
            ficheros.add(file);
        } else
            throw new ReproException ("\nError 404, file not found\n :(");
    }

    /**
     * @param file que es vol eliminar
     */
    public void removeFitxer(File file){
        ficheros.remove(file);
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
    public boolean isFull() {  //Solo aplicable a portafolis
        // Comprobem que es podria introduir mes fitxers
        if (ficheros.size() < totalSize)
            return false;
        return true;
    }


    public List<String> show() {
        List<String> returnList = new ArrayList<String>();
        for (int x = 0; x<getSize(); x++)
            returnList.add(x+". " + getAt(x));
        return returnList;
    }

    /**
     *
     *
     * @return res
     */
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (int x = 0; x<getSize(); x++)
            returnString.append(x+". " + getAt(x));
        return returnString.toString();
    }
}

