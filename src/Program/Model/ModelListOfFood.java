package Program.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;

public class ModelListOfFood {
    private ObservableList<ModelFood> listOfFood;

    public ModelListOfFood(){
        listOfFood = FXCollections.observableList(new ArrayList<>());
        listOfFood.add(new ModelFood("apple","fruit",1,LocalDate.of(2019, 1, 8),LocalDate.of(2019, 2, 8),1,"from England"));
    }

    public void addFood(ModelFood food){ listOfFood.add(food); }

    public ObservableList<ModelFood> getListOfFood(){return listOfFood;}

}
