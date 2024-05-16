package es.uji.prog_av;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {

    CSV r = new CSV();
    String separator = System.getProperty("file.separator");
    String fileName = "src" + separator + "main" + separator + "resources" + separator + "miles_dollars.csv";
    String fileName1 = "src" + separator + "main" + separator + "resources" + separator + "iris.csv";


    @Test
    void estimate() throws IOException {
        TableWithLabels t = r.readTableWithLabel(fileName1);
        KNN s = new KNN();
        s.train(t);
        List<Double> l1 = new ArrayList<>();
        l1.add(5.82);
        l1.add(2.63);
        l1.add(3.94);
        l1.add(1.19);
        List<Double> l2 = new ArrayList<>();
        l2.add(4.91);
        l2.add(3.01);
        l2.add(1.43);
        l2.add(0.22);
        List<Double> l3 = new ArrayList<>();
        l3.add(5.1);
        l3.add(3.5);
        l3.add(1.4);
        l3.add(0.2);
        List<Double> l4 = new ArrayList<>();
        l4.add(6.42);
        l4.add(3.12);
        l4.add(5.51);
        l4.add(1.86);
        assertEquals(1, s.estimate(l1), "Error en la funcion estimate");
        assertEquals(0, s.estimate(l2), "Error en la funcion estimate");
        assertEquals(0, s.estimate(l3), "Error en la funcion estimate");
        assertEquals(2, s.estimate(l4), "Error en la funcion estimate");
    }

    @Test
    void distance() throws IOException{
        TableWithLabels t = r.readTableWithLabel(fileName1);
        KNN s = new KNN();
        s.train(t);
        Double d = 3.607D;
        List<Double> l1 = new ArrayList<>();
        l1.add(5.82);
        l1.add(2.63);
        l1.add(3.94);
        l1.add(1.19);
        List<Double> l2 = new ArrayList<>();
        l2.add(2.7);
        l2.add(3.9);
        l2.add(1.2);
        l2.add(5.6);
        //System.out.println(String.format(Locale.US, "%.3f",s.distance(l1,l2)));
        assertEquals(String.format(Locale.US, "%.3f", 6.189D), String.format(Locale.US, "%.3f",s.distance(l1, l2)), "Fallo en el calculo de la distancia");
        List<Double> l3 = new ArrayList<>();
        l3.add(5.1);
        l3.add(3.5);
        l3.add(1.4);
        l3.add(0.2);
        List<Double> l4 = new ArrayList<>();
        l4.add(6.42);
        l4.add(3.12);
        l4.add(5.51);
        l4.add(1.86);
        //System.out.println(String.format(Locale.US, "%.3f",s.distance(l3,l4)));
        assertEquals(String.format(Locale.US, "%.3f", 4.641D), String.format(Locale.US, "%.3f",s.distance(l3, l4)), "Fallo en el calculo de la distancia");

    }
}