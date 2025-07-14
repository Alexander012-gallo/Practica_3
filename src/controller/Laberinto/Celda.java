package controller.Laberinto;

/**
 *
 * @author Asus
 */
public class Celda {

    public enum Tipo {
        PARED, CAMINO, INICIO, SALIDA
    }

    private Tipo tipo;

    public Celda(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        switch (tipo) {
            case PARED:
                return "X";
            case CAMINO:
                return ".";
            case INICIO:
                return "I";
            case SALIDA:
                return "S";
            default:
                return " ";
        }
    }
}
