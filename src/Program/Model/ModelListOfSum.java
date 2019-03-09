package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfSum {
    private ObservableList<ModelSum> listOfConsom;
    private ObservableList<ModelSum> listOfGas;
    private ObservableList<ModelSum> listOfRate;
    private ObservableList<ModelSum> listOfConsomByType;
    private ObservableList<ModelSum> listOfGasByType;
    private ObservableList<ModelSum> listOfRateByType;
    private ObservableList<ModelFood> listOfFoodConsom;
    private ObservableList<ModelFood> listOfFoodGas;
    private ObservableList<ModelTag> listOfTag;

    public ModelListOfSum(){
        listOfGas = FXCollections.observableList(new ArrayList<>());
        listOfConsom = FXCollections.observableList(new ArrayList<>());
        listOfRate = FXCollections.observableList(new ArrayList<>());
        listOfConsomByType = FXCollections.observableList(new ArrayList<>());
        listOfTag = FXCollections.observableList(new ArrayList<>());
        listOfGasByType = FXCollections.observableList(new ArrayList<>());
        listOfRateByType = FXCollections.observableList(new ArrayList<>());
    }

    public void init(ModelListOfFood modelListOfFood,ModelListOfTags modelListOfTags){
        this.listOfFoodConsom = modelListOfFood.getlistOfConsom();
        this.listOfFoodGas = modelListOfFood.getListOfGas();
        this.listOfTag = modelListOfTags.getListOfTag();
    }

    public ObservableList<ModelSum> getListOfConsom(){
        getListInSomme(listOfConsom,listOfFoodConsom);
        return listOfConsom;
    }

    public ObservableList<ModelSum> getListOfGas(){
        getListInSomme(listOfGas,listOfFoodGas);
        return listOfGas;
    }

    public void getListInSomme(ObservableList<ModelSum> sum,ObservableList<ModelFood> food){
        sum.removeAll(sum);
        int somme = 0;
        for(ModelFood aFood : food){
            somme += aFood.getQuantity();
        }
        sum.add(new ModelSum("Aliments",String.valueOf(somme)));
    }

    public ObservableList<ModelSum> getListOfConsomByType(){
        getListInType(listOfConsomByType,listOfFoodConsom);
        return listOfConsomByType;
    }

    public ObservableList<ModelSum> getListOfGasByType(){
        getListInType(listOfGasByType,listOfFoodGas);
        return listOfGasByType;
    }

    public void getListInType(ObservableList<ModelSum> sum,ObservableList<ModelFood> food){
        sum.removeAll(sum);
        for (ModelTag tag : listOfTag) {
            int somme = 0;
            for (ModelFood aFood : food) {
                if(aFood.getFoodType().equals(tag.getName())){
                    somme += aFood.getQuantity();
                }
            }
            sum.add(new ModelSum(tag.getName(), String.valueOf(somme)));
        }
    }

    public ObservableList<ModelSum> getListOfRate(){
        listOfRate.removeAll(listOfRate);
        String rate = "0%";
        if(Integer.parseInt(listOfConsom.get(0).getSum()) != 0){
            rate = (float)Integer.parseInt(listOfGas.get(0).getSum())/(float) Integer.parseInt(listOfConsom.get(0).getSum())*100 + "%";
        }
        listOfRate.add(new ModelSum("Alimets",rate));
        return listOfRate;
    }

    public ObservableList<ModelSum> getListOfRateByType(){
        listOfRateByType.removeAll(listOfRateByType);
        String rate = "0%";
        for (int cmp = 0;cmp < listOfConsomByType.size();cmp ++) {
            if (Integer.parseInt(listOfConsomByType.get(cmp).getSum()) != 0) {
                rate = (float) Integer.parseInt(listOfGasByType.get(cmp).getSum()) / (float) Integer.parseInt(listOfConsomByType.get(cmp).getSum()) * 100 + "%";
            }
            listOfRateByType.add(new ModelSum(listOfConsomByType.get(cmp).getName(),rate));
        }
        return listOfRateByType;
    }
}