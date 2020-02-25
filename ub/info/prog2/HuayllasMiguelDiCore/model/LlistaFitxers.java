package ub.info.prog2.HuayllasMiguelDiCore.model;
import ub.info.prog2.utils.InFileList;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.util.ArrayList;
//AQUI SOLO IMPLEMENTAR LOS METHODOS DELA ARRAYLIST

public class LlistaFitxers implements InFileList {
    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void addFitxer(File file) throws ReproException {

    }

    @Override
    public void removeFitxer(File file) {

    }

    @Override
    //Retorna la posicion del ArrayList
    public File getAt(int i) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isFull() {
        return false;
    }
}


