package Piezas;

import Tablero.Alianza;
import Tablero.Azulejo;
import Tablero.Movimiento;
import Tablero.Movimiento.MovimientoAtaque;
import Tablero.Movimiento.MovimientoPrincipal;
import Tablero.Tablero;
import Tablero.Utiles;
import java.util.ArrayList;
import java.util.List;
import org.carrot2.shaded.guava.common.collect.ImmutableList;

public class Caballero extends Pieza{
    
    private final static int[] POSIBLES_MOVIMIENTOS = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Caballero(int posPieza, Alianza aliPieza) {
        super(posPieza, aliPieza);
    }
    
    @Override
    public List<Movimiento> calcularMovimientosLegales(final Tablero tablero) {
        
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : POSIBLES_MOVIMIENTOS){
            final int posicionDestinoCandidata = this.posPieza + candidatoActual;            
            if(Utiles.posAzulejoValido(posicionDestinoCandidata)){                
                if(esPrimeraColumnaExcluida(this.posPieza, candidatoActual) ||
                        esSegundaColumnaExcluida(this.posPieza, candidatoActual) ||
                        esSetimaColumnaExcluida(this.posPieza, candidatoActual) ||
                        esOctavaColumnaExcluida(this.posPieza, candidatoActual)){
                    continue;
                }                
                final Azulejo azulejoDestinoCandidato = tablero.obtenerAzulejo(posicionDestinoCandidata);
                if(!azulejoDestinoCandidato.elAzulejoEstaOcupado()){
                    movimientosLegales.add(new MovimientoPrincipal(tablero, this, posicionDestinoCandidata));                    
                }else{
                    final Pieza piezaEnElDestino = azulejoDestinoCandidato.obtenerPieza();
                    final Alianza piezaAlianza = piezaEnElDestino.obtenerAlianzaPieza();                    
                    if(this.aliPieza != piezaAlianza){
                        movimientosLegales.add(new MovimientoAtaque(tablero, this,posicionDestinoCandidata, piezaEnElDestino));
                    }
                }
            }
        }
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    @Override
    public String toString(){
        return TipoPieza.CABALLERO.toString();
    }

    private static boolean esPrimeraColumnaExcluida(final int posicionActual, final int posicionCandidata){        
        return Utiles.PRIMERA_COLUMNA[posicionActual] && (posicionCandidata == -17 || 
                posicionCandidata == -10 || posicionCandidata == 6 || posicionActual == 15);
    }
    
    private static boolean esSegundaColumnaExcluida(final int posicionActual, int posicionCandidata){
        return Utiles.SEGUNDA_COLUMNA[posicionActual] && (posicionCandidata == -10 || posicionCandidata == 6);
    }
    private static boolean esSetimaColumnaExcluida(final int posicionActual, int posicionCandidata){
        return Utiles.SETIMA_COLUMNA[posicionActual] && (posicionCandidata == -6 || posicionActual == 10);
    }
    private static boolean esOctavaColumnaExcluida(final int posicionActual, int posicionCandidata){
        return Utiles.OCTAVA_COLUMNA[posicionActual] && (posicionCandidata == -15 || 
                posicionCandidata == -6 || posicionCandidata ==10 || posicionCandidata == 17);
    }
    
    
}
























































