package controller;

import java.io.*;

public class Casascontroller {

    private String[][] casas = new String[10][6];
    private int index = 0;
    private final String archivo = "src/data/casas_valores.dat";

    public void agregarCasa(String largo, String ancho, String altura, String pisos) {
        if (index < casas.length) {
            casas[index][0] = String.valueOf(index + 1);
            casas[index][1] = largo;
            casas[index][2] = ancho;
            casas[index][3] = altura;
            casas[index][4] = pisos;
            casas[index][5] = "";
            index++;
        }
    }

    public String[][] getCasas() {
        return casas;
    }

    public void verificarHomonimas() {
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < i; j++) {
                boolean igual
                        = casas[i][1].equals(casas[j][1])
                        && casas[i][2].equals(casas[j][2])
                        && casas[i][3].equals(casas[j][3])
                        && casas[i][4].equals(casas[j][4]);
                if (igual) {
                    casas[i][5] = "Casa " + casas[j][0];
                    break;
                }
            }
        }
    }

    public void guardarArchivo() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("Nro\tLargo\tAncho\tAltura\tPisos\tHomonima");
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < 6; j++) {
                    pw.print(casas[i][j]);
                    if (j < 5) {
                        pw.print("\t");
                    }
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void cargarArchivo() {
        index = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null && index < casas.length) {
                String[] datos = linea.split("\t");
                for (int j = 0; j < 6; j++) {
                    casas[index][j] = (j < datos.length) ? datos[j] : "";
                }
                index++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
