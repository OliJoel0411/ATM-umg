package implementacionAtm;

/**
 *
 * @author olive
 */
public class Deposito extends Transaccion {
    
    public Deposito(int numeroCuentaUsuario,BaseDatosBanco baseDatosBancoATM  ){
     super( numeroCuentaUsuario, baseDatosBancoATM );   
    }
    
    @Override
    public void ejecutar() {
        System.out.println("Se deposito ");
    }
    
}
