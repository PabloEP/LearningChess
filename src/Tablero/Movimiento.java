package Tablero;

import Piezas.Pieza;

public abstract class Movimiento {  
    
    final Tablero tablero;
    final Pieza piezaMovida;
    final int posicionDestino;
    
    private Movimiento(final Tablero tablero, 
            final Pieza piezaMovida, 
            final int posicionDestino){
        this.tablero = tablero;
        this.piezaMovida = piezaMovida;
        this.posicionDestino = posicionDestino;
    }
    
    public static final class MovimientoPrincipal extends Movimiento{
        public MovimientoPrincipal(final Tablero tablero, 
                final Pieza piezaMovida, 
                final int posicionDestino){
            super(tablero, piezaMovida, posicionDestino);
        }
    }
    
    public static final class MovimientoAtaque extends Movimiento {
        
        final Pieza piezaAtacada;
        
        public MovimientoAtaque(final Tablero tablero, 
                final Pieza piezaMovida,
                final int posicionDestino,
                final Pieza piezaAtacada){
            super(tablero, piezaMovida, posicionDestino);
            this.piezaAtacada = piezaAtacada;
        }
    }
}
























































