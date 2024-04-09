package es.uji.prog_av;


public interface Algorithm<T extends Table, I, R> {
    public void train(T datos) throws InvalidNumberOfClustersException;
    public I estimate(R data);
}
