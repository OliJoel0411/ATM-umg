package clasesATM;

/**
 *
 * @author oliver
 */
public abstract class Transaccion {
    
    // Atributos
    int noCuenta;
    private Pantalla pantalla; // Referencia a la clase pantalla
    private BaseDatosBanco baseDatosBanco;
    
    public void ejecutar(){}
}
