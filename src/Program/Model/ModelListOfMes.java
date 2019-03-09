package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ModelListOfMes {
    private ObservableList<ModelMessage> listOfMes;
    private ModelListOfFollow listOfFollow;
    public ModelListOfMes(){
        listOfFollow =new ModelListOfFollow();
        listOfMes = FXCollections.observableList(new ArrayList<>());
        listOfMes.add(new ModelMessage(listOfFollow.getListOfAmi().get(0),listOfFollow.getListOfFans().get(0),"I like the cake you made.", LocalDateTime.now().minusDays(3)));
        listOfMes.add(new ModelMessage(listOfFollow.getListOfAmi().get(0),new ModelUser("user1","aaa"),"hello",LocalDateTime.now().minusDays(1)));

    }
    public ObservableList getListOfMes(){
        System.out.println(222);
        return listOfMes;}
}
