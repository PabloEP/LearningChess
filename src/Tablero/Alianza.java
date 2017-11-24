
package Tablero;

public enum Alianza {
    BLANCA {
        @Override
        public int obtenerDireccion() {
            return -1;
        }
    },
    NEGRA {
        @Override
        public int obtenerDireccion(){
            return 1;
        }
    };
    
    public abstract int obtenerDireccion();
    
}
