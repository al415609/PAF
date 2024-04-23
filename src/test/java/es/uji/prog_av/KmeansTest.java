package es.uji.prog_av;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class KmeansTest {


    private Distance distance = new EuclideanDistance();
    long seed = 1234567891011121314L;
    String separator = System.getProperty("file.separator");
    String fileName = "src" + separator + "main" + separator + "resources" + separator + "miles_dollars.csv";
    @Test
    void train() throws IOException, InvalidNumberOfClustersException {
        ReaderTemplate r = new CSVUnlabeledFileReader(fileName);
        Table t = r.readTableFromSource();
        Kmeans s = new Kmeans(3,100,seed, distance);
        s.train(t);
        assertEquals(s.estimate(t.getRowAt(0).getData()), s.getAsignaciones().get(0));
        assertEquals(s.estimate(t.getRowAt(1).getData()), s.getAsignaciones().get(1));
        assertEquals(s.estimate(t.getRowAt(2).getData()), s.getAsignaciones().get(2));
        assertEquals(s.estimate(t.getRowAt(3).getData()), s.getAsignaciones().get(3));
        assertEquals(s.estimate(t.getRowAt(4).getData()), s.getAsignaciones().get(4));
        assertEquals(s.estimate(t.getRowAt(5).getData()), s.getAsignaciones().get(5));
        assertEquals(s.estimate(t.getRowAt(6).getData()), s.getAsignaciones().get(6));
        assertEquals(s.estimate(t.getRowAt(7).getData()), s.getAsignaciones().get(7));
        assertEquals(s.estimate(t.getRowAt(8).getData()), s.getAsignaciones().get(8));
        assertEquals(s.estimate(t.getRowAt(9).getData()), s.getAsignaciones().get(9));
        assertEquals(s.estimate(t.getRowAt(10).getData()), s.getAsignaciones().get(10));

        Kmeans k1 = new Kmeans(40,100,seed, distance);
        assertThrows(InvalidNumberOfClustersException.class, () -> {k1.train(t);});
    }
}