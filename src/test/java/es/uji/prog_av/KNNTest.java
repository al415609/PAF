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
        TableWithLabels t = r.readTableWithLabels(fileName1);
        KNN s = new KNN();
        s.train(t);
        System.out.println("Test del calculo de la distancia euclidea");
        System.out.println(" ");
        Double d = 3.607D;
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
        System.out.println(l1);
        System.out.println(l2);
        System.out.println("Esperado: " + d);
        System.out.println("Actual: " + String.format(Locale.US,"%.3f",s.distance(l1, l2)));
        assertEquals(String.format(Locale.US, "%.3f", d), String.format(Locale.US, "%.3f",s.distance(l1, l2)), "Fallo en el calculo de la distancia");
        System.out.println(" ");
        Double d1 = 0.539D;
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
        System.out.println(l3);
        System.out.println(l4);
        System.out.println("Esperado: " + d1);
        System.out.println("Actual: " + String.format(Locale.US,"%.3f",s.distance(l3, l4)));
        assertEquals(String.format(Locale.US, "%.3f", d1), String.format(Locale.US, "%.3f",s.distance(l3, l4)), "Fallo en el calculo de la distancia");
        System.out.println(" ");
        System.out.println("Test de la funcion estimate");
        System.out.println("Esperado: " + 107);
        System.out.println("Actual: " + s.estimate(l1));
        assertEquals(107, s.estimate(l1), "Error en la funcion estimate");
        System.out.println(" ");
        System.out.println("Test de la funcion estimate");
        System.out.println("Esperado: " + 44);
        System.out.println("Actual: " + s.estimate(l2));
        assertEquals(44, s.estimate(l2), "Error en la funcion estimate");
        System.out.println(" ");
        System.out.println("Test de la funcion estimate");
        System.out.println("Esperado: " + 1);
        System.out.println("Actual: " + s.estimate(l3));
        assertEquals(1, s.estimate(l3), "Error en la funcion estimate");
    }
}