package Piezas;

import Tablero.Alianza;
import Tablero.Movimiento;
import Tablero.Movimiento.MovimientoPrincipal;
import Tablero.Tablero;
import Tablero.Utiles;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.carrot2.shaded.guava.common.collect.ImmutableList;

public class Peon extends Pieza{
    private final static int[] CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO = {8, 16, 9, 7};

    public Peon(int posPieza,final Alianza aliPieza) {
        super(posPieza, aliPieza);
    }

    @Override
    public Collection<Movimiento> calcularMovimientosLegales(final Tablero tablero) {
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO){
            final int candidatoPosicionDestino = this.posPieza + (this.obtenerAlianzaPieza().obtenerDireccion() * candidatoActual);
            
            if(!Utiles.posAzulejoValido(candidatoPosicionDestino)){
                continue;
            }
            if(candidatoActual == 8 && !tablero.obtenerAzulejo(candidatoPosicionDestino).elAzulejoEstaOcupado()){
                //TODO Por hacer mas lidear con promociones
                movimientosLegales.add(new MovimientoPrincipal(tablero, this,candidatoPosicionDestino));
            }else if(candidatoActual == 16 && this.esPrimerMovimiento() && 
                    (Utiles.SEGUNDA_FILA[this.posPieza] && this.obtenerAlianzaPieza().esNegra()) || 
                    (Utiles.SETIMA_FILA[this.posPieza] && this.obtenerAlianzaPieza().esBlanca())){
                final int detrasDeLaPosicionDeDestinoCandidata = this.posPieza +(this.aliPieza.obtenerDireccion() * 8);
                if(!tablero.obtenerAzulejo(detrasDeLaPosicionDeDestinoCandidata).elAzulejoEstaOcupado() && 
                   !tablero.obtenerAzulejo(candidatoPosicionDestino).elAzulejoEstaOcupado()){
                    movimientosLegales.add(new MovimientoPrincipal(tablero, this, candidatoPosicionDestino));                    
                }                
            }else if(candidatoActual == 7 &&
                    !((Utiles.OCTAVA_COLUMNA[this.posPieza] && this.aliPieza.esBlanca()) ||
                    (Utiles.PRIMERA_COLUMNA[this.posPieza] && this.aliPieza.esNegra())) ){
                if(tablero.obtenerAzulejo(candidatoPosicionDestino).elAzulejoEstaOcupado()){
                    final Pieza piezaEnCandidato = tablero.obtenerAzulejo(candidatoPosicionDestino).obtenerPieza();
                    if(this.aliPieza != piezaEnCandidato.obtenerAlianzaPieza()){
                        //MAS POR HACER
                        movimientosLegales.add(new MovimientoPrincipal(tablero, this, candidatoPosicionDestino));
                    }
                }
                
            }else if(candidatoActual ==9 && 
                    !((Utiles.PRIMERA_COLUMNA[this.posPieza] && this.aliPieza.esBlanca()) ||
                    (Utiles.OCTAVA_COLUMNA[this.posPieza] && this.aliPieza.esNegra())) ){
                if(tablero.obtenerAzulejo(candidatoPosicionDestino).elAzulejoEstaOcupado()){
                    final Pieza piezaEnCandidato = tablero.obtenerAzulejo(candidatoPosicionDestino).obtenerPieza();
                    if(this.aliPieza != piezaEnCandidato.obtenerAlianzaPieza()){
                        //MAS POR HACER
                        movimientosLegales.add(new MovimientoPrincipal(tablero, this, candidatoPosicionDestino));
                    }
                }                
            }
        }
        
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    @Override
    public String toString(){
        return TipoPieza.PEON.toString();
    }
    
}
