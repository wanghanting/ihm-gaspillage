package Program.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelListOfFood {
    private ObservableList<ModelFood> listOfFood;

    public ModelListOfFood(){
        listOfFood = FXCollections.observableList(new ArrayList<>());
        listOfFood.add(new ModelFood("apple","fruits",1,new DatePicker(LocalDate.of(2019, 1, 8)),new DatePicker(LocalDate.of(2019, 2, 8)),1,"from England"));
    }

    public void addFood(ModelFood food){ listOfFood.add(food); }

    public ObservableList<ModelFood> getListOfFood(){
        return listOfFood;
    }

}