package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelListOfFood {
    private ObservableList<ModelFood> listOfFoodA;
    private ObservableList<ModelFood> listOfFoodG;
    private ObservableList<ModelFood> listOfOkFood;
    private ObservableList<ModelFood> listOfPerimeFood;
    private ObservableList<ModelFood> listOfPPFood;
    private ObservableList<ModelFood> listOfOkFoodG;
    private ObservableList<ModelFood> listOfPerimeFoodG;
    private ObservableList<ModelFood> listOfPPFoodG;
    private ObservableList<ModelFood> listOfOkFoodOfOneType;
    private ObservableList<ModelFood> listOfPerimeFoodOfOneType;
    private ObservableList<ModelFood> listOfPPFoodOfOneType;
    private ObservableList<ModelFood> listOfConsom;
    private ObservableList<ModelFood> listOfGas;
    private String type;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public ModelListOfFood(){
        listOfFoodA= FXCollections.observableList(new ArrayList<>());
        listOfFoodG= FXCollections.observableList(new ArrayList<>());
        listOfPerimeFood=FXCollections.observableList(new ArrayList<>());
        listOfOkFood = FXCollections.observableList(new ArrayList<>());
        listOfPPFood= FXCollections.observableList(new ArrayList<>());
        listOfPerimeFoodG=FXCollections.observableList(new ArrayList<>());
        listOfOkFoodG = FXCollections.observableList(new ArrayList<>());
        listOfPPFoodG= FXCollections.observableList(new ArrayList<>());
        listOfOkFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfPerimeFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfPPFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfConsom = FXCollections.observableList(new ArrayList<>());
        listOfGas = FXCollections.observableList(new ArrayList<>());
        listOfFoodA.add(new ModelFood("apple","fruit",1,LocalDate.of(2019, 1, 8),LocalDate.of(2019, 2, 8),1,"from England"));
        listOfFoodG.add(new ModelFood("apple","fruit",1,LocalDate.of(2019, 1, 8),LocalDate.of(2019, 2, 8),1,"from England"));
    }

    public void addFood(ModelFood food){
        this.listOfFoodA.add(food);
        this.listOfFoodG.add(food);
    }
    public ObservableList<ModelFood> getListOfFoodA(){return  listOfFoodA;}
    public ObservableList<ModelFood> getListOfOkFood(){return listOfOkFood;}
    public ObservableList<ModelFood> getListOfPPFood(){return listOfPPFood;}
    public ObservableList<ModelFood> getListOfPerimeFood(){return listOfPerimeFood;}
    public ObservableList<ModelFood> getListOfOkFoodG(){return listOfOkFoodG;}
    public ObservableList<ModelFood> getListOfPPFoodG(){return listOfPPFoodG;}
    public ObservableList<ModelFood> getListOfPerimeFoodG(){return listOfPerimeFoodG;}
    public void init(){
        listOfPPFood.removeAll(listOfPPFood);
        listOfPerimeFood.removeAll(listOfPerimeFood);
        listOfOkFood.removeAll(listOfOkFood);
        listOfPPFoodG.removeAll(listOfPPFoodG);
        listOfPerimeFoodG.removeAll(listOfPerimeFoodG);
        listOfOkFoodG.removeAll(listOfOkFoodG);
        for(ModelFood food:this.listOfFoodA){
            if(food.getDateExpiration().compareTo(LocalDate.now())<0){
                listOfPerimeFood.add(food);
            }else if(food.getDateExpiration().minusDays((long)food.getDaysBeforeAlmostExpired()).compareTo(LocalDate.now())>0){
                listOfOkFood.add(food);
            }else listOfPPFood.add(food);
        }
        for(ModelFood food:this.listOfFoodG){
            if(food.getDateExpiration().compareTo(LocalDate.now())<0){
                listOfPerimeFoodG.add(food);
            }else if(food.getDateExpiration().minusDays((long)food.getDaysBeforeAlmostExpired()).compareTo(LocalDate.now())>0){
                listOfOkFoodG.add(food);
            }else listOfPPFoodG.add(food);
        }
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public ObservableList<ModelFood> getListOfOkFoodOfOneType(){
        listOfOkFoodOfOneType.removeAll(listOfOkFoodOfOneType);
        for(ModelFood food:this.listOfOkFood){
            if(food.getFoodType().equals(this.type)){
                listOfOkFoodOfOneType.add(food);
            }
        }
        return listOfOkFoodOfOneType;
    }

    public ObservableList<ModelFood> getListOfPerimeFoodOfOneType(){
        listOfPerimeFoodOfOneType.removeAll(listOfPerimeFoodOfOneType);
        for(ModelFood food:this.listOfPerimeFood){
            if(food.getFoodType().equals(this.type)){
                listOfPerimeFoodOfOneType.add(food);
            }
        }
        return listOfPerimeFoodOfOneType;
    }

    public ObservableList<ModelFood> getListOfPPFoodOfOneType(){
        listOfPPFoodOfOneType.removeAll(listOfPPFoodOfOneType);
        for(ModelFood food:this.listOfPPFoodOfOneType){
            if(food.getFoodType().equals(this.type)){
                listOfPPFoodOfOneType.add(food);
            }
        }
        return listOfPPFoodOfOneType;
    }

    public ObservableList<ModelFood> getlistOfConsom(){
        listOfConsom.removeAll(listOfConsom);
        if(dateFrom == null || dateTo == null){
            return this.listOfFoodG;
        }else {
            for (ModelFood food : this.listOfFoodG) {
                if (food.getDatePurchase().compareTo(dateFrom) >= 0 && food.getDatePurchase().compareTo(dateTo) <= 0) {
                    listOfConsom.add(food);
                }
            }
            return listOfConsom;
        }
    }

    public ObservableList<ModelFood> getListOfGas(){
        listOfGas.removeAll(listOfGas);
        if(dateFrom == null || dateTo == null){
            return this.listOfPerimeFoodG;
        }else {
            for (ModelFood food : this.listOfPerimeFoodG) {
                if (food.getDateExpiration().compareTo(dateFrom) >= 0 && food.getDateExpiration().compareTo(dateTo) <= 0) {
                    listOfGas.add(food);
                }
            }
            return listOfGas;
        }
    }

    public void setDateFrom(LocalDate dateFrom){
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo){
        this.dateTo = dateTo;
    }

    public LocalDate getDateFrom(){
        return dateFrom;
    }

    public LocalDate getDateTo(){
        return dateTo;
    }
}
