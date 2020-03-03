import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExempleStream {
    /*Un tipus molt utilitzat en l’entrada/sortida de Java són els Streams. Un Stream és un
    flux de dades. Segons si volem llegir informació d’un Stream, o afegir informació a un
    Stream, parlarem d’Stream d’entrada (InputStream) o Stream de sortida (OutputStream). */
    public static void main(String[] args) {
// Obtener ruta y guardr en un objeto file
        File fitxer = new File("C://Users//migue//Documents//yourLieInApril.txt");
        //Acceso I/O
        /*FileInputStream fin=new FileInputStream(fitxer);
        FileOutputStream fout= new FileOutputStream(fitxer);
        //Gestion
        ObjectOutputStream oos = new ObjectOutputStream(fout);
        ObjectInputStream ois = new ObjectInputStream(fin);*/
        /*try (FileInputStream fis = new FileInputStream(fitxer)) {

            System.out.println("Total file size to read (in bytes) : "+ fis.available());

            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
