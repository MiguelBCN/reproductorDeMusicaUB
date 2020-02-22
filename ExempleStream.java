import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExempleStream {
    /*Un tipus molt utilitzat en l’entrada/sortida de Java són els Streams. Un Stream és un
    flux de dades. Segons si volem llegir informació d’un Stream, o afegir informació a un
    Stream, parlarem d’Stream d’entrada (InputStream) o Stream de sortida (OutputStream). */
    public static void main(String[] args) {
// En Windows
        File fitxer = new File("C://Users/MiguelDesktop/Documents/yourLieInApril.txt");
// En Linux
        //File fitxer = new File("~/Reproductor/BibliotecaMusical.txt ");
// Obrir un Stream d’entrada des del fitxer
        FileInputStream fin = new FileInputStream(fitxer);
// Obrir un Stream de sortida cap al fitxer
        FileOutputStream fout = new FileOutputStream(fitxer);
    }
}
