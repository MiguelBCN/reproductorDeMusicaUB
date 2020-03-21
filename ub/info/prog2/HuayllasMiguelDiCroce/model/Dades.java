package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.utils.ReproException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dades implements Serializable {
    //Esto debe instanciar a repo y portfolio
//    public Audio(String cami, File fitxerImatge, String autor, String codec, int kbps, Motor motor);
//    public Imatge(String cami, String autor, String codec, int alcada, int amplada, Motor motor);


    /**
     * Atributos de Dades
     */
    private RepositoriFitxersMultimedia repositorio;
    private ArrayList<PortafoliFitxersMultimedia> portafolios;

    /**
     * Constructor de Dades
     */
    public Dades() {

        repositorio = new RepositoriFitxersMultimedia();

        portafolios = new ArrayList<PortafoliFitxersMultimedia>();

    }


    /**
     * Este metdo retorna en forma de lista el repositorio
     *
     * @return
     */
    public List<String> showRepositori() {
        return repositorio.mostrar();
    }

    /**
     * El metodo saveDates se encargara de guardarse a si misma dentro de un fichero .dat
     *
     * @param s El parametro s es la ruta donde se guardara
     */
    private void saveDAtes(String s) {
    }

    /**
     * El metodo se encargara de cargar los datos desde un fichero .dat
     *
     * @param s Elparametro s es la ruta donde se guardara
     */
    private void loadDAtes(String s) {
    }

    /**
     * Agregara un portafolio a la lista de portafolio
     *
     * @param s Este parametro sera el atributo nombre de PortafoliFitxersMultimedia
     */
    private void addPortafoli(String s) {
        portafolios.add(new PortafoliFitxersMultimedia(s));
    }

    /**
     * El metodo retorna una lista de los nombres de los portafolios
     *
     * @return
     */
    protected List<String> showPortafolis() {
        List<String> returnStrings = new ArrayList<String>();
        for (int i = 0; i < this.portafolios.size(); i++) {
            returnStrings.add(this.portafolios.get(i).nombre);
        }
        return returnStrings;
    }

    /**
     * Este metodo borrara un portafolio de acuerdo al nombre que se lñe haya pasado como prametero
     *
     * @param s
     */
    private void removePortafoli(String s) {
        for (int i = 0; i < portafolios.size(); i++) {
            if (s == portafolios.get(i).nombre) {
                portafolios.remove(i);
            }
        }
    }

    /**
     * Dado que los portafolios se detectan por el nombre solo habra que buscar en la lista actual si este ya existe o no
     *
     * @param s El nombre del portafolio
     * @return Si el portafolio esta o no en la lista de protafolios
     */
    private boolean existPortafoli(String s) {
        boolean existe = false;
        for (int i = 0; i < portafolios.size() && !existe; i++) {
            if (s == portafolios.get(i).nombre) {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Este metodo
     * @param s
     * @param i
     */
    public  void addFitxer(String s, int i) {

    }


    private void addAudio(String s, String s1, String s2, String s3, int i) {
    }

    private void addImatge(String s, String s1, String s2, int i, int i1) {
    }

    /**
     * El siguiente metodo mostrara solo un portafolio
     * @param s
     * @return
     */
    private List<String> showPortafoli(String s) {
        List<String> returnStrings = new ArrayList<String>();
        for (int i = 0; i < this.portafolios.size(); i++) {
            if (s.equals(portafolios.get(i).nombre)) {
                returnStrings.add(this.portafolios.get(i));
            }
        }
        return returnStrings;
    }

    /**
     * Eliminara un fichero de un portafolio
     * @param s
     * @param i
     */
    private void removeFitxer(String s, int i) {
        for (int i = 0; i < this.portafolios.size(); i++) {
            if (s.equals(portafolios.get(i).nombre)) {
                portafolios.get(i).removeFitxer();
            }
        }

    }

    /**
     * Eliminara un fichero de un repositorio
     * @param i
     */
    private void removeFitxer(int i) {
        for (int j = 0; j <this.repositorio.getSize() ; j++)
            this.repositorio.removeFitxer();

    }


}