package es.uji.prog_av;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KMeans implements Algorithm<Table, Integer, List<Double>>{
    private List<Row> centroids;
    private List<Integer> asignaciones;
    private int numClusters;
    private int numIterations;
    private Random random;
    private Distance distance;
    public KMeans(int numClusters, int numIterations, long seed, Distance distance){
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.random = new Random(seed);
        this.centroids = new ArrayList<>();
        this.asignaciones = new ArrayList<>();
        this.distance = distance;
    }

    @Override
    public void train(Table datos) throws InvalidNumberOfClustersException{
        if(numClusters > datos.n_filas()){
            throw new InvalidNumberOfClustersException("El numero de clusters indicado: " + numClusters + " es superior al tamaño de la muestra de datos" + datos.n_filas());
        }
        seleccionarPrototiposIniciales(datos);
        for(int i = 0; i<numIterations; i++){
            asignaciones = asignarAGrupos(datos);
            calcularCentroides(datos, asignaciones);
        }
    }
    @Override
    public Integer estimate(List<Double> dato){
        double distancia_min = Double.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < centroids.size(); i++){
            double distancia_teoria = distance(centroids.get(i).getData(),dato);
            if(distancia_min > distancia_teoria){
                distancia_min = distancia_teoria;
                index = i;
            }
        }
        return index;
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
        int size = datos.n_filas();
        List<Integer> res = new ArrayList<>(Collections.nCopies(size, 0));
        int indice = -1;

        for(int i = 0; i < datos.n_filas(); i++){
            double minDistance = Double.MAX_VALUE;
            for(int j = 0; j< centroids.size(); j++){
                double distancia = distance(datos.getRowAt(i).getData(), centroids.get(j).getData());
                if(distancia < minDistance){
                    minDistance = distancia;
                    indice = j;
                }
            }
            res.set(i, indice);
        }
        return res;
    }

    private void calcularCentroides(Table datos, List<Integer> asignaciones){
        List<Row> newClusters = new ArrayList<>();

        int tamaño = 0;

        for(int i = 0; i < numClusters; i++){
            List<Double> nuevo_Centroide = new ArrayList<>();
            List<Double> total = new ArrayList<>(Collections.nCopies(datos.n_columnas(),0.0));
            for(int j = 0; j < asignaciones.size(); j++){
                if(i == asignaciones.get(j)){
                    total = suma(datos.getRowAt(j).getData(), total);
                    tamaño++;
                }
            }
            for(int k = 0; k < total.size(); k++){
                nuevo_Centroide.add(total.get(k) / tamaño);
            }
            newClusters.add(new Row(nuevo_Centroide));
            tamaño = 0;
        }
        centroids = newClusters;
    }

    private List<Double> suma(List<Double> data, List<Double> total) {
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < data.size(); i++){
            res.add(total.get(i) + data.get(i));
        }
        return res;
    }

    public double distance(List<Double> L1, List<Double> L2){
        return distance.calculateDistance(L1, L2);
    }

    public List<Integer> getAsignaciones(){
        return this.asignaciones;
    }
}
