package ub.info.prog2.HuayllasMiguel.controlador;

import ub.info.prog2.HuayllasMiguel.model.Dades;
import ub.info.prog2.utils.InControlador;
import ub.info.prog2.utils.ReproException;

import java.io.IOException;
import java.util.List;

/**
 * La siguiente clase controlador es el que hara las llamadas a Model(Dades)  y este ultimo es el que gestiona las demas clases de modelo+
 * En esta clase se controlora que los parametros que se pasen no esten vacios
 */
public class Controlador implements InControlador {
    /**
     * Atributos de la clase Controlador
     */
    private Dades model;                //Este es ela tributo de la clase que se encargara de la gestion de las clases de modelo
    private  Motor reproductor;    //Este atributo se pasara cada vez que agreguemos un Audio o Imatge
    private EscoltadorReproduccio reproductorListas;


    /**
     * Constructor de la clase Controlador
     */
    public Controlador() {
        this.model = new Dades();
        this.reproductorListas = new EscoltadorReproduccio();

        String rutaVLC = "C:\\Program Files\\VideoLAN\\VLC";
        try {
            this.reproductor = new Motor(rutaVLC, reproductorListas);
        } catch (Exception e) {

        }


    }

    /**
     * Este metodo tratara de agregar un Audio al repositorio , previo a eso hare las comprobaciones pertinentes de que los parametros no sean nulos
     *
     * @param cami       Ruta del archivo
     * @param rutaImagen Ruta de la imagen del audio
     * @param autor      Author del archivo
     * @param codec      Extension del archivo
     * @param calidad    Calidad del archivo
     * @throws ReproException Se encargara de que los parametroas que se pasen no sean nulos
     */
    @Override
    public void addAudio(String cami, String rutaImagen, String autor, String codec, int calidad) throws ReproException {
        //Hacemos las comprobaciones de los paramtros
        if (cami == null)
            throw new ReproException("La ruta del archivo es incorrecta");
        else if (rutaImagen == null)
            throw new ReproException("La ruta de la imagen archivo no puede estar vacia");
        else if (autor == null)
            throw new ReproException("El autor no puede estar vacio");
        else if (codec == null)
            throw new ReproException("El codec no puede estar vacio");
        else if (calidad < 0)
            throw new ReproException("La calidad no puede ser negativa");

        //Tratamos de agregar el archivo al repositorio
        try {
            model.addAudio(cami, rutaImagen, autor, codec, calidad, reproductor);
        } catch (ReproException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo tratara de agregar una Imatge al repositorio , previo a eso hare las comprobaciones pertinentes de que los parametros no sean nulos
     *
     * @param cami    Ruta del archivo
     * @param autor   Author del archivo
     * @param codec   Extension del archivo
     * @param alcada  Alcada de la imagen
     * @param amplada Amplada de la imagen
     * @throws ReproException Se encargara de que los parametroas que se pasen no sean nulos
     */
    @Override
    public void addImatge(String cami, String autor, String codec, int alcada, int amplada) throws ReproException {
        //Hacemos las comprobaciones pertinentes
        if (cami == null)
            throw new ReproException("La ruta del archivo no puede estar vacio");
        else if (autor == null)
            throw new ReproException("El autor no puede estar vacio");
        else if (codec == null)
            throw new ReproException("El codexc no puede estar vacio");
        else if (alcada == 0 | alcada < 0)
            throw new ReproException("La alcada no puede ser negativo o 0");
        else if (amplada == 0 | amplada < 0)
            throw new ReproException("La amplada no puede ser negativo o 0");

        //Tratamos de agregar la Imatge al repositorio
        try {
            model.addImatge(cami, autor, codec, alcada, amplada, reproductor);
        } catch (ReproException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo insertara en un portafolio un archivo del repositorio
     *
     * @param nombrePortafolio Este parametro determinara a que portafolio vamos agregar el archivo
     * @param posRepositorio   La posicion del archivo en el repositorio
     * @throws ReproException Lanzara un aviso indicando que parametro esta mal
     */
    @Override
    public void addFitxer(String nombrePortafolio, int posRepositorio) throws ReproException {
        //Hacemos las comprobaciones
        if (nombrePortafolio == null)
            throw new ReproException("El nombre del portafolio no puede estar vacio");
        else if (posRepositorio < 0)
            throw new ReproException("La posicion del repositorio no puede ser negativa");

        //Agregamos al portafolio un fichero del repositorio
        model.addFitxer(nombrePortafolio, posRepositorio);

    }

    /**
     * Este metodo devolvera una lista array con todos los archivos del repositorio
     *
     * @return devolvera una lista array con todos los archivos
     */
    @Override
    public List<String> showRepositori() {
        return model.showRepositori();
    }

    /**
     * Este metodo devolvera una lista con los nombres de todos los portafolios
     *
     * @return Devolvera una lista con los nombres de todos los portafolios
     */
    @Override
    public List<String> showPortafolis() {
        return model.showPortafolis();
    }

    /**
     * Devolvera una lista que contenga todos los archivos de un portafolio
     *
     * @param nombrePortafolio Esto determinara que portafolio mostrar de la lista de portafolios
     * @return Devolvera una lista de archivos multimedia de un portafolo
     * @throws ReproException Lanzara un error de que el parametro esta vacio
     */
    @Override
    public List<String> showPortafoli(String nombrePortafolio) throws ReproException {
        if (nombrePortafolio == null)
            throw new ReproException("El nombre de portafolio ingresado no puede estar vacio");

        //Llamamos a la funcion en Dades luego de haber hecho una comprobacion
        return model.showPortafoli(nombrePortafolio);
    }

    /**
     * Este metodo llamara al de Dades para que se elimine un fichero del repositorio
     *
     * @param posRepo Posicion del fichero en el repositorio
     * @throws ReproException Lanza un error si la posicion es negativa
     */
    @Override
    public void removeFitxer(int posRepo) throws ReproException {
        if (posRepo < 0)
            throw new ReproException("La posicion no puede ser negativa");

        model.removeFitxer(posRepo);

    }

    /**
     * El siguiente metodo llama a un metodo de Dades que se encarga de guardar Dades en un fichero
     *
     * @param ruta La ruta del archivo donde se guardara el archivo .dat
     * @throws ReproException Lanza un error si la ruta esta vacia
     */
    @Override
    public void saveDades(String ruta) throws ReproException {
        if (ruta == null)
            throw new ReproException("La ruta no puede estar vacia");

        try {
            model.saveDates(ruta);

        } catch (ReproException | IOException e) {
            throw new ReproException(e.getMessage());
        }
    }

    /**
     * El siguiente metodo llama a un metodo de Dades que se encarga de cargar Dades desde un fichero u cargarlo en nuestro actual Dades
     *
     * @param ruta La ruta del archivo donde se guardara el archivo .dat
     * @throws ReproException Lanza un error si la ruta esta vacia
     */
    @Override
    public void loadDades(String ruta) throws ReproException {
        if (ruta == null)
            throw new ReproException("La ruta no puede estar vacia");
        //Cargamos lo del archivo en nuestro actual model
        model = model.loadDates(ruta);
        //Seteamos nel nuevo motor
        model.setMotor(reproductor);
        //Cargamos el ciclico y reverse de Dades
        reproductorListas.reverso=model.getReverso();
        reproductorListas.ciclico=model.getCiclico();

    }

    /**
     * Este metodo agregra un portafolio a una lista de portfolio
     *
     * @param nombre El nombre que tendra el portfolio
     * @throws ReproException Lanzara un error si el nombre esta vacio
     */
    @Override
    public void addPortafoli(String nombre) throws ReproException {
        if (nombre == null)
            throw new ReproException("El nombre del portafolio no puede estar vacio");
        model.addPortafoli(nombre);

    }

    /**
     * El siguiente agraga un portafolio a la lista de portafolios con un tamaño personalizado
     *
     * @param nombre Nombre del portafolio
     * @param size   Tamaño del portafolio
     * @throws ReproException Lanzara un error si algun parametro no es correcto
     */
    public void addPortafoli(String nombre, int size) throws ReproException {
        if (nombre == null)
            throw new ReproException("El nombne no puede estar vacio");
        else if (size == 0 || size < 0)
            throw new ReproException("El tamño no puede ser cero o negativo");
        model.addPortafoli(nombre, size);

    }

    /**
     * El siguiente metodo eliminara un portafolio de la lista
     *
     * @param nombre El nombre del portafolio que se eliminara
     * @throws ReproException Lanzara un error si el nombre introducido no existe
     */
    @Override
    public void removePortafoli(String nombre) throws ReproException {
        if (!existPortafoli(nombre))
            throw new ReproException("El nombre del portafolio introducido no existe");

        model.removePortafoli(nombre);

    }

    /**
     * El siguiente metodo eliminarara un fichero de un portafolio
     *
     * @param nombrePortafolio Nombre del portafolio del cual eliminaremos un archivo
     * @param posPortafolio    Posicion del fichero en el portafolio donde vamos a eliminar
     * @throws ReproException Lanzara un error si algun parametro es incorrecto
     */
    @Override
    public void removeFitxer(String nombrePortafolio, int posPortafolio) throws ReproException {
        if (nombrePortafolio == null)
            throw new ReproException("El nombre del portafolio no puede estar vacio");
        else if (!existPortafoli(nombrePortafolio))
            throw new ReproException("EL nombre introducido no corresponde a ningun portafolio");
        else if (posPortafolio < 0)
            throw new ReproException("La poscion del Portfolio no puede ser negativo");

        model.removeFitxer(nombrePortafolio, posPortafolio);

    }

    /**
     * Este metodo comprobara que un nombre existe en la lista de portafolios
     *
     * @param nombre Nombre a comprobar en la lista
     * @return Dice si exsite o no en la lista
     */
    @Override
    public boolean existPortafoli(String nombre) {
        return model.existPortafoli(nombre);
    }

    /**
     * Este metodo se encargara de hacer un llamado al metodo reproducir un archivo del repositorio
     *
     * @param i La posicion del archivo en el repositorio
     * @throws ReproException
     */
    @Override
    public void playFitxer(int i) throws ReproException {
        if (i < 0 || i > this.model.getRepositorio().getSize())
            throw new ReproException("La posicion indicada " + i + " no existe en la lista");

        this.openFinestraReproductor();
        this.model.getRepositorio().goTo(i).reproduir();
        // this.closeFinestraReproductor();


    }

    @Override
    public void openFinestraReproductor() {
        this.reproductor.open();

    }

    @Override
    public void closeFinestraReproductor() throws ReproException {
        this.reproductor.close();

    }

    /**
     * Este metodo se encarga de reproducir todos los elementos del repositorio
     *
     * @throws ReproException
     */
    @Override
    public void playLlista() throws ReproException {
        this.openFinestraReproductor();
        reproductorListas.iniciarReproduccion(this.model.getRepositorio(), this.model.getCiclico(), this.model.getReverso());
        //this.closeFinestraReproductor();

    }

    /**
     * ESte metodo se encarga de reproducir todos los elementos de un portafolio
     *
     * @param s indica el nombre del portafolio
     * @throws ReproException
     */
    @Override
    public void playLlista(String s) throws ReproException {
        this.openFinestraReproductor();
        reproductorListas.iniciarReproduccion(this.model.getPortafolio(s), this.model.getCiclico(), this.model.getReverso());
        //this.closeFinestraReproductor();
    }

    /**
     * Resumen de un archivo pausado o parado
     *
     * @throws ReproException
     */
    @Override
    public void resumeReproduccio() throws ReproException {
        this.reproductor.resume();

    }

    /**
     * Este metodo pausa la reproduccion de un archivo
     *
     * @throws ReproException
     */
    @Override
    public void pauseReproduccio() throws ReproException {
        this.reproductor.pause();

    }

    /**
     * Este metodo para la reproduccion de un archivo
     *
     * @throws ReproException
     */
    @Override
    public void stopReproduccio() throws ReproException {
        this.reproductor.stop();
    }

    /**
     * Este metodo pasara a la siguiente/anterior cancion
     *
     * @throws ReproException
     */
    @Override
    public void jumpReproduccio() throws ReproException {
        if (this.reproductorListas.hasNext())
            this.reproductorListas.next();
    }

    /**
     * Metodo que cambia la variable ciclico de Dades y Escoltador
     */
    public void cambioCiclico() {
        this.model.setCiclico();
        this.reproductorListas.ciclico = this.model.getCiclico();
    }

    /**
     * Metodo que cambia la variable reverso de Dades y Escoltador
     */
    public void cambioReverso() {
        this.model.setReverso();
        this.reproductorListas.reverso = this.model.getReverso();
    }

    public boolean getCiclico() {
        return this.model.getCiclico();
    }

    public boolean getReverso() {
        return this.model.getReverso();
    }



}
