package clasesATM;

/**
 *
 * @author oliver
 */
public class DispensadorEfectivo {
    
    private final static int CUENTA_INICIAL = 500;
    private int cuenta; // restante de billetes
    
    // Contructor
    
    public DispensadorEfectivo(){
        cuenta = CUENTA_INICIAL;
    } // fin DispensadorEfectivo
    
    // Metodo para entregar dinero (simulado)
    
    public void dispensarEfectivo(int monto){
        int billetesRequeridos = monto/20; // solo cantidades de 20 unidades monetarias
        cuenta -= billetesRequeridos; // Acualiza el saldo del ATM
        
    } // fin dispensarEfectivo
    
    public boolean haySuficienteEfectivoDisponible(int monto){
        int billetesRequeridos = monto/20; // numero de billetes requeridos
        if(cuenta >= billetesRequeridos){
            return true; // hay suficientes billetes disponibles
        }else{
            return false; // no hay suficientes billetes disponibles
        }
    }
    
    
}
