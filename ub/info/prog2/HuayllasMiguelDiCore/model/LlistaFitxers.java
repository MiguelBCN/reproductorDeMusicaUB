package ub.info.prog2.HuayllasMiguelDiCore.model;

import ub.info.prog2.utils.InFileList;
import java.util.Scanner;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import ub.info.prog2.utils.ReproException;

public class LlistaFitxers implements InFileList, Serializable {
    //Creamos el ArrayList inicialmente con espacio para 100
    ArrayList<File> ficheros;
    int totalSize;
    //Creo los 2 constructores
    public LlistaFitxers(int i) {
        totalSize = i;
        ficheros = new ArrayList<File>(totalSize);
    }

    public LlistaFitxers() {
        totalSize = 100;
        ficheros = new ArrayList<File>(totalSize);
    }

    @Override
    public int getSize() {
        return ficheros.size();
    }

    public void addFitxer(File file) throws ReproException {
        if (file.exists()) {
            Scanner sc = new Scanner(System.in);
            FitxerMultimedia temp;
            System.out.println("\nDo you want to add an author? Y/N\n");
            String answer = sc.nextLine();
            if (answer.equals("Y") || answer.equals("y") ){
                System.out.println("\nWright thee name of the author\n");
                String a = sc.nextLine();
                temp = new FitxerMultimedia(file.getAbsolutePath(), a);
            }else
                temp = new FitxerMultimedia(file.getAbsolutePath());
            ficheros.add(temp);
            System.out.println("\nFile "+temp+" added correctly\n");
        } else
            throw new ReproException ("File Already Present");
    }

    public void removeFitxer(File file) {
        //Aqui tendremos que usar una comparacion entre ficheros y cuando hallermos
        // el que pasamos ppor parametro lo eliminamos
        if (file.exists()) {
            if (ficheros.contains(file)) {
                ficheros.remove(file);
                System.out.println("\nFile deleted correctly\n");
            } else
                System.out.println("\nError 404, file not found\n");
        } else
            System.out.println("\nError 404, file not found\n");
    }

    @Override
    //Retorna la posicion del ArrayList
    public File getAt(int i) {
        return ficheros.get(i);
    }

    @Override
    public void clear() {
        ficheros.clear();
    }

    @Override
    public boolean isFull() {
        //Creo te daba error porque el total size es 100 mientras el size() era menor
        if (ficheros.size() < totalSize)
            return false;
        return true;
    }

    public String toString() {
        return "";
    }
}

