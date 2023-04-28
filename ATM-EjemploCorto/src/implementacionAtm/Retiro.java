package implementacionAtm;

/**
 *
 * @author olive
 */
public class Retiro extends Transaccion {
    
    private double monto;
    
    public Retiro(int numeroCuentaUsuario,BaseDatosBanco baseDatosBancoATM  ){
     super( numeroCuentaUsuario, baseDatosBancoATM );   
    }
    
    // metodos
    @Override
     public void ejecutar(){
        System.out.println("Se retiro dinero");
    }
}
