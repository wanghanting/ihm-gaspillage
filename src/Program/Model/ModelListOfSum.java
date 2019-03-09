package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfSum {
    private ObservableList<ModelSum> listOfConsom;
    private ObservableList<ModelSum> listOfGas;
    private ObservableList<ModelSum> listOfRate;
    private ObservableList<ModelFood> listOfFoodConsom;
    private ObservableList<ModelFood> listOfFoodGas;

    public ModelListOfSum(){
        listOfGas = FXCollections.observableList(new ArrayList<>());
        listOfConsom = FXCollections.observableList(new ArrayList<>());
        listOfRate = FXCollections.observableList(new ArrayList<>());
    }

    public void init(ModelListOfFood modelListOfFood){
        this.listOfFoodConsom = modelListOfFood.getlistOfConsom();
        this.listOfFoodGas = modelListOfFood.getListOfGas();
    }

    public ObservableList<ModelSum> getListOfConsom(){
        listOfConsom.removeAll(listOfConsom);
        int somme = 0;
        for(ModelFood food : listOfFoodConsom){
            somme += food.getQuantity();
        }
        listOfConsom.add(new ModelSum("Aliments",String.valueOf(somme)));
        return listOfConsom;
    }

    public ObservableList<ModelSum> getListOfGas(){
        listOfGas.removeAll(listOfGas);
        int somme = 0;
        for(ModelFood food : listOfFoodGas){
            somme += food.getQuantity();
        }
        listOfGas.add(new ModelSum("Aliments",String.valueOf(somme)));
        return listOfGas;
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
}