package ub.info.prog2.HuayllasMiguelDiCroce.model;

public class PortafoliFitxersMultimedia extends LlistaFitxers {
    String nombre;
    public PortafoliFitxersMultimedia(String s){
        this.nombre=s;
    }
    private String getNombre(){return this.nombre;}
}
