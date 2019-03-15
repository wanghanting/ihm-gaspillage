package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.util.ArrayList;

public class ModelListOfFood {
    private ObservableList<ModelFood> listOfFoodCanDelete;
    private ObservableList<ModelFood> listOfFoodNotDelete;
    private ObservableList<ModelFood> listOfOkFood;
    private ObservableList<ModelFood> listOfPerimeFood;
    private ObservableList<ModelFood> listOfPPFood;
    private ObservableList<ModelFood> listOfOkFoodNotDelete;
    private ObservableList<ModelFood> listOfPerimeFoodNotDelete;
    private ObservableList<ModelFood> listOfPPFoodNotDelete;
    private ObservableList<ModelFood> listOfOkFoodOfOneType;
    private ObservableList<ModelFood> listOfPerimeFoodOfOneType;
    private ObservableList<ModelFood> listOfPPFoodOfOneType;
    private ObservableList<ModelFood> listOfConsom;
    private ObservableList<ModelFood> listOfGas;
    private String type;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public ModelListOfFood(){
        listOfFoodCanDelete = FXCollections.observableList(new ArrayList<>());
        listOfFoodNotDelete = FXCollections.observableList(new ArrayList<>());
        listOfPerimeFood=FXCollections.observableList(new ArrayList<>());
        listOfOkFood = FXCollections.observableList(new ArrayList<>());
        listOfPPFood= FXCollections.observableList(new ArrayList<>());
        listOfPerimeFoodNotDelete =FXCollections.observableList(new ArrayList<>());
        listOfOkFoodNotDelete = FXCollections.observableList(new ArrayList<>());
        listOfPPFoodNotDelete = FXCollections.observableList(new ArrayList<>());
        listOfOkFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfPerimeFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfPPFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfConsom = FXCollections.observableList(new ArrayList<>());
        listOfGas = FXCollections.observableList(new ArrayList<>());
        listOfFoodCanDelete.add(new ModelFood("pomme","fruit",1,LocalDate.of(2019, 1, 8),LocalDate.of(2019, 2, 8),1,"from England"));
        listOfFoodNotDelete.add(new ModelFood("pomme","fruit",1,LocalDate.of(2019, 1, 8),LocalDate.of(2019, 2, 8),1,"from England"));
    }

    public void addFood(ModelFood food){
        this.listOfFoodCanDelete.add(food);
        this.listOfFoodNotDelete.add(food);
    }
    public ObservableList<ModelFood> getListOfFoodCanDelete(){return listOfFoodCanDelete;}
    public ObservableList<ModelFood> getListOfOkFood(){return listOfOkFood;}
    public ObservableList<ModelFood> getListOfPPFood(){return listOfPPFood;}
    public ObservableList<ModelFood> getListOfPerimeFood(){return listOfPerimeFood;}
    public ObservableList<ModelFood> getListOfOkFoodNotDelete(){return listOfOkFoodNotDelete;}
    public ObservableList<ModelFood> getListOfPPFoodNotDelete(){return listOfPPFoodNotDelete;}
    public ObservableList<ModelFood> getListOfPerimeFoodNotDelete(){return listOfPerimeFoodNotDelete;}
    public void init(){
        listOfPPFood.removeAll(listOfPPFood);
        listOfPerimeFood.removeAll(listOfPerimeFood);
        listOfOkFood.removeAll(listOfOkFood);
        listOfPPFoodNotDelete.removeAll(listOfPPFoodNotDelete);
        listOfPerimeFoodNotDelete.removeAll(listOfPerimeFoodNotDelete);
        listOfOkFoodNotDelete.removeAll(listOfOkFoodNotDelete);
        for(ModelFood food:this.listOfFoodCanDelete){
            if(food.getDateExpiration().compareTo(LocalDate.now())<0){
                listOfPerimeFood.add(food);
            }else if(food.getDateExpiration().minusDays((long)food.getDaysBeforeAlmostExpired()).compareTo(LocalDate.now())>0){
                listOfOkFood.add(food);
            }else listOfPPFood.add(food);
        }
        for(ModelFood food:this.listOfFoodNotDelete){
            if(food.getDateExpiration().compareTo(LocalDate.now())<0){
                listOfPerimeFoodNotDelete.add(food);
            }else if(food.getDateExpiration().minusDays((long)food.getDaysBeforeAlmostExpired()).compareTo(LocalDate.now())>0){
                listOfOkFoodNotDelete.add(food);
            }else listOfPPFoodNotDelete.add(food);
        }
    }
    public void setListOfFoodA(){this.listOfFoodCanDelete.removeAll(this.listOfFoodCanDelete);}

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
        for(ModelFood food:this.listOfPPFood){
            if(food.getFoodType().equals(this.type)){
                listOfPPFoodOfOneType.add(food);
            }
        }
        return listOfPPFoodOfOneType;
    }

    public ObservableList<ModelFood> getlistOfConsom(){
        listOfConsom.removeAll(listOfConsom);
        if(dateFrom == null || dateTo == null){
            return this.listOfFoodNotDelete;
        }else {
            for (ModelFood food : this.listOfFoodNotDelete) {
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
            return this.listOfPerimeFoodNotDelete;
        }else {
            for (ModelFood food : this.listOfPerimeFoodNotDelete) {
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
