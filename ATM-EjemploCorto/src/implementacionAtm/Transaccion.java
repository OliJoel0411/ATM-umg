package implementacionAtm;

/**
 *
 * @author olive
 */
public abstract class Transaccion {
    
    // Como los atributos son privados usaremos los Get para que sean heredados de las subclases
    
    
    private int numeroCuenta;
    private BaseDatosBanco baseDatosBanco;// requiere acceso a las cuentas que esta asociada
    
// constructor
    // la instancia super se usara unicamente en las subclases

public Transaccion(int numeroCuenta, BaseDatosBanco baseDatosBancoATM){
    this.numeroCuenta = numeroCuenta;
    baseDatosBanco = baseDatosBancoATM;
}    // fin constructor

// metodos

    public int obtenerNumeroCuenta() {
        return numeroCuenta;
    }
    // necestiamos una referencia a la base de datos
    public BaseDatosBanco obtenerBaseDatosBanco(){
        return baseDatosBanco;
    }
    
    // Los metedos abstractos son porque no se pueden crear instancias de las clases abstractas
    // esto obliga a las subclases a heredarlos y sobreescribirlos para implementarlos. 
    abstract public  void ejecutar();
        
    
}
