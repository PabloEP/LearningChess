/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import Piezas.Pieza;
import Tablero.Movimiento;
import Tablero.Tablero;
import java.util.Collection;

public class JugadorNegro extends Jugador{
    public JugadorNegro(Tablero tablero, 
            Collection<Movimiento> blancasMovimientosLegalesEstandar, 
            Collection<Movimiento> negrasMovimientosLegalesEstandar){
        
        super(tablero, negrasMovimientosLegalesEstandar, blancasMovimientosLegalesEstandar);
        
    }
    @Override
    public Collection<Pieza> obtenerPiezasActivas(){
        return this.tablero.obtenerPiezasNegras();
    }
    
}
