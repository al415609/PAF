package es.uji.prog_av;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<String> cabecera = new ArrayList<>();
    private List<Row> datosTabla = new ArrayList<>();

    public void addHeader(String headers){
        this.cabecera.add(headers);
    }
    public List<String> getHeaders(){
        return cabecera;
    }
    public void addRow(List<Double> data){
        this.datosTabla.add(new Row(data));
    }
    public Row getRowAt(int rowNumber){
        return datosTabla.get(rowNumber);
    }
    public int n_filas(){
        return datosTabla.size();
    }
    public int n_columnas(){
        return datosTabla.get(1).tamaño();
    }
}
