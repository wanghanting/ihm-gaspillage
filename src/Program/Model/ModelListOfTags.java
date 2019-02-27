package Program.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ModelListOfTags {
    private ObservableList<ModelTag> listOfTag;

    public ModelListOfTags(){
        listOfTag = FXCollections.observableList(new ArrayList<>());
        listOfTag.add(new ModelTag("fruit"));
        listOfTag.add(new ModelTag("legume"));
    }

    public void add(ModelTag tag){
        listOfTag.add(tag);
    }

    public ObservableList<ModelTag> getListOfTag(){
        return listOfTag;
    }
}
