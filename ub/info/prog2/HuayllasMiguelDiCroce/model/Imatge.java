package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.ReproException;

public class Imatge extends FitxerMultimedia {
    public Imatge(String cami, String autor, String codec, int alcada, int amplada, Motor motor){
        super(cami,autor,codec,amplada,motor);
    }

    @Override
    public void reproduir() throws ReproException {

    }
}
