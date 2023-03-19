package clasesATM;

/**
 *
 * @author oliver
 */


public class Retiro extends Transaccion {// inicio clase
    
    
    // Referencias a otras clases ha las que esta asociada
   // private Pantalla pantalla; // pantalla al ATM (Son heredados de la clase TRANSACCION)
    private Teclado teclado; // teclaso al ATM
    private DispensadorEfectivo dispensadorEfectivo; // dispensadorEfectivo al ATM
   // private BaseDatosBanco baseDatosBanco; // baseDatosBanco a cuentas (Son heredados de la clase TRANSACCION)
    
    
    // Atributos
   // private int noCuenta; //  cuenta de la que se retirara el dinero private Pantalla pantalla;
      private double monto; // monto a retirar
    
    
    // Constructor
    public Retiro(){ }
    
    
    // Metodos
    public void ejecutat(){}
    
}// fin clase
