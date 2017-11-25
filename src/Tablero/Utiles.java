package Tablero;

public class Utiles {

    public static final boolean[] PRIMERA_COLUMNA = iniColumna(0);
    public static final boolean[] SEGUNDA_COLUMNA = iniColumna(1);
    public static final boolean[] SETIMA_COLUMNA  = iniColumna(6);
    public static final boolean[] OCTAVA_COLUMNA  = iniColumna(7);
    
    public static final boolean[] SEGUNDA_FILA = iniFila(8);
    public static final boolean[] SETIMA_FILA = iniFila(48);
    
    public static final int NUM_AZULEJO = 64;
    public static final int NUM_AZULEJO_POR_FILA = 8;
    private Utiles(){
        throw new RuntimeException("No se puede instanciar Utiles");
    }

    public static boolean posAzulejoValido(final int posicion) {
        return posicion >= 0 && posicion < NUM_AZULEJO;
    }

    private static boolean[] iniColumna(int numeroColumna) {
        final boolean[] columna = new boolean[64];        
        do{
            columna[numeroColumna] = true;
            numeroColumna += 8;            
        }while(numeroColumna < 64);             
        return columna;
    }
    private static boolean[] iniFila(int numeroFila){
        final boolean[] fila = new boolean[NUM_AZULEJO];
        do{
            fila[numeroFila]= true;
            numeroFila++;
        }while(numeroFila % NUM_AZULEJO_POR_FILA != 0);
        return fila;
    }
    
}


























































