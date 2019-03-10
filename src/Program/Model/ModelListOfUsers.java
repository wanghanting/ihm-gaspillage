package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;

public class ModelListOfUsers {
    public ObservableList<ModelUser> ListOfUsers;

    public ModelListOfUsers(){

        ListOfUsers = FXCollections.observableList( new ArrayList<>());
        ListOfUsers.add(new ModelUser("user1","shagua"));
        ListOfUsers.add(new ModelUser("hahaha","shagua"));
        ListOfUsers.add(new ModelUser("superdemon","shagua"));

    }
    public void addUser(ModelUser user){
        ListOfUsers.add(user);
    }

    public ObservableList<ModelUser> getListOfUsers(){
        return ListOfUsers;
    }
}
