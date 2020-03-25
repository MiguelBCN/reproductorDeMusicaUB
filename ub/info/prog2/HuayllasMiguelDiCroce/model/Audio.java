package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.ReproException;

import java.io.File;

public class Audio extends FitxerMultimedia {
    String camiImatge;
    int qualitat;

    /**
     * Este sera el constructor de Audio los parametros que se pasen es seguro que son correctos
     *
     * @param cami        ruta del archivo
     * @param fitxerAudio ruta de archivo imagen del audio
     * @param autor       autor del archivo
     * @param codec       Tipo de archivo que es (.mp3,.jpg)
     * @param qualitat    Calidad del archivo
     * @param motor
     */
    public Audio(String cami, File fitxerAudio, String autor, String codec, int qualitat, Motor motor) {
        super(cami, autor, codec, motor);
        this.camiImatge = camiImatge;
        this.qualitat = qualitat;
    }

    /**
     * Metodo para reproducir el archivo
     *
     * @throws ReproException
     */
    @Override
    public void reproduir() throws ReproException {


    }
}
