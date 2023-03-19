package clasesATM;

/**
 *
 * @author oliver
 */
public class SolicitudSaldo extends Transaccion {

    
    // constructor de SolicitudSaldo
    public SolicitudSaldo(int noCuenta, Pantalla pantalla, BaseDatosBanco baseDatosBanco)
    {
        // haciendo referencia a la clase super, se incializa el constructor
        super( noCuenta, pantalla, baseDatosBanco);
    }// fin contructor
    
    
    
    
    
    @Override
    public void ejecutar() {
       // obtiene referencias a la base de datos del banco y la pantalla
       BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
       Pantalla pantalla = obtenerPantalla();
       
       // obtiene el saldo disponible para la cuenta implicada
       
       double saldoDisponible = baseDatosBanco.obtenerSaldoDisponible( obtenerNumeroCuenta() );
       
       // obtiene el saldo total para la cuenta implicada
       double saldoTotal = baseDatosBanco.obtenerSaldoTotal( obtenerNumeroCuenta() );
       
       // muestra la información del saldo en la pantalla
       pantalla.mostrarLineaMensaje(" ");
       pantalla.mostrarMensaje(" ");
       pantalla.mostrarMonto(saldoDisponible);
       pantalla.mostrarMensaje("");
       pantalla.mostrarMonto(saldoTotal);
       pantalla.mostrarLineaMensaje("");
    }// fin metodo ejecutar
    
}
