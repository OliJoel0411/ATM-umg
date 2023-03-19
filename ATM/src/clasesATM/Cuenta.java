package clasesATM;

/**
 *
 * @author oliver
 */
public class Cuenta {
    private int numeroCuenta;
    private int nip;
    private double saldoDisponible;
    private double saldoTotal;
    
    // Constructor

    public Cuenta(int numeroCuenta, int nip, double saldoDisponible, double saldoTotal) {
        this.numeroCuenta = numeroCuenta;
        this.nip = nip;
        this.saldoDisponible = saldoDisponible;
        this.saldoTotal = saldoTotal;
    }// fin constructor
    
    // metodo para validar Nip
    public boolean validarNip(int nipUsuario){
        if(nipUsuario == this.nip){
            return true;
        }else{
            return false;
        }
    }// Fin validarNip; // se recibió el sobre
    
    // metodo para devolver el saldo disponible
    public double obtenerSaldoDisponible(){
        return saldoDisponible;
    }// fin obtenerSaldoDisponible
    
    // metodo para devolver el saldo total
    public double obtenerSaldoTotal(){
        return saldoTotal;
    }// fin obtenerSaldoTotal
    
    // metodo para abonar a cuenta
    public void abonar( double monto ){
        saldoTotal += monto;
    }
    
    // metodo para cargar monto a la cuenta
    public void cargar( double monto ){
        saldoDisponible -= monto; // lo resta del saldo disponible
        saldoTotal -= monto; // lo resta del saldo total
    }// fin cargar
    
    
    // Metodo para devolver el numero de cuenta
    public int obtenerNumeroCuenta(){
        return numeroCuenta;
    }
}
