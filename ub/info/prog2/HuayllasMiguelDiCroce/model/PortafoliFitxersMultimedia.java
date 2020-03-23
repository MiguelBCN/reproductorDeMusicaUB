package ub.info.prog2.HuayllasMiguelDiCroce.model;

import java.util.List;
import ub.info.prog2.utils.ReproException;


public class PortafoliFitxersMultimedia extends LlistaFitxers {
    String name;
    String author;

    public PortafoliFitxersMultimedia(String nom, int tamany){
        super(tamany);
        name = nom;
    }

    public PortafoliFitxersMultimedia(String nom){
        super(100);
        name = nom;
    }

    public void addFileToPortafoli (FitxerMultimedia file) throws ReproException{
        if(super.getSize()>0){
            if (file.getAutor()==author)
                super.addFitxer(file);
            else
                throw new ReproException ("Author not compatible\n");
        }else{
            super.addFitxer(file);
            author = file.getAutor();
        }
    }

    public String getAuthor(){
        return author;
    }
    public String getName(){
        return name;
    }

    public List<String> showPortafoli(){
        return super.show();
    }

    public String toString (){
        return super.toString();


    }
}
