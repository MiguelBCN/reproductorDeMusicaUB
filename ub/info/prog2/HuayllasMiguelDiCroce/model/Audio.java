package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.ReproException;

import java.io.File;

public class Audio extends FitxerMultimedia {
    String camiImatge;
    int qualitat;

    public Audio(String cami, File fitxerAudio, String autor, String codec, int qualitat, Motor motor){
        super(cami,autor,codec,motor);
        this.camiImatge = camiImatge;

        this.qualitat = qualitat;
    }

    @Override
    public void reproduir() throws ReproException {

    }
}
