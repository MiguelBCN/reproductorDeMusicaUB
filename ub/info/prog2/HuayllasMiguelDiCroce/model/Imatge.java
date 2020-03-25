package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.ReproException;

public class Imatge extends FitxerMultimedia {
    int alcada;
    int amplada;
    /**
     * Este sera el constructor de Audio los parametros que se pasen es seguro que son correctos
     * @param cami ruta del archivo
     * @param autor autor del archivo
     * @param codec Tipo de archivo que es (.mp3,.jpg)
     * @param alcada Altura de la imagen
     * @param amplada Ancho de la imagen
     * @param motor
     */
    public Imatge(String cami, String autor, String codec, int alcada, int amplada, Motor motor){
        super(cami,autor,codec,motor);
        this.alcada = alcada;
        this.amplada = amplada;
    }

    /**
     * Metodo para reproducir la imagen
     * @throws ReproException
     */
    @Override
    public void reproduir() throws ReproException {

    }
}
