package ub.info.prog2.HuayllasMiguel.model;

import ub.info.prog2.utils.InFileList;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ub.info.prog2.utils.ReproException;


/**
 * Usaremos esta clase para ir guardando ficheros ,esta clase se extendera a
 * RepositoriFitxersMultimedia y PortafoliFitxersMultimedia
 *
 * @author Miguel Huayllas and Luca Eric Di Croce
 */
public class LlistaFitxers implements InFileList, Serializable {
    ArrayList<File> ficheros;
    int totalSize;

    /**
     * Constructor de LlistaFitxers, que l'ha inicialitza a 100
     */
    public LlistaFitxers() {
        ficheros = new ArrayList<File>();
    }

    /**
     * Constructor de LlistaFitxers no utilitzat
     *
     * @param i marca el tamany de l'ArrayList ficheros
     */
    public LlistaFitxers(int i) {
        ficheros = new ArrayList<File>(i);
        totalSize = i;
    }

    /**
     * @return el tamany del ArrayList ficheros
     */
    @Override
    public int getSize() {
        return ficheros.size();
    }

    /**
     * Utilitzem el file per a portar el path del fitxer que l'usuari vol afegir
     * i inicialitzarem la variable vect de tipus FitxerMultimedia, que
     * inicalitzarem amb el path proporcionat pel file i, si el usuari vol, el
     * nom de l'autor
     *
     * @param file EL archivo a gregar
     * @throws ReproException Lanzara un error si el archivo no existe en el pc
     */
    public void addFitxer(File file) throws ReproException {
        // Comprovem que el file existeixi en l'ordinador
        if (file.exists()) {
            ficheros.add(file);
        } else
            throw new ReproException("\nError 404, file not found\n :(");
    }

    /**
     * @param file que es vol eliminar
     */
    public void removeFitxer(File file) {

        ficheros.remove(file);
    }

    @Override
    /**
     * @return el file en la posicio i del ArrayList ficheros
     */
    public File getAt(int i) {
        return ficheros.get(i);
    }

    @Override
    /**
     * Elimina tots els elements del ArrayList ficheros
     */
    public void clear() {
        ficheros.clear();
    }

    @Override
    /**
     * @return false si hi ha espai per a introduir mes fitxers, i true si no
     */
    public boolean isFull() {  //Solo aplicable a portafolis
        // Comprobem que es podria introduir mes fitxers
        if (ficheros.size() < totalSize)
            return false;
        return true;
    }


    /**
     * @return Devolvera en forma de lista cada objeto dentro de la lista
     */
    public List<String> show() {
        List<String> returnList = new ArrayList<String>();
        for (int x = 0; x < getSize(); x++)
            returnList.add(x+1 + ". " + getAt(x));
        return returnList;
    }


    /**
     * El siguiente metodo devolvera en forma de String los atributos de este objeto
     *
     * @return Devolvera en forma de String los atributos de este objeto
     */
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (int x = 0; x < getSize(); x++)
            returnString.append(x + ". " + getAt(x));
        return returnString.toString();
    }
    public FitxerMultimedia goTo(int i){return  (FitxerMultimedia) ficheros.get(i);}
}

