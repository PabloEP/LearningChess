package Piezas;

import Tablero.Alianza;
import Tablero.Movimiento;
import Tablero.Tablero;
import java.util.Collection;

public abstract class Pieza {
    protected final int posPieza;
    protected final Alianza aliPieza;
    
    Pieza(final int posPieza, final Alianza aliPieza){
        this.aliPieza = aliPieza;
        this.posPieza = posPieza;
    }
    
    public Alianza obtenerAlianzaPieza(){
        return this.aliPieza;
    }
    
    public abstract Collection<Movimiento> calcularMovimientosLegales(final Tablero tablero);
    
    
}





































