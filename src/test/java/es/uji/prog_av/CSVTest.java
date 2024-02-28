package es.uji.prog_av;

import java.io.File;
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
        Table t = r.readTable(fileName);
        List<String> l = new ArrayList<>();
        l.add("Miles");
        l.add("Dollars");
        System.out.println(l);
        System.out.println(t.getHeaders());
       // assertEquals(l, t.getHeaders());
    }

    @org.junit.jupiter.api.Test
    void readTableWithLabels() throws IOException {
        r.readTableWithLabels(fileName1);
    }
}