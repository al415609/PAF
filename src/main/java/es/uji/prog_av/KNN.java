package es.uji.prog_av;

import java.util.ArrayList;
import java.util.List;

public class KNN {

    private TableWithLabels datos;
    private Double minimo;
    private int r1;
    public void train(TableWithLabels data){
        this.datos = data;
    }

   public int estimate(List<Double> data){
        double c;
        for(int i = 0; i<datos.n_filas(); i++){
            c = distance(datos.getRowAt(i).getData(), data);
            if(c < minimo){
                minimo = c;
                r1 = datos.getRowAt(i).getNumberClass();
            }
        }
        return r1;
   }

   public double distance(List<Double> d1, List<Double> d2){
        double res = 0;
        for(int i = 0; i < d1.size(); i++){
            res += Math.pow((d1.get(i)-d2.get(i)), 2);
        }
        return Math.sqrt(res);
   }
}
