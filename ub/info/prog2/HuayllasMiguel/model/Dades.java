package ub.info.prog2.HuayllasMiguel.model;

import ub.info.prog2.HuayllasMiguel.controlador.EscoltadorReproduccio;
import ub.info.prog2.HuayllasMiguel.controlador.Motor;
import ub.info.prog2.utils.ReproException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * La clase Dades se encargara de gesstionar Repositorio y Portafolio , ademas de tener los metodos para guardarse y ser cargado a un arhcivo .dat
 *
 * @author Miguel Huayllas
 */
public class Dades implements Serializable {

    /**
     * Atributos de Dades
     */
    private RepositoriFitxersMultimedia repositorio;
    private ArrayList<PortafoliFitxersMultimedia> portafolios;
    private boolean ReproCiclica =false;
    private boolean ReproReversa =false;

    /**
     * Constructor de Dades
     */
    public Dades() {
        repositorio = new RepositoriFitxersMultimedia();
        portafolios = new ArrayList<PortafoliFitxersMultimedia>();
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
     * Este metdo retorna en forma de lista el repositorio
     *
     * @return
     */
    public List<String> showRepositori() {
        return repositorio.showRepositori();
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

    }

    /**
     * Eliminara un fichero de un repositorio
     *
     * @param posFichero
     */
    //Que busque tambien por author
    public void removeFitxer(int posFichero) {
        FitxerMultimedia comodin;
        //Primero buscaremos todas las copias hechas en los portafolios y los eliminaremos
        comodin = (FitxerMultimedia) this.repositorio.getAt(posFichero);
        //Buscamos en todos los portafolios
        for (int i = 0; i < portafolios.size(); i++) {
            //EScogemos el portafolio que tenga el mismo autor
            if (portafolios.get(i).author == comodin.getAutor()) {
                //Dentro de ese portafolio hacemos otra busqueda
                for (int j = 0; j < portafolios.get(i).getSize(); j++) {
                    //Esta  variable nos servira de alias para tratar con cada archivo dentro del portafolio
                    FitxerMultimedia comodin2 = (FitxerMultimedia) portafolios.get(i).getAt(j);
                    //Finalmente cogemos aquellos que tenga el mismo cami
                    if (comodin.getCamiAbsolut() == comodin2.getCamiAbsolut()) {
                        //Con tanto el portafolio y las posiciones que cumplan dicho criterio llamamos al metodo que elimina de de portafolios
                        //La varible i servira para determinar el nombre dentro de la lista y la variable j para determinar las posiciones dentro del portafolio
                        removeFitxer(portafolios.get(i).name, j);

                    }

                }
            }

        }

        //Finalmemto eliminamos tambien el fichero del repositorio
        this.repositorio.removeFitxer(this.repositorio.getAt(posFichero));

    }

    public RepositoriFitxersMultimedia getRepositorio() {
        return this.repositorio;
    }

    public PortafoliFitxersMultimedia getPortafolio(String nombre) {
        PortafoliFitxersMultimedia obj = null;
        for (int i = 0; i < this.portafolios.size(); i++) {
            if (this.portafolios.get(i).getName().equals(nombre)) {
                obj=this.portafolios.get(i);
            }
        }
        return obj;

    }
    public boolean getCiclico(){return this.ReproCiclica;}
    public boolean getReverso(){return this.ReproReversa;}

    public void setCiclico(){ this.ReproCiclica=!this.ReproCiclica;}
    public void setReverso(){this.ReproReversa=!this.ReproReversa;}
    //Este metodo debero recibir un motor y luego pasar ese escoltador a los ficheros
    public void setMotor(Motor motorNuevo){
        //motorNuevo=new Motor("C:\\Program Files\\VideoLAN\\VLC",escolta);
        //Seteo el motor nuevo a todos los ficheor del repositorio
        for (int i = 0; i <this.getRepositorio().getSize() ; i++) {
            this.getRepositorio().goTo(i).motor=motorNuevo;
        }

    }



}