package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.ReproException;

import java.io.File;

public class Audio extends FitxerMultimedia {
    public Audio(String cami, File fitxerAudio, String autor, String codec, int kbps, Motor motor){
        super(cami,autor,codec,kbps,motor);
    }

    @Override
    public void reproduir() throws ReproException {

    }
}
