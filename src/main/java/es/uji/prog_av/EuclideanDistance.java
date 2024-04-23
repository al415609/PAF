package es.uji.prog_av;

import java.util.List;

public class EuclideanDistance implements Distance{

    @Override
    public double calculateDistance(List<Double> d1, List<Double> d2){
        double res = 0;
        for(int i = 0; i < d1.size(); i++){
            res += Math.pow((d1.get(i)-d2.get(i)), 2);
        }
        return Math.sqrt(res);
    }
}
