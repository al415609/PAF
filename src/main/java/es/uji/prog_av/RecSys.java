package es.uji.prog_av;

import java.util.ArrayList;
import java.util.List;

public class RecSys{
    private Algorithm algorithm;
    private List<Integer> estimates;
    private List<String> testItemNames;
    private List<String> slectedItems = new ArrayList<>();
    private Table testData;
    public RecSys(Algorithm algorithm){
        this.algorithm = algorithm;
        this.estimates = new ArrayList<>();
    }
    public void train(Table trainData) throws InvalidNumberOfClustersException {
        algorithm.train(trainData);
    }
    public void run(Table testData, List<String> testItemNames){
        this.testData = testData;
        this.testItemNames = testItemNames;
        for(int i = 0; i < testData.n_filas(); i++){
            estimates.add((int) algorithm.estimate(testData.getRowAt(i).getData()));
        }
    }
    public List<String> recommend(String namedLinkedItem, int numRecommendations) throws InvalidNameLikedItem {
        if(!testItemNames.contains(namedLinkedItem)){
            throw new InvalidNameLikedItem(namedLinkedItem + "no se encuentra en la lista para recomendar.");
        }
        int idx = findName(namedLinkedItem);
        int lbl = estimates.get(idx);
        selecItems(idx, lbl, numRecommendations);
        return getNamesSelectedItems();
    }

    private int findName(String nameItem){
        return testItemNames.indexOf(nameItem);
    }
    private void selecItems(int idxLikedItem, int labelLikedItem, int numRec){
        int c = 0;
        for(int i = 0; i < testData.n_filas(); i++){
            if(estimates.get(i) == labelLikedItem && i != idxLikedItem){
                slectedItems.add(testItemNames.get(i));
                c++;
            }
            if(c == numRec)
                break;
        }
    }
    private List<String> getNamesSelectedItems(){
        return slectedItems;
    }
}
