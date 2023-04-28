package implementacionAtm;

import java.util.Scanner;

/**
 *
 * @author olive
 */
public class ATM {
    // Atributo
    private boolean usuarioAutenticado;
    // necestiamos un numero de cuenta actual
    private int numeroCuentaActual;
    // necesitamos una referencia a la base de Datos
    private BaseDatosBanco baseDatosBanco; // nos proporciona la informacion de las cuentas
    Scanner tc = new Scanner(System.in);
    
    // Constructor para inicializar 
    public ATM(){
        usuarioAutenticado = false;
        numeroCuentaActual = 0;
        baseDatosBanco = new BaseDatosBanco(); // desde que crea un ATM crea una base de datos
        
    }
    
    public void encender(){
        // necesitamos autenticar al usuario
        // necesitamos que se repita lo necesario
        while(!usuarioAutenticado){
            System.out.println("Bienvenido");
            autenticarUsuario();
        }
        realizarTransaccion();
        usuarioAutenticado = false;
        numeroCuentaActual = 0;
    }// fin encender
    
    public void autenticarUsuario(){
        
        System.out.println("Escriba su numero de cuenta");
        int numeroCuenta = tc.nextInt();
        System.out.println("Escriba su Nip");
        int nip = tc.nextInt();
        
        usuarioAutenticado = baseDatosBanco.autenticarUsuario( numeroCuenta, nip );
    
        if(usuarioAutenticado)
            numeroCuentaActual = numeroCuenta;
        else
            System.out.println("Numero de cuenta o Nip Invalido");
    }// fin autenticarUsuario
    
    public void realizarTransaccion(){
        // Uso de polimorfismo
        Transaccion transaccionActual = null;
        
        boolean usuarioSalio = false; // cuando el usuario elija salir sera true
        
        while(!usuarioSalio){
            int seleccionMenuPrincipal = mostrarMenuPrincipal();
            switch(seleccionMenuPrincipal){
                case 1:
                    
                case 2:
                    
                case 3:
                    transaccionActual = crearTransaccion( seleccionMenuPrincipal );
                    transaccionActual.ejecutar();
                case 4:
                    usuarioSalio = true;
                    break;
            }
        }
        
    }// fin realizarTransaccion
    
    public int mostrarMenuPrincipal() {
        System.out.println("Menu principal");
        System.out.println("1. ver saldo");
        System.out.println("2. retirar");
        System.out.println("3. depositar");
        System.out.println("4. salir");
        System.out.println("Escriba una opcion");
        int opc = tc.nextInt();
        return opc;
    }// fin menu principal 
    
    // Polimorfismo
    
    private Transaccion crearTransaccion(int tipo){
        Transaccion trans =  null;
        
        switch(tipo){
            case 1:
                // Polimorfismo
                trans = new SolicitudSaldo(numeroCuentaActual, baseDatosBanco );
                break;
            case 2:
                // Polimorfismo
                trans = new Retiro(numeroCuentaActual, baseDatosBanco);
                
                break;
                //trans = new Deposito(numeroCuentaActual, baseDatosBanco);
            case 3:
                break;
                    
        }
        return trans; // tiene que tener el mismo tipo de retorno
    }
    
    
    
    
}
