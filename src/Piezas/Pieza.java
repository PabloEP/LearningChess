package Piezas;

import Tablero.Alianza;
import Tablero.Movimiento;
import Tablero.Tablero;
import java.util.Collection;

public abstract class Pieza {
    protected final int posPieza;
    protected final Alianza aliPieza;
    //Por hacer mas
    protected boolean esPrimerMovimiento;
    
    Pieza(final int posPieza, final Alianza aliPieza){
        this.aliPieza = aliPieza;
        this.posPieza = posPieza;
        this.esPrimerMovimiento = false;
    }
    
    public int obtenerPosicionPieza(){
        return this.posPieza;
    }
    
    public Alianza obtenerAlianzaPieza(){
        return this.aliPieza;
    }
    public boolean esPrimerMovimiento(){
        return this.esPrimerMovimiento;
    }
    
    public abstract Collection<Movimiento> calcularMovimientosLegales(final Tablero tablero);
    
    public enum TipoPieza{
        PEON("P"),
        CABALLERO("C"),
        ARFIL("A"),
        TORRE("T"),
        REINA("R"),
        REY("K");
        
        private String nombrePieza;
        TipoPieza(final String nombrePieza){
            this.nombrePieza = nombrePieza;
        }
        @Override
        public String toString(){
            return this.nombrePieza;
        }
        
        
    }
    
}





































