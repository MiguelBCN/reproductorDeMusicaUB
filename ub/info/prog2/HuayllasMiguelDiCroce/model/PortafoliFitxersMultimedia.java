package ub.info.prog2.HuayllasMiguelDiCroce.model;

import java.util.List;

import ub.info.prog2.utils.ReproException;

/**
 * Esta clase tiene como objetivo guardar varios archivos de Audio e iamgen que tengan el mismo author aunque sean repetidos
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class PortafoliFitxersMultimedia extends LlistaFitxers {
    String name;
    String author;

    /**
     * Constructor que inicia un portafolio con un nombre y un tamaño especificado
     *
     * @param nom
     * @param tamany
     */
    public PortafoliFitxersMultimedia(String nom, int tamany) {
        super(tamany);
        name = nom;
    }

    /**
     * Constructor que inicia un portafolio con un nombre y un tamaño de 100
     *
     * @param nom
     */
    public PortafoliFitxersMultimedia(String nom) {
        super(100);
        name = nom;
    }

    public void addFileToPortafoli(FitxerMultimedia file) throws ReproException {
        if (super.getSize() > 0) {
            if (file.getAutor() == author)
                super.addFitxer(file);
            else
                throw new ReproException("Author not compatible\n");
        } else {
            super.addFitxer(file);
            author = file.getAutor();
        }
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public List<String> showPortafoli() {
        return super.show();
    }

    public String toString() {
        return super.toString();


    }
}
