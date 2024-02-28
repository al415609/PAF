package es.uji.prog_av;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Table {

    private List<String> cabecera;
    private List<Row> datos = new ArrayList<>();

    public void addHeader(List<String> headers){
        this.cabecera = headers;
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
}
