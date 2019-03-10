package Program.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.*;

public class ModelListOfUsers {

    public ObservableList<ModelUser> ListOfUsers;
    public ModelListOfUsers() {
       ListOfUsers = FXCollections.observableList(new ArrayList<>());
        adduser(ListOfUsers);
    }
    public void adduser( ObservableList<ModelUser> ListOfUsers1){


        ListOfUsers1.add(new ModelUser("user1","shagua"));
        ListOfUsers1.add(new ModelUser("hahaha","shagua"));
        ListOfUsers1.add(new ModelUser("superdemon","shagua"));

    }
    public void addUser(ModelUser user){
        ListOfUsers.add(user);
    }

    public ObservableList<ModelUser> getListOfUsers(){
        return ListOfUsers;
    }
}
