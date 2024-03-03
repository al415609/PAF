package es.uji.prog_av;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<String> cabecera = new ArrayList<>();
    private List<Row> datos = new ArrayList<>();

    public void addHeader(String headers){
        this.cabecera.add(headers);
    }
    public List<String> getHeaders(){
        return cabecera;
    }
    public void addRow(List<Double> data){
        this.datos.add(new Row(data));
    }
    public Row getRowAt(int rowNumber){
        return datos.get(rowNumber);
    }
    public int n_filas(){
        return datos.size();
    }
    public int n_columnas(){
        return datos.get(1).tamaño();
    }
}
