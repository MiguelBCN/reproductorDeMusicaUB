package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.utils.InFile;

import java.io.File;
import java.util.Date;


/**
 * Utilitzarem la classe FitxerMultimedia per a extendre la classe file, i
 * poder afegir els atributs i metodes necessaris per a aquesta entrega
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class FitxerMultimedia extends File implements InFile {
    String author;

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

    @Override
    /**
     * return la data de la ultima modificaio feta al file
     */
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

