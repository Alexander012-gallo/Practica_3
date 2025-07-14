package view.tables;

import javax.swing.table.AbstractTableModel;

public class ModeloTablacasas extends AbstractTableModel {

    private String[][] casas;
    private String[] columnas = {"Nro", "Largo", "Ancho", "Altura", "Pisos", "Homónima"};

    public String[][] getCasas() {
        return casas;
    }

    public void setCasas(String[][] casas) {
        this.casas = casas;
    }

    @Override
    public int getRowCount() {
        return (casas != null) ? casas.length : 0;
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return casas[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}

