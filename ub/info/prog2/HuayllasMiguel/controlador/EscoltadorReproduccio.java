package ub.info.prog2.HuayllasMiguel.controlador;

import ub.info.prog2.HuayllasMiguel.model.LlistaFitxers;
import ub.info.prog2.utils.EscoltadorReproduccioBasic;
import ub.info.prog2.utils.ReproException;

public class EscoltadorReproduccio extends EscoltadorReproduccioBasic {
    LlistaFitxers listaAReproducir;
    int pistaActual = 0;
    boolean ciclico=false;
    boolean reverso=false;


    /**
     * Este metodo sera llamado cada vez que se acabe de reproducir un archivo
     */
    @Override
    protected void onEndFile() {
        System.out.println("Se ha acabado de reproducir,pasando a la siguiente cancion");
        if (hasNext())
            next();


    }

    /**
     * El siguiente elemento saltara al siguiente elemento a reproducir , aqui es necesario comprar los dos estados de reproduccion
     * Esto no da como resultado 4 estados:
     * A Si Ciclico y Reverso esta activo -> Se reproducira al reves y al llegar al principio ira al final
     * B Si Ciclico y Reverso estan apagados ->Se  reproducira la lista normalmente y al llegar al final la reproduccion parara
     * C Si Ciclico esta activo y Reverso apagado -> Se reproduce normal y al llegar al final se vuelve a poner al principio
     * D Si Ciclico esta apagado y Reverso activo -> SE reproduce al reves y al llegar al principio de la lista se parara
     */
    @Override
    protected void next() {
        System.out.println("Ciclico encendido y reverso encendido pista "+pistaActual );
        //Caso A
        if (ciclico && reverso) {
            //Reproducir hacia atras
            pistaActual--;
            //Reproducir Ciclico llegar al principio e ir al final
            if (pistaActual == -1) {
                pistaActual = this.listaAReproducir.getSize() - 1;
            }
            try {
                System.out.println("Actualmente esta en la pista " + (pistaActual ));
                listaAReproducir.goTo(pistaActual).reproduir();
                //onEndFile();
            } catch (ReproException e) {
                e.printStackTrace();
            }
        }
        //Caso B
        else if (!ciclico && !reverso) {
            System.out.println("Ciclico apagado y reverso apagado pista "+pistaActual );
            //Reproducir normalmente
            if (hasNext()) {
                pistaActual++;
                try {
                    System.out.println("Actualmente esta en la pista " + (pistaActual ));
                    listaAReproducir.goTo(pistaActual).reproduir();
                    //onEndFile();
                } catch (ReproException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("LLegaste al final de la lista en caso B ");
            }
        }
        //Caso C
        else if (ciclico && !reverso) {
            System.out.println("Ciclico encendido y reverso apagado pista "+pistaActual );
            //Reproducir normal
            pistaActual++;
            //Reproducir ciclico ,llegar al final y volver al pricipio
            if (pistaActual == this.listaAReproducir.getSize()) {
                pistaActual = 0;
            }
            try {
                System.out.println("Actualmente esta en la pista " + (pistaActual ));
                listaAReproducir.goTo(pistaActual).reproduir();
                //onEndFile();
            } catch (ReproException e) {
                e.printStackTrace();
            }
        }
        //Caso D
        else if (!ciclico && reverso) {
            System.out.println("Ciclico apagado y reverso encendido pista "+pistaActual );

            //Reproducir ciclico apagado debemos comprobar que hay siguiente
            if (hasNext()) {
                //Reproducir hacia atras
                pistaActual--;
                try {
                    System.out.println("Actualmente esta en la pista " + (pistaActual ));
                    listaAReproducir.goTo(pistaActual).reproduir();
                    //onEndFile();
                } catch (ReproException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("LLegaste al final de la lista en el caso D");
            }
        }

    }

    /**
     * El siguiente metodo se encargara de comprobar si el actual elemeto tiene uno siguiente, para eso entenderemos que siempre tiene siguiente
     * mientras no alcanze el final de la lista, y si la reproduccion Ciclica esta activa entonces siempre tendra siguiente elemento
     *
     * @return
     */
    @Override
    protected boolean hasNext() {
        if (ciclico)
            return true;
        if (reverso) {
            if (pistaActual - 1 >= 0)
                return true;
            else return false;
        } else {
            if (pistaActual+1 < listaAReproducir.getSize())
                return true;
            else return false;
        }

    }

    public void iniciarReproduccion(LlistaFitxers listaReproduciendo, boolean reproCiclica, boolean reproReversa) {
        this.listaAReproducir = listaReproduciendo;
        this.ciclico = reproCiclica;
        this.reverso = reproReversa;
        this.pistaActual=0;
        System.out.println("Actualmente esta en la pista " + (pistaActual + 1));

        //Para reproducir una lista solo es ir uno a uno reproduciendola,mi iterador sera pistaActual
        //Pero como han dicho de no usar un bucle debeo hacerlo de otra forma

        try {
            listaAReproducir.goTo(pistaActual).reproduir();
            //onEndFile();

        } catch (ReproException e) {
            e.printStackTrace();
        }


    }

}
