package clasesATM;

/**
 *
 * @author oliver
 */
public abstract class Transaccion {
    
    // Atributos
    private int noCuenta;
    private Pantalla pantalla; // Referencia a la clase pantalla
    private BaseDatosBanco baseDatosBanco;
    
    public Transaccion(int noCuenta, Pantalla pantalla, BaseDatosBanco baseDatosBanco){
        this.noCuenta = noCuenta;
        this.pantalla = pantalla;
        this.baseDatosBanco = baseDatosBanco;
    }// fin contructor
    
    // devuelve el número de cuenta
    public int obtenerNumeroCuenta(){
        return this.noCuenta;
    }// fin obtenerNumeroCuenta
    
    // devuelve una referencia a la pantalla
    public Pantalla obtenerPantalla(){
        return pantalla;
    }
    
    // devuelve una referencia a la base de datos del banco
    public BaseDatosBanco obtenerBaseDatosBanco(){
        return baseDatosBanco;
    }// fin obtenerBaseDatosBanco
    
    // realiza la transacción (cada subclase sobrescribe este método)
    abstract public void ejecutar();
    
}
