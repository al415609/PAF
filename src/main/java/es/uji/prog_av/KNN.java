package es.uji.prog_av;

import java.util.ArrayList;
import java.util.List;

public class KNN implements Algorithm<TableWithLabels, Integer, List<Double>>{

    private TableWithLabels datos;
    private Double minimo;
    private int r1;
    private Distance distance;

    public KNN(Distance distance){
        this.distance = distance;
    }

    @Override
    public void train(TableWithLabels data){
        this.datos = data;
    }

    @Override
   public Integer estimate(List<Double> data){
        double c;
        minimo = 100D;
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
       return distance.calculateDistance(d1, d2);
   }
}
