package ub.info.prog2.HuayllasMiguel.controlador;

import ub.info.prog2.HuayllasMiguel.model.Audio;
import ub.info.prog2.HuayllasMiguel.model.Imatge;
import ub.info.prog2.utils.MotorBasic;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.io.Serializable;

public class Motor extends MotorBasic implements Serializable {
    public Motor(String ruta,EscoltadorReproduccio escoltador) {
        super(ruta,escoltador);

    }

    /**
     * El siguiente metodo le mandara la orden de reproducir una imagen
     * @param im La iamgen a mostrar
     */
    public void reproducir(Imatge im){
        try {
            this.show(im);
        } catch (ReproException e) {
            e.printStackTrace();
        }

    }

    /**
     * EL siguiente metodo reproducira un arhcivo de audio
     * @param audio El archivo de audio a reproducir
     * @param fitxerImatge La imagen/caratula del audio
     * @throws ReproException
     */
    public void reproducir(Audio audio, File fitxerImatge) throws ReproException {

        this.play(audio,fitxerImatge);
    }
}
