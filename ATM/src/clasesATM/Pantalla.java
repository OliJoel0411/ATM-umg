package clasesATM;

/**
 *
 * @author oliver
 */
public class Pantalla {
      
    
    //Metodos
    
    public void mostrarMensaje(String mensaje){
        
        System.out.print(mensaje);
        
    }// fin monstrar mensaje
    
    public void mostrarLineaMensaje(String mensaje){
        
        System.out.println(mensaje);
        
    }// fin mostrarLineaMensaje
    
    public void mostrarMonto(double monto){
        
        System.out.printf("Q%,.2f", monto);
        
    }// fin mostrarMonto
    
}
