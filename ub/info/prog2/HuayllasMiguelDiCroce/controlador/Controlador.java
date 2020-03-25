package ub.info.prog2.HuayllasMiguelDiCroce.controlador;

import ub.info.prog2.HuayllasMiguelDiCroce.model.Dades;
import ub.info.prog2.utils.InControlador;
import ub.info.prog2.utils.ReproException;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Controlador implements InControlador {
    /**
     * Atributos de la clase Controlador
     */
    private Dades model;
    private final Motor reproductor;


    /**
     * Constructor de la clase Controlador
     */
    public Controlador() {

        this.model = new Dades();
        this.reproductor = new Motor();
    }

    /**
     * Este metodo llamara a un metodo de Clases que agregara un audio al Repositorio
     *
     * @param cami
     * @param rutaImagen
     * @param autor
     * @param codec
     * @param calidad
     * @throws ReproException
     */
    @Override
    public void addAudio(String cami, String rutaImagen, String autor, String codec, int calidad) throws ReproException {
        if (cami == null | rutaImagen == null | autor == null | codec == null)
            throw new ReproException("Los parametros no pueden estar vacios");
        try {
            model.addAudio(cami, rutaImagen, autor, codec, calidad);
        } catch (ReproException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo llamara a un metodo de Clases que agregara una imagen al Repositorio
     *
     * @param cami
     * @param autor
     * @param codec
     * @param alcada
     * @param amplada
     * @throws ReproException
     */
    @Override
    public void addImatge(String cami, String autor, String codec, int alcada, int amplada) throws ReproException {
        if (cami == null | autor == null | codec == null)
            throw new ReproException("Los parametros no pueden estar vacios");
        if (alcada == 0 | amplada == 0 | alcada < 0 | amplada < 0)
            throw new ReproException("Los valores de alcada o amplada no pueden ser 0 o negativos");
        try {
            model.addImatge(cami, autor, codec, alcada, amplada);
        } catch (ReproException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Este metodo insertara en un portafolio un archivo de repositorio
     *
     * @param nombrePortafolio El nombre del pportafolio al cual vamos a agregar el archivo
     * @param posRepositorio   La posicion del archivo en el repositorio
     * @throws ReproException
     */
    @Override
    public void addFitxer(String nombrePortafolio, int posRepositorio) throws ReproException {
        if (nombrePortafolio == null)
            throw new ReproException("El nombre del portafolio no puede estar vacio");
        else if (posRepositorio < 0)
            throw new ReproException("La posicion del repositorio no puede ser negativa");
        else
            model.addFitxer(nombrePortafolio, posRepositorio);

    }

    /**
     * Este metodo devolvera una lista array con todos los archivos
     *
     * @return devolvera una lista array con todos los archivos
     */
    @Override
    public List<String> showRepositori() {
        return model.showRepositori();
    }

    /**
     * Es metodo mostrara todos los portafolios
     * @return
     */
    @Override
    public List<String> showPortafolis() {
        return model.showPortafolis();
    }

    @Override
    public List<String> showPortafoli(String s) {
        return model.showPortafoli(s);
    }

    @Override
    public void removeFitxer(int posRepo) throws ReproException {
        model.removeFitxer(posRepo);

    }

    @Override
    public void saveDades(String ruta) throws ReproException {
        try {
            model.saveDates(ruta);

        } catch (ReproException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void loadDades(String ruta) throws ReproException {
        model.loadDates(ruta);

    }

    @Override
    public void addPortafoli(String nombre) throws ReproException {
        model.addPortafoli(nombre);

    }

    public void addPortafoli(String nombre, int size) throws ReproException {
        model.addPortafoli(nombre,size);

    }


    @Override
    public void removePortafoli(String nombre) throws ReproException {
        model.removePortafoli(nombre);

    }

    @Override
    public boolean existPortafoli(String nombre) {
        return model.existPortafoli(nombre);
    }


    @Override
    public void removeFitxer(String nombrePortafolio, int posPortafolio) throws ReproException {
        model.removeFitxer(nombrePortafolio,posPortafolio);

    }
}
