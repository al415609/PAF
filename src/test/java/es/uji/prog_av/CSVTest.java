package es.uji.prog_av;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    CSV r = new CSV();
    String separator = FileSystems.getDefault().getSeparator();
    String fileName = "src" + separator + "main" + separator + "resources" + separator + "miles_dollars.csv";
    String fileName1 = "src" + separator + "main" + separator + "resources" + separator + "iris.csv";

    @org.junit.jupiter.api.Test
    void readTable() throws IOException {
        Table t = r.readTable(fileName);
        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        assertEquals(l, t.getHeaders(), "No son iguales");
        assertEquals(25, t.n_filas(), "El número de filas no es correcto");
        assertEquals(2,t.n_columnas(),"El número de columnas no es el esperado");
        List<Double> l_test = new ArrayList<>();
        l_test.add(1211D);
        l_test.add(1802D);
        assertEquals(l_test, t.getRowAt(0).getData(), "Las filas guardadas no coinciden");

    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() throws IOException {
        TableWithLabels t = r.readTableWithLabels(fileName1);
        List<String> l = new ArrayList<>();
        l.add("sepal length");
        l.add("sepal width");
        l.add("petal length");
        l.add("petal width");
        l.add("class");
        assertEquals(l, t.getHeaders(), "No son iguales");
        assertEquals(150, t.n_filas(), "El número de filas no es correcto");
        assertEquals(5,t.n_columnas(),"El número de columnas no es el esperado");
        List<Double> l_test = new ArrayList<>();
        l_test.add(5.1D);
        l_test.add(3.4D);
        l_test.add(1.5D);
        l_test.add(0.2D);
        assertEquals(l_test, t.getRowAt(39).getData(), "Las filas guardadas no coinciden");
    }
}