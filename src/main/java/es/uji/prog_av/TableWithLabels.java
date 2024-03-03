package es.uji.prog_av;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<Integer, String> labelsToIndex = new HashMap<>();
    private List<RowWithLabel> datos1 = new ArrayList<>();

    public void addRowWithLabels(List<Double> l, String s){
        if(this.labelsToIndex.put(labelsToIndex.size(),s) == null){
            this.datos1.add(new RowWithLabel(l, labelsToIndex.size()));
        }
    }

    @Override
    public int n_filas() {
        return datos1.size();
    }
    @Override
    public int n_columnas(){
        return datos1.get(1).tamaño() + 1;
    }

    public RowWithLabel getRowAt(int rowNumber){
        return datos1.get(rowNumber);
    }

}
