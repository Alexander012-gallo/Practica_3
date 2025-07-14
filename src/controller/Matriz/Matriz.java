package controller.Matriz;

/**
 *
 * @author Asus
 */
public class Matriz {

    private int filas;
    private int columnas;
    private Object[][] datos;

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        datos = new Object[filas][columnas];
    }

    public void generarAleatoria() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = (int) (Math.random() * 100);
            }
        }
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void eliminarEn(int fila, int columna) {
        if (esPosicionValida(fila, columna)) {
            datos[fila][columna] = "-";
        }
    }

    public void cambiarValor(int fila, int columna, int nuevoValor) {
        if (esPosicionValida(fila, columna)) {
            datos[fila][columna] = nuevoValor;
        }
    }

    public void eliminarPrimos() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (datos[i][j] instanceof Integer && esPrimo((Integer) datos[i][j])) {
                    datos[i][j] = "-";
                }
            }
        }
    }

    public boolean esPosicionValida(int fila, int columna) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }

    public boolean esPrimo(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
}
