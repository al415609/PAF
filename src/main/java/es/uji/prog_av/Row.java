package es.uji.prog_av;

import java.util.List;

public class Row{
    private List<Double> lista;
    private int n;

    public Row(List<Double> lista){
        this.lista = lista;
    }

    public List<Double> getData(){
        return lista;
    }
}
