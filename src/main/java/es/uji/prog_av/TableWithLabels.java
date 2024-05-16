package es.uji.prog_av;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    private Map<String, Integer> labelsToIndex = new HashMap<>();
    private List<RowWithLabel> datosFilas = new ArrayList<>();

    public void addRowWithLabels(List<Double> datos, String etiqueta){
        int etiquetaInt = 0;
        if(labelsToIndex.containsKey(etiqueta)){
            etiquetaInt = labelsToIndex.get(etiqueta);
        } else {
            etiquetaInt = labelsToIndex.size();
            labelsToIndex.put(etiqueta, etiquetaInt);
        }
        this.datosFilas.add(new RowWithLabel(datos, etiquetaInt));

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
