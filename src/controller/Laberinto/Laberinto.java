package controller.Laberinto;

/**
 *
 * @author Asus
 */
import java.util.Random;
import javax.swing.JOptionPane;

public class Laberinto {

    private Celda[][] mapa;
    private static final Random random = new Random();

    public Laberinto(int size) {
        generarMapaAleatorio(size);
    }

    public void generarMapaAleatorio(int size) {
        if (size < 10 || size > 100) {
            JOptionPane.showMessageDialog(
                    null,
                    "El tamaño del laberinto debe estar entre 10 y 100.\n"
                    + "Valor ingresado: " + size,
                    "Error de tamaño",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int filas = size;
        int columnas = size;

        mapa = new Celda[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Celda.Tipo tipo;
                int r = random.nextInt(100);
                if (r < 40) {
                    tipo = Celda.Tipo.PARED;
                } else {
                    tipo = Celda.Tipo.CAMINO;
                }
                mapa[i][j] = new Celda(tipo);
            }
        }

        mapa[0][0].setTipo(Celda.Tipo.INICIO);
        mapa[filas - 1][columnas - 1].setTipo(Celda.Tipo.SALIDA);
    }

    public Celda[][] getMapa() {
        return mapa;
    }

    public int getFilas() {
        return mapa.length;
    }

    public int getColumnas() {
        return mapa[0].length;
    }

    public Celda getCelda(int fila, int columna) {
        return mapa[fila][columna];
    }
}
