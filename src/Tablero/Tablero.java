package Tablero;

import Player.JugadorBlanco;
import Piezas.Peon;
import Piezas.Arfil;
import Piezas.Caballero;
import Piezas.Reina;
import Piezas.Rey;
import Piezas.Torre;
import Piezas.Pieza;
import Player.JugadorNegro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.carrot2.shaded.guava.common.collect.ImmutableList;

public class Tablero {
    
    private final List<Azulejo> tableroJuego;
    private final Collection<Pieza> piezasBlancas;
    private final Collection<Pieza> piezasNegras;
    
    //private final JugadorBlanco jugadorBlanco;
    //private final JugadorNegro jugadorNegro;
    
    private Tablero(Builder builder){
        this.tableroJuego = crearTableroJuego(builder);
        this.piezasBlancas = calcularPiezasActivas(this.tableroJuego, Alianza.BLANCA);
        this.piezasNegras  = calcularPiezasActivas(this.tableroJuego, Alianza.NEGRA);       
        
        final Collection<Movimiento> blancasMovimientosLegalesEstandar = calcularMovimientosLegales(this.piezasBlancas);
        final Collection<Movimiento> negrasMovimientosLegalesEstandar = calcularMovimientosLegales(this.piezasNegras);
        
        //this.jugadorBlanco = new JugadorBlanco(this, blancasMovimientosLegalesEstandar, negrasMovimientosLegalesEstandar);
        //this.jugadorNegro = new JugadorNegro(this, blancasMovimientosLegalesEstandar, negrasMovimientosLegalesEstandar);
    }
    
    @Override
    public String toString(){
        final StringBuilder builder = new StringBuilder();
        for(int i = 0; i < Utiles.NUM_AZULEJO; i++){
            final String textoAzulejo = this.tableroJuego.get(i).toString();
            builder.append(String.format("%3s", textoAzulejo));
            if((i + 1) % Utiles.NUM_AZULEJO_POR_FILA == 0){
                builder.append("\n");
            }            
        }
        return builder.toString();
    }
    
    public Collection<Pieza> obtenerPiezasNegras(){
        return this.piezasNegras;
    }
    
    public Collection<Pieza> obtenerPiezasBlancas(){
        return this.piezasBlancas;
    }
    
    private static String impresionBonita(final Azulejo azulejo){        
        return azulejo.toString();
    }
    
    public Azulejo obtenerAzulejo(final int posAzulejo){
        return tableroJuego.get(posAzulejo);
    }
    
    private static List<Azulejo> crearTableroJuego(final Builder builder){
        final Azulejo[] azulejos = new Azulejo[Utiles.NUM_AZULEJO];
        for(int i =0; i < Utiles.NUM_AZULEJO; i++){
            azulejos[i] = Azulejo.crearAzulejos(i, builder.configuracionTablero.get(i));
           }
        return ImmutableList.copyOf(azulejos);
    }
    
    public static Tablero crearTableroEstandar(){
        final Builder builder = new Builder();
        //Piezas Negras
        builder.fijarPieza(new Torre(0, Alianza.NEGRA));
        builder.fijarPieza(new Caballero(1, Alianza.NEGRA));
        builder.fijarPieza(new Arfil(2, Alianza.NEGRA));
        builder.fijarPieza(new Reina(3, Alianza.NEGRA));
        builder.fijarPieza(new Rey(4, Alianza.NEGRA));
        builder.fijarPieza(new Arfil(5, Alianza.NEGRA));
        builder.fijarPieza(new Caballero(6, Alianza.NEGRA));
        builder.fijarPieza(new Torre(7, Alianza.NEGRA));
        builder.fijarPieza(new Peon(8, Alianza.NEGRA));
        builder.fijarPieza(new Peon(9, Alianza.NEGRA));
        builder.fijarPieza(new Peon(10, Alianza.NEGRA));
        builder.fijarPieza(new Peon(11, Alianza.NEGRA));
        builder.fijarPieza(new Peon(12, Alianza.NEGRA));
        builder.fijarPieza(new Peon(13, Alianza.NEGRA));
        builder.fijarPieza(new Peon(14, Alianza.NEGRA));
        builder.fijarPieza(new Peon(15, Alianza.NEGRA));
        //Piezas Blancas
        builder.fijarPieza(new Peon(48, Alianza.BLANCA));
        builder.fijarPieza(new Peon(49, Alianza.BLANCA));
        builder.fijarPieza(new Peon(50, Alianza.BLANCA));
        builder.fijarPieza(new Peon(51, Alianza.BLANCA));
        builder.fijarPieza(new Peon(52, Alianza.BLANCA));
        builder.fijarPieza(new Peon(53, Alianza.BLANCA));
        builder.fijarPieza(new Peon(54, Alianza.BLANCA));
        builder.fijarPieza(new Peon(55, Alianza.BLANCA));
        builder.fijarPieza(new Torre(56, Alianza.BLANCA));
        builder.fijarPieza(new Caballero(57, Alianza.BLANCA));
        builder.fijarPieza(new Arfil(58, Alianza.BLANCA));
        builder.fijarPieza(new Rey(59, Alianza.BLANCA));
        builder.fijarPieza(new Reina(60, Alianza.BLANCA));
        builder.fijarPieza(new Arfil(61, Alianza.BLANCA));
        builder.fijarPieza(new Caballero(62, Alianza.BLANCA));
        builder.fijarPieza(new Torre(63, Alianza.BLANCA));
        //bLANCAS A MOVER
        builder.fijerCreadorDeMovimiento(Alianza.BLANCA);        
        return builder.build();
    }

    private static Collection<Pieza> calcularPiezasActivas(final List<Azulejo> tableroJuego, 
                                                    final Alianza alianza) {
        final List<Pieza> piezasActivas = new ArrayList<>();
        for(final Azulejo azulejo : tableroJuego){           
            if(azulejo.elAzulejoEstaOcupado()){
                final Pieza pieza = azulejo.obtenerPieza();
                //System.out.print("***********************************************************************************");
                //System.out.print("Primero es:" + pieza.obtenerAlianzaPieza() + " Segundo es: " + alianza);
                if(pieza.obtenerAlianzaPieza() == alianza){
                    piezasActivas.add(pieza);
                }
            }
        }        
        return ImmutableList.copyOf(piezasActivas);
    }

    private Collection<Movimiento> calcularMovimientosLegales(final Collection<Pieza> piezas) {
        final List<Movimiento> movimientosLegales = new ArrayList<>();
        for(final Pieza pieza : piezas){
            movimientosLegales.addAll(pieza.calcularMovimientosLegales(this));
        }
        
        return ImmutableList.copyOf(movimientosLegales);
    }
    
    public static class Builder{
        Map<Integer, Pieza> configuracionTablero;
        Alianza creadorSiguienteMovimiento;
        
        public Builder(){
            this.configuracionTablero = new HashMap<>();
        }
        
        public Builder fijarPieza(final Pieza pieza){
            this.configuracionTablero.put(pieza.obtenerPosicionPieza(), pieza);
            return this;
        }
        
        public Builder fijerCreadorDeMovimiento(final Alianza creadorSiguienteMovimiento){
            this.creadorSiguienteMovimiento = creadorSiguienteMovimiento;
            return this;
        }
        
        public Tablero build(){
            return new Tablero(this);
        }
    }
    
}
