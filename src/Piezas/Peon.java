package Piezas;

import Tablero.Alianza;
import Tablero.Movimiento;
import Tablero.Tablero;
import Tablero.Utiles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Peon extends Pieza{
    private final static int[] CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO = {8};

    public Peon(int posPieza, Alianza aliPieza) {
        super(posPieza, aliPieza);
    }

    @Override
    public Collection<Movimiento> calcularMovimientosLegales(Tablero tablero) {
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO){
            int posicionDestinoCandidata = this.posPieza + (this.obtenerAlianzaPieza().obtenerDireccion() * candidatoActual);
            
            if(!Utiles.posAzulejoValido(posicionDestinoCandidata)){
                continue;
            }
            if(candidatoActual == 8 && !tablero.obtenerAzulejo(posicionDestinoCandidata).elAzulejoEstaOcupado()){
                //TODO Por hacer mas
                movimientosLegales.add(new Movimiento.MovimientoPrincipal(tablero, this,posicionDestinoCandidata));
            }
        }
        
        
        return movimientosLegales;
    }
    
}
