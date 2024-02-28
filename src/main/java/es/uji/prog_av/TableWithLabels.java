package es.uji.prog_av;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String, Integer> labelsToIndex = new HashMap<>();
    private List<RowWithLabel> datos1 = new ArrayList<>();

    public void addRowWithLabels(List<Double> l, String s){
        if(!this.labelsToIndex.containsKey(s)){
            this.labelsToIndex.put(s,labelsToIndex.size());
            this.datos1.add(new RowWithLabel(l, labelsToIndex.get(s)));
        }
    }


    public RowWithLabel getRowAt(int rowNumber){
        return datos1.get(rowNumber);
    }

}
