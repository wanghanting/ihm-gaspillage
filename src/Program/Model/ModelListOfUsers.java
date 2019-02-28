package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;

public class ModelListOfUsers {
    public ObservableList<ModelUser> ListOfUsers;

    public ModelListOfUsers(){
        ListOfUsers = FXCollections.observableList( new ArrayList<>());
        ListOfUsers.add(new ModelUser("wukejia","Jj789"));
        ListOfUsers.add(new ModelUser("xiaopeur","keke345"));
    }
    public void addUser(ModelUser user){
        ListOfUsers.add(user);
    }

    public ObservableList<ModelUser> getListOfUsers(){
        return ListOfUsers;
    }
}
