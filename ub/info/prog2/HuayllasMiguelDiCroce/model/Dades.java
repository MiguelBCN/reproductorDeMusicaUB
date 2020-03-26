package ub.info.prog2.HuayllasMiguelDiCroce.model;

import ub.info.prog2.HuayllasMiguelDiCroce.controlador.Motor;
import ub.info.prog2.utils.ReproException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Dades implements Serializable {

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
        return repositorio.showRepositori();
    }

    /**
     * El metodo saveDates se encargara de guardarse a si misma dentro de un fichero .dat
     *
     * @param ruta El parametro s es la ruta donde se guardara
     */
    public void saveDates(String ruta) throws ReproException, IOException {
        File fichero = new File(ruta);
        try {
            FileOutputStream fos = new FileOutputStream(fichero);
            ObjectOutputStream ous = new ObjectOutputStream(fos);
            ous.writeObject(this);
            ous.close();
            fos.close();
        } catch (Exception e) {
            throw new ReproException(e.getMessage());

        }

    }

    /**
     * El metodo se encargara de cargar los datos desde un fichero .dat
     *
     * @param ruta Elparametro s es la ruta donde se guardara
     */
    public Dades loadDates(String ruta) throws ReproException {
        File fichero = new File(ruta);
        Object one;
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            one = ois.readObject();
            fis.close();
            ois.close();

            return (Dades) one;
        } catch (Exception e) {
            throw new ReproException(e.getMessage());

        }

    }

    /**
     * Agregara un portafolio a la lista de portafolio
     *
     * @param nombre Este parametro sera el atributo name de PortafoliFitxersMultimedia
     */
    public void addPortafoli(String nombre) {

        portafolios.add(new PortafoliFitxersMultimedia(nombre));
    }

    /**
     * Este metodo agrega un portafolio a la lista
     *
     * @param nombre El nombre del portafolio
     * @param size   El tamaño del portafolio
     */
    public void addPortafoli(String nombre, int size) {
        portafolios.add(new PortafoliFitxersMultimedia(nombre, size));
    }

    /**
     * El metodo retorna una lista de los nombres de los portafolios
     *
     * @return
     */
    public List<String> showPortafolis() {
        List<String> returnStrings = new ArrayList<String>();
        for (int i = 0; i < this.portafolios.size(); i++) {
            returnStrings.add(this.portafolios.get(i).name);
        }
        return returnStrings;
    }

    /**
     * Este metodo borrara un portafolio de acuerdo al nombre que se lñe haya pasado como prametero
     *
     * @param nombre
     */
    public void removePortafoli(String nombre) {
        for (int i = 0; i < portafolios.size(); i++) {
            if (nombre.equals(portafolios.get(i).getName())) {
                portafolios.remove(i);
            }
        }
    }

    /**
     * Dado que los portafolios se detectan por el nombre solo habra que buscar en la lista actual si este ya existe o no
     *
     * @param nombre El nombre del portafolio
     * @return Si el portafolio esta o no en la lista de protafolios
     */
    public boolean existPortafoli(String nombre) {
        boolean existe = false;
        for (int i = 0; i < portafolios.size() && !existe; i++) {
            if (nombre.equals(portafolios.get(i).getName())) {
                existe = true;
            }
        }
        return existe;
    }

    /**
     * Este metodo agregara al portafolio una posicion del repositorio
     *
     * @param nombrePortafolio
     * @param posRepositorio
     */
    public void addFitxer(String nombrePortafolio, int posRepositorio) throws ReproException {
        for (int i = 0; i < portafolios.size(); i++) {
            if (nombrePortafolio.equals(portafolios.get(i).getName())) {
                portafolios.get(i).addFitxer(repositorio.getAt(posRepositorio));
            }

        }
    }

    /**
     * Este metodo agregara un Audio al repositorio
     *
     * @param ruta
     * @param rutaImagen
     * @param autor
     * @param codec
     * @param calidad
     * @throws ReproException
     */
    public void addAudio(String ruta, String rutaImagen, String autor, String codec, int calidad, Motor reproductor) throws ReproException {
        File ficheroImagen = new File(rutaImagen);
        Audio audio = new Audio(ruta, ficheroImagen, autor, codec, calidad, reproductor);
        repositorio.addFileToRepositori(audio);

    }

    /**
     * Este metodo agregara una Imagen al repositorio
     *
     * @param ruta
     * @param autor
     * @param codec
     * @param alcada
     * @param amplada
     * @throws ReproException
     */
    public void addImatge(String ruta, String autor, String codec, int alcada, int amplada, Motor reproductor) throws ReproException {

        Imatge imagen = new Imatge(ruta, autor, codec, alcada, amplada, reproductor);
        repositorio.addFileToRepositori(imagen);

    }

    /**
     * El siguiente metodo mostrara solo un portafolio
     *
     * @param nombrePortafolio
     * @return
     */
    public List<String> showPortafoli(String nombrePortafolio) {
        List<String> returnStrings = new ArrayList<String>();
        for (int i = 0; i < this.portafolios.size(); i++) {
            if (nombrePortafolio.equals(portafolios.get(i).getName())) {
                returnStrings.add(this.portafolios.get(i).toString());
            }
        }
        return returnStrings;
    }

    /**
     * Eliminara un fichero de un portafolio
     *
     * @param nombrePortafolio
     * @param posPortafolio
     */
    public void removeFitxer(String nombrePortafolio, int posPortafolio) {
        for (int i = 0; i < this.portafolios.size(); i++) {
            if (nombrePortafolio.equals(portafolios.get(i).getName())) {
                //con esto obtenemos el portafolio , ahora vamos
                portafolios.get(i).removeFitxer(portafolios.get(i).getAt(posPortafolio));
            }
        }
        //Luego habrab que comprovar si hay otro igual
        // Si no lo hay tambien eliminaremos del repositorio

    }

    /**
     * Eliminara un fichero de un repositorio
     *
     * @param posFichero
     */
    //Que busque tambien por author
    public void removeFitxer(int posFichero) {
        this.repositorio.removeFitxer(this.repositorio.getAt(posFichero));
        //Buscaremos de este todas las copias en los repositorios

    }


}