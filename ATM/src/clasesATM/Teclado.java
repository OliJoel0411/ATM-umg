package clasesATM;
import java.util.Scanner;
/**
 *
 * @author oliver
 */
public class Teclado {
    private Scanner tc; // objeto para recibir entrada por medio del teclado de la computadora
    
    // Constructor
    
    public Teclado(){
        tc = new Scanner(System.in);
    } // fin constructor
    
    public int obtenerEntrada(){
        return tc.nextInt();
    }
    
}
