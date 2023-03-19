package clasesATM;

/**
 *
 * @author oliver
 */

    // REPRESENTE AL CAJERO AUTOMATICO
public class ATM {
    
    //Atributos
    private boolean usuarioAutenticado; // respuesta a la autenticacion del usuario
    private int noCuentaActual; // numero ingresado
    private Pantalla pantalla; // referencia a la clase asociada
    private Teclado teclado; // referencia a la clase asociada
    private DispensadorEfectivo dispensadorEfectivo; // referencia a la clase asociada
    private RanuraDeposito ranueraDeposito; // referencia a la clase asociada
    private BaseDatosBanco baseDatosBanco; // referencia a la clase asociada
    
    
    // Constantes correspondientes a las opciones principales
    public static final int SOLICITUD_SALDO = 1;
    public static final int RETIRO = 2;
    public static final int DEPOSITO = 3;
    public static final int SALIR = 4;
            
    // Constructor
    public ATM(){
    // inicializar variables de instancia
    
    usuarioAutenticado = false; // False, cuando el usuario no esta autenticado
    noCuentaActual = 0; // no hay numero de cuenta, cuando inicia el ATM
    pantalla = new Pantalla(); 
    teclado = new Teclado();
    dispensadorEfectivo = new DispensadorEfectivo();
    ranueraDeposito = new RanuraDeposito();
    baseDatosBanco = new BaseDatosBanco();
    
    
    } // fin constructor
    
    // metodo para iniciar el ATM
    
    public void run(){
        
        // Da la Bienvenida al Usuario y lo Autentica; realiza transacciones
        
        while(true){ // while 01
            // itera mientras el usuario no haya sido autenticado
            while(!usuarioAutenticado){ // while 02
                
                pantalla.mostrarMensaje("Bienvenido");
                pantalla.mostrarMensaje(" ");// un espacio vacio
                
            }// fin while 02
            
        }// fin while 01
        
    } // fin run
    
    
    
    
    
    
}
