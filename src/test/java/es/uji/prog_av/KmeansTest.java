package es.uji.prog_av;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KmeansTest {

    CSV r = new CSV();
    long seed = 1234567891011121314L;
    String separator = System.getProperty("file.separator");
    String fileName = "src" + separator + "main" + separator + "resources" + separator + "test.csv";
    @Test
    void train() throws IOException, InvalidNumberOfClustersException {
        Table t = r.readTable(fileName);
        Kmeans s = new Kmeans(3,100,seed);
        s.train(t);
        System.out.println(s.getAsignaciones());
    }
}