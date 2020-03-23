/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ub.info.prog2.HuayllasMiguelDiCroce.model;

import java.io.File;
import java.util.List;
import ub.info.prog2.utils.ReproException;

/**
 *
 * @author Test
 */
public class RepositoriFitxersMultimedia extends LlistaFitxers {
    public RepositoriFitxersMultimedia (){
        super();
    }

    public void addFileToRepositori (File file)  throws ReproException{
        int temp = 0;
        boolean found = false;
        while(temp < super.getSize() && !found) {
            if (super.getAt(temp).equals(file)){
                found = true;
                throw new ReproException("El fitxer ja existeix");
            }
            temp++;
        }
        if(!found){
            try{
                super.addFitxer(file);
            } catch (ReproException e){
                throw e;
            }
        }

    }


    public void deleteFile (File file){
        super.removeFitxer(file);
    }

    public List<String> showRepositori(){
        return super.show();
    }

    public String toString(){
        return super.toString();
    }
}
