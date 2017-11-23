package Elementos;

public abstract class Azulejo {
    int posAzulejo;
    
    Azulejo(int posAzulejo){
        this.posAzulejo = posAzulejo;
    }    
    //Para los metodos abstractos
    public abstract boolean estaOcupada();    
    public abstract Pieza obtenerPieza();    
    
    //Para cuando el azulejo está vacio
    public static final class AzulejoVacio extends Azulejo{
        //Crea el azulejo sin pieza
        AzulejoVacio(int posicion){
            super(posicion);
        }        
        //Retorna que la posicion no está ocupada
        @Override
        public boolean estaOcupada() {
            return false;
        }        
        //Retorna que no hay ninguna pieza
        @Override
        public Pieza obtenerPieza() {
            return null;
        }
    }
    
    //Para cuando el azulejo está con una pieza encima
    public static final class AzulejoOcupado extends Azulejo {
        Pieza piezaEnAzulejo;        
        //Crea el azulejo con una pieza encima
        AzulejoOcupado(int posAzulejo, Pieza piezaEnAzulejo){
            super(posAzulejo);
            this.piezaEnAzulejo = piezaEnAzulejo;
        }        
        //Retorna que la posicion está ocupada
        @Override
        public boolean estaOcupada() {
            return true;
        }        
        //Retorna que la pieza que tiene encima
        @Override
        public Pieza obtenerPieza() {
            return this.piezaEnAzulejo;
        }
    }
}
