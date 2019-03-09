package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;


import java.util.ArrayList;

public class ModelListOfFollow {
    private ObservableList<ModelUser> listOfFans;
    private ObservableList<ModelUser> listOfAmi;

    public ModelListOfFollow(){
        listOfFans = FXCollections.observableList (new ArrayList<> ());
        listOfAmi = FXCollections.observableList (new ArrayList<> ());
        listOfFans.add (new ModelUser ("hahaha", "asd"));
        listOfAmi.add (new ModelUser ("superdemon", "aaa"));
    }

    public ObservableList<ModelUser> getListOfAmi() {
        return listOfAmi;
    }

    public ObservableList<ModelUser> getListOfFans() {
        return listOfFans;
    }

}
