package clasesATM;

/**
 *
 * @author oliver
 */


public class Retiro extends Transaccion {// inicio clase
    
    // Atributos
    private int monto; // monto a retirar
    private Teclado teclado; // referencia al teclado
    private DispensadorEfectivo dispensadorEfectivo; // referencia al dispensador
    /*
    // Referencias a otras clases ha las que esta asociada
    // private Pantalla pantalla; // pantalla al ATM (Son heredados de la clase TRANSACCION)
    private Teclado teclado; // teclaso al ATM
    private DispensadorEfectivo dispensadorEfectivo; // dispensadorEfectivo al ATM
    // private BaseDatosBanco baseDatosBanco; // baseDatosBanco a cuentas (Son heredados de la clase TRANSACCION)
    
    */
    
    // constante que corresponde a la opción del menú a cancelar
    private final static int CANCELO = 6;
    
    
    // Constructor
    public Retiro(int noCuenta, Pantalla pantalla, BaseDatosBanco baseDatosBanco, Teclado teclado, DispensadorEfectivo dispensadorEfectivo){ 
    // inicializa las variables de la superclase
    super( noCuenta, pantalla, baseDatosBanco);
    
    // inicializa las referencias al teclado y al dispensador de efectivo
        teclado = teclado;
        dispensadorEfectivo = dispensadorEfectivo;
        
    }// fin constructor
   
    @Override
    public void ejecutar() {
       boolean efectivoDispensado = false; // no se ha dispensado aún el efectivo
       double saldoDisponible; // monto disponible para retirar
       
       // obtiene referencias a la base de datos del banco y la pantalla
       BaseDatosBanco baseDatosBanco = obtenerBaseDatosBanco();
       Pantalla pantalla = obtenerPantalla();
       
       // itera hasta que se dispense el efectivo o que cancele el usuario
       do{
           // obtiene un monto de retiro elegido por el usuario
           monto = mostrarMenuDeMontos();
           // comprueba si el usuario eligió un monto de retiro o si canceló
           if ( monto != CANCELO ){
               // obtiene el saldo disponible de la cuenta implicada
               saldoDisponible = baseDatosBanco.obtenerSaldoDisponible( obtenerNumeroCuenta() );
           
           // comprueba si el usuario tiene suficiente dinero en la cuenta
           if ( monto <= saldoDisponible ){
               // comprueba si el dispensador de efectivo tiene suficiente dinero
               if ( dispensadorEfectivo.haySuficienteEfectivoDisponible( monto ) ){
                   // actualiza la cuenta implicada para reflejar el saldo
                   baseDatosBanco.cargar( obtenerNumeroCuenta(), monto );
                   dispensadorEfectivo.dispensarEfectivo( monto ); // dispensar efectivo
                   efectivoDispensado = true; // se dispensó el efectivo
                   
                   // instruye al usuario que tome efectivo
                   pantalla.mostrarLineaMensaje("Tome su dinero...");
                   
               }// fin if 03
               else{
                   pantalla.mostrarLineaMensaje("No hay  suficiente efectivo ");
               }// fin else
           }// fin if 02
           else{
               pantalla.mostrarLineaMensaje("No hay fondos en su cuenta ");
           }
               }// fin if 01
           else{
               pantalla.mostrarLineaMensaje("Cancelando transaccion ");
           }
       }while(!efectivoDispensado);
       
    }// fin ejectuar
    
    // muestra un menú de montos de retiro y la opción para cancelar;
    // devuelve el monto elegido o 0 si el usuario elije cancelar
    
    private int mostrarMenuDeMontos(){
        int opcionUsuario = 0; // variable local para almacenar el valor de retorno
        
        Pantalla pantalla = obtenerPantalla(); // obtiene referencia a la pantalla
        
        // arreglo de montos que corresponde a los números del menú
        
        int montos[] = { 0, 20, 40, 60, 100, 200 };
        
        // itera mientras no se haya elegido una opción válida
        
        while ( opcionUsuario == 0 ){
            // muestra el menú
            pantalla.mostrarLineaMensaje("Menu Retiro");
            pantalla.mostrarLineaMensaje("1.- UM 20");
            pantalla.mostrarLineaMensaje("2.- UM 40");
            pantalla.mostrarLineaMensaje("3.- UM 60");
            pantalla.mostrarLineaMensaje("4.- UM 100");
            pantalla.mostrarLineaMensaje("5.- UM 200");
            pantalla.mostrarLineaMensaje("6.- cancelar");
            pantalla.mostrarMensaje("Seleccione un monta a retirar");
            
            int entrada = teclado.obtenerEntrada(); // obtiene la entrada del usuario
            
            // determina cómo proceder con base en el valor de la entrada
            switch ( entrada ){
                case 1: // si el usuario eligió un monto de retiro
                case 2: // (es decir, si eligió la opción 1, 2, 3, 4 o 5), devolver
                case 3: // el monto correspondiente del arreglo montos
                case 4:
                case 5:
                    opcionUsuario = montos[ entrada ]; // guarda la elección del usuario
                    break;
                    case CANCELO: // el usuario eligió cancelar
                        opcionUsuario = CANCELO; // guarda la elección del usuario
                        break;
                    default: // el usuario no introdujo un valor del 1 al 6
                        pantalla.mostrarLineaMensaje("nSeleccion invalida. Intente de nuevo");
                           
            }// fin switch
        }// fin while
            return opcionUsuario; // devuelve el monto de retiro o CANCELO
    }// fin mostrarMenuMontos 
    
}// fin clase
