package implementacionAtm;

/**
 *
 * @author olive
 */
public class SolicitudSaldo extends Transaccion {
    
    // Constructor
    // le pasamos los mismos atributos que en la clase padre
    public SolicitudSaldo(int numeroCuentaUsuario, BaseDatosBanco baseDatosBancoATM){
        
        // usamos la sentencia super para indicar que los que vamos a inicializar son los de la clase padre 
        super(numeroCuentaUsuario, baseDatosBancoATM);
        
    }
    
    // metodos heredado que es abstracto 
    // al ser abstracto podemos suscribirlo e implementar una funcionalidad propia de solicitudSaldo
    @Override
    public void ejecutar(){
        // Crear referencias a la base de Datos usando el metodo que implementamos 
        BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
        
        // obtener el sado disponible de la cuenta indicada
        
        double saldoDisponible = baseDatosBanco.obtenerSaldoDisponible(obtenerNumeroCuenta());
        
        double saltoTotal = baseDatosBanco.obtenerSaldoTotal(obtenerNumeroCuenta());
        
        
        // mostrar en pantalla
        
        System.out.println("Saldos");
        System.out.println("Saldo Disponible");
        System.out.println(saldoDisponible);
        System.out.println("Saldo Total");
        System.out.println(saltoTotal);
    }
}
