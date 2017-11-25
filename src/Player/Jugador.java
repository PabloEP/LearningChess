package Player;

import Piezas.Pieza;
import Piezas.Rey;
import Tablero.Movimiento;
import Tablero.Tablero;
import java.util.Collection;

public abstract class Jugador {
    protected final Tablero tablero;
    protected final Rey playerRey;
    protected final Collection<Movimiento> movimientoslegales;
    
    Jugador(final Tablero tablero,
            final Collection<Movimiento> movimientosLegales,
            final Collection<Movimiento> movimientosEnemigos){
        
        this.tablero = tablero;
        this.playerRey = establecerRey();
        this.movimientoslegales = movimientosLegales;
    }

    private Rey establecerRey() {
        for(final Pieza pieza : obtenerPiezasActivas()){
            if(pieza.obtenerTipoPieza().esRey()){
                return (Rey) pieza;
            }
        }
        
        return null;
    }
    
    public abstract Collection<Pieza> obtenerPiezasActivas();
}
