package es.uji.prog_av;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVUnlabeledFileReader extends ReaderTemplate{
    protected BufferedReader br;
    protected String linea;

    public CSVUnlabeledFileReader(String fileName){
        super(fileName);
        this.tabla = new Table();
    }

    @Override
    void openSource(String source) throws FileNotFoundException {
        br = new BufferedReader(new FileReader(source));
    }

    @Override
    void processHeaders(String headers) throws IOException {
        String[] s = headers.split(",");
        for(String s1 : s)
            tabla.addHeader(s1);
    }

    @Override
    void processData(String data) throws IOException {
        String[] s = data.split(",");
        List<Double> row = new ArrayList<>();
        for(String s1: s)
            row.add(Double.parseDouble(s1));
        tabla.addRow(row);
    }

    @Override
    void closeSource() throws IOException {
        br.close();
    }

    @Override
    boolean hasMoreData() throws IOException {
        linea = br.readLine();
        return linea != null;
    }

    @Override
    String getNextData() throws IOException {
        return linea;
    }
}
