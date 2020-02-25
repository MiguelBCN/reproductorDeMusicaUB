package ub.info.prog2.HuayllasMiguelDiCore.model;
import org.w3c.dom.ls.LSOutput;
import ub.info.prog2.utils.InFileList;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
//AQUI SOLO IMPLEMENTAR LOS METHODOS DELA ARRAYLIST

public class LlistaFitxers implements InFileList {
    //Creamos el ArrayList inicialmente con espacio para 100
    ArrayList<File> ficheros;
    //Creo los 2 constructores
    public LlistaFitxers(int i){
        ficheros=new ArrayList<File>(i);
    }
    public LlistaFitxers(){
        ficheros=new ArrayList<File>(100);
    }

    @Override
    public int getSize() {
        return ficheros.size();
    }

    @Override
    public void addFitxer(File file) throws ReproException {
        //Add more content here
        ficheros.add(file);

    }

    @Override
    public void removeFitxer(File file) {
            //Aqui tendremos que usar una comparacion entre ficheros y cuando hallermos
            // el que pasamos ppor parametro lo eliminamos
      ficheros.remove(file) ;


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
        return false;
    }

    //public toString(){}

    //public mostrarFichero(){}
}


