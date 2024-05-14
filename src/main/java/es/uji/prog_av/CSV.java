package es.uji.prog_av;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public Table readTable(String fileName) throws IOException {
        Table t = new Table();
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        int i = 0;
        while((line = br.readLine()) != null){
            if( i == 0){
                String[] s1 = line.split(",");
                for(String s2 : s1){
                    t.addHeader(s2);
                }
                i++;
            } else {
                String[] datos = line.split(",");
                List<Double> row = new ArrayList<>();
                for(String s : datos){
                    row.add(Double.parseDouble(s));
                }
                t.addRow(row);
            }
        }
        br.close();
        return t;
    }

    public TableWithLabels readTableWithLabel(String fileName) throws IOException {
        TableWithLabels t1 = new TableWithLabels();
        BufferedReader br1 = new BufferedReader(new FileReader(new File(fileName)));
        String line;
        int i = 0;
        while((line = br1.readLine()) != null){
            if(i == 0){
                String[] s1 = line.split(",");
                for(String s2 : s1){
                    t1.addHeader(s2);
                }
                i++;
            } else {
                String[] datos = line.split(",");
                List<Double> rowWithL = new ArrayList<>();
                for(int j = 0; j<datos.length - 1; j++){
                    rowWithL.add(Double.parseDouble(datos[j]));
                }
                t1.addRowWithLabels(rowWithL, datos[datos.length-1]);
            }

        }
        br1.close();
        return t1;
    }
}
