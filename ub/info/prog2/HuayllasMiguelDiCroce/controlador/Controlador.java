package ub.info.prog2.HuayllasMiguelDiCroce.controlador;

import ub.info.prog2.HuayllasMiguelDiCroce.model.Dades;
import ub.info.prog2.utils.InControlador;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.io.IOException;
import java.util.List;



public class Controlador implements InControlador {
    /**
     * Atributos de la clase Controlador
     */
    private Dades model;
    private final Motor reproductor;


    /**
     * Constructor de la clase Controlador
     */
    public Controlador() {

        this.model = new Dades();
        this.reproductor = new Motor();
    }


    @Override
    public void addAudio(String s, String s1, String s2, String s3, int i) throws ReproException {

    }

    @Override
    public void addImatge(String s, String s1, String s2, int i, int i1) throws ReproException {

    }

    @Override
    public List<String> showRepositori() {
        return model.showRepositori();
    }

    @Override
    public void removeFitxer(int i) throws ReproException {

    }

    @Override
    public void saveDades(String ruta) throws ReproException {
        try {
            model.saveDates(ruta);

        }catch (ReproException | IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void loadDades(String ruta) throws ReproException {
        model.loadDates(ruta);

    }

    @Override
    public void addPortafoli(String s) throws ReproException {

    }
    public void addPortafoli(String s,int size) throws ReproException {

    }

    @Override
    public List<String> showPortafolis() {
        return null;
    }

    @Override
    public void removePortafoli(String s) throws ReproException {

    }

    @Override
    public boolean existPortafoli(String s) {
        return false;
    }

    @Override
    public void addFitxer(String s, int i) throws ReproException {

    }

    @Override
    public List<String> showPortafoli(String s) throws ReproException {
        return null;
    }

    @Override
    public void removeFitxer(String s, int i) throws ReproException {

    }
}
