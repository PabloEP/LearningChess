/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

public class Rey extends Pieza{
    
    private final static int[] CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO = {-9, -8, -7, -1, 1, 7, 8, 9};

    public Rey(int posPieza, Alianza aliPieza) {
        super(posPieza, aliPieza);
    }

    @Override
    public Collection<Movimiento> calcularMovimientosLegales(final Tablero tablero) {
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        
        for(final int candidatoActual : CORDENADAS_CANDIDATO_VECTOR_MOVIMIENTO){
            final int candidatoPosicionDestino = this.posPieza + candidatoActual;
            if(esPrimeraColumnaExcluida(this.posPieza, candidatoActual) || 
               esOctavaColumnaExcluida(this.posPieza, candidatoActual)){
                continue;
            }
            
            if(Utiles.posAzulejoValido(candidatoPosicionDestino)){
                final Azulejo azulejoDestinoCandidato = tablero.obtenerAzulejo(candidatoPosicionDestino);
                if(!azulejoDestinoCandidato.elAzulejoEstaOcupado()){
                    movimientosLegales.add(new Movimiento.MovimientoPrincipal(tablero, this, candidatoPosicionDestino));                    
                }else{
                    final Pieza piezaEnElDestino = azulejoDestinoCandidato.obtenerPieza();
                    final Alianza piezaAlianza = piezaEnElDestino.obtenerAlianzaPieza();                    
                    if(this.aliPieza != piezaAlianza){
                        movimientosLegales.add(new Movimiento.MovimientoAtaque(tablero, this,candidatoPosicionDestino, piezaEnElDestino));
                    }
                }
                
            }
            
        }
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    @Override
    public String toString(){
        return TipoPieza.REY.toString();
    }
    
     private static boolean esPrimeraColumnaExcluida(final int posicionActual, final int posicionCandidata){        
        return Utiles.PRIMERA_COLUMNA[posicionActual] && (posicionCandidata == -9 || 
                                                          posicionCandidata == -1 || 
                                                          posicionCandidata == 7);
    }
    
    private static boolean esOctavaColumnaExcluida(final int posicionActual, int posicionCandidata){
        return Utiles.OCTAVA_COLUMNA[posicionActual] && (posicionCandidata == -7 || 
                                                         posicionCandidata == 1  ||
                                                         posicionCandidata == 9);
    }
    
}
