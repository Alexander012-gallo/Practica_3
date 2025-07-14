package controller;

public class Ensayo {

    public static void main(String[] args) {
        int[][][] tabla = new int[10][10][10];
        llenarTabla(tabla);
        imprimirTabla(tabla);
    }

    public static void llenarTabla(int[][][] tabla) {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    tabla[x][y][z] = x + y + z;
                }
            }
        }

    }

    public static void imprimirTabla(int[][][] tabla) {
        for (int x = 0; x < 10; x++) {
            System.out.println("Bloque: " + x);
            for (int y = 0; y < 10; y++) {
                for (int z = 0; z < 10; z++) {
                    System.out.print(tabla[x][y][z] + "\t");
                }
                System.out.println();
            }
            System.out.println("-------------------------------------------"
                    + "------------------------------------");
        }
    }
}


