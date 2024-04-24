package es.uji.prog_av;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class KMeansTest {


    private Distance distance = new EuclideanDistance();
    long seed = 1234567891011121314L;
    String separator = System.getProperty("file.separator");
    String fileName = "src" + separator + "main" + separator + "resources" + separator + "miles_dollars.csv";
    @Test
    void train() throws IOException, InvalidNumberOfClustersException {
        ReaderTemplate r = new CSVUnlabeledFileReader(fileName);
        Table t = r.readTableFromSource();
        KMeans s = new KMeans(3,100,seed, distance);
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

        KMeans k1 = new KMeans(40,100,seed, distance);
        assertThrows(InvalidNumberOfClustersException.class, () -> {k1.train(t);});
    }

    @Test
    void distance(){
        KMeans s = new KMeans(3,100,seed, distance);
        List<Double> l1 = new ArrayList<>();
        l1.add(1.5);
        l1.add(2.3);
        l1.add(3.8);
        l1.add(4.1);
        List<Double> l2 = new ArrayList<>();
        l2.add(2.7);
        l2.add(3.9);
        l2.add(1.2);
        l2.add(5.6);
        assertEquals(3.607D, Double.parseDouble(String.format(Locale.US,"%.3f",s.distance(l1,l2))));
        List<Double> l3 = new ArrayList<>();
        l3.add(5.1);
        l3.add(3.5);
        l3.add(1.4);
        l3.add(0.2);
        List<Double> l4 = new ArrayList<>();
        l4.add(4.9);
        l4.add(3.0);
        l4.add(1.4);
        l4.add(0.2);
        assertEquals(0.539D,  Double.parseDouble(String.format(Locale.US,"%.3f",s.distance(l3,l4))));
    }
}