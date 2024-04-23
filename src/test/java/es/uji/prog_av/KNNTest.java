package es.uji.prog_av;

import org.junit.jupiter.api.Test;
import org.w3c.dom.html.HTMLTableElement;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {
    private Distance distance = new ManhattanDistance();


    String separator = FileSystems.getDefault().getSeparator();
    String fileName1 = "src" + separator + "main" + separator + "resources" + separator + "iris.csv";

    @Test
    void estimate() throws IOException {
        ReaderTemplate r = new CSVLabeledFileReader(fileName1);
        TableWithLabels tabla = (TableWithLabels) r.readTableFromSource();
        KNN s = new KNN(distance);
        s.train(tabla);
        Double d = 6.900D;
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
        assertEquals(String.format(Locale.US, "%.3f", d), String.format(Locale.US, "%.3f",s.distance(l1, l2)), "Fallo en el calculo de la distancia");
        Double d1 = 0.700D;
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
        assertEquals(String.format(Locale.US, "%.3f", d1), String.format(Locale.US, "%.3f",s.distance(l3, l4)), "Fallo en el calculo de la distancia");
        assertEquals(30, s.estimate(l1), "Error en la funcion estimate");
        assertEquals(11, s.estimate(l2), "Error en la funcion estimate");
        assertEquals(9, s.estimate(l3), "Error en la funcion estimate");
    }
}