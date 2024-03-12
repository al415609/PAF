package es.uji.prog_av;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Kmeans {
    private List<Row> centroids;
    private int numClusters;
    private int numIterations;
    private Random random;
    public Kmeans(int numClusters, int numIterations, long seed){
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.random = new Random(seed);
        this.centroids = new ArrayList<>();
    }
    public void train(Table datos){
        seleccionarPrototiposIniciales(datos);
        List<Integer> asignaciones;
        for(int i = 0; i<numIterations; i++){
            asignaciones = asignarAGrupos(datos);
            calcularCentroides(datos, asignaciones);
        }
    }
    public int estimate(List<Double> dato){

    }
    private void seleccionarPrototiposIniciales(Table datos){
        List<Integer> indices = new ArrayList<>();
        for(int i = 0; i<datos.n_filas(); i++){
            indices.add(i);
        }
        Collections.shuffle(indices,random);
        for(int i = 0; i <numClusters; i++){
            centroids.add(datos.getRowAt(indices.get(i)));
        }
    }

    private List<Integer> asignarAGrupos(Table datos){
        List<Integer> res = new ArrayList<>();
        double minDistance = Double.MAX_VALUE;
        int indice = -1;

        for(int i = 0; i < datos.n_filas(); i++){
            for(int j = 0; j< centroids.size(); j++){
                double distancia = distance(datos.getRowAt(i).getData(), centroids.get(j).getData());
                if(distancia < minDistance){
                    minDistance = distancia;
                    indice = j;
                }
            }
            res.add(indice);
        }
        return res;
    }

    private void calcularCentroides(Table datos, List<Integer> asignaciones){
        List<Integer> newClusters = new ArrayList<>();


    }
    public double distance(List<Double> d1, List<Double> d2){
        double res = 0;
        for(int i = 0; i < d1.size(); i++){
            res += Math.pow((d1.get(i)-d2.get(i)), 2);
        }
        return Math.sqrt(res);
    }
}
