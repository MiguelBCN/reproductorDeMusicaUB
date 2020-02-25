package ub.info.prog2.HuayllasMiguelDiCore.model;
import ub.info.prog2.utils.InFileList;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.util.ArrayList;

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


