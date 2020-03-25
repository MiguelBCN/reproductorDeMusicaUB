package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.InFile;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.util.Date;


/**
 * Usaremos la clase FitxerMultimedia como extension de la clase File y tambien esta misma sera una extension para
 * las clase Audio e Imatge que seran los objetos que iremos guardando en la clases hijo de LlistaFitxers
 * RepositoriFitxersMultimedia y PortafoliFitxersMultimedia
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public abstract class FitxerMultimedia extends File implements InFile {
    private String author;
    private String codec;
    private Motor motor;

    /**
     * @param path del file que es vol afegir
     */
    public FitxerMultimedia(String path) {
        super(path);
        this.author = "Unknown";
    }

    /**
     * @param path   del file que es vol afegir
     * @param author
     */
    public FitxerMultimedia(String path, String author) {
        super(path);
        this.author = author;
    }

    /**
     * Constructor principal de la clase FitxerMultimedia ya que tiene todos los atributos a inicializar
     *
     * @param cami   Corresponde a la ruta del archivo
     * @param author Corresponde al author del archivo
     * @param codec  Tipo de archivo que es (.mp3,.jpg)
     * @param motor
     */
    protected FitxerMultimedia(String cami, String author, String codec, Motor motor) {
        super(cami);
        this.setAutor(author);
        this.codec = codec;
        this.motor = motor;

    }

    /**
     * Constructor alternitivo que iniciliza el autor como "Desconocido"
     *
     * @param cami  Corresponde a la ruta del archivo
     * @param codec Tipo de archivo que es (.mp3,.jpg)
     * @param motor
     */
    protected FitxerMultimedia(String cami, String codec, Motor motor) {
        super(cami);
        this.author = "Desconocido";
        this.codec = codec;
        this.motor = motor;

    }

    /**
     * Metodo para reproducir el archivo
     *
     * @throws ReproException
     */
    public abstract void reproduir() throws ReproException;


    /**
     * @param obj que es vol comparar amb el FitxerMultimedia
     * @return true si els dos objectes son equivalents i false si no
     */
    public boolean equals(Object obj) {
        // Si el objecte esta buit, retorna false
        if (obj == null) return false;
        // Creem un objecte del tipus que compararem
        FitxerMultimedia other = null;
        // Comprovem que el objecte del param sigui del tipus correcte
        if (obj instanceof FitxerMultimedia)
            // Fem un alias del objecte
            other = (FitxerMultimedia) obj;
        // Finalment fem la comparacio
        return this.getAutor().equals(other.getAutor()) && super.equals(other);
    }

    /**
     * Metodo que devuelve la ultima modificación del archivo
     *
     * @return devuelve la ultima modificación del archivo
     */
    @Override
    public Date getUltimaModificacio() {
        Date lastMod = new Date(this.lastModified());
        return lastMod;
    }

    @Override
    /**
     * @return el path absolut del file
     */
    public String getCamiAbsolut() {
        return getAbsolutePath();
    }

    @Override
    /**
     * @return el name del file
     */
    public String getNomFitxer() {
        return getName();
    }

    @Override
    /**
     * @return el atribut author
     */
    public String getAutor() {
        return this.author;
    }

    @Override
    /**
     * Canvia el author a s
     */
    public void setAutor(String s) {
        this.author = s;
    }

    /**
     * @return el author, la data de la ultima modificacio, i el path absolut
     */
    public String toString() {
        String returnString = new String("Autor= " + this.getAutor() + ", data=" +
                this.getUltimaModificacio() + ", cami complet=" + this.getCamiAbsolut());
        return returnString;
    }


}

