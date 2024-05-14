package es.uji.prog_av;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<Integer, String> labelsToIndex = new HashMap<>();
    private List<RowWithLabel> datosFilas = new ArrayList<>();

    public void addRowWithLabels(List<Double> l, String s){
        if(this.labelsToIndex.put(labelsToIndex.size(),s) == null){
            this.datosFilas.add(new RowWithLabel(l, labelsToIndex.size()));
        }
    }

    @Override
    public int n_filas() {
        return datosFilas.size();
    }
    @Override
    public int n_columnas(){
        return datosFilas.get(1).tamaño() + 1;
    }

    public RowWithLabel getRowAt(int rowNumber){
        return datosFilas.get(rowNumber);
    }

}
