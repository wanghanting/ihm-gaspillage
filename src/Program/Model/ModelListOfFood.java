package Program.Model;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelListOfFood {
    private ObservableList<ModelFood> listOfFood;
    private ObservableList<ModelFood> listOfOkFood;
    private ObservableList<ModelFood> listOfPerimeFood;
    private ObservableList<ModelFood> listOfPPFood;
    private ObservableList<ModelFood> listOfOkFoodOfOneType;
    private ObservableList<ModelFood> listOfPerimeFoodOfOneType;
    private ObservableList<ModelFood> listOfPPFoodOfOneType;
    private String type;

    public ModelListOfFood(){
        listOfOkFood = FXCollections.observableList(new ArrayList<>());
        listOfFood= FXCollections.observableList(new ArrayList<>());
        listOfPerimeFood=FXCollections.observableList(new ArrayList<>());
        listOfPPFood= FXCollections.observableList(new ArrayList<>());
        listOfOkFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfPerimeFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfPPFoodOfOneType = FXCollections.observableList(new ArrayList<>());
        listOfFood.add(new ModelFood("apple","fruit",1,LocalDate.of(2019, 1, 8),LocalDate.of(2019, 2, 8),1,"from England"));
    }

    public void addFood(ModelFood food){
        this.listOfFood.add(food);
    }
    public ObservableList<ModelFood> getListOfFood(){return  listOfFood;}
    public ObservableList<ModelFood> getListOfOkFood(){return listOfOkFood;}
    public ObservableList<ModelFood> getListOfPPFood(){return listOfPPFood;}
    public ObservableList<ModelFood> getListOfPerimeFood(){return listOfPerimeFood;}

    public void init(){
        listOfPPFood.removeAll(listOfPPFood);
        listOfPerimeFood.removeAll(listOfPerimeFood);
        listOfOkFood.removeAll(listOfOkFood);
        for(ModelFood food:this.listOfFood){
            if(food.getDateExpiration().compareTo(LocalDate.now())<0){
                listOfPerimeFood.add(food);
            }else if(food.getDateExpiration().minusDays((long)food.getDaysBeforeAlmostExpired()).compareTo(LocalDate.now())>0){
                listOfOkFood.add(food);
                System.out.println(listOfFood.size());
            }else listOfPPFood.add(food);
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

}
