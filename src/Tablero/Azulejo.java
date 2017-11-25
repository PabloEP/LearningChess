package Tablero;

import Piezas.Pieza;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.carrot2.shaded.guava.common.collect.ImmutableMap;


public abstract class Azulejo {
    protected final int posAzulejo;
    private static final Map<Integer, AzulejoVacio> AZULEJOS_VACIOS_ARRAY = crearTodosLosAzulejosPosibles();
    
    
    //Contructor
    private Azulejo(final int posAzulejo){
        this.posAzulejo = posAzulejo;
    } 
    
    //Para los metodos abstractos
    public abstract boolean elAzulejoEstaOcupado();    
    public abstract Pieza obtenerPieza();

    //Creador del mapa de posiciones
    private static Map<Integer, AzulejoVacio> crearTodosLosAzulejosPosibles() {
        final Map<Integer, AzulejoVacio> mapaAzulejosVacios = new HashMap<>();
        for(int i = 0; i < Utiles.NUM_AZULEJO; i++){
            mapaAzulejosVacios.put(i,new AzulejoVacio(i));
        }
        
        
        return ImmutableMap.copyOf(mapaAzulejosVacios);
    }
    //Devuelve nulo si esta vacia la poscion o pone una pieza en esa poscicion
    public static Azulejo crearAzulejos(final int posAzulejo, final Pieza pieza){
        return pieza != null ? new AzulejoOcupado(posAzulejo, pieza): AZULEJOS_VACIOS_ARRAY.get(posAzulejo);
    }
    
    
    //Construtores
    
    //Para cuando el azulejo está vacio
    public static final class AzulejoVacio extends Azulejo{
        //Crea el azulejo sin pieza
        AzulejoVacio(final int posicion){
            super(posicion);
        }
        @Override
        public String toString(){
            return "-";
        }
        //Retorna que la posicion no está ocupada
        @Override
        public boolean elAzulejoEstaOcupado() {
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
        private final Pieza piezaEnAzulejo;        
        //Crea el azulejo con una pieza encima
        AzulejoOcupado(final int posAzulejo,final Pieza piezaEnAzulejo){
            super(posAzulejo);
            this.piezaEnAzulejo = piezaEnAzulejo;
        }  
        
        @Override
        public String toString(){
            return obtenerPieza().obtenerAlianzaPieza().esBlanca() ? obtenerPieza().toString().toLowerCase() :
                   obtenerPieza().toString();
        }
        //Retorna que la posicion está ocupada
        @Override
        public boolean elAzulejoEstaOcupado() {
            return true;
        }        
        //Retorna que la pieza que tiene encima
        @Override
        public Pieza obtenerPieza() {
            return this.piezaEnAzulejo;
        }
    }
}




















































