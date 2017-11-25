
package Tablero;

public enum Alianza {
    BLANCA {
        @Override
        public int obtenerDireccion() {
            return -1;
        }

        @Override
        public boolean esBlanca() {
            return true;
        }

        @Override
        public boolean esNegra() {
            return false;
        }
    },
    NEGRA {
        @Override
        public int obtenerDireccion(){
            return 1;
        }

        @Override
        public boolean esBlanca() {
            return false;
        }

        @Override
        public boolean esNegra() {
            return true;
        }
    };
    
    public abstract int obtenerDireccion();
    public abstract boolean esBlanca();
    public abstract boolean esNegra();
    
}
