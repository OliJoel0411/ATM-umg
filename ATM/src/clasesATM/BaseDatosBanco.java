package clasesATM;

/**
 *
 * @author oliver
 */
public class BaseDatosBanco {
    
    private Cuenta cuenta[]; // arreglo de objetos cuentas, simulando un arreglo de cuenta
    
    // Constructor
    public BaseDatosBanco(){
        cuenta = new Cuenta[2];
        
        cuenta[0] = new Cuenta(12345,54321,1000.0,1000.0);
        cuenta[1] = new Cuenta(54321,12345,1000.0,2000.0);
        
        }// fin del constructor
    // obtiene el objeto Cuenta que contiene el número de cuenta especificado
    private Cuenta obtenerCuenta(int numeroCuenta){
        for(Cuenta cuentaActual: cuenta){
            // devuelve la cuenta actual si encuentra una coincidencia
            if ( cuentaActual.obtenerNumeroCuenta() == numeroCuenta ){
                return cuentaActual;
            }
                
        }
        return null; // si no se encontró una cuenta que coincida, devuelve null
    }// fin obtener cuentas
    // determina si el número de cuenta y el NIP especificados por el usuario coinciden
    public boolean autenticarUsuario( int numeroCuentaUsuario, int nipUsuario ){
        // trata de obtener la cuenta con el número de cuenta
        Cuenta cuentaUsuario = obtenerCuenta(numeroCuentaUsuario);
        // si la cuenta existe, devuelve el resultado del método validarNIP de Cuenta
        if ( cuentaUsuario != null ){
            return cuentaUsuario.validarNip( nipUsuario );
        }else{
            // no se encontró el número de cuenta, por lo que devuelve false
            return false;
        }// fin else
        
        // devuelve el saldo disponible de la Cuenta con el número de cuenta especificado
    }// fin autenticarUsuario
    public double obtenerSaldoDisponible( int numeroCuentaUsuario ){
            return obtenerCuenta( numeroCuentaUsuario ).obtenerSaldoDisponible();
        }// fin obtenerSaldoDisponible
    // devuelve el saldo total de la Cuenta con el número de cuenta especificado
    public double obtenerSaldoTotal( int numeroCuentaUsuario ){
        return obtenerCuenta( numeroCuentaUsuario ).obtenerSaldoTotal();
    }// fin obtenerSaldoTotal
    
    // abona un monto a la Cuenta a través del número de cuenta especificado
    public void abonar( int numeroCuentaUsuario, double monto ){
        obtenerCuenta( numeroCuentaUsuario ).abonar( monto );
    }// fin abonar
    
    // carga un monto a la Cuenta con el número de cuenta especificado
    public void cargar( int numeroCuentaUsuario, double monto ){
        obtenerCuenta( numeroCuentaUsuario ).cargar( monto );
    }// fin cargar
}
