package clasesATM;

/**
 *
 * @author oliver
 */
public class Deposito extends Transaccion {
    
    private double monto; // monto a depositar
    private Teclado teclado; // referencia al teclado
    private RanuraDeposito ranuraDeposito; // referencia a la ranura de depósito
    private final static int CANCELO = 0; // constante para la opción de cancelar
    
    // constructor de Deposito
    public Deposito(int noCuenta, Pantalla pantalla, BaseDatosBanco baseDatosBanco, Teclado teclado, RanuraDeposito ranuraDeposito){ 
        super( noCuenta, pantalla, baseDatosBanco);
        // inicializa las referencias al teclado y la ranura de depósito
        teclado = teclado;
        ranuraDeposito = ranuraDeposito;
    }// fin constructor 
    
    // realizar una transaccion
    @Override
    public void ejecutar() {
        BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco(); // obtiene la referencia a la base de datos
        Pantalla pantalla = obtenerPantalla(); // obtiene la referencia a la pantalla
        monto = pedirMontoADepositar(); // obtiene el monto a depositar del usuario
        // comprueba si el usuario introdujo un monto a depositar o canceló
        if ( monto != CANCELO ){
            // solicita un sobre de depósito que contenga el monto especificado
            pantalla.mostrarMensaje("nInserte un sobre que contenga");
            pantalla.mostrarMonto(monto);
            pantalla.mostrarLineaMensaje(".");
            
            // recibe el sobre de depósito
            
            boolean seRecibioSobre = ranuraDeposito.seRecibioSobre();
            
            // comprueba si se recibió el sobre de depósito
            
            if ( seRecibioSobre ){
                pantalla.mostrarLineaMensaje("Se recibio correctamente!");
                // hace un abono a la cuenta para reflejar el depósito
                baseDatosBanco.abonar( obtenerNumeroCuenta(), monto );
                
            }// fin if 02
            else{
                pantalla.mostrarLineaMensaje("No se inserto sobre");
            }// fin else
        }// fin if 01
        else{
            pantalla.mostrarLineaMensaje("pantalla.mostrarLineaMensaje");
            
        }// fin 
    }// fin ejecutar
    // Metodo para depositar
    
    private double pedirMontoADepositar(){
        Pantalla pantalla = new Pantalla();
        
        // mostrar el indicador 
        pantalla.mostrarMensaje("ingrese el monto en centavos");
        int entrada = teclado.obtenerEntrada(); // recibe la entrada por medio del scanner
        
        // filtro para recibir que el monto sea correcto
        if(entrada == CANCELO){
            return CANCELO;
        }else{
            return (double) entrada/100;
        }
    }// fin pedir monto depositar
    
}
