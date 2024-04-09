package es.uji.prog_av;

import java.util.List;

public interface Algorithm<T extends Table> {
    public void train(T datos) throws InvalidNumberOfClustersException;
    public int estimate(List<Double> data);
}
