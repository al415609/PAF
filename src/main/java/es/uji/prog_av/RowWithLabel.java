package es.uji.prog_av;

import java.util.List;

public class RowWithLabel extends Row{
    private int numberClass;
    private List<Double> lista;

    public RowWithLabel(List<Double> l, int n){
        super(l);
        this.numberClass = n;
    }

    public int getNumberClass(){
        return numberClass;
    }
}
