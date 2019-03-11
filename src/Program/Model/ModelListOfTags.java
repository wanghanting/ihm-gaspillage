package Program.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfTags {
    private static ObservableList<ModelTag> listOfTag;

    public ModelListOfTags(){
        listOfTag = FXCollections.observableList(new ArrayList<>());
        listOfTag.add(new ModelTag("fruit"));
        listOfTag.add(new ModelTag("legume"));
        listOfTag.add(new ModelTag("boisson"));
    }

    public void add(ModelTag tag){
        listOfTag.add(tag);
    }

    public ObservableList<String> getNames(){
        ObservableList<String> names= FXCollections.observableList(new ArrayList<>());
        for(int i =0; i < getListOfTag().size();i++){
            names.add(getListOfTag().get(i).getName());
        }
        return names;
    }

    public ObservableList<ModelTag> getListOfTag(){
        return listOfTag;
    }
}

