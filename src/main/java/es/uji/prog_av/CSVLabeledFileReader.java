package es.uji.prog_av;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVLabeledFileReader extends CSVUnlabeledFileReader{
    public CSVLabeledFileReader(String fileName) {
        super(fileName);
        this.tabla = new TableWithLabels();
    }
    void processData(String data) throws IOException {
        String[] s = data.split(",");
        List<Double> rowWithL = new ArrayList<>();
        for(int i = 0; i < s.length -1; i++)
            rowWithL.add(Double.parseDouble(s[i]));
        ((TableWithLabels) tabla).addRowWithLabels(rowWithL, s[s.length - 1]);
    }

}
