package Tablero;

public class Utiles {

    public static boolean[] PRIMERA_COLUMNA = iniColumna(0);
    public static boolean[] SEGUNDA_COLUMNA = iniColumna(1);
    public static boolean[] SETIMA_COLUMNA  = iniColumna(6);
    public static boolean[] OCTAVA_COLUMNA  = iniColumna(7);
    
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
    
}


























































