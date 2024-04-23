package es.uji.prog_av;

import java.util.List;

public class ManhattanDistance implements Distance{
    @Override
    public double calculateDistance(List<Double> p, List<Double> q) {
        double resultado_distancia = 0.0;
        for(int i = 0; i < p.size(); i++){
            resultado_distancia += Math.abs(p.get(i)-q.get(i));
        }
        return resultado_distancia;
    }
}
