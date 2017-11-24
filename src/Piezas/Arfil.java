
package Piezas;

import Tablero.Alianza;
import Tablero.Azulejo;
import Tablero.Movimiento;
import Tablero.Tablero;
import Tablero.Utiles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.carrot2.shaded.guava.common.collect.ImmutableList;

public class Arfil extends Pieza{
    
    public final static int[] CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO = {-9, -7, 7,9};

    public Arfil(int posPieza, Alianza aliPieza) {
        super(posPieza, aliPieza);
    }

    @Override
    public Collection<Movimiento> calcularMovimientosLegales(final Tablero tablero) {
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO){
            int posicionDestinoCandidata = this.posPieza;
            while(Utiles.posAzulejoValido(posicionDestinoCandidata)){                
                if(esPrimeraColumnaExcluida(posicionDestinoCandidata, candidatoActual) ||
                        esOctavaColumnaExcluida(posicionDestinoCandidata, candidatoActual)){
                    break;                    
                }                
                posicionDestinoCandidata += candidatoActual;
                if(Utiles.posAzulejoValido(posicionDestinoCandidata)){                    
                    final Azulejo azulejoDestinoCandidato = tablero.obtenerAzulejo(posicionDestinoCandidata);
                    if(!azulejoDestinoCandidato.elAzulejoEstaOcupado()){
                        movimientosLegales.add(new Movimiento.MovimientoPrincipal(tablero, this, posicionDestinoCandidata));                    
                    }else{
                        final Pieza piezaEnElDestino = azulejoDestinoCandidato.obtenerPieza();
                        final Alianza piezaAlianza = piezaEnElDestino.obtenerAlianzaPieza();                    
                        if(this.aliPieza != piezaAlianza){
                            movimientosLegales.add(new Movimiento.MovimientoAtaque(tablero, this,posicionDestinoCandidata, piezaEnElDestino));
                        }
                        break;//Para que no avance mas si encuentra una pieza
                    }                    
                }                
            }            
        }
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    private static boolean esPrimeraColumnaExcluida(final int posicionActual, final int candidatoActual){
        return Utiles.PRIMERA_COLUMNA[posicionActual] && (candidatoActual == -9 || candidatoActual == 7);
    }
    private static boolean esOctavaColumnaExcluida(final int posicionActual, final int candidatoActual){
        return Utiles.OCTAVA_COLUMNA[posicionActual] && (candidatoActual == -7 || candidatoActual == 9);
    }
    
}





























































