package clasesATM;

/**
 *
 * @author oliver
 */

    // REPRESENTE AL CAJERO AUTOMATICO
public class ATM {
    
    //Atributos
    private boolean usuarioAutenticado; // respuesta a la autenticacion del usuario
    private int noCuentaActual; // numero ingresado
    private Pantalla pantalla; // referencia a la clase asociada
    private Teclado teclado; // referencia a la clase asociada
    private DispensadorEfectivo dispensadorEfectivo; // referencia a la clase asociada
    private RanuraDeposito ranuraDeposito; // referencia a la clase asociada
    private BaseDatosBanco baseDatosBanco; // referencia a la clase asociada
    
    
    // Constantes correspondientes a las opciones principales
    public static final int SOLICITUD_SALDO = 1;
    public static final int RETIRO = 2;
    public static final int DEPOSITO = 3;
    public static final int SALIR = 4;
            
    // Constructor
    public ATM(){
    // inicializar variables de instancia
    
    usuarioAutenticado = true; // False, cuando el usuario no esta autenticado
    noCuentaActual = 12345; // no hay numero de cuenta, cuando inicia el ATM
    pantalla = new Pantalla(); 
    teclado = new Teclado();
    dispensadorEfectivo = new DispensadorEfectivo();
    ranuraDeposito = new RanuraDeposito();
    baseDatosBanco = new BaseDatosBanco();
    
    
    } // fin constructor
    
    // metodo para iniciar el ATM
    
    public void run(){
        
        // Da la Bienvenida al Usuario y lo Autentica; realiza transacciones
        
        while(true){ // while 01
            // itera mientras el usuario no haya sido autenticado
            while(!usuarioAutenticado){ // while 02
                
                pantalla.mostrarMensaje("Bienvenido");
                pantalla.mostrarMensaje(" ");// un espacio vacio
                
            }// fin while 02
            realizarTransacciones(); // ahora el usuario está autenticado
            usuarioAutenticado = false; // restablece antes de la siguiente sesión con ATM
            noCuentaActual = 0; // restablece antes de la siguiente sesión con el ATM
            
            pantalla.mostrarMensaje("Adios...");
            
        }// fin while 01
        
        } // fin run

        // trata de autenticar al usuario en la base de datos
        private void autenticarUsuario(){
                pantalla.mostrarMensaje("Escriba su numero de cuenta");
                int numeroCuenta = teclado.obtenerEntrada(); // recibe como entrada el número cuenta
                
                pantalla.mostrarMensaje("Escriba su NIP");
                int nip = teclado.obtenerEntrada(); // recibe como entrada el NIP
                // establece usuarioAutenticado con el valor booleano devuelto por la base de datos
                usuarioAutenticado = baseDatosBanco.autenticarUsuario( numeroCuenta, nip );
                // verifica si la autenticación tuvo éxito
                if ( usuarioAutenticado ){
                    noCuentaActual = numeroCuenta; // guarda el # de cuenta del usuario
                }// fin if 01
                else{
                    pantalla.mostrarLineaMensaje("Invalido NIP");
                }// fin else
        }// fin autenticarUsuario
        // muestra el menú principal y realiza transacciones
        private void realizarTransacciones(){
            // variable local para almacenar la transacción que se procesa actualmente
            Transaccion transaccionActual = null;
            boolean usuarioSalio = false; // el usuario no ha elegido salir
            // itera mientras que el usuario no haya elegido la opción para salir del sistema
            while ( !usuarioSalio ){
                // muestra el menú principal y obtiene la selección del usuario
                int seleccionMenuPrincipal = mostrarMenuPrincipal();
                // decide cómo proceder, con base en la opción del menú seleccionada por el usuario
                switch ( seleccionMenuPrincipal ){
                    // el usuario eligió realizar uno de tres tipos de transacciones
                    case SOLICITUD_SALDO:
                    case RETIRO:
                    case DEPOSITO:
                                
                        // inicializa como nuevo objeto del tipo elegido
                        transaccionActual = crearTransaccion( seleccionMenuPrincipal );
                        transaccionActual.ejecutar(); // ejecuta la transacción
                        break;
                        
                    case SALIR: // el usuario eligió terminar la sesión
                        pantalla.mostrarLineaMensaje("Cerrando sistema...");
                        usuarioSalio = true; // esta sesión con el ATM debe terminar
                        break;
                    default: // el usuario no introdujo un entero de 1 a 4
                        pantalla.mostrarMensaje("Opcion no valida, intente de nuevo");
                        break;
                            
                }// fin switch
            }// fin while
        }// fin realizarTransacciones
        
        private int mostrarMenuPrincipal(){
            pantalla.mostrarMensaje("Menu principal");
            pantalla.mostrarLineaMensaje("1.- Ver saldo");
            pantalla.mostrarLineaMensaje("2.- Retirar efectivo");
            pantalla.mostrarLineaMensaje("3.- Depositar fondos");
            pantalla.mostrarLineaMensaje("4.- Salir\n");
            pantalla.mostrarLineaMensaje("Digite una opcion");
            return teclado.obtenerEntrada(); // devuelve la opcion seleccionada por el usuario
        }// fin mostrarMenuPrincipal
        
        // devuelve un objeto de la subclase especificada de Transaccion
        private Transaccion crearTransaccion( int tipo ){
            Transaccion temp = null; // variable temporal Transaccion
            // determina qué tipo de Transaccion crear
            switch ( tipo ){
                case SOLICITUD_SALDO: // crea una nueva transacción SolicitudSaldo
                    temp = new SolicitudSaldo(noCuentaActual, pantalla, baseDatosBanco);
                    break;
                case RETIRO: // crea una nueva transacción Retiro
                    temp = new Retiro(noCuentaActual, pantalla,baseDatosBanco, teclado, dispensadorEfectivo);
                    break;
                case DEPOSITO: // crea una nueva transacción Deposito
                    temp = new Deposito(noCuentaActual, pantalla,baseDatosBanco, teclado, ranuraDeposito);
                    break;
                    
            }// fin switch
            return temp;
        }// fin crearTransaccion
    
}
