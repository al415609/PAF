package es.uji.prog_av;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    CSV r = new CSV();
    String separator = System.getProperty("file.separator");
    String fileName = "src" + separator + "main" + separator + "resources" + separator + "miles_dollars.csv";
    String fileName1 = "src" + separator + "main" + separator + "resources" + separator + "iris.csv";

    @org.junit.jupiter.api.Test
    void readTable() throws IOException {
        System.out.println("Test de los métodos con el archivo miles_dollars.csv");
        System.out.println(" ");
        Table t = r.readTable(fileName);
        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        System.out.println("Test de las cabeceras");
        System.out.println("Esperado: " + l);
        System.out.println("Actual: " + t.getHeaders());
        assertEquals(l, t.getHeaders(), "No son iguales");
        System.out.println("Estan correctas");
        System.out.println(" ");
        System.out.println("Test del número de filas");
        System.out.println("Esperado: " + 25);
        System.out.println("Actual: " + t.n_filas());
        assertEquals(25, t.n_filas(), "El número de filas no es correcto");
        System.out.println("Estan correctas ");
        System.out.println(" ");
        System.out.println("Test del número de columnas");
        System.out.println("Esperado: " + 2);
        System.out.println("Actual: "+ t.n_columnas());
        assertEquals(2,t.n_columnas(),"El número de columnas no es el esperado");
        System.out.println("Estan correctas ");
        List<Double> l_test = new ArrayList<>();
        l_test.add(1211D);
        l_test.add(1802D);
        System.out.println(" ");
        System.out.println("Test de el guardado de filas");
        System.out.println("Fila con indice 0");
        System.out.println("Esperado: " + l_test);
        System.out.println("Actual: " + t.getRowAt(0).getData());
        assertEquals(l_test, t.getRowAt(0).getData(), "Las filas guardadas no coinciden");
        System.out.println("Estan correctas ");

    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() throws IOException {
        System.out.println("Test de los métodos con el archivo iris.csv");
        System.out.println(" ");
        TableWithLabels t = r.readTableWithLabel(fileName1);
        List<String> l = new ArrayList<>();
        l.add("sepal length");
        l.add("sepal width");
        l.add("petal length");
        l.add("petal width");
        l.add("class");
        System.out.println("Test de las cabeceras");
        System.out.println("Esperado: " + l);
        System.out.println("Actual: " + t.getHeaders());
        assertEquals(l, t.getHeaders(), "No son iguales");
        System.out.println("Estan correctas");
        System.out.println(" ");
        System.out.println("Test del número de filas");
        System.out.println("Esperado: " + 150);
        System.out.println("Actual: " + t.n_filas());
        assertEquals(150, t.n_filas(), "El número de filas no es correcto");
        System.out.println("Estan correctas ");
        System.out.println(" ");
        System.out.println("Test del número de columnas");
        System.out.println("Esperado: " + 5);
        System.out.println("Actual: "+ t.n_columnas());
        assertEquals(5,t.n_columnas(),"El número de columnas no es el esperado");
        System.out.println("Estan correctas ");
        List<Double> l_test = new ArrayList<>();
        l_test.add(5.1D);
        l_test.add(3.4D);
        l_test.add(1.5D);
        l_test.add(0.2D);
        System.out.println(" ");
        System.out.println("Test de el guardado de filas");
        System.out.println("Fila con índice 39");
        System.out.println("Esperado: " + l_test);
        System.out.println("Actual: " + t.getRowAt(39).getData());
        assertEquals(l_test, t.getRowAt(39).getData(), "Las filas guardadas no coinciden");
        System.out.println("Estan correctas ");
    }
}